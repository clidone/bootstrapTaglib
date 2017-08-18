package com.clidone.tag;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.clidone.tag.bootstrap.IBootstrapTag;

/**
 * <strong>抽象Body标签对象</strong>
 * @author wuhuaxia
 */
public abstract class AbstractBodyTag extends BodyTagSupport implements IBootstrapTag {

    private static final long serialVersionUID = -6152630007445070508L;

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
     * 获取是否隐藏样式
     * @return 是否隐藏
     */
    @Override
    public boolean getHide() {
        return hidden;
    }

    /**
     * 设置是否隐藏样式
     * @param hidden 是否隐藏
     */
    @Override
    public void setHide(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * 获取是否显示样式
     * @return 是否显示
     */
    @Override
    public boolean getShow() {
        return show;
    }

    /**
     * 设置是否显示样式
     * @param show 是否显示
     */
    @Override
    public void setShow(boolean show) {
        this.show = show;
    }

    /**
     * 获取对屏幕阅读器以外的设备隐藏内容
     * @return 是否显示
     */
    @Override
    public boolean getSrOnly() {
        return srOnly;
    }

    /**
     * 设置对屏幕阅读器以外的设备隐藏内容
     * @param srOnly 是否显示
     */
    @Override
    public void setSrOnly(boolean srOnly) {
        this.srOnly = srOnly;
    }

    /**
     * 获取XS下是否显示
     * @return 显示样式
     */
    @Override
    public String getXsShow() {
        return xsShowStyle;
    }

    /**
     * 设置XS下是否显示
     * @param style 显示样式
     */
    @Override
    public void setXsShow(String style) {
        this.xsShowStyle = style;
    }

    /**
     * 获取SM下是否显示
     * @return 显示样式
     */
    @Override
    public String getSmShow() {
        return smShowStyle;
    }

    /**
     * 设置SM下是否显示
     * @param style 显示样式
     */
    @Override
    public void setSmShow(String style) {
        this.smShowStyle = style;
    }

    /**
     * 获取MD下是否显示
     * @return 显示样式
     */
    @Override
    public String getMdShow() {
        return mdShowStyle;
    }

    /**
     * 设置MD下是否显示
     * @param style 显示样式
     */
    @Override
    public void setMdShow(String style) {
        this.mdShowStyle = style;
    }

    /**
     * 获取LG下是否显示
     * @return 显示样式
     */
    @Override
    public String getLgShow() {
        return lgShowStyle;
    }

    /**
     * 设置LG下是否显示
     * @param style 显示样式
     */
    @Override
    public void setLgShow(String style) {
        this.lgShowStyle = style;
    }

    /**
     * 获取Print下是否显示
     * @return 显示样式
     */
    @Override
    public String getPrintShow() {
        return printShowStyle;
    }

    /**
     * 设置Print下是否显示
     * @param style 显示样式
     */
    @Override
    public void setPrintShow(String style) {
        this.printShowStyle = style;
    }

    /**
     * 获取XS下是否隐藏
     * @return 隐藏样式
     */
    @Override
    public boolean getXsHide() {
        return xsHide;
    }

    /**
     * 设置XS下是否隐藏
     * @param hide 隐藏样式
     */
    @Override
    public void setXsHide(boolean hide) {
        this.xsHide = hide;
    }

    /**
     * 获取SM下是否隐藏
     * @return 隐藏样式
     */
    @Override
    public boolean getSmHide() {
        return smHide;
    }

    /**
     * 设置SM下是否隐藏
     * @param hide 隐藏样式
     */
    @Override
    public void setSmHide(boolean hide) {
        this.smHide = hide;
    }

    /**
     * 获取MD下是否隐藏
     * @return 隐藏样式
     */
    @Override
    public boolean getMdHide() {
        return mdHide;
    }

    /**
     * 设置MD下是否隐藏
     * @param hide 隐藏样式
     */
    @Override
    public void setMdHide(boolean hide) {
        this.mdHide = hide;
    }

    /**
     * 获取LG下是否隐藏
     * @return 隐藏样式
     */
    @Override
    public boolean getLgHide() {
        return lgHide;
    }

    /**
     * 设置LG下是否隐藏
     * @param hide 隐藏样式
     */
    @Override
    public void setLgHide(boolean hide) {
        this.lgHide = hide;
    }

    /**
     * 获取Print下是否隐藏
     * @return 隐藏样式
     */
    @Override
    public boolean getPrintHide() {
        return printHide;
    }

    /**
     * 设置Print下是否隐藏
     * @param hide 隐藏样式
     */
    @Override
    public void setPrintHide(boolean hide) {
        this.printHide = hide;
    }

    /**
     * 获取透明度
     * @return 透明度
     */
    @Override
    public String getOpacity() {
        return opacity;
    }

    /**
     * 设置透明度
     * @param opacity 透明度
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
     * Before render body tags,
     * @return EVAL_BODY_INCLUDE: Render body, bodyContent does NOT available in doAfterBody()
     *         EVAL_BODY_BUFFERED: Render body, bodyContent does available in doAfterBody()
     *         SKIP_BODY: Ignore body
     */
    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_BUFFERED;
    }

    /**
     * Invoke when doStartTag() return EVAL_BODY_BUFFERED
     * before doInitBody() and doAfterBody()
     */
    @Override
    public void doInitBody() throws JspException {
        super.doInitBody();
    }

    /**
     * Invoke when doStartTag() return EVAL_BODY_BUFFERED
     * before doAfterBody()
     */
    @Override
    public void setBodyContent(BodyContent bodyContent) {
        super.setBodyContent(bodyContent);
    }

    /**
     * Invoke when doStartTag() return EVAL_BODY_INCLUDE or EVAL_BODY_BUFFERED
     * @return EVAL_BODY_AGAIN: Render body again
     *         SKIP_BODY: invoke doEndTag()
     */
    @Override
    public int doAfterBody() throws JspException {
        ServletContext servletContext = getServletContext();

        // Get configuration
        String taglibVersion = (String) servletContext.getAttribute(BootstrapConfigConst.BOOTSTRAP_TAGLIB_VERSION_KEY);
        if (taglibVersion == null || "".equals(taglibVersion.trim())) {
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
        printContent(content);

        return super.doAfterBody();
    }

    /**
     * Invoke when reach the end of tag
     * @return EVAL_PAGE: Keep render the left JSP content
     *         SKIP_PAGE: Break the left JSP content
     */
    @Override
    public int doEndTag() throws JspException {
        return super.doEndTag();
    }

    /**
     * Get ServletContext
     * @return ServletContext
     */
    protected ServletContext getServletContext() {
        return super.pageContext.getServletContext();
    }

    /**
     * Get ServletRequest
     * @return ServletRequest
     */
    protected ServletRequest getRequest() {
        return super.pageContext.getRequest();
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
     * Print and output content to page
     * @param content
     * @throws JspException
     */
    protected void printContent(String content) throws JspException {
        try {
            super.getPreviousOut().println(content);

        } catch (IOException ex) {
            throw new JspException(ex);
        }
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