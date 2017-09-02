package com.clidone.tag.data;

/**
 * <strong>KeyValue pair data object</strong>
 * @author wuhuaxia
 */
public class KeyValue {

    // key
    private String key = null;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    // value
    private String value = null;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
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
    public KeyValue(String key, String value) {
        this.key   = key;
        this.value = value;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Key: " + key + "    Value: " + value;
    }
}