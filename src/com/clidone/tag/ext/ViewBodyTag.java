package com.clidone.tag.ext;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;

/**
 * <strong>View body tag</strong>
 * @author wuhuaxia
 */
public class ViewBodyTag extends AbstractTag {

    private static final long serialVersionUID = 8067381105808339628L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // container fluid or not boolean flag
    protected boolean fluid = true;
    public void setFluid(boolean fluid) {
        this.fluid = fluid;
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
        setTagName("div");

        if (fluid) {
            addClass("view-body container-fluid");
        } else {
            addClass("view-body container");
        }

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