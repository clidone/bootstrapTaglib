package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>ModalHeader tag</strong>
 * @author wuhuaxia
 */
public class ModalHeaderTag extends AbstractTag {

    private static final long serialVersionUID = 2244219619750562248L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // headingText
    protected String headingText = null;
    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }

    // headingIcon
    protected String headingIcon = null;
    public void setHeadingIcon(String headingIcon) {
        this.headingIcon = headingIcon;
    }

    // headingIconOnly
    protected Boolean headingIconOnly = new Boolean(false);
    public void setHeadingIconOnly(Boolean headingIconOnly) {
        this.headingIconOnly = headingIconOnly;
    }

    // headingAs
    protected String headingAs = "h4";
    public void setHeadingAs(String headingAs) {
        this.headingAs = headingAs;
    }

    // close
    protected Boolean close = new Boolean(true);
    public void setClose(Boolean close) {
        this.close = close;
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

        addClass("modal-header");

        ModalTag modalTag = (ModalTag) findAncestorWithClass(this, ModalTag.class);
        String modalId = "";
        if (modalTag != null) {
            modalId = modalTag.getId();
        }

        if (close != null && close.booleanValue()) {
            addBeforeContent("<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">");
            addBeforeContent(    "<span aria-hidden=\"true\">&times;</span>");
            addBeforeContent("</button>");
        }

        boolean hasHeadingAs   = !ValueUtils.isEmpty(headingAs);
        boolean hasHeadingIcon = !ValueUtils.isEmpty(headingIcon);
        boolean hasHeadingText = !ValueUtils.isEmpty(headingText);
        if (hasHeadingAs || hasHeadingIcon || hasHeadingText) {
            if (hasHeadingAs) {
                addBeforeContent("<"+headingAs+" class=\"modal-title\" id=\""+modalId+"\">");
            }
            if (!ValueUtils.isEmpty(headingIcon)) {
                String iconHTML = renderIcon(headingIcon, (headingIconOnly != null && headingIconOnly.booleanValue()));
                addBeforeContent(iconHTML);
            }
            if (!ValueUtils.isEmpty(headingText)) {
                addBeforeContent(headingText);
            }
            if (hasHeadingAs) {
                addBeforeContent("</"+headingAs+">");
            }
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