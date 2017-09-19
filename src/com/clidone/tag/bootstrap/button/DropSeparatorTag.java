package com.clidone.tag.bootstrap.button;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;

/**
 * <strong>Drop separator tag</strong>
 * @author wuhuaxia
 */
public class DropSeparatorTag extends AbstractTag {

    private static final long serialVersionUID = 5007303512396512339L;

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

        addClass("divider");

        addAttribute("role", "separator");

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