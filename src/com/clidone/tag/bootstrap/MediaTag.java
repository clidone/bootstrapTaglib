package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Media tag</strong>
 * @author wuhuaxia
 */
public class MediaTag extends AbstractTag {

    private static final long serialVersionUID = -438782456833524619L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // heading
    protected String heading = null;
    public void setHeading(String heading) {
        this.heading = heading;
    }

    // headingTag
    protected String headingTag = "h4";
    public void setHeadingTag(String headingTag) {
        this.headingTag = headingTag;
    }

    // icon
    protected String icon = null;
    public void setIcon(String icon) {
        this.icon = icon;
    }

    // left image
    protected String leftImage = null;
    public void setLeftImage(String leftImage) {
        this.leftImage = leftImage;
    }

    // left image width
    protected String leftWidth = "64px";
    public void setLeftWidth(String leftWidth) {
        this.leftWidth = leftWidth;
    }

    // left image height
    protected String leftHeight = "64px";
    public void setLeftHeight(String leftHeight) {
        this.leftHeight = leftHeight;
    }

    // left image align
    protected String leftAlign = null;
    public void setLeftAlign(String leftAlign) {
        this.leftAlign = leftAlign;
    }

    // left image url
    protected String leftUrl = null;
    public void setLeftUrl(String leftUrl) {
        this.leftUrl = leftUrl;
    }

    // right image
    protected String rightImage = null;
    public void setRightImage(String rightImage) {
        this.rightImage = rightImage;
    }

    // right image width
    protected String rightWidth = "64px";
    public void setRightWidth(String rightWidth) {
        this.rightWidth = rightWidth;
    }

    // right image height
    protected String rightHeight = "64px";
    public void setRightHeight(String rightHeight) {
        this.rightHeight = rightHeight;
    }

    // right image align
    protected String rightAlign = null;
    public void setRightAlign(String rightAlign) {
        this.rightAlign = rightAlign;
    }

    // right image url
    protected String rightUrl = null;
    public void setRightUrl(String rightUrl) {
        this.rightUrl = rightUrl;
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

        addClass("media");

        if (!ValueUtils.isEmpty(leftImage)) {
            String align = ValueUtils.isEmpty(leftAlign) ? "" : " media-"+leftAlign;
            addBeforeContent("<div class=\"media-left"+align+"\">");
            if (!ValueUtils.isEmpty(leftUrl)) {
                addBeforeContent("<a href=\""+leftUrl+"\">");
            }
            addBeforeContent("<img class=\"media-object\" alt=\"Image\" src=\""+leftImage+"\" data-holder-rendered=\"true\" style=\"width:"+leftWidth+"; height:"+leftHeight+";\">");
            if (!ValueUtils.isEmpty(leftUrl)) {
                addBeforeContent("</a>");
            }
            addBeforeContent("</div>");
        }

        addBeforeContent("<div class=\"media-body\">");
        addBeforeContent("<"+headingTag+" class=\"media-heading\">");
        if (!ValueUtils.isEmpty(icon)) {
            String iconHTML = renderIcon(icon);
            addBeforeContent(iconHTML);
        }
        addBeforeContent(heading);
        addBeforeContent("</"+headingTag+">");

        addBeforeContent("<p>");

        addAfterContent("</p>");

        if (!ValueUtils.isEmpty(rightImage)) {
            String align = ValueUtils.isEmpty(rightAlign) ? "" : " media-"+rightAlign;
            addAfterContent("<div class=\"media-right"+align+"\">");
            if (!ValueUtils.isEmpty(rightUrl)) {
                addAfterContent("<a href=\""+rightUrl+"\">");
            }
            addAfterContent("<img class=\"media-object\" alt=\"Image\" src=\""+rightImage+"\" data-holder-rendered=\"true\" style=\"width:"+rightWidth+"; height:"+rightHeight+";\">");
            if (!ValueUtils.isEmpty(rightUrl)) {
                addAfterContent("</a>");
            }
            addAfterContent("</div>");
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