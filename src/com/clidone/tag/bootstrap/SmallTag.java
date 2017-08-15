package com.clidone.tag.bootstrap;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * <strong>Small tag</strong>
 * @author wuhuaxia
 */
public class SmallTag extends TagSupport {

    private static final long serialVersionUID = -6239073026173720098L;

    // 在标题内还可以包含 <small> 标签或赋予 .small 类的元素，可以用来标记副标题。
    private boolean small = true;
    public void setSmall(boolean small) {
        this.small = small;
    }
}