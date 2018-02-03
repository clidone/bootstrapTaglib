package com.clidone.tag.bootstrap.table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Table tag</strong>
 * @author wuhuaxia
 */
public class TableTag extends AbstractTag {

    private static final long serialVersionUID = -510289398275521046L;

    // **********************************************************************************
    //
    // Tag data
    //
    // **********************************************************************************
    // Whether table has data
    private boolean hasData = false;

    // Whether table has more data or not
    private boolean hasMoreData = false;

    // Raw data iterator
    private Iterator<?> iterator = null;

    // Table register columns
    private List<TableColumnData> columns = null;

    // Whether should collect column data or not
    // After first time render body content, this flag will set false, and no more collection
    private boolean shouldCollectColumn = true;

    // No Record conent
    private String noRecordContent = null;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // id
    protected String id = null;
    public void setId(String id) {
        this.id = id;
    }

    // var
    protected String var = null;
    public void setVar(String var) throws JspException {
        if (ValueUtils.isEmpty(var)) {
            throw new JspException("Table var attribute is required.");
        }
        this.var = var;
    }

    // items
    public void setItems(Object items) {
        // initialize raw data iterator
        if (items instanceof Collection) {
            Collection<?> data = (Collection<?>) items;
            this.iterator = data.iterator();

        } else if (items instanceof Map) {
            Map<?,?> data = (Map<?,?>) items;
            this.iterator = data.entrySet().iterator();
        }

        this.hasData = (items != null && iterator != null && iterator.hasNext());
    }

    // caption
    protected String caption = null;
    public void setCaption(String caption) {
        this.caption = caption;
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

    // bordered
    protected Boolean bordered = null;
    public void setBordered(Boolean bordered) {
        this.bordered = bordered;
    }

    // condensed
    protected Boolean condensed = null;
    public void setCondensed(Boolean condensed) {
        this.condensed = condensed;
    }

    // hover
    protected Boolean hover = null;
    public void setHover(Boolean hover) {
        this.hover = hover;
    }

    // striped
    protected Boolean striped = null;
    public void setStriped(Boolean striped) {
        this.striped = striped;
    }

    // responsive
    protected Boolean responsive = new Boolean(true);
    public void setResponsive(Boolean responsive) {
        this.responsive = responsive;
    }

    // header
    protected Boolean header = new Boolean(true);
    public void setHeader(Boolean header) {
        this.header = header;
    }

    // footer
    protected Boolean footer = null;
    public void setFooter(Boolean footer) {
        this.footer = footer;
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
        hasMoreData = hasMoreData();
        if (hasMoreData) {
            // get current item, and make it available for body render
            Object item = iterator.next();
            if (pageContext.getAttribute(var) != null) {
                pageContext.removeAttribute(var);
            }
            pageContext.setAttribute(var, item);
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
     * @see AbstractTag#doAfterBodyV2()
     */
    @Override
    protected int doAfterBodyV2() throws JspException {
        // When we collect all column data, no need to collect again
        if (shouldCollectColumn) {
            shouldCollectColumn = false;
        }

        hasMoreData = hasMoreData();
        if (hasMoreData) {
            // get current item, and make it available for body render
            Object item = iterator.next();
            if (pageContext.getAttribute(var) != null) {
                pageContext.removeAttribute(var);
            }
            pageContext.setAttribute(var, item);

            return EVAL_BODY_AGAIN;
        } else {
            return SKIP_BODY;
        }
    }

    /**
     * @see AbstractTag#doAfterBodyV3()
     */
    @Override
    protected int doAfterBodyV3() throws JspException {
        return doAfterBodyV2();
    }

    /**
     * @see AbstractTag#doEndTagV2()
     */
    @Override
    protected String doEndTagV2() throws JspException {
        setTagName("table");

        addClass("table");

        if (ValueUtils.isEmpty(id)) {
            id = UUID.randomUUID().toString();
        }
        String tableHeadId = id + "Head";
        String tableBodyId = id + "Body";
        String tableFootId = id + "Foot";

        addAttribute("id", id);

        // table caption
        String captionContent = "";
        if (!ValueUtils.isEmpty(icon)) {
            captionContent += renderIcon(icon, (iconOnly != null && iconOnly.booleanValue()));
        }
        if (!ValueUtils.isEmpty(caption)) {
            captionContent += caption;
        }
        if (!ValueUtils.isEmpty(captionContent)) {
            addBeforeContent("<caption>"+captionContent+"</caption>");
        }

        // table style
        if (bordered != null && bordered.booleanValue()) {
            addClass("table-bordered");
        }
        if (condensed != null && condensed.booleanValue()) {
            addClass("table-condensed");
        }
        if (hover != null && hover.booleanValue()) {
            addClass("table-hover");
        }
        if (striped != null && striped.booleanValue()) {
            addClass("table-striped");
        }
        if (responsive != null && responsive.booleanValue()) {
            addBeforeWrap("<div class=\"table-responsive\">");
            addAfterWrap("</div>");
        }

        // render header
        if (header != null && header.booleanValue()) {
            addBeforeContent("<thead id=\""+tableHeadId+"\">");
            if (columns != null) {
                addBeforeContent("<tr>");
                for (int i=0,len=columns.size(); i<len; i++) {
                    addBeforeContent("<th>");
                    addBeforeContent(columns.get(i).getLabel());
                    addBeforeContent("</th>");
                }
                addBeforeContent("</tr>");
            }
            addBeforeContent("</thead>");
        }

        // render body and data
        addBeforeContent("<tbody id=\""+tableBodyId+"\">");
        addAfterContent("</tbody>");

        // set No record content
        if (noRecordContent != null) {
            int colspan = (columns != null) ? columns.size() : 1;
            addBeforeContent("<tr><td colspan=\""+colspan+"\">"+noRecordContent+"</td></tr>");
            noRecordContent = null;
        }

        // footer
        if (footer != null && footer.booleanValue()) {
            addAfterContent("<tfoot id=\""+tableFootId+"\">");
            if (columns != null) {
                addAfterContent("<tr>");
                for (int i=0,len=columns.size(); i<len; i++) {
                    addAfterContent("<th>");
                    addAfterContent(columns.get(i).getLabel());
                    addAfterContent("</th>");
                }
                addAfterContent("</tr>");
            }
            addAfterContent("</tfoot>");
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

    /**
     * Add column tag data
     * @param columnData column data
     */
    public void addColumn(TableColumnData columnData) {
        if (!shouldCollectColumn) {
            return;
        }
        if (columnData == null) {
            return;
        }
        if (columns == null) {
            columns = new ArrayList<TableColumnData>();
        }
        columns.add(columnData);
    }

    /**
     * Whether collect column data or not
     * @return true: collect, false: ignore
     */
    public boolean shouldCollectColumn() {
        return shouldCollectColumn;
    }

    /**
     * Get has data flag
     * @return true: has data, false: no data
     */
    public boolean hasData() {
        return hasData;
    }

    /**
     * Set No record content
     * @param noRecordContent No record content
     */
    public void setNoRecordContent(String noRecordContent) {
        this.noRecordContent = noRecordContent;
    }

    /**
     * Check has more data or not
     * @return true: has data, false: no more data
     */
    private boolean hasMoreData() {
        if (iterator == null) {
            return false;
        }
        return iterator.hasNext();
    }
}