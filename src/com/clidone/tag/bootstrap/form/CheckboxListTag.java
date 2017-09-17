package com.clidone.tag.bootstrap.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;

import com.clidone.tag.ValueUtils;
import com.clidone.tag.data.KeyValue;

/**
 * <strong>Checkbox list tag</strong>
 * <p>
 * Initialize checkbox list, there are three ways:
 * <ol>
 *   <li>set <code>items</code> attribute as List data: In this case, you should also setup both of
 *       <code>valueKey</code> and <code>textKey</code> attributes, we will access current item with
 *       valueKey and textKey getter methods, and build valueKey as checkbox field value, textKey as
 *       checkbox display text;
 *   </li>
 *   <li>set <code>items</code> attribute as String[][] data: In this case, the inner array index 0 data
 *   are checkbox field value, index 1 are checkbox display text;
 *   </li>
 *   <li>set <code>keys</code> and <code>texts</code> attributes: both of these are String and concatenated
 *   by ',' char, values is checkbox field value, texts is checkbox field display text.
 *   </li>
 * </ol>
 * </p>
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
    // Support type: List<?> and String[][], when render items is List, we must also setup valueKey and textKey attributes,
    // or items is instance of String[][], the second array index 0 is value, index 1 is text
    private List<KeyValue> items = null;
    public void setItems(Object items) throws JspException {
        if (items == null) {
            return;
        }
        initItems(items);
    }

    // valueKey
    private String valueKey = null;
    public void setValueKey(String valueKey) {
        this.valueKey = valueKey;
    }

    // textKey
    private String textKey = null;
    public void setTextKey(String textKey) {
        this.textKey = textKey;
    }

    // values
    private String values = null;
    public void setKeys(String values) throws JspException {
        this.values = values;
        initItems();
    }

    // texts
    private String texts = null;
    public void setTexts(String texts) throws JspException {
        this.texts = texts;
        initItems();
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

                addBeforeContent("<label class=\"checkbox-inline\">");
                addBeforeContent(    "<input type=\"checkbox\" name=\""+filedName+"\" value=\""+filedValue+"\""+filedReadonly+fieldChecked+">" + filedLabel);
                addBeforeContent("</label>");
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
     * Initialize items list
     * @param items item object
     * @throws JspException
     */
    private void initItems(Object items) throws JspException {
        if (items instanceof List<?>) {
            this.items = new ArrayList<KeyValue>();

            if (ValueUtils.isEmpty(valueKey)) {
                throw new JspException("items is list, 'valueKey' attribute is required.");
            }
            if (ValueUtils.isEmpty(textKey)) {
                throw new JspException("items is list, 'textKey' attribute is required.");
            }

            List<?> list = (List<?>) items;
            for (int i=0,len=list.size(); i<len; i++) {
                Object item = list.get(i);
                if (item == null) {
                    continue;
                }

                Object value = ValueUtils.get(item, valueKey);
                Object text  = ValueUtils.get(item, textKey);
                this.items.add(new KeyValue(
                    ((value == null) ? "" : value.toString()),
                    ((text == null)  ? "" : text.toString())
                ));
            }

        } else if (items instanceof String[][]) {
            this.items = new ArrayList<KeyValue>();

            String[][] arrays = (String[][]) items;
            for (int i=0,len=arrays.length; i<len; i++) {
                String[] item = arrays[i];
                if (item == null) {
                    continue;
                }

                this.items.add(new KeyValue(
                    ((item[0] == null) ? "" : item[0]),
                    ((item[1] == null) ? "" : item[1])
                ));
            }
        }
    }

    /**
     * Initialize items list
     * @throws JspException
     */
    private void initItems() throws JspException {
        if (this.values == null) {
            return;
        }
        if (this.texts == null) {
            return;
        }

        String[] valueArray = this.values.split(",");
        String[] textArray  = this.texts.split(",");
        if (valueArray.length != textArray.length) {
            throw new JspException("values and texts (length) is NOT equal.");
        }

        this.items = new ArrayList<KeyValue>();
        for (int i=0,len=valueArray.length; i<len; i++) {
            this.items.add(new KeyValue(
                ((valueArray[i] == null) ? "" : valueArray[i]),
                ((textArray[i]  == null) ? "" : textArray[i])
            ));
        }
    }

    /**
     * Check value is match or not
     * @param filedValue item value
     * @return true: matched, false: not match
     */
    private boolean isChcked(String filedValue) {
        boolean checked = false;

        if (this.value instanceof String) {
            String data = (String) this.value;
            if (!ValueUtils.isEmpty(data)) {
                checked = (data.indexOf(filedValue) >= 0);
            }

        } else if (this.value instanceof String[]) {
            String[] data = (String[]) this.value;
            if (data != null) {
                String itemValue = null;
                for (int i=0,len=data.length; i<len; i++) {
                    itemValue = data[i];
                    if ((itemValue == null && filedValue == null) ||
                        ("".equals(itemValue) && "".equals(filedValue)) ||
                        (itemValue != null && itemValue.equals(filedValue))) {
                        checked = true;
                        break;
                    }
                }
            }

        } else if (this.value instanceof List<?>) {
            List<?> data = (List<?>) this.value;
            if (data != null) {
                String itemValue = null;
                for (int i=0,len=data.size(); i<len; i++) {
                    itemValue = String.valueOf(data.get(i));
                    if ((itemValue == null && filedValue == null) ||
                        ("".equals(itemValue) && "".equals(filedValue)) ||
                        (itemValue != null && itemValue.equals(filedValue))) {
                        checked = true;
                        break;
                    }
                }
            }
        }

        return checked;
    }
}