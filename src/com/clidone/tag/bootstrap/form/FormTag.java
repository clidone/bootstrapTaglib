package com.clidone.tag.bootstrap.form;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;

/**
 * <strong>Form tag</strong>
 * @author wuhuaxia
 */
public class FormTag extends AbstractTag {

    private static final long serialVersionUID = 2824431813604511174L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // layout
    private String layout = null;
    public String getLayout() {
        return layout;
    }
    public void setLayout(String layout) {
        this.layout = layout;
    }

    // static
    protected Boolean staticFlag = null;
    public Boolean getStatic() {
        return staticFlag;
    }
    public void setStatic(Boolean staticFlag) {
        this.staticFlag = staticFlag;
    }

    // model
    private String model = null;
    public void setModel(String model) {
        this.model = model;
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
        setTagName("form");

        if ("i".equals(layout) || "inline".equals(layout)) {
            addClass("form-inline");
        } else if ("h".equals(layout) || "horizontal".equals(layout)) {
            addClass("form-horizontal");
        }

        addAttribute("role", "form");

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