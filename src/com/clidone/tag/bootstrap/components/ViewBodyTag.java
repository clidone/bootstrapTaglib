package com.clidone.tag.bootstrap.components;

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
    private boolean fluid = true;
    public boolean getFluid() {
        return fluid;
    }
    public void setFluid(boolean fluid) {
        this.fluid = fluid;
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
        if (fluid) {
            addClass("view-body container-fluid");
        } else {
            addClass("view-body container");
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