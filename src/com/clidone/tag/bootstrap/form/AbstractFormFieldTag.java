package com.clidone.tag.bootstrap.form;

import com.clidone.tag.AbstractTag;

abstract class AbstractFormFieldTag extends AbstractTag {

    private String label = null;
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    private boolean required = false;
    public boolean getRequired() {
        return required;
    }
    public void setRequired(boolean required) {
        this.required = required;
    }

    private boolean horizontal = false;
    public boolean getHorizontal() {
        return horizontal;
    }
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }
}