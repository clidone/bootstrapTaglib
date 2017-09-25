package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;

/**
 * <strong>Modal tag</strong>
 * @author wuhuaxia
 */
public class ModalTag extends AbstractTag {

    private static final long serialVersionUID = -283206794752405339L;

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

        addClass("modal fade");
        addAttribute("tabindex", "-1");
        addAttribute("role", "dialog");

        addBeforeContent("<div class=\"modal-dialog\" role=\"document\">");
        addBeforeContent(    "<div class=\"modal-content\">");

        addAfterContent(    "</div>");
        addAfterContent("</div>");

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