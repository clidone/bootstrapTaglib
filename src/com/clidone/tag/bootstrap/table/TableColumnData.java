package com.clidone.tag.bootstrap.table;

/**
 * <strong>Table column data</strong>
 * @author wuhuaxia
 */
class TableColumnData {

    // label
    private String label = null;
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    // headerClass
    private String headerClass = null;
    public void setHeaderClass(String headerClass) {
        this.headerClass = headerClass;
    }
    public String getHeaderClass() {
        return headerClass;
    }

    // bodyClass
    private String bodyClass = null;
    public void setBodyClass(String bodyClass) {
        this.bodyClass = bodyClass;
    }
    public String getBodyClass() {
        return bodyClass;
    }

    // footerClass
    private String footerClass = null;
    public void setFooterClass(String footerClass) {
        this.footerClass = footerClass;
    }
    public String getFooterClass() {
        return footerClass;
    }
}