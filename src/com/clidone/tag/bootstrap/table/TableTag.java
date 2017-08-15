package com.clidone.tag.bootstrap.table;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * <strong>Table tag</strong>
 * @author wuhuaxia
 */
public class TableTag extends TagSupport {

    private static final long serialVersionUID = -5271790824898179363L;

    // 添加 .table-bordered 类为表格和其中的每个单元格增加边框。
    private boolean bordered = false;
    public void setBordered(boolean bordered) {
        this.bordered = bordered;
    }

    // 通过添加 .table-condensed 类可以让表格更加紧凑，单元格中的内补（padding）均会减半。
    private boolean condensed = false;
    public void setCondensed(boolean condensed) {
        this.condensed = condensed;
    }

    // 通过添加 .table-hover 类可以让 <tbody> 中的每一行对鼠标悬停状态作出响应。
    private boolean hover = false;
    public void setHover(boolean hover) {
        this.hover = hover;
    }

    // 通过 .table-striped 类可以给 <tbody> 之内的每一行增加斑马条纹样式。
    private boolean striped = false;
    public void setStriped(boolean striped) {
        this.striped = striped;
    }

    // 将任何 .table 元素包裹在 .table-responsive 元素内，即可创建响应式表格，
    // 其会在小屏幕设备上（小于768px）水平滚动。当屏幕大于 768px 宽度时，水平滚动条消失。
    private boolean responsive = true;
    public void setResponsive(boolean responsive) {
        this.responsive = responsive;
    }
}