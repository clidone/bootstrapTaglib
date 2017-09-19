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

    // size
    private String size = null;
    public void setSize(String size) {
        this.size = size;
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

    // active
    private Boolean active = null;
    public void setActive(Boolean active) {
        this.active = active;
    }

    // block
    private Boolean block = null;
    public void setBlock(Boolean block) {
        this.block = block;
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

        if (!ValueUtils.isEmpty(size)) {
            addClass("btn-" + size);
        }

        if (active != null && active.booleanValue()) {
            addClass("active");
        }

        if (block != null && block.booleanValue()) {
            addClass("btn-block");
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