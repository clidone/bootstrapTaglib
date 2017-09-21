package com.clidone.tag.bootstrap.form;

import javax.servlet.jsp.JspException;

import com.clidone.tag.ValueUtils;

/**
 * <strong>Input tag</strong>
 * @author wuhuaxia
 */
public class InputTag extends AbstractFormFieldTag {

    private static final long serialVersionUID = -3551303839357793817L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // addonSize
    private String addonSize = null;
    public void setAddonSize(String addonSize) {
        this.addonSize = addonSize;
    }

    // prefixAddon
    protected String prefixAddon = null;
    public void setPrefixAddon(String prefixAddon) {
        this.prefixAddon = prefixAddon;
    }

    // suffixAddon
    protected String suffixAddon = null;
    public void setSuffixAddon(String suffixAddon) {
        this.suffixAddon = suffixAddon;
    }

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    /**
     * @see AbstractFormFieldTag#doEndTagV2()
     */
    @Override
    protected String doEndTagV2() throws JspException {
        FormTag formTag     = (FormTag) findAncestorWithClass(this, FormTag.class);
        boolean formStatic  = (formTag != null && formTag.getStatic() != null && formTag.getStatic().booleanValue());
        boolean fieldStatic = (staticFlag != null && staticFlag.booleanValue());

        if (formStatic || fieldStatic) {
            setTagName("p");

            addClass("form-control-static");

            if (value != null) {
                addBeforeContent(String.valueOf(value));
            }

        } else {
            setTagName("input");

            addClass("form-control");

            // handle addon
            boolean hasPrefixAddon = !ValueUtils.isEmpty(prefixAddon);
            boolean hasSuffixAddon = !ValueUtils.isEmpty(suffixAddon);
            if (hasPrefixAddon || hasSuffixAddon) {
                String size = ValueUtils.isEmpty(addonSize) ? "" : " input-group-" + addonSize;
                addBeforeWrap("<div class=\"input-group"+size+"\">");
            }
            if (hasPrefixAddon) {
                String addon = renderAddOn(suffixAddon);
                addBeforeWrap(addon);
            }
            if (hasSuffixAddon) {
                String addon = renderAddOn(suffixAddon);
                addAfterWrap(addon);
            }
            if (hasPrefixAddon || hasSuffixAddon) {
                addAfterWrap("</div>");
            }

            // set value
            if (value != null) {
                addAttribute("value", String.valueOf(value));
            }
        }

        renderWrap();

        return render();
    }

    /**
     * @see AbstractFormFieldTag#doEndTagV3()
     */
    @Override
    protected String doEndTagV3() throws JspException {
        return doEndTagV2();
    }

    /**
     * Render addOn
     * @param addOn
     */
    private String renderAddOn(String addOn) {
        if (ValueUtils.isEmpty(addOn)) {
            return "";
        }

        String addOnHTML = null;
        if (addOn.startsWith("icon:")) {
            addOnHTML = super.renderIcon(addOn.replace("icon:", ""));
        } else {
            addOnHTML = addOn;
        }
        return "<span class=\"input-group-addon\">"+addOnHTML+"</span>";
    }
}