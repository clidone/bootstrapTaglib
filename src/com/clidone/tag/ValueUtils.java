package com.clidone.tag;

import java.lang.reflect.Method;

/**
 * <strong>Value Data Utils</strong>
 * @author wuhuaxia
 */
public final class ValueUtils {

    /**
     * Validate value is empty or not
     * @return true: empty, false: not empty
     */
    public final static boolean isEmpty(String value) {
        return (value == null || value.length() == 0);
    }

    /**
     * Validate value is empty or not
     * @return true: empty, false: not empty
     */
    public final static boolean isEmpty(Boolean value) {
        return (value == null);
    }

    /**
     * Validate value is empty or not
     * @return true: empty, false: not empty
     */
    public final static boolean isEmpty(Integer value) {
        return (value == null);
    }

    /**
     * Validate value is empty or not
     * @return true: empty, false: not empty
     */
    public final static boolean isEmpty(Long value) {
        return (value == null);
    }

    /**
     * Validate value is empty or not
     * @return true: empty, false: not empty
     */
    public final static boolean isEmpty(Double value) {
        return (value == null);
    }

    /**
     * Validate value is empty or not
     * @return true: empty, false: not empty
     */
    public final static boolean isEmpty(Short value) {
        return (value == null);
    }

    /**
     * Get item data
     * @param item data object
     * @param key data key
     * @return
     */
    public final static Object get(Object item, String key) {
        if (item == null) {
            return "";
        }

        Object value = null;

        try {
            Method[] methods = item.getClass().getMethods();
            if (methods != null) {
                String getter = buildGetter(key);
                for (int i=0,len=methods.length; i<len; i++) {
                    if (getter.equals(methods[i].getName())) {
                        value = methods[i].invoke(item);
                        break;
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            value = "";
        }

        return value;
    }

    /**
     * Build key getter method name
     * @param key Key
     * @return key getter method name
     */
    private final static String buildGetter(String key) {
        if (isEmpty(key)) {
            return "get";
        }
        String getter = String.valueOf(key.charAt(0)).toUpperCase();
        if (key.length() > 1) {
            getter += key.substring(1);
        }
        return "get" + getter;
    }
}