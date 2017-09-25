package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

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
    // id
    protected String id = null;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    // size
    protected String size = null;
    public void setSize(String size) {
        this.size = size;
    }

    // fade
    protected Boolean fade = new Boolean(true);
    public void setFade(Boolean fade) {
        this.fade = fade;
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

        String modalSize = ValueUtils.isEmpty(size) ? "" : " modal-"+size;

        addClass("modal");
        if (fade != null && fade.booleanValue()) {
            addClass("fade");
        }
        addAttribute("tabindex", "-1");
        addAttribute("role", "dialog");
        if (!ValueUtils.isEmpty(id)) {
            addAttribute("aria-labelledby", id);
        }

        addBeforeContent("<div class=\"modal-dialog"+modalSize+"\" role=\"document\" aria-hidden=\"true\">");
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