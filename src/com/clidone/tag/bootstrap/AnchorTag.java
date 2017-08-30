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
    private String uri = null;
    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }

    // icon
    private String icon = null;
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    /**
     * @see AbstractTag#renderV2()
     */
    @Override
    protected String renderV2() throws JspException {
        setName("a");

        String contextPath = super.getServletContext().getContextPath();
        String uriValue = ValueUtils.isEmpty(uri)  ? "" : uri;
        addAttribute("href", contextPath + uriValue);

        String iconHTML = ValueUtils.isEmpty(icon) ? "" : renderIcon(icon);
        addBeforeContent(iconHTML);

        return render();
    }

    /**
     * @see AbstractTag#renderV3()
     */
    @Override
    protected String renderV3() throws JspException {
        return renderV2();
    }
}