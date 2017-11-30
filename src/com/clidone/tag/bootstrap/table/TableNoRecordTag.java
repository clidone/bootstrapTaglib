package com.clidone.tag.bootstrap.table;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;

/**
 * <strong>Table no record tag</strong>
 * @author wuhuaxia
 */
public class TableNoRecordTag extends AbstractTag {

    private static final long serialVersionUID = 8072465087900438313L;

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
        if (tableTag == null) {
            return "";
        }

        if (tableTag.hasData()) {
            return "";
        }

        setTagName("div");
        String noRecordContent = render();

        tableTag.setNoRecordContent(noRecordContent);

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