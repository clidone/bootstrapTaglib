package com.clidone.tag.bootstrap.form;

import javax.servlet.jsp.JspException;

import com.clidone.tag.ValueUtils;

/**
 * <strong>Checkbox tag</strong>
 * @author wuhuaxia
 */
public class CheckboxTag extends AbstractFormFieldTag {

    private static final long serialVersionUID = 5736902356262362784L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // submitValue
    protected String submitValue = null;
    public void setSubmitValue(String submitValue) {
        this.submitValue = submitValue;
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

        setTagName("input");

        addAttribute("type", "checkbox");

        if (formStatic || fieldStatic) {
            addAttribute("readonly", "readonly");
        }

        if (submitValue != null) {
            addAttribute("value", String.valueOf(submitValue));
            if (value != null) {
                if (String.valueOf(value).equals(String.valueOf(submitValue))) {
                    addAttribute("checked", "checked");
                }
            }
        }

        addBeforeWrap("<div class=\"checkbox\">");
        addBeforeWrap("<label>");

        if (!ValueUtils.isEmpty(label)) {
            addAfterWrap(label);
        }

        addAfterWrap("</label>");
        addAfterWrap("</div>");

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