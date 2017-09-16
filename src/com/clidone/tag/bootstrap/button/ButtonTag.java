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
    private String type = "button";
    public void setType(String type) {
        this.type = type;
    }

    // theme
    private String theme = "default";
    public void setTheme(String theme) {
        this.theme = theme;
    }

    // icon
    private String icon = null;
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // dropdown
    private Boolean dropdown = null;
    public void setDropdown(Boolean dropdown) {
        this.dropdown = dropdown;
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

        if (dropdown != null && dropdown.booleanValue()) {
            addClass("dropdown-toggle");
            addAttribute("data-toggle",   "dropdown");
            addAttribute("aria-haspopup", "true");
            addAttribute("aria-expanded", "false");
            addAfterContent("<span class=\"caret\"></span>");
        }

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