package com.clidone.tag.bootstrap.button;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;

/**
 * <strong>Drop header tag</strong>
 * @author wuhuaxia
 */
public class DropHeaderTag extends AbstractTag {

    private static final long serialVersionUID = -5742251613085147459L;

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
     * @see AbstractTag#doEndTagV2()
     */
    @Override
    protected String doEndTagV2() throws JspException {
        setTagName("li");

        addClass("dropdown-header");

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