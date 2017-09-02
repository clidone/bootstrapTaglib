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
    private String resize = "none";
    public String getResize() {
        return this.resize;
    }
    public void setResize(String resize) {
        this.resize = resize;
    }

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
            setTagName("textarea");

            addClass("form-control");

            if (!ValueUtils.isEmpty(resize)) {
                addStyle("resize", resize);
            }

            if (!ValueUtils.isEmpty(value)) {
                addBeforeContent(value);
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