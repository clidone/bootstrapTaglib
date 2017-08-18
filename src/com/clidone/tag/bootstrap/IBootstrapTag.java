package com.clidone.tag.bootstrap;

/**
 * <strong>Bootstrap标签接口</strong>
 * @author wuhuaxia
 */
public interface IBootstrapTag {

    /**
     * Get custom class attributes content
     * @return custom class attributes content
     */
    String getClassCss();

    /**
     * Set custom class attributes content
     * @param classCss custom class attributes content
     */
    void setClassCss(String classCss);

    /**
     * Get custom style attributes content
     * @return custom style attributes content
     */
    String getStyleCss();

    /**
     * Set custom style attributes content
     * @param styleCss custom style attributes content
     */
    void setStyleCss(String styleCss);

    /**
     * 获取是否隐藏样式
     * @return 是否隐藏
     */
    boolean getHide();

    /**
     * 设置是否隐藏样式
     * @param hidden 是否隐藏
     */
    void setHide(boolean hidden);

    /**
     * 获取是否显示样式
     * @return 是否显示
     */
    boolean getShow();

    /**
     * 设置是否显示样式
     * @param show 是否显示
     */
    void setShow(boolean show);

    /**
     * 获取对屏幕阅读器以外的设备隐藏内容
     * @return 是否显示
     */
    boolean getSrOnly();

    /**
     * 设置对屏幕阅读器以外的设备隐藏内容
     * @param srOnly 是否显示
     */
    void setSrOnly(boolean srOnly);

    /**
     * 获取XS下是否显示
     * @return 显示样式
     */
    String getXsShow();

    /**
     * 设置XS下是否显示
     * @param style 显示样式
     */
    void setXsShow(String style);

    /**
     * 获取SM下是否显示
     * @return 显示样式
     */
    String getSmShow();

    /**
     * 设置SM下是否显示
     * @param style 显示样式
     */
    void setSmShow(String style);

    /**
     * 获取MD下是否显示
     * @return 显示样式
     */
    String getMdShow();

    /**
     * 设置MD下是否显示
     * @param style 显示样式
     */
    void setMdShow(String style);

    /**
     * 获取LG下是否显示
     * @return 显示样式
     */
    String getLgShow();

    /**
     * 设置LG下是否显示
     * @param style 显示样式
     */
    void setLgShow(String style);

    /**
     * 获取Print下是否显示
     * @return 显示样式
     */
    String getPrintShow();

    /**
     * 设置Print下是否显示
     * @param style 显示样式
     */
    void setPrintShow(String style);

    /**
     * 获取XS下是否隐藏
     * @return 隐藏样式
     */
    boolean getXsHide();

    /**
     * 设置XS下是否隐藏
     * @param hide 隐藏样式
     */
    void setXsHide(boolean hide);

    /**
     * 获取SM下是否隐藏
     * @return 隐藏样式
     */
    boolean getSmHide();

    /**
     * 设置SM下是否隐藏
     * @param hide 隐藏样式
     */
    void setSmHide(boolean hide);

    /**
     * 获取MD下是否隐藏
     * @return 隐藏样式
     */
    boolean getMdHide();

    /**
     * 设置MD下是否隐藏
     * @param hide 隐藏样式
     */
    void setMdHide(boolean hide);

    /**
     * 获取LG下是否隐藏
     * @return 隐藏样式
     */
    boolean getLgHide();

    /**
     * 设置LG下是否隐藏
     * @param hide 隐藏样式
     */
    void setLgHide(boolean hide);

    /**
     * 获取Print下是否隐藏
     * @return 隐藏样式
     */
    boolean getPrintHide();

    /**
     * 设置Print下是否隐藏
     * @param hide 隐藏样式
     */
    void setPrintHide(boolean hide);

    /**
     * 获取透明度
     * @return 透明度
     */
    String getOpacity();

    /**
     * 设置透明度
     * @param opacity 透明度
     */
    void setOpacity(String opacity);
}