package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Anchor tag</strong>
 * @author wuhuaxia
 */
public class AnchorTag extends AbstractTag {

    private static final long serialVersionUID = -6211850808642948790L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // url
    protected String uri = null;
    public void setUri(String uri) {
        this.uri = uri;
    }

    // icon
    protected String icon = null;
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
        setTagName("a");

        String contextPath = super.getServletContext().getContextPath();
        String uriValue = ValueUtils.isEmpty(uri)  ? "javascript:void(0);" : contextPath+uri;
        addAttribute("href", uriValue);

        String iconHTML = ValueUtils.isEmpty(icon) ? "" : renderIcon(icon);
        addBeforeContent(iconHTML);

        // When anchor is in AlterTag, should add this class
        AlertTag alertTag = (AlertTag) findAncestorWithClass(this, AlertTag.class);
        if (alertTag != null) {
            addClass("alert-link");
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