package com.clidone.tag.bootstrap.button;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Button toolbar tag</strong>
 * @author wuhuaxia
 */
public class ButtonToolbarTag extends AbstractTag {

    private static final long serialVersionUID = 4283967024937744279L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // size (xs, sm, lg)
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

        addClass("btn-toolbar");

        if (!ValueUtils.isEmpty(size)) {
            addClass("btn-group-" + size);
        }

        addAttribute("role", "toolbar");
        addAttribute("aria-label", "toolbar");

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