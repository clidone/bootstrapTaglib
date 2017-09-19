package com.clidone.tag.bootstrap.button;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Drop link tag</strong>
 * @author wuhuaxia
 */
public class DropLinkTag extends AbstractTag {

    private static final long serialVersionUID = -8180072060442409477L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // url
    private String uri = null;
    public void setUri(String uri) {
        this.uri = uri;
    }

    // icon
    private String icon = null;
    public void setIcon(String icon) {
        this.icon = icon;
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

        String contextPath = super.getServletContext().getContextPath();
        String uriValue = ValueUtils.isEmpty(uri)  ? "" : uri;
        addBeforeContent("<a href=\""+contextPath+uriValue+"\">");

        String iconHTML = ValueUtils.isEmpty(icon) ? "" : renderIcon(icon);
        addBeforeContent(iconHTML);

        addAfterContent("</a>");

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