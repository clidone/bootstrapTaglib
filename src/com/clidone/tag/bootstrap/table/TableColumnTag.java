package com.clidone.tag.bootstrap.table;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Table column tag</strong>
 * @author wuhuaxia
 */
public class TableColumnTag extends AbstractTag {

    private static final long serialVersionUID = -3485738109495647959L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // label
    protected String label = null;
    public void setLabel(String label) {
        this.label = label;
    }

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    /**
     * @see AbstractTag#doStartTagV2()
     */
    @Override
    protected int doStartTagV2() throws JspException {
        TableTag tableTag = (TableTag) findAncestorWithClass(this, TableTag.class);
        if (tableTag != null) {
            if (tableTag.shouldCollectColumn()) {
                TableColumnData columnData = new TableColumnData();
                columnData.setLabel(ValueUtils.isEmpty(label) ? "" : label);
                tableTag.addColumn(columnData);
            }
        }

        return EVAL_BODY_BUFFERED;
    }

    /**
     * @see AbstractTag#doStartTagV3()
     */
    @Override
    protected int doStartTagV3() throws JspException {
        return doStartTagV2();
    }

    /**
     * @see AbstractTag#doEndTagV2()
     */
    @Override
    protected String doEndTagV2() throws JspException {
        setTagName("td");
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