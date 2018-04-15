package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Anchor tag</strong>
 * @author wuhuaxia
 */
public class AnchorTag extends AbstractTag {

    private static final long serialVersionUID = -6211850808642948790L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // url
    protected String url = null;
    public void setUrl(String url) {
        this.url = url;
    }

    // icon
    protected String icon = null;
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // iconOnly
    protected Boolean iconOnly = new Boolean(false);
    public void setIconOnly(Boolean iconOnly) {
        this.iconOnly = iconOnly;
    }

    // confirm
    protected String confirm = null;
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    // cache
    protected Boolean cache = new Boolean(false);
    public void setCache(Boolean cache) {
        this.cache = cache;
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
        setTagName("a");

        String contextPath = super.getServletContext().getContextPath();
        String urlValue = null;
        if (cache == Boolean.TRUE && !ValueUtils.isEmpty(url)) {
            String timestamp = "_no_cache="+String.valueOf(System.currentTimeMillis());
            if (url.indexOf("?") >= 0) {
                url += ("&" + timestamp);
            } else {
                url += ("?" + timestamp);
            }
        }
        if (ValueUtils.isEmpty(url)) {
            urlValue = "javascript:void(0);";
        } else if (!ValueUtils.isEmpty(confirm)) {
            urlValue = "javascript:confirmIt('"+contextPath+url+"','"+confirm+"');";
        } else {
            urlValue = contextPath + url;
        }
        addAttribute("href", urlValue);

        String iconHTML = ValueUtils.isEmpty(icon) ? "" : renderIcon(icon, (iconOnly != null && iconOnly.booleanValue()));
        addBeforeContent(iconHTML);

        // When anchor is in AlterTag, should add this class
        AlertTag alertTag = (AlertTag) findAncestorWithClass(this, AlertTag.class);
        if (alertTag != null) {
            addClass("alert-link");
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