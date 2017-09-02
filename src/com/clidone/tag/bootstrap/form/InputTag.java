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

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    /**
     * @see AbstractFormFieldTag#renderV2()
     */
    @Override
    protected String renderV2() throws JspException {
        FormTag formTag     = (FormTag) findAncestorWithClass(this, FormTag.class);
        boolean formStatic  = (formTag != null && formTag.getStatic() != null && formTag.getStatic().booleanValue());
        boolean fieldStatic = (staticFlag != null && staticFlag.booleanValue());

        if (formStatic || fieldStatic) {
            setTagName("p");

            addClass("form-control-static");

            if (!ValueUtils.isEmpty(value)) {
                addBeforeContent(value);
            }

        } else {
            setTagName("input");

            addClass("form-control");

            if (!ValueUtils.isEmpty(value)) {
                addAttribute("value", value);
            }
        }

        renderWrap();

        return render();
    }

    /**
     * @see AbstractFormFieldTag#renderV3()
     */
    @Override
    protected String renderV3() throws JspException {
        return renderV2();
    }
}