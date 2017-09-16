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
    private Boolean isFluid = new Boolean(false);
    public void setFluid(Boolean isFluid) {
        this.isFluid = isFluid;
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
        if (isFluid != null && isFluid.booleanValue()) {
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