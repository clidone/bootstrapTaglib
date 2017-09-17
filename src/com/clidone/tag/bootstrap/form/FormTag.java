package com.clidone.tag.bootstrap.form;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

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
    // action
    private String action = null;
    public void setAction(String action) {
        this.action = action;
    }

    // layout
    // Available value: inline(i)、horizontal(h)
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

        if (!ValueUtils.isEmpty(action)) {
            String contextPath = super.getServletContext().getContextPath();
            String url = contextPath + action;
            addAttribute("action", url);
        }

        if ("i".equalsIgnoreCase(layout) || "inline".equalsIgnoreCase(layout)) {
            addClass("form-inline");
        } else if ("h".equalsIgnoreCase(layout) || "horizontal".equalsIgnoreCase(layout)) {
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