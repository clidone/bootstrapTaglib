package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Text tag</strong>
 * @author wuhuaxia
 */
public class TextTag extends AbstractTag {

    private static final long serialVersionUID = -8887543450510548104L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // as
    private String as = null;
    public String getAs() {
        return this.as;
    }
    public void setAs(String as) {
        this.as = as;
    }

    // font-family
    private String fontFamily = null;
    public String getFontFamily() {
        return fontFamily;
    }
    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    // font-size
    private String fontSize = null;
    public String getFontSize() {
        return fontSize;
    }
    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    // font-style
    private String fontStyle = null;
    public String getFontStyle() {
        return fontStyle;
    }
    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    // font-weight
    private String fontWeight = null;
    public String getFontWeight() {
        return fontWeight;
    }
    public void setFontWeight(String fontWeight) {
        this.fontWeight = fontWeight;
    }

    // line-height
    private String lineHeight = null;
    public String getLineHeight() {
        return lineHeight;
    }
    public void setLineHeight(String lineHeight) {
        this.lineHeight = lineHeight;
    }

    // cursor
    private String cursor = null;
    public String getCursor() {
        return this.cursor;
    }
    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    // text-align
    private String textAlign = null;
    public String getAlign() {
        return textAlign;
    }
    public void setAlign(String textAlign) {
        this.textAlign = textAlign;
    }

    // color
    private String color = null;
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    // background-color
    private String bg = null;
    public String getBg() {
        return bg;
    }
    public void setBg(String bg) {
        this.bg = bg;
    }

    // case
    private String textCase = null;
    public String getCase() {
        return this.textCase;
    }
    public void setCase(String textCase) {
        this.textCase = textCase;
    }

    // icon
    private String icon = null;
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    /**
     * @see AbstractTag#renderV2()
     */
    @Override
    protected String renderV2() throws JspException {
        setTagName(as);

        if (!ValueUtils.isEmpty(fontFamily)) {
            addStyle("font-family", fontFamily);
        }

        if (!ValueUtils.isEmpty(fontSize)) {
            addStyle("font-size", fontSize);
        }

        if (!ValueUtils.isEmpty(fontStyle)) {
            addStyle("font-style", fontStyle);
        }

        if (!ValueUtils.isEmpty(fontWeight)) {
            addStyle("font-weight", fontWeight);
        }

        if (!ValueUtils.isEmpty(lineHeight)) {
            addStyle("line-height", lineHeight);
        }

        if (!ValueUtils.isEmpty(cursor)) {
            addStyle("cursor", cursor);
        }

        if (!ValueUtils.isEmpty(textAlign)) {
            addClass("text-" + textAlign);
        }

        if (!ValueUtils.isEmpty(color)) {
            addClass("text-" + color);
        }

        if (!ValueUtils.isEmpty(bg)) {
            addClass("bg-" + color);
        }

        if (!ValueUtils.isEmpty(textCase)) {
            addClass("text-" + textCase);
        }

        if (!ValueUtils.isEmpty(icon)) {
            String iconContent = super.renderIcon(icon);
            addBeforeContent(iconContent);
        }

        return render();
    }

    /**
     * @see AbstractTag#renderV3()
     */
    @Override
    protected String renderV3() throws JspException {
        return renderV2();
    }

}