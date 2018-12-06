package com.clidone.tag.bootstrap.form;

import javax.servlet.jsp.JspException;

import com.clidone.tag.ValueUtils;

/**
 * <strong>Input tag</strong>
 * @author wuhuaxia
 */
public class InputTag extends AbstractFormFieldTag {

    private static final long serialVersionUID = 5148512676366411770L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // type
    protected String type = "text";
    public void setType(String type) {
        this.type = type;
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

        if (ValueUtils.isEmpty(name)) {
            name = "";
        }

        if ("hidden".equals(type)) {
            setTagName("input");
            addAttribute("type", type);
            addAttribute("name", name);
            if (value != null) {
                addAttribute("value", String.valueOf(value));
            }
            if (disabled != null && disabled.booleanValue()) {
                addAttribute("disabled", "disabled");
            }

        } else {
            if (formStatic || fieldStatic) {
                setTagName("p");
                addClass("form-control-static");
                addAttribute("name", name);
                if (value != null) {
                    addBeforeContent(String.valueOf(value));
                }

            } else {
                setTagName("input");
                addClass("form-control");
                addAttribute("type", type);
                addAttribute("name", name);
                if (value != null) {
                    addAttribute("value", String.valueOf(value));
                }
                if (size != null) {
                    addClass("input-"+size);
                }
                if (readonly != null && readonly.booleanValue()) {
                    addAttribute("readonly", "readonly");
                }
                if (disabled != null && disabled.booleanValue()) {
                    addAttribute("disabled", "disabled");
                }
            }

            if (simple == null || (simple != null && !simple.booleanValue())) {
                renderWrap();
            }
        }

        return render();
    }

    /**
     * @see AbstractFormFieldTag#doEndTagV3()
     */
    @Override
    protected String doEndTagV3() throws JspException {
        return doEndTagV2();
    }
}