package com.clidone.tag;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.clidone.tag.bootstrap.IBootstrapTag;

/**
 * <strong>抽象Simlpe标签对象</strong>
 * @author wuhuaxia
 */
public abstract class AbstractSimpleTag extends SimpleTagSupport implements IBootstrapTag {

    // **********************************************************************************
    //
    // Tag data
    //
    // **********************************************************************************
    // Custom class attributes content
    protected String classCss = null;

    // Custom style attributes content
    protected String styleCss = null;

    // Icon prefix
    protected String iconPrefix = null;

    // 是否隐藏样式
    protected boolean hidden = false;

    // 是否显示样式
    protected boolean show = false;

    // 对屏幕阅读器以外的设备隐藏内容
    protected boolean srOnly = false;

    // XS下是否显示
    protected String xsShowStyle = null;

    // SM下是否显示
    protected String smShowStyle = null;

    // MD下是否显示
    protected String mdShowStyle = null;

    // LG下是否显示
    protected String lgShowStyle = null;

    // Print下是否显示
    protected String printShowStyle = null;

    // XS下是否隐藏
    protected boolean xsHide = false;

    // SM下是否隐藏
    protected boolean smHide = false;

    // MD下是否隐藏
    protected boolean mdHide = false;

    // LG下是否隐藏
    protected boolean lgHide = false;

    // Print下是否隐藏
    protected boolean printHide = false;

    // 透明度
    protected String opacity = null;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    /**
     * @see IBootstrapTag#getClassCss()
     */
    @Override
    public String getClassCss() {
        return (classCss == null) ? "" : classCss;
    }

    /**
     * @see IBootstrapTag#setClassCss()
     */
    @Override
    public void setClassCss(String classCss) {
        this.classCss = classCss;
    }

    /**
     * @see IBootstrapTag#getStyleCss()
     */
    @Override
    public String getStyleCss() {
        return (styleCss == null) ? "" : styleCss;
    }

    /**
     * @see IBootstrapTag#setStyleCss()
     */
    @Override
    public void setStyleCss(String styleCss) {
        this.styleCss = styleCss;
    }

    /**
     * @see IBootstrapTag#getHide()
     */
    @Override
    public boolean getHide() {
        return hidden;
    }

