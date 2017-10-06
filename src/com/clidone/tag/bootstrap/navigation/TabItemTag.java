package com.clidone.tag.bootstrap.navigation;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Tab item tag</strong>
 * @author wuhuaxia
 */
public class TabItemTag extends AbstractTag {

    private static final long serialVersionUID = 6903452245469940722L;

    // **********************************************************************************
    //
    // Tag data
    //
    // **********************************************************************************
    // default active flag
    private boolean isActive = false;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // id
    protected String id = null;
    public void setId(String id) {
        this.id = id;
    }

    // text
    protected String text = null;
    public void setText(String text) {
        this.text = text;
    }

    // icon
    protected String icon = null;
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // iconOnly
    protected Boolean iconOnly = new Boolean(false);
    public void setIconOnly(Boolean iconOnly) {
        this.iconOnly = iconOnly;
    }

    // active
    protected Boolean active = null;
    public void setActive(Boolean active) {
        this.active = active;
    }

    // disabled
    protected Boolean disabled = null;
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    // order
    protected int order = 0;
    public void setOrder(int order) {
        this.order = order;
    }

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    /**
     * @see AbstractTag#doStartTagV2()
     */
    @Override
    protected int doStartTagV2() throws JspException {
        AbstractTabTag tabTag = (AbstractTabTag) findAncestorWithClass(this, AbstractTabTag.class);
        if (tabTag != null) {
            // set default active flag
            String tabActive = tabTag.getActive();
            isActive = (!ValueUtils.isEmpty(tabActive) && tabActive.equals(id)) ||
                       (active != null && active.booleanValue());

            // register item data
            TabItemData itemData = new TabItemData();
            itemData.setId(id);
            itemData.setText(text);
            itemData.setIcon(icon);
            itemData.setIconOnly(iconOnly);
            itemData.setOrder(order);
            itemData.setActive(isActive);
            tabTag.addItem(itemData);
        }

        return EVAL_BODY_BUFFERED;
    }

    /**
     * @see AbstractTag#doStartTagV3()
     */
    @Override
    protected int doStartTagV3() throws JspException {
        return doStartTagV2();
    }

    /**
     * @see AbstractTag#doEndTagV2()
     */
    @Override
    protected String doEndTagV2() throws JspException {
        setTagName("div");

        AbstractTabTag tabTag = (AbstractTabTag) findAncestorWithClass(this, AbstractTabTag.class);
        if (tabTag == null) {
            throw new JspException("");
        }

        addClass("tab-pane");

        if (isActive) {
            addClass("active");
        }

        if (disabled != null && disabled.booleanValue()) {
            addClass("disabled");
        }

        if (tabTag.getFade() != null && tabTag.getFade().booleanValue()) {
            addClass("fade");
            if (isActive) {
                addClass("in");
            }
        }

        addAttribute("id",   id);
        addAttribute("role", "tabpanel");

        return render();
    }

    /**
     * @see AbstractTag#doEndTagV3()
     */
    @Override
    protected String doEndTagV3() throws JspException {
        return doEndTagV2();
    }
}