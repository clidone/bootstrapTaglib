package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Badge tag</strong>
 * @author wuhuaxia
 */
public class BadgeTag extends AbstractTag {

    private static final long serialVersionUID = 971266254298297578L;

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

    // theme
    protected String theme = "default";
    public void setTheme(String theme) {
        this.theme = theme;
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
        setTagName("span");

        addClass("label");
        if (!ValueUtils.isEmpty(theme)) {
            addClass("label-" + theme.trim());
        }

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