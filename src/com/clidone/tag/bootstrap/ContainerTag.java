package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;

/**
 * <strong>Container tag</strong>
 * @author wuhuaxia
 */
public class ContainerTag extends AbstractTag {

    private static final long serialVersionUID = -6573348275204364636L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // Whether container is fluid or not
    protected Boolean fluid = new Boolean(false);
    public void setFluid(Boolean fluid) {
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

        if (fluid != null && fluid.booleanValue()) {
            addClass("container-fluid");
        } else {
            addClass("container");
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