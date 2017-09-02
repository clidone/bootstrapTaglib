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

        setTagName("input");

        addClass("form-control");

        addAttribute("type", "checkbox");

        if (formStatic || fieldStatic) {
            addAttribute("readonly", "readonly");
        }

        if (!ValueUtils.isEmpty(value)) {
            addAttribute("value", value);
        }

        addBeforeWrap("<div class=\"checkbox\">");
        addBeforeWrap("<label>");

        if (!ValueUtils.isEmpty(label)) {
            addAfterWrap(label);
        }

        addAfterWrap("</label>");
        addAfterWrap("</div>");

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