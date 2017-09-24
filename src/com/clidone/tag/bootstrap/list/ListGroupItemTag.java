package com.clidone.tag.bootstrap.list;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>ListGroupItem Tag</strong>
 * @author wuhuaxia
 */
public class ListGroupItemTag extends AbstractTag {

    private static final long serialVersionUID = -4526761267330582186L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // text
    protected String text = null;
    public void setText(String text) {
        this.text = text;
    }

    // active
    protected Boolean active = null;
    public void setActive(Boolean active) {
        this.active = active;
    }

    // disabled
    protected Boolean disabled = null;
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    // theme
    protected String theme = null;
    public void setTheme(String theme) {
        this.theme = theme;
    }

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
        if (active != null && active.booleanValue()) {
            addClass("active");
        }
        if (disabled != null && disabled.booleanValue()) {
            addClass("disabled");
        }
        if (!ValueUtils.isEmpty(theme)) {
            addClass("list-group-item-"+theme);
        }

        if (!ValueUtils.isEmpty(icon)) {
            String iconHTML = renderIcon(icon);
            addBeforeContent(iconHTML);
        }

        if (!ValueUtils.isEmpty(badge)) {
            addBeforeContent("<span class=\"badge\">"+badge+"</span>");
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