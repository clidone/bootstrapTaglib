package com.clidone.tag;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.DynamicAttributes;

/**
 * <strong>Abstract Tag</strong>
 * @author wuhuaxia
 */
public abstract class AbstractTag extends BodyTagSupport implements DynamicAttributes {

    private static final long serialVersionUID = -6152630007445070508L;

    // **********************************************************************************
    //
    // Tag data
    //
    // **********************************************************************************
    private String tagName  = "div";

    private StringBuilder tagHTML       = null;
    private StringBuilder tagClass      = null;
    private StringBuilder tagStyle      = null;
    private StringBuilder tagAttributes = null;
    private StringBuilder beforeTagHTML = null;
    private StringBuilder afterTagHTML  = null;

    // 对屏幕阅读器以外的设备隐藏内容
    protected boolean srOnly = false;

    // Show or hidden
    protected Boolean hidden       = null;
    protected Boolean show         = null;
    protected String  visibleXs    = null;
    protected String  visibleSm    = null;
    protected String  visibleMd    = null;
    protected String  visibleLg    = null;
    protected String  visiblePrint = null;
    protected Boolean hiddenXs     = null;
    protected Boolean hiddenSm     = null;
    protected Boolean hiddenMd     = null;
    protected Boolean hiddenLg     = null;
    protected Boolean hiddenPrint  = null;

    // opacity
    protected String opacity = null;

    // Icon prefix
    protected String iconPrefix = null;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // None

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
        tagHTML = new StringBuilder();
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

        try {
            super.getPreviousOut().println(content);

        } catch (IOException ex) {
            throw new JspException(ex);
        }

