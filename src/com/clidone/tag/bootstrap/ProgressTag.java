package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Progress Tag</strong>
 * @author wuhuaxia
 */
public class ProgressTag extends AbstractTag {

    private static final long serialVersionUID = -8523132676940756577L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // value
    protected double value = 0;
    public void setValue(double value) {
        this.value = value;
    }

    // minimum value
    protected double minValue = 0;
    public void setMin(double minValue) {
        this.minValue = minValue;
    }

    // maximum value
    protected double maxValue = 100;
    public void setMax(double maxValue) {
        this.maxValue = maxValue;
    }

    // theme
    protected String theme = null;
    public void setTheme(String theme) {
        this.theme = theme;
    }

    // labelSrOnly
    protected Boolean labelSrOnly = new Boolean(false);
    public void setLabelSrOnly(Boolean labelSrOnly) {
        this.labelSrOnly = labelSrOnly;
    }

    // striped
    protected Boolean striped = null;
    public void setStriped(Boolean striped) {
        this.striped = striped;
    }

    // active
    protected Boolean active = null;
    public void setActive(Boolean active) {
        this.active = active;
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

        addBeforeWrap("<div class=\"progress\">");

        addClass("progress-bar");
        if (!ValueUtils.isEmpty(theme)) {
            addClass("progress-bar-" + theme);
        }
        if (striped != null && striped.booleanValue()) {
            addClass("progress-bar-striped");
        }
        if (active != null && active.booleanValue()) {
            addClass("active");
        }

        double progress = Math.floor(((value - minValue) / (maxValue - minValue)) * 100);

        boolean srOnly = (labelSrOnly != null && labelSrOnly.booleanValue());
        if (srOnly) {
            addBeforeContent(    "<span class=\"sr-only\">");
        }
        addBeforeContent(            progress + "%");
        if (srOnly) {
            addBeforeContent(    "</span>");
        }
        addBeforeContent("</div>");


        addStyle("width",     String.valueOf(progress));
        addStyle("min-width", "2em");

        addAttribute("role",          "progressbar");
        addAttribute("aria-valuenow", String.valueOf(value));
        addAttribute("aria-valuemin", String.valueOf(minValue));
        addAttribute("aria-valuemax", String.valueOf(maxValue));

        addAfterWrap("</div>");

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