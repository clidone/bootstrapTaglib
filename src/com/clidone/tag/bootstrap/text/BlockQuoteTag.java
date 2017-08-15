package com.clidone.tag.bootstrap.text;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * <strong>BlockQuote tag</strong>
 * @author wuhuaxia
 */
public class BlockQuoteTag extends TagSupport {

    private static final long serialVersionUID = -2244044361875784196L;

    // 通过赋予 .blockquote-reverse 类可以让引用呈现内容右对齐的效果。
    private boolean reverse = false;
    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

}