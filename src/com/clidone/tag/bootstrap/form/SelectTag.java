package com.clidone.tag.bootstrap.form;

import java.util.List;
import java.util.UUID;

import javax.servlet.jsp.JspException;

import com.clidone.tag.ValueUtils;

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

    // valueKey
    protected String valueKey = "key";
    public void setValueKey(String valueKey) {
        this.valueKey = valueKey;
    }

    // labelKey
    protected String labelKey = "value";
    public void setLabelKey(String labelKey) {
        this.labelKey = labelKey;
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

        Object item = null;
        Object valueData = null;
        Object labelData = null;

        if (formStatic || fieldStatic) {
            setTagName("p");
            addClass("form-control-static");

            boolean isMatch = false;
            if (items != null) {
                String optionValue = null;

                for (int i=0,len=items.size(); i<len; i++) {
                    item = items.get(i);
                    if (item == null) {
                        continue;
                    }
                    valueData = ValueUtils.get(item, valueKey);
                    labelData = ValueUtils.get(item, labelKey);

                    optionValue = ValueUtils.isEmpty(valueData) ? "" : String.valueOf(valueData);
                    if (isChcked(optionValue)) {
                        String optionLabel = ValueUtils.isEmpty(labelData) ? "" : String.valueOf(labelData);
                        addBeforeContent(optionLabel);
                        isMatch = true;
                    }
                }
            }

            if (!isMatch && hasDefault != null && hasDefault.booleanValue()) {
                addBeforeContent(defaultText);
            }

        } else {
            if (ValueUtils.isEmpty(fieldId)) {
                fieldId = UUID.randomUUID().toString();
            }
            if (ValueUtils.isEmpty(name)) {
                name = "";
            }

            setTagName("select");
            addClass("form-control");
            addAttribute("id",   fieldId);
            addAttribute("name", name);

            if (size != null) {
                addClass("input-"+size);
            }

            if (disabled != null && disabled.booleanValue()) {
                addAttribute("disabled", "disabled");
            }

            if (hasDefault != null && hasDefault.booleanValue()) {
                addBeforeContent("<option value=\""+defaultValue+"\">");
                addBeforeContent(defaultText);
                addBeforeContent("</option>");
            }

            if (items != null) {
                String optionLabel    = null;
                String optionValue    = null;
                String optionSelected = null;

                for (int i=0,len=items.size(); i<len; i++) {
                    item = items.get(i);
                    if (item == null) {
                        continue;
                    }
                    valueData = ValueUtils.get(item, valueKey);
                    labelData = ValueUtils.get(item, labelKey);

                    optionValue = ValueUtils.isEmpty(valueData) ? "" : String.valueOf(valueData);
                    optionLabel = ValueUtils.isEmpty(labelData) ? "" : String.valueOf(labelData);

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

        if (simple == null || (simple != null && !simple.booleanValue())) {
            renderWrap();
        }

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