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
    // text
    protected String text = null;
    public void setText(String text) {
        this.text = text;
    }

    // icon
    protected String icon = null;
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // iconOnly
    protected Boolean iconOnly = new Boolean(false);
    public void setIconOnly(Boolean iconOnly) {
        this.iconOnly = iconOnly;
    }

    // headingAs
    protected String as = "h4";
    public void setAs(String as) {
        this.as = as;
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

        boolean hasHeadingAs   = !ValueUtils.isEmpty(as);
        boolean hasHeadingIcon = !ValueUtils.isEmpty(icon);
        boolean hasHeadingText = !ValueUtils.isEmpty(text);
        if (hasHeadingAs || hasHeadingIcon || hasHeadingText) {
            if (hasHeadingAs) {
                addBeforeContent("<"+as+" class=\"modal-title\" id=\""+modalId+"Label\">");
            }
            if (!ValueUtils.isEmpty(icon)) {
                String iconHTML = renderIcon(icon, (iconOnly != null && iconOnly.booleanValue()));
                addBeforeContent(iconHTML);
            }
            if (!ValueUtils.isEmpty(text)) {
                addBeforeContent(text);
            }
            if (hasHeadingAs) {
                addBeforeContent("</"+as+">");
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