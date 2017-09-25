package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;

/**
 * <strong>ModalFooter tag</strong>
 * @author wuhuaxia
 */
public class ModalFooterTag extends AbstractTag {

    private static final long serialVersionUID = 1613102567385587924L;

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

        addClass("modal-footer");

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