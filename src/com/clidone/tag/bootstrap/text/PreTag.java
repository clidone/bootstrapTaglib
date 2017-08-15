package com.clidone.tag.bootstrap.text;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * <strong>Pre tag</strong>
 * @author wuhuaxia
 */
public class PreTag extends TagSupport {

    private static final long serialVersionUID = 5329194455820201924L;

    // 使用 .pre-scrollable 类，其作用是设置 max-height 为 350px ，并在垂直方向展示滚动条。
    private int height = 200;
    public void setHeight(int height) {
        this.height = height;
    }
}