        return SKIP_BODY;
    }

    /**
     * Invoke when reach the end of tag
     * @return EVAL_PAGE: Keep render the left JSP content
     *         SKIP_PAGE: Break the left JSP content
     */
    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    /**
     * @see DynamicAttributes#setDynamicAttribute(String, String, Object)
     */
    @Override
    public void setDynamicAttribute(String uri, String name, Object value) throws JspException {
        String attrName  = (name ==  null) ? "" : name.toString().trim();
        String attrValue = (value == null) ? "" : value.toString().trim();

        if ("class".equals(attrName)) {
            addClass("attrValue");

        } else if ("style".equals(attrName)) {
            addStyle(attrValue);

        } else if ("show".equals(attrName) && "true".equals(attrValue)) {
            addClass("show");

        } else if ("hidden".equals(attrName) && "true".equals(attrValue)) {
            addClass("hidden");

        } else if ("hiddenXs".equals(attrName) && "true".equals(attrValue)) {
            addClass("hidden-xs");

        } else if ("hiddenSm".equals(attrName) && "true".equals(attrValue)) {
            addClass("hidden-sm");

        } else if ("hiddenMd".equals(attrName) && "true".equals(attrValue)) {
            addClass("hidden-md");

        } else if ("hiddenLg".equals(attrName) && "true".equals(attrValue)) {
            addClass("hidden-lg");

        } else if ("hiddenPrint".equals(attrName) && "true".equals(attrValue)) {
            addClass("hidden-print");

        } else if ("visibleXs".equals(attrName)) {
            if ("true".equals(attrValue) || "false".equals(attrValue)) {
                addClass("visible-xs");
            } else if ("block".equals(attrValue) || "inline".equals(attrValue) || "inline-block".equals(attrValue)) {
                addClass("visible-xs-" + attrValue);
            }

        } else if ("visibleSm".equals(attrName)) {
            if ("true".equals(attrValue) || "false".equals(attrValue)) {
                addClass("visible-sm");
            } else if ("block".equals(attrValue) || "inline".equals(attrValue) || "inline-block".equals(attrValue)) {
                addClass("visible-sm-" + attrValue);
            }

        } else if ("visibleMd".equals(attrName)) {
            if ("true".equals(attrValue) || "false".equals(attrValue)) {
                addClass("visible-md");
            } else if ("block".equals(attrValue) || "inline".equals(attrValue) || "inline-block".equals(attrValue)) {
                addClass("visible-md-" + attrValue);
            }

        } else if ("visibleLg".equals(attrName)) {
            if ("true".equals(attrValue) || "false".equals(attrValue)) {
                addClass("visible-lg");
            } else if ("block".equals(attrValue) || "inline".equals(attrValue) || "inline-block".equals(attrValue)) {
                addClass("visible-lg-" + attrValue);
            }

        } else if ("visiblePrint".equals(attrName)) {
            if ("true".equals(attrValue) || "false".equals(attrValue)) {
                addClass("visible-print");
            } else if ("block".equals(attrValue) || "inline".equals(attrValue) || "inline-block".equals(attrValue)) {
                addClass("visible-print-" + attrValue);
            }

        } else if ("opacity".equals(attrName)) {
            int    opacityInt = 0;
            double opacityDbl = new Double(attrValue).doubleValue();
            if (opacityDbl > 1) {
                if (opacityDbl > 100) {
                    opacityDbl = 100;
                }
                opacityInt = new Double(opacityDbl).intValue();
                opacityDbl = opacityInt / 100;
            } else {
                if (opacityDbl < 0) {
                    opacityDbl = 0;
                }
                opacityInt = new Double(opacityDbl * 100).intValue();
            }
            addStyle("filter:alpha(opacity="+opacityInt+");-moz-opacity:"+opacityDbl+";-khtml-opacity:"+opacityDbl+";opacity:"+opacityDbl+";");

        } else {
            addAttribute(attrName, attrValue);
        }
    }

    /**
     * Set tag name
     * @param tagName
     * @return AbstractTag
     */
    protected AbstractTag setName(String tagName) {
        this.tagName = tagName;
        return this;
    }

    /**
     * Add tag class
     * @param tagClassValue
     * @return AbstractTag
     */
    protected AbstractTag addClass(String tagClassValue) {
        if (tagClass == null) {
            tagClass = new StringBuilder();
        }
        if (tagClass.length() > 0) {
            tagClass.append(" ");
        }
        tagClass.append(tagClassValue);
        return this;
    }

    /**
     * Add tag style
     * @param tagStyleValue
     * @return AbstractTag
     */
    protected AbstractTag addStyle(String tagStyleValue) {
        if (tagStyle == null) {
            tagStyle = new StringBuilder();
        }
        if (tagStyle.length() > 0) {
            tagStyle.append(" ");
        }
        tagStyle.append(tagStyleValue);
        return this;
    }

    /**
     * Add tag style
     * @param tagStyleName
     * @param tagStyleValue
     * @return AbstractTag
     */
    protected AbstractTag addStyle(String tagStyleName, String tagStyleValue) {
        if (tagStyle == null) {
            tagStyle = new StringBuilder();
        }
        if (tagStyle.length() > 0) {
            tagStyle.append(" ");
        }
        tagStyle.append(tagStyleName).append(":").append(tagStyleValue).append(";");
        return this;
    }

    /**
     * Add tag attribute
     * @param name Attribute name
     * @param value Attribute value
     * @return AbstractTag
     */
    protected AbstractTag addAttribute(String name, String value) {
        if (tagAttributes == null) {
            tagAttributes = new StringBuilder();
        }
        if (tagAttributes.length() > 0) {
            tagAttributes.append(" ");
        }
        tagAttributes.append(name).append("=\"").append(value).append("\"");
        return this;
    }

    /**
     * Add content before tag body
     * @param content
     * @return AbstractTag
     */
    protected AbstractTag addBeforeContent(String content) {
        if (content != null) {
            if (beforeTagHTML == null) {
                beforeTagHTML = new StringBuilder();
            }
            beforeTagHTML.append(content);
        }
        return this;
    }

    /**
     * Add content after tag body
     * @param content
     * @return AbstractTag
     */
    protected AbstractTag addAfterContent(String content) {
        if (content != null) {
            if (afterTagHTML == null) {
                afterTagHTML = new StringBuilder();
            }
            afterTagHTML.append(content);
        }
        return this;
    }

    /**
     * Render tag HTML content
     * @return tag HTML content
     */
    protected String render() {
        String classValue = (tagClass      == null) ? null : tagClass.toString();
        String styleValue = (tagStyle      == null) ? null : tagStyle.toString();
        String attributes = (tagAttributes == null) ? null : tagAttributes.toString();

        tagHTML.append("<").append(tagName);
        if (!ValueUtils.isEmpty(classValue)) {
            tagHTML.append(" class=\"").append(classValue).append("\"");
        }
        if (!ValueUtils.isEmpty(styleValue)) {
            tagHTML.append(" style=\"").append(styleValue).append("\"");
        }
        if (!ValueUtils.isEmpty(attributes)) {
            tagHTML.append(" ").append(attributes);
        }
        tagHTML.append(">");

        if (beforeTagHTML != null) {
            tagHTML.append(beforeTagHTML.toString());
        }
        if (bodyContent != null) {
            tagHTML.append(bodyContent.getString());
        }
        if (afterTagHTML != null) {
            tagHTML.append(afterTagHTML.toString());
        }

        tagHTML.append("</").append(tagName).append(">");

        return tagHTML.toString();
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