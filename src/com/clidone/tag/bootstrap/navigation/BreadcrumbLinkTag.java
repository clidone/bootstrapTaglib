package com.clidone.tag.bootstrap.navigation;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Breadcrumb link tag</strong>
 * @author wuhuaxia
 */
public class BreadcrumbLinkTag extends AbstractTag {

    private static final long serialVersionUID = -6803916169728156605L;

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

    // active
    private Boolean active = null;
    public void setActive(Boolean active) {
        this.active = active;
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
        String activeStyle = (active != null && active.booleanValue()) ? "active" : "";
        addBeforeContent("<a href=\""+contextPath+uriValue+"\" class=\""+activeStyle+"\">");

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