package com.clidone.tag.bootstrap.table;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;

/**
 * <strong>Table row tag</strong>
 * @author wuhuaxia
 */
public class TableRowTag extends AbstractTag {

    private static final long serialVersionUID = -2431347597250859642L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************

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
        TableTag tableTag = (TableTag) findAncestorWithClass(this, TableTag.class);
        if (tableTag != null && tableTag.hasData()) {
            setTagName("tr");
            return render();
        }
        return "";
    }

    /**
     * @see AbstractTag#doEndTagV3()
     */
    @Override
    protected String doEndTagV3() throws JspException {
        return doEndTagV2();
    }
}