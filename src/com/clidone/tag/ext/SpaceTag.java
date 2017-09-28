package com.clidone.tag.ext;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;

/**
 * <strong>Space tag</strong>
 * @author wuhuaxia
 */
public class SpaceTag extends AbstractTag {

    private static final long serialVersionUID = 9218967717413687462L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // count
    protected int count = 4;
    public void setCount(int count) {
        this.count = count;
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
        for (int i=0; i<count; i++) {
            addBeforeContent("&nbsp;");
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