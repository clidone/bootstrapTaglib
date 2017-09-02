package com.clidone.tag.bootstrap.form;

import java.util.List;

import javax.servlet.jsp.JspException;

import com.clidone.tag.ValueUtils;
import com.clidone.tag.data.KeyValue;

/**
 * <strong>Checkbox list tag</strong>
 * @author wuhuaxia
 */
public class CheckboxListTag extends AbstractFormFieldTag {

    private static final long serialVersionUID = 1035607448189203580L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // items
    @SuppressWarnings("rawtypes")
    private List items = null;
    @SuppressWarnings("rawtypes")
    public List getItems() {
        return this.items;
    }
    @SuppressWarnings("rawtypes")
    public void setItems(List items) {
        this.items = items;
    }

    // data
    private Object data = null;
    public Object getData() {
        return this.data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    /**
     * @see AbstractFormFieldTag#renderV2()
     */
    @Override
    protected String renderV2() throws JspException {
        if (items != null) {
            KeyValue keyValue   = null;
            String filedLabel   = null;
            String filedValue   = null;
            String fieldChecked = null;

            String filedName = ValueUtils.isEmpty(super.name) ? "" : name;

            FormTag formTag      = (FormTag) findAncestorWithClass(this, FormTag.class);
            boolean formStatic   = (formTag != null && formTag.getStatic() != null && formTag.getStatic().booleanValue());
            boolean fieldStatic  = (staticFlag != null && staticFlag.booleanValue());
            String filedReadonly = (formStatic || fieldStatic) ? " readonly=\"readonly\"" : "";

            for (int i=0,len=items.size(); i<len; i++) {
                keyValue = (KeyValue) items.get(i);
                if (keyValue == null) {
                    continue;
                }

                filedLabel   = ValueUtils.isEmpty(keyValue.getValue()) ? "" : keyValue.getValue();
                filedValue   = ValueUtils.isEmpty(keyValue.getKey())   ? "" : keyValue.getKey();
                fieldChecked = !isChcked(filedValue)                   ? "" : " checked=\"checked\"";

                addBeforeContent("<div class=\"checkbox\">");
                addBeforeContent(    "<label>");
                addBeforeContent(        "<input type=\"checkbox\" name=\""+filedName+"\" value=\""+filedValue+"\""+filedReadonly+fieldChecked+">" + filedLabel);
                addBeforeContent(    "</label>");
                addBeforeContent("</div>");
            }
        }

        renderWrap();

        return render();
    }

    /**
     * @see AbstractFormFieldTag#renderV3()
     */
    @Override
    protected String renderV3() throws JspException {
        return renderV2();
    }

    /**
     * Check value is match or not
     * @param value item value
     * @return true: matched, false: not match
     */
    private boolean isChcked(String value) {
        boolean checked = false;

        if (data instanceof String) {
            String dataStr = (String) data;
            if (!ValueUtils.isEmpty(dataStr)) {
                checked = (dataStr.indexOf(value) >= 0);
            } else if ("".equals(dataStr) && "".equals(value)) {
                checked = true;
            }

        } else if (data instanceof List) {
            @SuppressWarnings("rawtypes")
            List dataList = (List) data;
            if (dataList != null) {
                String itemValue = null;

                for (int i=0,len=dataList.size(); i<len; i++) {
                    itemValue = dataList.get(i).toString();

                    if (!ValueUtils.isEmpty(itemValue) && itemValue.equals(value)) {
                        checked = true;
                        break;

                    } else if ("".equals(itemValue) && "".equals(value)) {
                        checked = true;
                        break;
                    }
                }
            }
        }

        return checked;
    }
}