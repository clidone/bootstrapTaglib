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
    protected String uri = null;
    public void setUri(String uri) {
        this.uri = uri;
    }

    // size
    protected String size = null;
    public void setSize(String size) {
        this.size = size;
    }

    // theme
    protected String theme = "link";
    public void setTheme(String theme) {
        this.theme = theme;
    }

    // icon
    protected String icon = null;
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // active
    protected Boolean active = null;
    public void setActive(Boolean active) {
        this.active = active;
    }

    // disabled
    protected Boolean disabled = null;
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    // block
    protected Boolean block = null;
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

        if (disabled != null && disabled.booleanValue()) {
            addAttribute("disabled", "disabled");
            addClass("disabled");
        }

        if (block != null && block.booleanValue()) {
            addClass("btn-block");
        }

        addAttribute("role", "button");

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