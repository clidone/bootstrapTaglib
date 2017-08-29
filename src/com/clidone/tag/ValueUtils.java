package com.clidone.tag;

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
        return (value == null || "".equals(value.trim()));
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
}