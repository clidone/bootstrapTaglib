package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Panel tag</strong>
 * @author wuhuaxia
 */
public class PanelTag extends AbstractTag {

    private static final long serialVersionUID = -4271492475408010177L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // theme
    protected String theme = "default";
    public void setTheme(String theme) {
        this.theme = theme;
    }

    // headingText
    protected String headingText = null;
    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }

    // headingIcon
    protected String headingIcon = null;
    public void setHeadingIcon(String headingIcon) {
        this.headingIcon = headingIcon;
    }

    // headingAs
    protected String headingAs = null;
    public void setHeadingAs(String headingAs) {
        this.headingAs = headingAs;
    }

    // footerText
    protected String footerText = null;
    public void setFooterText(String footerText) {
        this.footerText = footerText;
    }

    // footerIcon
    protected String footerIcon = null;
    public void setFooterIcon(String footerIcon) {
        this.footerIcon = footerIcon;
    }

    // footerAs
    protected String footerAs = null;
    public void setFooterAs(String footerAs) {
        this.footerAs = footerAs;
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

        addClass("panel");
        if (!ValueUtils.isEmpty(theme)) {
            addClass("panel-"+theme);
        }

        boolean hasHeadingAs   = !ValueUtils.isEmpty(headingAs);
        boolean hasHeadingIcon = !ValueUtils.isEmpty(headingIcon);
        boolean hasHeadingText = !ValueUtils.isEmpty(headingText);

        if (hasHeadingAs || hasHeadingIcon || hasHeadingText) {
            addBeforeContent("<div class=\"panel-heading\">");
            if (hasHeadingAs) {
                addBeforeContent("<"+headingAs+" class=\"panel-title\">");
            }
            if (!ValueUtils.isEmpty(headingIcon)) {
                String iconHTML = renderIcon(headingIcon);
                addBeforeContent(iconHTML);
            }
            if (!ValueUtils.isEmpty(headingText)) {
                addBeforeContent(headingText);
            }
            if (hasHeadingAs) {
                addBeforeContent("</"+headingAs+">");
            }
            addBeforeContent("</div>");
        }

        addBeforeContent("<div class=\"panel-body\">");
        addAfterContent("</div>");

        boolean hasFooterAs   = !ValueUtils.isEmpty(footerAs);
        boolean hasFooterIcon = !ValueUtils.isEmpty(footerIcon);
        boolean hasFooterText = !ValueUtils.isEmpty(footerText);

        if (hasFooterAs || hasFooterIcon || hasFooterText) {
            addAfterContent("<div class=\"panel-footer\">");
            if (hasFooterAs) {
                addAfterContent("<"+footerAs+" class=\"panel-title\">");
            }
            if (!ValueUtils.isEmpty(footerIcon)) {
                String iconHTML = renderIcon(footerIcon);
                addAfterContent(iconHTML);
            }
            if (!ValueUtils.isEmpty(footerText)) {
                addAfterContent(footerText);
            }
            if (hasFooterAs) {
                addAfterContent("</"+footerAs+">");
            }
            addAfterContent("</div>");
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