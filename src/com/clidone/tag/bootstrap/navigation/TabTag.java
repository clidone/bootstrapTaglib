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
        setTagName("ul");

        addBeforeWrap("<nav>");

        addClass("nav nav-tabs");

        if (justified != null && justified.booleanValue()) {
            addClass("nav-justified");
        }

        addAttribute("role", "tablist");

        if (items != null) {
            TabItemData itemData = null;
            for (int i=0,len=items.size(); i<len; i++) {
                itemData = items.get(i);
                if (itemData == null) {
                    continue;
                }

                String id     = itemData.getId();
                String text   = itemData.getText();
                String icon   = itemData.getIcon();
                String active = itemData.getActive() ? " class=\"active\"" : "";

                String iconHTML = "";
                if (!ValueUtils.isEmpty(icon)) {
                    iconHTML = renderIcon(icon);
                }

                addBeforeContent("<li role=\"presentation\""+active+">");
                addBeforeContent(    "<a href=\"#"+id+"\" aria-controls=\"home\" role=\"tab\" data-toggle=\"tab\">"+iconHTML+text+"</a>");
                addBeforeContent("</li>");
            }
        }

        addBeforeContent("<div class=\"tab-content\">");

        addAfterContent("</div>");

        addAfterWrap("</nav>");

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