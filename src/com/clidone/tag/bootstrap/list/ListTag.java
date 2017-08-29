package com.clidone.tag.bootstrap.list;

import java.util.List;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * <strong>List tag</strong>
 * @author wuhuaxia
 */
public class ListTag extends TagSupport {

    // 前缀：dot、number
    // TODO：更加前缀选择ul或ol标签
    private String prefix = "dot";
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    // 无样式列表
    private boolean unstyled = false;
    public void setUnstyled(boolean unstyled) {
        this.unstyled = unstyled;
    }

    // 内联列表
    private boolean inline = false;
    public void setInline(boolean inline) {
        this.inline = inline;
    }

    // 列表组 list-group
    private boolean group = false;
    public void setgroup(boolean group) {
        this.group = group;
    }

    // 内容：TODO：根据内容智能显示只标签？还是标签内再用标签自定义填充？
    private List content;
    public void setContent(List content) {
        this.content = content;
    }
}