package com.clidone.tag.bootstrap;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * <strong>Container tag</strong>
 * @author wuhuaxia
 */
public class ContainerTag extends TagSupport {

    private static final long serialVersionUID = -6573348275204364636L;

    // Whether container is fluid or not
    private boolean isFluid = false;
    public boolean isFluid() {
        return isFluid;
    }
    public void setFluid(boolean isFluid) {
        this.isFluid = isFluid;
    }


}