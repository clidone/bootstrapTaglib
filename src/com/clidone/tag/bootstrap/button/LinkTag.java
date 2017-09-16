package com.clidone.tag.bootstrap.button;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Link(Anchor) button tag</strong>
 * @author wuhuaxia
 */
public class LinkTag extends AbstractTag {

    private static final long serialVersionUID = -523369805260770944L;

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

    // theme
    private String theme = "link";
    public void setTheme(String theme) {
        this.theme = theme;
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
        setTagName("a");

        addClass("btn");
        if (!ValueUtils.isEmpty(theme)) {
            addClass("btn-" + theme.trim());
        }

        String contextPath = super.getServletContext().getContextPath();
        String uriValue = ValueUtils.isEmpty(uri)  ? "" : uri;
        addAttribute("href", contextPath + uriValue);

        String iconHTML = ValueUtils.isEmpty(icon) ? "" : renderIcon(icon);
        addBeforeContent(iconHTML);

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