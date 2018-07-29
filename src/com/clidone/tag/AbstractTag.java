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

    // Version constant
    private static final String VERSION2 = "2";
    private static final String VERSION3 = "3";

    // **********************************************************************************
    //
    // Tag data
    //
    // **********************************************************************************
    private String tagName  = null;

    private StringBuilder tagHTML       = null;
    private StringBuilder tagClass      = null;
    private StringBuilder tagStyle      = null;
    private StringBuilder tagAttributes = null;
    private StringBuilder beforeContent = null;
    private StringBuilder afterContent  = null;
    private StringBuilder beforeWrap    = null;
    private StringBuilder afterWrap     = null;

    // tag version
    private String taglibVersion = null;

    // Icon prefix
    protected String iconPrefix = null;

    // Icon version
    protected String iconVersion = null;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // None

    // **********************************************************************************
    //
    // Tag logic
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
        init();

        if (VERSION3.equals(taglibVersion.trim())) {
            return doStartTagV3();
        } else if (VERSION2.equals(taglibVersion.trim())) {
            return doStartTagV2();
        } else {
            throw new JspException("Render tag failure: taglib version is invalid, should be 2 or 3 value.");
        }
    }

    /**
     * Invoke when doStartTag() return EVAL_BODY_BUFFERED
     * before doInitBody() and doAfterBody()
     */
    @Override
    public void doInitBody() throws JspException {
        if (VERSION3.equals(taglibVersion.trim())) {
            doInitBodyV3();
        } else if (VERSION2.equals(taglibVersion.trim())) {
            doInitBodyV2();
        } else {
            throw new JspException("Render tag failure: taglib version is invalid, should be 2 or 3 value.");
        }
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
        if (VERSION3.equals(taglibVersion.trim())) {
            return doAfterBodyV3();
        } else if (VERSION2.equals(taglibVersion.trim())) {
            return doAfterBodyV2();
        } else {
            throw new JspException("Render tag failure: taglib version is invalid, should be 2 or 3 value.");
        }
    }

    /**
     * Invoke when reach the end of tag
     * @return EVAL_PAGE: Keep render the left JSP content
     *         SKIP_PAGE: Break the left JSP content
     */
    @Override
    public int doEndTag() throws JspException {
        // Render tag content
        String content = null;
        if (VERSION3.equals(taglibVersion.trim())) {
            content = doEndTagV3();

        } else if (VERSION2.equals(taglibVersion.trim())) {
            content = doEndTagV2();

        } else {
            throw new JspException("Render tag failure: taglib version is invalid, should be 2 or 3 value.");
        }

        try {
            super.pageContext.getOut().println(content);

        } catch (IOException ex) {
            throw new JspException(ex);
        }

        tagHTML       = null;
        tagClass      = null;
        tagStyle      = null;
        tagAttributes = null;
        beforeContent = null;
        afterContent  = null;
        beforeWrap    = null;
        afterWrap     = null;
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
            addClass(attrValue);

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
     * Initialize tag context
     * @throws JspException
     */
    protected void init() throws JspException {
        ServletContext servletContext = getServletContext();

        // get tag version
        taglibVersion = (String) servletContext.getAttribute(BootstrapConfigConst.BOOTSTRAP_TAGLIB_VERSION_KEY);
        if (taglibVersion == null || "".equals(taglibVersion.trim())) {
            throw new JspException("Render tag failure: taglib version is empty.");
        }

        // get icon prefix
        iconPrefix = (String) servletContext.getAttribute(BootstrapConfigConst.BOOTSTRAP_TAGLIB_ICON_KEY);
        if (ValueUtils.isEmpty(iconPrefix)) {
            iconPrefix = "";
        }

        // get icon version
        iconVersion = (String) servletContext.getAttribute(BootstrapConfigConst.BOOTSTRAP_TAGLIB_ICON_VERSION_KEY);
        if (ValueUtils.isEmpty(iconVersion)) {
            iconVersion = "4";
        }

        tagHTML = new StringBuilder();
    }

    /**
     * Set tag name
     * @param tagName
     * @return AbstractTag
     * @exception JspException
     */
    protected AbstractTag setTagName(String tagName) throws JspException {
        if (ValueUtils.isEmpty(tagName)) {
            throw new JspException("Set tag name failure: tag name is empty.");
        }
        this.tagName = tagName;
        return this;
    }

    /**
     * Add tag class
     * @param tagClassValue
     * @return AbstractTag
     */
    protected AbstractTag addClass(String tagClassValue) {
        if (ValueUtils.isEmpty(tagClassValue)) {
            return this;
        }
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
        if (ValueUtils.isEmpty(tagStyleValue)) {
            return this;
        }
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
     * @exception JspException
     */
    protected AbstractTag addStyle(String tagStyleName, String tagStyleValue) throws JspException {
        if (ValueUtils.isEmpty(tagStyleName) || ValueUtils.isEmpty(tagStyleValue)) {
            throw new JspException("Set tag style failure: tag style is empty.");
        }
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
     * @exception JspException
     */
    protected AbstractTag addAttribute(String name, String value) throws JspException {
        if (ValueUtils.isEmpty(name)) {
            throw new JspException("Set tag attribute failure: tag attribute is empty.");
        }
        if (ValueUtils.isEmpty(value)) {
            value = "";
        }
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
            if (beforeContent == null) {
                beforeContent = new StringBuilder();
            }
            beforeContent.append(content);
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
            if (afterContent == null) {
                afterContent = new StringBuilder();
            }
            afterContent.append(content);
        }
        return this;
    }

    /**
     * Add wrap before tag
     * @param content
     * @return AbstractTag
     */
    protected AbstractTag addBeforeWrap(String content) {
        if (content != null) {
            if (beforeWrap == null) {
                beforeWrap = new StringBuilder();
            }
            beforeWrap.append(content);
        }
        return this;
    }

    /**
     * Add wrap after tag
     * @param content
     * @return AbstractTag
     */
    protected AbstractTag addAfterWrap(String content) {
        if (content != null) {
            if (afterWrap == null) {
                afterWrap = new StringBuilder();
            }
            afterWrap.append(content);
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

        if (beforeWrap != null) {
            tagHTML.append(beforeWrap.toString());
        }

        boolean hasTagName = !ValueUtils.isEmpty(tagName);
        if (hasTagName) {
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
        }

        if (beforeContent != null) {
            tagHTML.append(beforeContent.toString());
        }
        if (bodyContent != null) {
            tagHTML.append(bodyContent.getString());
        }
        if (afterContent != null) {
            tagHTML.append(afterContent.toString());
        }

        if (hasTagName) {
            tagHTML.append("</").append(tagName).append(">");
        }

        if (afterWrap != null) {
            tagHTML.append(afterWrap.toString());
        }

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
     * Get request root URL
     * @return request root URL
     */
    protected String getURL() {
        ServletContext servletContext = super.pageContext.getServletContext();
        ServletRequest request = super.pageContext.getRequest();
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+servletContext.getContextPath();
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
     * @param noSpace Has space after icon or not
     * @return icon HTML
     */
    protected String renderIcon(String icon, boolean noSpace) {
        return renderIcon(icon, noSpace, false);
    }

    /**
     * Render icon HTML
     * @param icon iconMark
     * @param noSpace Has space after icon or not
     * @param spin
     * @return icon HTML
     */
    protected String renderIcon(String icon, boolean noSpace, boolean spin) {
        String iconHTML = null;
        if (BootstrapConfigConst.ICON_FONTAWESOME.equals(iconPrefix)) {
            String spinClass = spin ? " fa-spin" : "";
            if ("5".equals(iconVersion)) {
                iconHTML = "<i class=\"fal fa-"+icon+spinClass+"\"></i>";
            } else {
                iconHTML = "<i class=\"fa fa-"+icon+spinClass+"\"></i>";
            }

        } else if (BootstrapConfigConst.ICON_GLYPHICON.equals(iconPrefix)) {
            iconHTML = "<span class=\"glyphicon glyphicon-"+icon+"\"></span>";
        } else {
            iconHTML = "<i class=\""+icon+"\"></i>";
        }

        if (!noSpace) {
            iconHTML += "&nbsp;";
        }

        return iconHTML;
    }

    /**
     * Render Version 2.* HTML Content
     * @return render result
     * @exception JspException
     */
    protected int doStartTagV2() throws JspException {
        return EVAL_BODY_BUFFERED;
    }

    /**
     * Render Version 3.* HTML Content
     * @return render result
     * @exception JspException
     */
    protected int doStartTagV3() throws JspException {
        return EVAL_BODY_BUFFERED;
    }

    /**
     * Render Version 2.* HTML Content
     * @exception JspException
     */
    protected void doInitBodyV2() throws JspException {
        super.doInitBody();
    }

    /**
     * Render Version 3.* HTML Content
     * @exception JspException
     */
    protected void doInitBodyV3() throws JspException {
        super.doInitBody();
    }

    /**
     * Render Version 2.* HTML Content
     * @return render result
     * @exception JspException
     */
    protected int doAfterBodyV2() throws JspException {
        return SKIP_BODY;
    }

    /**
     * Render Version 3.* HTML Content
     * @return render result
     * @exception JspException
     */
    protected int doAfterBodyV3() throws JspException {
        return SKIP_BODY;
    }

    /**
     * Render Version 2.* HTML Content
     * @return Tag HTML Content
     * @exception JspException
     */
    protected String doEndTagV2() throws JspException {
        return "";
    }

    /**
     * Render Version 3.* HTML Content
     * @return Tag HTML Content
     * @exception JspException
     */
    protected String doEndTagV3() throws JspException {
        return "";
    }
}