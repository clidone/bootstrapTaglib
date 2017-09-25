package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Image tag</strong>
 * @author wuhuaxia
 */
public class ImgTag extends AbstractTag {

    private static final long serialVersionUID = 4583331741673231041L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // responsive
    protected Boolean responsive = null;
    public void setResponsive(Boolean responsive) {
        this.responsive = responsive;
    }

    // center
    protected Boolean center = null;
    public void setCenter(Boolean center) {
        this.center = center;
    }

    // theme
    protected String theme = null;
    public void setTheme(String theme) {
        this.theme = theme;
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
        setTagName("img");

        if (responsive != null && responsive.booleanValue()) {
            addClass("img-responsive");
        }

        if (center != null && center.booleanValue()) {
            addClass("center-block");
        }

        if (!ValueUtils.isEmpty(theme)) {
            addClass("img-" + theme);
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