package com.clidone.tag.bootstrap.text;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * <strong>H tag</strong>
 * @author wuhuaxia
 */
public class HTag extends TagSupport {

    private static final long serialVersionUID = -152906503201083915L;

    private int xs = 6;
    public void setXs(int xs) {
        this.xs = xs;
    }

    private int sm = 6;
    public void setSm(int sm) {
        this.sm = sm;
    }

    private int md = 6;
    public void setMd(int md) {
        this.md = md;
    }

    private int lg = 6;
    public void setLg(int lg) {
        this.lg = lg;
    }
}