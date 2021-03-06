package com.clidone.tag.bootstrap.button;

import java.util.UUID;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Drop tag</strong>
 * @author wuhuaxia
 */
public class DropTag extends AbstractTag {

    private static final long serialVersionUID = 4098699034045495121L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // Whether drop down is 'down' or not (up)
    protected Boolean down = new Boolean(true);
    public void setDown(Boolean down) {
        this.down = down;
    }

    // Whether drop down is popup or not
    protected Boolean popup = new Boolean(true);
    public void setPopup(Boolean popup) {
        this.popup = popup;
    }

    // Whether drop down is expanded or not
    protected Boolean expanded = new Boolean(false);
    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    // theme (button theme)
    protected String theme = "default";
    public void setTheme(String theme) {
        this.theme = theme;
    }

    // text (button text)
    protected String text = null;
    public void setText(String text) {
        this.text = text;
    }

    // size (button size)
    protected String size = null;
    public void setSize(String size) {
        this.size = size;
    }

    // right (popup align right)
    protected Boolean right = null;
    public void setRight(Boolean right) {
        this.right = right;
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

        // When Dropdown tag is in ButtonGroup Tag, should be set these;
        Tag tag = super.getParent();
        if (tag instanceof ButtonGroupTag) {
            addClass("btn-group");
            addAttribute("role", "group");
            addAttribute("aria-label", "group");
        }

        if (down != null && down.booleanValue()) {
            addClass("dropdown");
        } else {
            addClass("dropup");
        }

        String ariaPopup    = (popup    != null && popup.booleanValue())    ? "true"                 : "false";
        String ariaExpanded = (expanded != null && expanded.booleanValue()) ? "true"                 : "false";
        String dropSize     = (ValueUtils.isEmpty(size))                    ? ""                     : " btn-" + size;
        String alignRight   = (right    != null && right.booleanValue())    ? " dropdown-menu-right" : "";
        String dropMenuId   = UUID.randomUUID().toString();

        addBeforeContent("<button type=\"button\" class=\"btn btn-"+theme+dropSize+" dropdown-toggle\" id=\""+dropMenuId+"\" data-toggle=\"dropdown\" aria-haspopup=\""+ariaPopup+"\" aria-expanded=\""+ariaExpanded+"\">");
        addBeforeContent(ValueUtils.isEmpty(text) ? "" : text);
        addBeforeContent("<span class=\"caret\"></span>");
        addBeforeContent("</button>");
        addBeforeContent("<ul class=\"dropdown-menu"+alignRight+"\" aria-labelledby=\""+dropMenuId+"\">");

        addAfterContent("</ul>");

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