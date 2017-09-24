package com.clidone.tag.bootstrap.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>ListGroup tag</strong>
 * @author wuhuaxia
 */
public class ListGroupTag extends AbstractTag {

    private static final long serialVersionUID = 2195299604191314411L;

    // ListGroup Type
    public static final String AS_TEXT   = "text";
    public static final String AS_LINK   = "link";
    public static final String AS_BUTTON = "button";

    // **********************************************************************************
    //
    // Tag data
    //
    // **********************************************************************************
    // Raw data iterator
    protected Iterator<?> iterator = null;

    // has set items attribute
    protected boolean hasSetItems = false;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // as
    protected String as = null;
    public String getAs() {
        return as;
    }
    public void setAs(String as) {
        this.as = as;
    }

    // var
    protected String var = null;
    public void setVar(String var) throws JspException {
        if (ValueUtils.isEmpty(var)) {
            throw new JspException("ListGroup var attribute is required.");
        }
        this.var = var;
    }

    // items
    public void setItems(Object items) {
        hasSetItems = true;

        // initialize raw data iterator
        if (items instanceof Collection) {
            Collection<?> data = (Collection<?>) items;
            this.iterator = data.iterator();

        } else if (items instanceof Map) {
            Map<?,?> data = (Map<?,?>) items;
            this.iterator = data.entrySet().iterator();
        }
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
        boolean hasMoreData = hasMoreData();
        if (hasMoreData) {
            // get current item, and make it available for body render
            Object item = iterator.next();
            if (pageContext.getAttribute(var) != null) {
                pageContext.removeAttribute(var);
            }
            pageContext.setAttribute(var, item);

            return EVAL_BODY_BUFFERED;
        } else {
            return hasSetItems ? SKIP_BODY : EVAL_BODY_BUFFERED;
        }
    }

    /**
     * @see AbstractTag#doStartTagV3()
     */
    @Override
    protected int doStartTagV3() throws JspException {
        return doStartTagV2();
    }

    /**
     * @see AbstractTag#doAfterBodyV2()
     */
    @Override
    protected int doAfterBodyV2() throws JspException {
        boolean hasMoreData = hasMoreData();
        if (hasMoreData) {
            // get current item, and make it available for body render
            Object item = iterator.next();
            if (pageContext.getAttribute(var) != null) {
                pageContext.removeAttribute(var);
            }
            pageContext.setAttribute(var, item);

            return EVAL_BODY_AGAIN;
        } else {
            return SKIP_BODY;
        }
    }

    /**
     * @see AbstractTag#doAfterBodyV3()
     */
    @Override
    protected int doAfterBodyV3() throws JspException {
        return doAfterBodyV2();
    }

    /**
     * @see AbstractTag#doEndTagV2()
     */
    @Override
    protected String doEndTagV2() throws JspException {
        switch (as) {
            case AS_TEXT:   setTagName("ul");  break;
            case AS_LINK:   setTagName("div"); break;
            case AS_BUTTON: setTagName("div"); break;
        }

        addClass("list-group");

        return render();
    }

    /**
     * @see AbstractTag#doEndTagV3()
     */
    @Override
    protected String doEndTagV3() throws JspException {
        return doEndTagV2();
    }

    /**
     * Check has more data or not
     * @return true: has data, false: no more data
     */
    private boolean hasMoreData() {
        if (iterator == null) {
            return false;
        }
        return iterator.hasNext();
    }
}