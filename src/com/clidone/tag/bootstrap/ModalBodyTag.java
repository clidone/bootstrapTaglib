package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;

/**
 * <strong>ModalBody tag</strong>
 * @author wuhuaxia
 */
public class ModalBodyTag extends AbstractTag {

    private static final long serialVersionUID = -9059234199755528424L;

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
        setTagName("div");

        addClass("modal-body");

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