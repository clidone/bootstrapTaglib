package com.clidone.tag.bootstrap.navigation;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Pill Tab tag</strong>
 * @author wuhuaxia
 */
public class PillTabTag extends AbstractTabTag {

    private static final long serialVersionUID = 4175699462039854126L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // stacked
    protected Boolean stacked = null;
    public void setStacked(Boolean stacked) {
        this.stacked = stacked;
    }

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    /**
     * @see AbstractTag#doEndTagV2()
     */
    @Override
    protected String doEndTagV2() throws JspException {
        setTagName("div");

        String justifiedClass = (justified != null && justified.booleanValue()) ? " nav-justified" : "";
        String stackedClass   = (stacked != null && stacked.booleanValue())     ? " nav-stacked"   : "";

        addBeforeContent("<ul class=\"nav nav-pills"+justifiedClass+stackedClass+"\" role=\"tablist\">");
        if (items != null) {
            TabItemData itemData = null;
            for (int i=0,len=items.size(); i<len; i++) {
                itemData = items.get(i);
                if (itemData == null) {
                    continue;
                }

                String  id       = itemData.getId();
                String  text     = itemData.getText();
                String  icon     = itemData.getIcon();
                Boolean iconOnly = itemData.getIconOnly();
                String  active   = itemData.getActive() ? " class=\"active\"" : "";

                String iconHTML = "";
                if (!ValueUtils.isEmpty(icon)) {
                    iconHTML = renderIcon(icon, (iconOnly != null && iconOnly.booleanValue()));
                }

                addBeforeContent("<li role=\"presentation\""+active+">");
                addBeforeContent(    "<a href=\"#"+id+"\" aria-controls=\"home\" role=\"tab\" data-toggle=\"tab\">"+iconHTML+text+"</a>");
                addBeforeContent("</li>");
            }
        }
        addBeforeContent("</ul>");

        addBeforeContent("<div class=\"tab-content\">");
        addAfterContent("</div>");

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