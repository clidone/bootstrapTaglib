package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Tag tag</strong>
 * @author wuhuaxia
 */
public class TagTag extends AbstractTag {

    private static final long serialVersionUID = -3763848045280119587L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // theme
    protected String theme = null;
    public void setTheme(String theme) {
        this.theme = theme;
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
        setTagName("span");

        addClass("label");

        if (!ValueUtils.isEmpty(theme)) {
            addClass("label-" + theme);
        }

        if (!ValueUtils.isEmpty(icon)) {
            String iconHTML = renderIcon(icon, (iconOnly != null && iconOnly.booleanValue()));
            addBeforeContent(iconHTML);
        }

        addBeforeContent(text);

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