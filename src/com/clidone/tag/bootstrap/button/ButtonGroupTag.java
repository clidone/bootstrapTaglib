package com.clidone.tag.bootstrap.button;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * <strong>Button group tag</strong>
 * @author wuhuaxia
 */
public class ButtonGroupTag extends TagSupport {

    private static final long serialVersionUID = 6761901111465647297L;

    // 只要给 .btn-group 加上 .btn-group-* 类，就省去为按钮组中的每个按钮都赋予尺寸类了，如果包含了多个按钮组时也适用。
    private String size = null;
    public void setSize(String size) {
        this.size = size;
    }

    // 只须将一系列 .btn 元素包裹到 .btn-group.btn-group-justified 中即可。
    private boolean justified = false;
    public void setJustified() {
        this.justified = justified;
    }

    // 让一组按钮垂直堆叠排列显示而不是水平排列。分列式按钮下拉菜单不支持这种方式。
    private boolean vertical = false;
    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }
}