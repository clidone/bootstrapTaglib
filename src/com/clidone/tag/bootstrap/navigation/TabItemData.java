package com.clidone.tag.bootstrap.navigation;

/**
 * <strong>Tab Item data</strong>
 * @author wuhuaxia
 */
class TabItemData {

    // id
    private String id = null;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    // text
    private String text = null;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    // icon
    private String icon = null;
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // order
    private int order = 0;
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }

    // active
    private boolean active = false;
    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}