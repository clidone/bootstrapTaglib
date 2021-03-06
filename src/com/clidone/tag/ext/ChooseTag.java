package com.clidone.tag.ext;

import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

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

    // matchKey
    protected String matchKey = "key";
    public void setMatchKey(String matchKey) {
        this.matchKey = matchKey;
    }

    // matchValue
    protected String matchValue = "value";
    public void setMatchValue(String matchValue) {
        this.matchValue = matchValue;
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
        if (ValueUtils.isEmpty(value)) {
            value = "";
        }

        // set noMatch value attribute as default
        if (noMatch == null) {
            noMatch = value;
        }

        String foundKey   = value;
        String foundValue = noMatch;

        if (items != null) {
            if (items instanceof Map<?, ?>) {
                Map<?, ?> data = (Map<?, ?>) items;
                if (data.containsKey(foundKey)) {
                    Object foundObject = data.get(foundKey);
                    foundValue = (foundObject == null) ? "" : foundObject.toString();
                }

            } else if (items instanceof List<?>) {
                List<?> data = (List<?>) items;
                Object item = null;
                for (int i=0,len=data.size(); i<len; i++) {
                    item = data.get(i);
                    Object itemObject = ValueUtils.get(item, varKey);
                    String itemKey = (itemObject == null) ? "" : itemObject.toString();

                    if (foundKey.equals(itemKey)) {
                        Object foundObject = ValueUtils.get(item, varValue);
                        foundValue = (foundObject == null) ? "" : foundObject.toString();
                        break;
                    }
                }

            } else {
                throw new JspException("Choose tag 'items' attribute not support.");
            }
        }

        pageContext.setAttribute(matchKey,   foundKey);
        pageContext.setAttribute(matchValue, foundValue);

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