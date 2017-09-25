package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Well tag</strong>
 * @author wuhuaxia
 */
public class WellTag extends AbstractTag {

    private static final long serialVersionUID = -4543015186259355600L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // size
    private String size = null;
    public void setSize(String size) {
        this.size = size;
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

        addClass("well");
        if (!ValueUtils.isEmpty(size)) {
            addClass("well-" + size);
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