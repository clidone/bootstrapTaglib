package com.clidone.tag.bootstrap.form;

import java.util.List;

import javax.servlet.jsp.JspException;

import com.clidone.tag.ValueUtils;
import com.clidone.tag.data.KeyValue;

/**
 * <strong>Select tag</strong>
 * @author wuhuaxia
 */
public class SelectTag extends AbstractFormFieldTag {

    private static final long serialVersionUID = 6840918125749769893L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // items
    protected List<?> items = null;
    public void setItems(List<?> items) {
        this.items = items;
    }

    // hasDefault
    protected Boolean hasDefault = null;
    public void setHasDefault(Boolean hasDefault) {
        this.hasDefault = hasDefault;
    }

    // defaultValue
    protected String defaultValue = "";
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    // defaultText
    protected String defaultText = "";
    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    /**
     * @see AbstractFormFieldTag#doEndTagV2()
     */
    @Override
    protected String doEndTagV2() throws JspException {
        FormTag formTag     = (FormTag) findAncestorWithClass(this, FormTag.class);
        boolean formStatic  = (formTag != null && formTag.getStatic() != null && formTag.getStatic().booleanValue());
        boolean fieldStatic = (staticFlag != null && staticFlag.booleanValue());

        if (formStatic || fieldStatic) {
            setTagName("p");
            addClass("form-control-static");

            boolean isMatch = false;
            if (items != null) {
                KeyValue keyValue  = null;
                String optionValue = null;

                for (int i=0,len=items.size(); i<len; i++) {
                    keyValue = (KeyValue) items.get(i);
                    if (keyValue == null) {
                        continue;
                    }

                    optionValue = ValueUtils.isEmpty(keyValue.getKey())   ? "" : keyValue.getKey();
                    if (isChcked(optionValue)) {
                        String optionLabel = ValueUtils.isEmpty(keyValue.getValue()) ? "" : keyValue.getValue();
                        addBeforeContent(optionLabel);
                        isMatch = true;
                    }
                }
            }

            if (!isMatch && hasDefault != null && hasDefault.booleanValue()) {
                addBeforeContent(defaultText);
            }

        } else {
            setTagName("select");
            addClass("form-control");

            if (hasDefault != null && hasDefault.booleanValue()) {
                addBeforeContent("<option value=\""+defaultValue+"\">");
                addBeforeContent(defaultText);
                addBeforeContent("</option>");
            }

            if (items != null) {
                KeyValue keyValue     = null;
                String optionLabel    = null;
                String optionValue    = null;
                String optionSelected = null;

                for (int i=0,len=items.size(); i<len; i++) {
                    keyValue = (KeyValue) items.get(i);
                    if (keyValue == null) {
                        continue;
                    }

                    optionLabel = ValueUtils.isEmpty(keyValue.getValue()) ? "" : keyValue.getValue();
                    optionValue = ValueUtils.isEmpty(keyValue.getKey())   ? "" : keyValue.getKey();

                    if (isChcked(optionValue)) {
                        optionSelected = " selected=\"selected\"";
                    } else {
                        optionSelected = "";
                    }

                    addBeforeContent("<option value=\""+optionValue+"\""+optionSelected+">");
                    addBeforeContent(optionLabel);
                    addBeforeContent("</option>");
                }
            }
        }

        renderWrap();

        return render();
    }

    /**
     * @see AbstractFormFieldTag#doEndTagV3()
     */
    @Override
    protected String doEndTagV3() throws JspException {
        return doEndTagV2();
    }

    /**
     * Check value is match or not
     * @param optionValue option value
     * @return true: matched, false: not match
     */
    private boolean isChcked(String optionValue) {
        boolean checked = false;

        if (value != null) {
            checked = String.valueOf(value).equals(optionValue);
        }

        return checked;
    }
}