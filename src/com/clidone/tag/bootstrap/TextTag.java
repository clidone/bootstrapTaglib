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
    protected String as = null;
    public void setAs(String as) {
        this.as = as;
    }

    // font-family
    protected String fontFamily = null;
    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    // font-size
    protected String fontSize = null;
    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    // font-style
    protected String fontStyle = null;
    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    // font-weight
    protected String fontWeight = null;
    public void setFontWeight(String fontWeight) {
        this.fontWeight = fontWeight;
    }

    // line-height
    protected String lineHeight = null;
    public void setLineHeight(String lineHeight) {
        this.lineHeight = lineHeight;
    }

    // cursor
    protected String cursor = null;
    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    // text-align
    protected String textAlign = null;
    public void setAlign(String textAlign) {
        this.textAlign = textAlign;
    }

    // color
    protected String color = null;
    public void setColor(String color) {
        this.color = color;
    }

    // background-color
    protected String bg = null;
    public void setBg(String bg) {
        this.bg = bg;
    }

    // case
    protected String textCase = null;
    public void setCase(String textCase) {
        this.textCase = textCase;
    }

    // icon
    protected String icon = null;
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // condition
    protected Boolean condition = null;
    public void setCondition(Boolean condition) {
        this.condition = condition;
    }

    // trueText
    protected String trueText = "";
    public void setTrueText(String trueText) {
        this.trueText = trueText;
    }

    // falseText
    protected String falseText = "";
    public void setFalseText(String falseText) {
        this.falseText = falseText;
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
            String iconHTML = super.renderIcon(icon);
            addBeforeContent(iconHTML);
        }

        if (condition != null) {
            addBeforeContent(condition.booleanValue() ? trueText : falseText);
        }

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