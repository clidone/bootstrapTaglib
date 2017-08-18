package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractSimpleTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>锚点标签对象</strong>
 * @author wuhuaxia
 */
public final class AnchorTag extends AbstractSimpleTag {

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    /**
    * URL
    */
    private String uri = null;
    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * ICON
     */
    private String icon = null;
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Text
     */
    private String text = null;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    @Override
    protected String renderV2() throws JspException {
        String contextPath = super.getServletContext().getContextPath();

        String uriHTML  = ValueUtils.isEmpty(uri)  ? "" : uri;
        String iconHTML = ValueUtils.isEmpty(icon) ? "" : super.renderIcon(icon);
        String textHTML = ValueUtils.isEmpty(text) ? "" : text;

        StringBuilder tagHTML = new StringBuilder();
        tagHTML.append("<a href=\"").append(contextPath).append(uriHTML).append("\" class=\"btn btn-primary\">");
        tagHTML.append(    iconHTML).append(textHTML);
        tagHTML.append("</a>");

        return tagHTML.toString();
    }

    @Override
    protected String renderV3() throws JspException {
        return renderV2();
    }
}