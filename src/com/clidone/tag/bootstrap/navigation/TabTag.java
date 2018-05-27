package com.clidone.tag.bootstrap.navigation;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Tab tag</strong>
 * @author wuhuaxia
 */
public class TabTag extends AbstractTabTag {

    private static final long serialVersionUID = 3172907823164530962L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************

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

        addBeforeContent("<ul class=\"nav nav-tabs"+justifiedClass+"\" role=\"tablist\">");
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
                String  url      = itemData.getUrl();
                String  active   = itemData.getActive() ? " class=\"active\"" : "";
                String  badge    = itemData.getBadge();

                String iconHTML = "";
                if (!ValueUtils.isEmpty(icon)) {
                    iconHTML = renderIcon(icon, (iconOnly != null && iconOnly.booleanValue()));
                }

                addBeforeContent("<li role=\"presentation\""+active+">");
                if (ValueUtils.isEmpty(url)) {
                    addBeforeContent("<a href=\"#"+id+"\" aria-controls=\""+id+"\" role=\"tab\" data-toggle=\"tab\">"+iconHTML+text);
                } else {
                    String contextPath = super.getServletContext().getContextPath();
                    addBeforeContent("<a href=\""+contextPath+url+"\" role=\"tab\">"+iconHTML+text);
                }
                if (!ValueUtils.isEmpty(badge)) {
                    addBeforeContent("&nbsp;<span class=\"badge\">"+badge+"</span>");
                }
                addBeforeContent("</a>");
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