    /**
     * @see IBootstrapTag#setHide(boolean)
     */
    @Override
    public void setHide(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * @see IBootstrapTag#getShow()
     */
    @Override
    public boolean getShow() {
        return show;
    }

    /**
     * @see IBootstrapTag#setShow(boolean)
     */
    @Override
    public void setShow(boolean show) {
        this.show = show;
    }

    /**
     * @see IBootstrapTag#getSrOnly()
     */
    @Override
    public boolean getSrOnly() {
        return srOnly;
    }

    /**
     * @see IBootstrapTag#setSrOnly(boolean)
     */
    @Override
    public void setSrOnly(boolean srOnly) {
        this.srOnly = srOnly;
    }

    /**
     * @see IBootstrapTag#getXsShow()
     */
    @Override
    public String getXsShow() {
        return xsShowStyle;
    }

    /**
     * @see IBootstrapTag#setXsShow(String)
     */
    @Override
    public void setXsShow(String style) {
        this.xsShowStyle = style;
    }

    /**
     * @see IBootstrapTag#getSmShow()
     */
    @Override
    public String getSmShow() {
        return smShowStyle;
    }

    /**
     * @see IBootstrapTag#setSmShow(String)
     */
    @Override
    public void setSmShow(String style) {
        this.smShowStyle = style;
    }

    /**
     * @see IBootstrapTag#getMdShow()
     */
    @Override
    public String getMdShow() {
        return mdShowStyle;
    }

    /**
     * @see IBootstrapTag#setMdShow(String)
     */
    @Override
    public void setMdShow(String style) {
        this.mdShowStyle = style;
    }

    /**
     * @see IBootstrapTag#getLgShow()
     */
    @Override
    public String getLgShow() {
        return lgShowStyle;
    }

    /**
     * @see IBootstrapTag#setLgShow(String)
     */
    @Override
    public void setLgShow(String style) {
        this.lgShowStyle = style;
    }

    /**
     * @see IBootstrapTag#getPrintShow()
     */
    @Override
    public String getPrintShow() {
        return printShowStyle;
    }

    /**
     * @see IBootstrapTag#setPrintShow(String)
     */
    @Override
    public void setPrintShow(String style) {
        this.printShowStyle = style;
    }

    /**
     * @see IBootstrapTag#getXsHide()
     */
    @Override
    public boolean getXsHide() {
        return xsHide;
    }

    /**
     * @see IBootstrapTag#setXsHide(boolean)
     */
    @Override
    public void setXsHide(boolean hide) {
        this.xsHide = hide;
    }

    /**
     * @see IBootstrapTag#getSmHide()
     */
    @Override
    public boolean getSmHide() {
        return smHide;
    }

    /**
     * @see IBootstrapTag#setSmHide(boolean)
     */
    @Override
    public void setSmHide(boolean hide) {
        this.smHide = hide;
    }

    /**
     * @see IBootstrapTag#getMdHide()
     */
    @Override
    public boolean getMdHide() {
        return mdHide;
    }

    /**
     * @see IBootstrapTag#setMdHide(boolean)
     */
    @Override
    public void setMdHide(boolean hide) {
        this.mdHide = hide;
    }

    /**
     * @see IBootstrapTag#getLgHide()
     */
    @Override
    public boolean getLgHide() {
        return lgHide;
    }

    /**
     * @see IBootstrapTag#setLgHide(boolean)
     */
    @Override
    public void setLgHide(boolean hide) {
        this.lgHide = hide;
    }

    /**
     * @see IBootstrapTag#getPrintHide()
     */
    @Override
    public boolean getPrintHide() {
        return printHide;
    }

    /**
     * @see IBootstrapTag#setPrintHide(boolean)
     */
    @Override
    public void setPrintHide(boolean hide) {
        this.printHide = hide;
    }

    /**
     * @see IBootstrapTag#getOpacity()
     */
    @Override
    public String getOpacity() {
        return opacity;
    }

    /**
     * @see IBootstrapTag#setOpacity(String)
     */
    @Override
    public void setOpacity(String opacity) {
        this.opacity = opacity;
    }


    // **********************************************************************************
    //
    // 标签逻辑
    //
    // **********************************************************************************
    /**
     * @see SimpleTagSupport#doTag()
     */
    @Override
    public void doTag() throws JspException, IOException {
        ServletContext servletContext = getServletContext();

        // Get configuration
        String taglibVersion = (String) servletContext.getAttribute(BootstrapConfigConst.BOOTSTRAP_TAGLIB_VERSION_KEY);
        if (ValueUtils.isEmpty(taglibVersion)) {
            throw new JspException("Render tag failure: taglib version is empty.");
        }
        iconPrefix = (String) servletContext.getAttribute(BootstrapConfigConst.BOOTSTRAP_TAGLIB_ICON_KEY);
        if (ValueUtils.isEmpty(iconPrefix)) {
            iconPrefix = "";
        }

        // Render tag content
        String content = null;
        if ("3".equals(taglibVersion.trim())) {
            content = renderV3();

        } else if ("2".equals(taglibVersion.trim())) {
            content = renderV2();

        } else {
            throw new JspException("Render tag failure: taglib version is invalid, should be 2 or 3 value.");
        }
        getJspContext().getOut().println(content);
    }

    /**
     * Get ServletContext
     * @return ServletContext
     */
    protected ServletContext getServletContext() {
        JspContext jspContext = getJspContext();
        return ((PageContext) jspContext).getServletContext();
    }

    /**
     * Render icon HTML
     * @param icon iconMark
     * @return icon HTML
     */
    protected String renderIcon(String icon) {
        String iconHTML = null;
        if (BootstrapConfigConst.ICON_FONTAWESOME.equals(iconPrefix)) {
            iconHTML = "<i class=\"fa fa-" + icon + "\"></i>&nbsp;";

        } else if (BootstrapConfigConst.ICON_GLYPHICON.equals(iconPrefix)) {
            iconHTML = "<span class=\"glyphicon glyphicon-" + icon + "\"></span>&nbsp;";
        } else {
            iconHTML = "<i class=\"" + icon + "\"></i>&nbsp;";
        }
        return iconHTML;
    }

    /**
     * Render Version 2.* HTML Content
     * @return Tag HTML Content
     * @exception JspException
     */
    protected abstract String renderV2() throws JspException;

    /**
     * Render Version 3.* HTML Content
     * @return Tag HTML Content
     * @exception JspException
     */
    protected abstract String renderV3() throws JspException;
}