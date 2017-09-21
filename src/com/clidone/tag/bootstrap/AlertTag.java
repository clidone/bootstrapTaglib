package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Alert tag</strong>
 * @author wuhuaxia
 */
public class AlertTag extends AbstractTag {

    private static final long serialVersionUID = -9159147526867161362L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // theme
    protected String theme = null;
    public void setTheme(String theme) {
        this.theme = theme;
    }

    // closable
    protected Boolean closable = null;
    public void setClosable(Boolean closable) {
        this.closable = closable;
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

        addClass("alert");

        if (!ValueUtils.isEmpty(theme)) {
            addClass("alert-" + theme);
        }

        if (closable != null && closable.booleanValue()) {
            addClass("alert-dismissible");

            addBeforeContent("<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">");
            addBeforeContent(    "<span aria-hidden=\"true\">&times;</span>");
            addBeforeContent("</button>");
        }

        addAttribute("role", "alert");

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