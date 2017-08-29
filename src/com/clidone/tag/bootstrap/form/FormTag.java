package com.clidone.tag.bootstrap.form;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * <strong>Form tag</strong>
 * @author wuhuaxia
 */
public class FormTag extends TagSupport {

    private static final long serialVersionUID = -142338100833633729L;

    private String action = null;
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }

    private String method = "post";
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }

    // 通过为表单添加 .form-horizontal 类，并联合使用 Bootstrap 预置的栅格类，
    // 可以将 label 标签和控件组水平并排布局。这样做将改变 .form-group 的行为，
    // 使其表现为栅格系统中的行（row），因此就无需再额外添加 .row 了。
    private boolean horizontal = false;
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    // 为 <form> 元素添加 .form-inline 类可使其内容左对齐并且表现为 inline-block 级别的控件。
    // 只适用于视口（viewport）至少在 768px 宽度时（视口宽度再小的话就会使表单折叠）。
    private boolean inline = false;
    public void setInline(boolean inline) {
        this.inline = inline;
    }

    private Object model = null;
    public Object getModel() {
        return model;
    }
    public void setModel(Object model) {
        this.model = model;
    }
}