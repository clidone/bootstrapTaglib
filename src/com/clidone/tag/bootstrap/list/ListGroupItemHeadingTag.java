package com.clidone.tag.bootstrap.list;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>ListGroupItemHeading Tag</strong>
 * @author wuhuaxia
 */
public class ListGroupItemHeadingTag extends AbstractTag {

    private static final long serialVersionUID = -5246305443595276664L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // as
    protected String as = "h4";
    public void setAs(String as) {
        this.as = as;
    }

    // text
    protected String text = null;
    public void setText(String text) {
        this.text = text;
    }

    // icon
    protected String icon = null;
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // iconOnly
    protected Boolean iconOnly = new Boolean(false);
    public void setIconOnly(Boolean iconOnly) {
        this.iconOnly = iconOnly;
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
        setTagName(as);

        addClass("list-group-item-heading");

        if (!ValueUtils.isEmpty(icon)) {
            String iconHTML = renderIcon(icon, (iconOnly != null && iconOnly.booleanValue()));
            addBeforeContent(iconHTML);
        }

        if (!ValueUtils.isEmpty(text)) {
            addBeforeContent(text);
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