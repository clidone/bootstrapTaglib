package com.clidone.tag.bootstrap;

import javax.servlet.jsp.tagext.BodyContent;

import com.clidone.tag.AbstractBodyTag;

/**
 * <strong>Row tag</strong>
 * @author wuhuaxia
 */
public class RowTag extends AbstractBodyTag {

    private static final long serialVersionUID = 2712884462549558144L;

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
     * @see AbstractBodyTag#renderV2()
     */
    @Override
    protected String renderV2() {
        BodyContent bodyContent = super.getBodyContent();

        StringBuilder tagHTML = new StringBuilder();
        tagHTML.append("<div class=\"row ").append(super.getClassCss()).append("\" style=\"").append(super.getStyleCss()).append("\">");
        tagHTML.append(bodyContent.getString());
        tagHTML.append("</div>");

        return tagHTML.toString();
    }

    /**
     * @see AbstractBodyTag#renderV3()
     */
    @Override
    protected String renderV3() {
        return renderV2();
    }
}