package com.clidone.tag.ext;

import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.data.KeyValue;

/**
 * <strong>Choose tag</strong>
 * @author wuhuaxia
 */
public class ChooseTag extends AbstractTag {

    private static final long serialVersionUID = 6263942748511371150L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // value
    protected String value = null;
    public void setValue(String value) {
        this.value = value;
    }

    // items
    protected Object items = null;
    public void setItems(Object items) {
        this.items = items;
    }

    // varKey
    protected String varKey = "key";
    public void setVarKey(String varKey) {
        this.varKey = varKey;
    }

    // varValue
    protected String varValue = "value";
    public void setVarValue(String varValue) {
        this.varValue = varValue;
    }

    // noMatch
    protected String noMatch = null;
    public void setNoMatch(String noMatch) {
        this.noMatch = noMatch;
    }

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    /**
     * @see AbstractTag#doStartTagV2()
     */
    @Override
    protected int doStartTagV2() throws JspException {
        // set noMatch value attribute as default
        if (noMatch == null) {
            noMatch = String.valueOf(value);
        }

        String matchKey   = String.valueOf(value);
        String matchValue = noMatch;

        if (items instanceof Map<?, ?>) {
            Map<?, ?> data = (Map<?, ?>) items;
            if (data.containsKey(value)) {
                matchValue = String.valueOf(data.get(value));
            }

        } else if (items instanceof List<?>) {
            List<?> data = (List<?>) items;
            KeyValue keyValue = null;
            for (int i=0,len=data.size(); i<len; i++) {
                keyValue = (KeyValue) data.get(i);
                if (value.equals(keyValue.getKey())) {
                    matchValue = keyValue.getValue();
                    break;
                }
            }

        } else {
            throw new JspException("Choose tag 'data' attribute not support.");
        }

        pageContext.setAttribute(varKey,   matchKey);
        pageContext.setAttribute(varValue, matchValue);

        return EVAL_BODY_BUFFERED;
    }

    /**
     * @see AbstractTag#doStartTagV3()
     */
    @Override
    protected int doStartTagV3() throws JspException {
        return doStartTagV2();
    }

    /**
     * @see AbstractTag#doEndTagV2()
     */
    @Override
    protected String doEndTagV2() throws JspException {
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