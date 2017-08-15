package com.clidone.tag.bootstrap;

import javax.servlet.jsp.tagext.TagSupport;

import com.clidone.tag.AbstractBodyTag;

/**
 * <strong>Column tag</strong>
 * @author wuhuaxia
 */
public class ColumnTag extends AbstractBodyTag {

    private static final long serialVersionUID = -2432690375886372089L;

    private int xs = 12;
    public void setXs(int xs) {
        this.xs = xs;
    }

    private int sm = 12;
    public void setSm(int sm) {
        this.sm = sm;
    }

    private int md = 12;
    public void setMd(int md) {
        this.md = md;
    }

    private int lg = 12;
    public void setLg(int lg) {
        this.lg = lg;
    }

    private int xsPush = 0;
    public void setXsPush(int xsPush) {
        this.xsPush = xsPush;
    }

    private int smPush = 0;
    public void setSmPush(int smPush) {
        this.smPush = smPush;
    }

    private int mdPush = 0;
    public void setMdPush(int mdPush) {
        this.mdPush = mdPush;
    }

    private int lgPush = 0;
    public void setLgPush(int lgPush) {
        this.lgPush = lgPush;
    }

    private int xsPull = 0;
    public void setXsPull(int xsPull) {
        this.xsPull = xsPull;
    }

    private int smPull = 0;
    public void setSmPull(int smPull) {
        this.smPull = smPull;
    }

    private int mdPull = 0;
    public void setMdPull(int mdPull) {
        this.mdPull = mdPull;
    }

    private int lgPull = 0;
    public void setLgPull(int lgPull) {
        this.lgPull = lgPull;
    }

    private int offset = 0;
    public void setOffset(int offset) {
        this.offset = offset;
    }
}