package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>PanelFooter tag</strong>
 * @author wuhuaxia
 */
public class PanelFooterTag extends AbstractTag {

    private static final long serialVersionUID = -4487998683352134422L;

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

    // as
    protected String as = "h4";
    public void setHeadingAs(String as) {
        this.as = as;
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
        setTagName("div");

        addClass("panel-footer");

        boolean hasAs = !ValueUtils.isEmpty(as);

        addBeforeContent("<div class=\"row\">");

        // left icon & text
        addBeforeContent("<div class=\"col-xs-12 col-sm-6\">");
        if (hasAs) {
            addBeforeContent("<"+as+" class=\"panel-title\" style=\"padding-top:3px;\">");
        }
        if (!ValueUtils.isEmpty(icon)) {
            String iconHTML = renderIcon(icon, (iconOnly != null && iconOnly.booleanValue()));
            addBeforeContent(iconHTML);
        }
        if (!ValueUtils.isEmpty(text)) {
            addBeforeContent(text);
        }
        if (hasAs) {
            addBeforeContent("</"+as+">");
        }
        addBeforeContent("</div>");

        // right buttons or something
        addBeforeContent("<div class=\"col-xs-12 col-sm-6 text-right\" style=\"margin-top:-5px;margin-bottom:-5px;\">");
        // Body content goes here
        addAfterContent("</div>");

        addAfterContent("</div>");

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