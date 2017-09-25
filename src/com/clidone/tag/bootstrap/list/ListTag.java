package com.clidone.tag.bootstrap.list;

import java.util.List;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;

/**
 * <strong>List tag</strong>
 * @author wuhuaxia
 */
public class ListTag extends AbstractTag {

    private static final long serialVersionUID = 193649963855763129L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // 前缀：dot、number
    // TODO：更加前缀选择ul或ol标签
    protected String prefix = "dot";
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    // 无样式列表
    protected boolean unstyled = false;
    public void setUnstyled(boolean unstyled) {
        this.unstyled = unstyled;
    }

    // 内联列表
    protected boolean inline = false;
    public void setInline(boolean inline) {
        this.inline = inline;
    }

    // 列表组 list-group
    protected boolean group = false;
    public void setgroup(boolean group) {
        this.group = group;
    }

    // 内容：TODO：根据内容智能显示只标签？还是标签内再用标签自定义填充？
    protected List<?> content;
    public void setContent(List<?> content) {
        this.content = content;
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