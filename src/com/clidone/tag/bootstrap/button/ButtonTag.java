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
    // theme
    private String theme = null;
    public String getTheme() {
        return this.theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }

    // icon
    private String icon = null;
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // dropdown
    private Boolean dropdown = false;
    public Boolean getDropdown() {
        return dropdown;
    }
    public void setDropdown(boolean dropdown) {
        this.dropdown = new Boolean(dropdown);
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
        setTagName("button");

        addClass("btn");
        if (!ValueUtils.isEmpty(theme)) {
            addClass("btn-" + theme.trim());
        }

        if (dropdown != null && dropdown.booleanValue()) {
            addClass("dropdown-toggle");
            addAttribute("data-toggle",   "data-toggle");
            addAttribute("aria-haspopup", "true");
            addAttribute("aria-expanded", "false");
            addAfterContent("<span class=\"caret\"></span>");
        }

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