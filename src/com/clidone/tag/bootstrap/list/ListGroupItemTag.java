package com.clidone.tag.bootstrap.list;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>ListGroupItem tag</strong>
 * @author wuhuaxia
 */
public class ListGroupItemTag extends AbstractTag {

    private static final long serialVersionUID = -4526761267330582186L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // icon
    protected String icon = null;
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // badge
    protected String badge = null;
    public void setBadge(String badge) {
        this.badge = badge;
    }

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    /**
     * @see AbstractTag#doEndTagV2()
     */
    @Override
    protected String doEndTagV2() throws JspException {
        setTagName("li");

        addClass("list-group-item");

        if (!ValueUtils.isEmpty(icon)) {
            String iconHTML = renderIcon(icon);
            addBeforeContent(iconHTML);
        }

        if (!ValueUtils.isEmpty(badge)) {
            addBeforeContent("<span class=\"badge\">"+badge+"</span>");
        }

        return render();
    }

    /**
     * @see AbstractTag#doEndTagV3()
     */
    @Override
    protected String doEndTagV3() throws JspException {
        return doEndTagV2();
    }
}