package com.clidone.tag.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <strong>KeyValue Builder</strong>
 * @author wuhuaxia
 */
public class KeyValueBuilder {

    /**
     * Constructor
     * @throws Exception
     */
    public KeyValueBuilder() throws Exception {
        throw new Exception("Not support instantiate.");
    }

    /**
     * Build List
     * @param data key:value array
     * @return key value list
     */
    public static List<KeyValue> build(Object[][] data) {
        if (data == null) {
            return new ArrayList<KeyValue>();
        }

        int size  = data.length;
        List<KeyValue> list = new ArrayList<KeyValue>(size);
        for (int i=0; i<size; i++) {
            list.add(new KeyValue(data[i][0], data[i][1]));
        }

        return list;
    }

    /**
     * Build List
     * @param dataList source data
     * @param keyName data key name
     * @param valueName data value name
     * @return key value list
     */
    @SuppressWarnings("rawtypes")
    public static List<KeyValue> build(List dataList, String keyName, String valueName) {
        if (dataList == null) {
            return new ArrayList<KeyValue>();
        }

        Map<?,?> data = null;
        int  size = dataList.size();
        List<KeyValue> list = new ArrayList<KeyValue>(size);

        for (int i=0; i<size; i++) {
            data = (Map<?, ?>) dataList.get(i);
            list.add(new KeyValue(String.valueOf(data.get(keyName)), String.valueOf(data.get(valueName))));
        }

        return list;
    }
}