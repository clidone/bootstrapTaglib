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
    // size
    private String size = null;
    public String getSize() {
        return this.size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    /**
     * @see AbstractTag#renderV2()
     */
    @Override
    protected String renderV2() throws JspException {
        addClass("btn-toolbar");
        if (!ValueUtils.isEmpty(size)) {
            addClass("btn-group-" + size);
        }

        addAttribute("role", "toolbar");
        addAttribute("aria-label", "");

        return render();
    }

    /**
     * @see AbstractTag#renderV3()
     */
    @Override
    protected String renderV3() throws JspException {
        return renderV2();
    }
}