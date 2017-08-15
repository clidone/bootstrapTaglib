package com.clidone.tag.bootstrap.table;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * <strong>Table Tr tag</strong>
 * @author wuhuaxia
 */
public class TableTrTag extends TagSupport {

    private static final long serialVersionUID = -5710817565452268913L;

    // 通过这些状态类可以为行或单元格设置颜色。
    private String status = null;
    public void setStatus(String status) {
        this.status = status;
    }
}