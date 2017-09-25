package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Badge tag</strong>
 * @author wuhuaxia
 */
public class BadgeTag extends AbstractTag {

    private static final long serialVersionUID = 971266254298297578L;

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
        setTagName("span");

        addClass("badge");

        if (!ValueUtils.isEmpty(icon)) {
            String iconHTML = renderIcon(icon);
            addBeforeContent(iconHTML);
        }

        if (!ValueUtils.isEmpty(text)) {
            addBeforeContent(text);
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