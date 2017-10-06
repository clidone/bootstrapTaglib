package com.clidone.tag.bootstrap.button;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Button tag</strong>
 * @author wuhuaxia
 */
public class ButtonTag extends AbstractTag {

    private static final long serialVersionUID = -7427355255774231344L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // type
    protected String type = "button";
    public void setType(String type) {
        this.type = type;
    }

    // theme
    protected String theme = "default";
    public void setTheme(String theme) {
        this.theme = theme;
    }

    // size
    protected String size = null;
    public void setSize(String size) {
        this.size = size;
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
        setTagName("button");

        if (!ValueUtils.isEmpty(type)) {
            super.addAttribute("type", type);
        }

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
        }

        if (block != null && block.booleanValue()) {
            addClass("btn-block");
        }

        String iconHTML = ValueUtils.isEmpty(icon) ? "" : renderIcon(icon, (iconOnly != null && iconOnly.booleanValue()));
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