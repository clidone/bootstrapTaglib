package com.clidone.tag.bootstrap;

import com.clidone.tag.AbstractTag;

/**
 * <strong>Paging tag</strong>
 * @author wuhuaxia
 */
public class PagingTag extends AbstractTag {

    private static final long serialVersionUID = 4652998063024869960L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // count
    protected long totalCount = 0L;
    public void setCount(long totalCount) {
        this.totalCount = totalCount;
    }

    // index
    protected long currentPage = 0L;
    public void setIndex(long currentPage) {
        this.currentPage = currentPage;
    }

    // each
    protected long eachPageCount = 24L;
    public void setEach(long eachPageCount) {
        this.eachPageCount = eachPageCount;
    }

    // url
    protected String linkUrl = null;
    public void setUrl(String url) {
        this.linkUrl = url;
    }

    // page parameter
    protected String page = "page";
    public void setPage(String page) {
        this.page = page;
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
    protected final String doEndTagV2() {
        StringBuilder content = new StringBuilder();
        return content.toString();
    }

    /**
     * @see AbstractTag#doEndTagV3()
     */
    @Override
    protected final String doEndTagV3() {
        StringBuilder html = new StringBuilder();
        html.append("<div class=\"text-center\">");
        html.append("<nav>");
        html.append("<ul class=\"pagination pagination-sm\">");

        // 首页
        if (currentPage == 1) {
            html.append("<li class=\"disabled\"><span>&laquo;</span></li>");
        } else {
            html.append("<li><a href="+buildHref(1L)+"><span>&laquo;</span></a></li>");
        }

        long totalPages = getTotalPages();
        // 页数较大场合
        if (totalPages >= 10) {
            currentPage = (Long) (currentPage / 10);
            long startPage = currentPage * 10;
            long endPage   = startPage + 9;

            // 不能大于最大页数
            if (endPage > totalPages) {
                endPage = totalPages;
            }

            // 当前页小于10, 则显示10以内的页码
            if (currentPage == 0) {
                startPage = 1L;
                endPage   = 10L;
            }

            // 分开显示第一页
            if (currentPage >= 10) {
                html.append("<li><a href="+buildHref(1L)+">1</a></li>");
                html.append("<li class=\"disabled\"><span>...</span></li>");
            }

            // 页码中间部分
            for (long i=startPage; i<=endPage; i++) {
                String active = (i == currentPage) ? " class=\"active\"" : "";
                html.append("<li"+active+"><a href="+buildHref(i)+">"+i+"</a></li>");
            }

            // 分开显示最后一页
            long temp = totalPages % 10;
            long displayLastPageNum = totalPages - temp;
            if (temp == 0) {
                displayLastPageNum = totalPages - 10;
            }
            if (currentPage < displayLastPageNum) {
                html.append("<li class=\"disabled\"><span>...</span></li>");
                html.append("<li><a href="+buildHref(totalPages)+">"+totalPages+"</a></li>");
            }

        // 常规少页数时
        } else {
            for (long i=1L; i<=totalPages; i++) {
                String active = (i == currentPage) ? " class=\"active\"" : "";
                html.append("<li"+active+"><a href="+buildHref(i)+">"+i+"</a></li>");
            }
        }

        // 末页
        if (currentPage == totalPages) {
            html.append("<li class=\"disabled\"><span>&raquo;</span></li>");
        } else {
            html.append("<li><a href="+buildHref(totalPages)+"><span>&raquo;</span></a></li>");
        }

        html.append("</ul>");
        html.append("</nav>");
        html.append("</div>");

        return html.toString();
    }

    /**
     * 计算总页数
     * @param count 数据总数
     * @return 总页数
     */
    private final long getTotalPages() {
        if (totalCount < 1) {
            return 0L;
        }

        long pages = totalCount / eachPageCount;
        if ((totalCount % eachPageCount) != 0) {
            pages++;
        }

        return pages;
    }

    /**
     * 构造URL参数
     * @return URL参数
     */
    private final String buildHref(long pageIndex) {
        if (linkUrl == null || "".equals(linkUrl.trim())) {
            return "";
        }

        StringBuilder hrefBuilder = new StringBuilder();
        hrefBuilder.append("\"");

        boolean isJSCall = (linkUrl.indexOf("javascript:") != -1);
        if (isJSCall) {
            hrefBuilder.append("javascript:void(0);\" onclick=\"");
            if (linkUrl.indexOf("?page?") >= 0) {
                hrefBuilder.append(linkUrl.replace("?page?", String.valueOf(pageIndex)));
            } else {
                hrefBuilder.append(linkUrl);
            }

        } else {
            String paramChar = (linkUrl.indexOf("?") >= 0) ? "&" : "?";
            hrefBuilder.append(linkUrl).append(paramChar).append(page).append("=").append(pageIndex);
        }
        hrefBuilder.append("\"");

        return hrefBuilder.toString();
    }
}