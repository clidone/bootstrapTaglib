package com.clidone.tag.data;

/**
 * <strong>KeyValue pair data object</strong>
 * @author wuhuaxia
 */
public class KeyValue {

    // key
    private Object key = null;
    public Object getKey() {
        return key;
    }
    public void setKey(Object key) {
        this.key = key;
    }

    // value
    private Object value = null;
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Constructor
     */
    public KeyValue() {
    }

    /**
     * Constructor
     * @param key Key
     * @param value Value
     */
    public KeyValue(Object key, Object value) {
        this.key   = key;
        this.value = value;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Key: " + String.valueOf(key) + "    Value: " + String.valueOf(value);
    }
}