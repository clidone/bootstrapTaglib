package com.clidone.tag.bootstrap.button;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Button group tag</strong>
 * @author wuhuaxia
 */
public class ButtonGroupTag extends AbstractTag {

    private static final long serialVersionUID = 4023347944446584944L;

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

    // justified
    private Boolean justified = null;
    public Boolean getJustified() {
        return this.justified;
    }
    public void setJustified(boolean justified) {
        this.justified = new Boolean(justified);
    }

    // vertical
    private Boolean vertical = null;
    public Boolean getVertical() {
        return this.vertical;
    }
    public void setVertical(boolean vertical) {
        this.vertical = new Boolean(vertical);
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
        setTagName("div");

        addClass("btn-group");

        if (!ValueUtils.isEmpty(size)) {
            addClass("btn-group-" + size);
        }

        if (justified != null && justified.booleanValue()) {
            addClass("btn-group-justified");
        }
        if (vertical != null && vertical.booleanValue()) {
            addClass("btn-group-vertical");
        }

        addAttribute("role", "group");
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