package com.clidone.tag.bootstrap.form;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Option tag</strong>
 * @author wuhuaxia
 */
public class OptionTag extends AbstractTag {

    private static final long serialVersionUID = 3266794280757521093L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // value
    private String value = null;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    // text
    private String text = null;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
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
        FormTag formTag     = (FormTag) super.findAncestorWithClass(this, FormTag.class);
        SelectTag selectTag = (SelectTag) super.findAncestorWithClass(this, SelectTag.class);
        boolean formStatic  = (formTag != null && formTag.getStatic() != null && formTag.getStatic().booleanValue());
        boolean fieldStatic = (selectTag.getStatic() != null && selectTag.getStatic().booleanValue());

        String selectValue = selectTag.getValue();
        boolean isMatchValue = ((ValueUtils.isEmpty(selectValue) && ValueUtils.isEmpty(value)) ||
                               (!ValueUtils.isEmpty(selectValue) && selectValue.equals(value)));

        if (formStatic || fieldStatic) {
            if (!isMatchValue) {
                try {
                    bodyContent.clear();
                } catch (IOException ex) {
                    throw new JspException(ex);
                }
            }

        } else {
            setTagName("option");

            addAttribute("value", (ValueUtils.isEmpty(value) ? "" : value));

            if (isMatchValue) {
                addAttribute("selected", "selected");
            }

            if (!ValueUtils.isEmpty(text)) {
                addBeforeContent(text);
            }
        }

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