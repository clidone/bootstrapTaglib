package com.clidone.tag.bootstrap.form;

import javax.servlet.jsp.JspException;

import com.clidone.tag.ValueUtils;

/**
 * <strong>Textarea tag</strong>
 * @author wuhuaxia
 */
public class TextareaTag extends AbstractFormFieldTag {

    private static final long serialVersionUID = 7593223508203338348L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    /**
     * resize: valid value are
     *         inherit: depending on parent
     *         none : no resize
     *         both : horizontal and vertical could be resized
     *         horizontal: horizontal resize
     *         vertical: vertical reize
     */
    protected String resize = "none";
    public void setResize(String resize) {
        this.resize = resize;
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
            if (ValueUtils.isEmpty(name)) {
                name = "";
            }

            setTagName("textarea");
            addClass("form-control");
            addAttribute("name", name);

            if (!ValueUtils.isEmpty(resize)) {
                addStyle("resize", resize);
            }

            if (value != null) {
                addBeforeContent(String.valueOf(value));
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