package com.clidone.tag.bootstrap.list;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>ListGroupItemText Tag</strong>
 * @author wuhuaxia
 */
public class ListGroupItemTextTag extends AbstractTag {

    private static final long serialVersionUID = -1996806117347829972L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // as
    protected String as = "p";
    public void setAs(String as) {
        this.as = as;
    }

    // text
    protected String text = null;
    public void setText(String text) {
        this.text = text;
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
        setTagName(as);

        addClass("list-group-item-text");

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