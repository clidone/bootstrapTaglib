package com.clidone.tag.bootstrap;

import com.clidone.tag.AbstractSimpleTag;

/**
 * <strong>Paging tag</strong>
 * @author wuhuaxia
 */
public class PagingTag extends AbstractSimpleTag {

    // **********************************************************************************
    //
    // 数据成员
    //
    // **********************************************************************************
    // 数据总件数
    private long totalCount = 0L;

    // 数据当前页索引
    private long currentPage = 0L;

    // 数据每页数量
    private long eachPageCount = 24L;

    // 翻页链接URL
    private String linkUrl = null;

    // 链接翻页参数名称
    private String pageParamName = "page";


    // **********************************************************************************
    //
    // 属性
    //
    // **********************************************************************************
    // 数据总件数
    public long getCount() {
        return totalCount;
    }
    public void setCount(long totalCount) {
        this.totalCount = totalCount;
    }

    // 数据当前页索引
    public long getIndex() {
        return currentPage;
    }
    public void setIndex(long currentPage) {
        this.currentPage = currentPage;
    }

    // 数据每页数量
    public long getEach() {
        return eachPageCount;
    }
    public void setEach(long eachPageCount) {
        this.eachPageCount = eachPageCount;
    }

    // 翻页链接URL
    public String getUrl() {
        return linkUrl;
    }
    public void setUrl(String url) {
        this.linkUrl = url;
    }

    // 链接翻页参数名称
    public String getPageParam() {
        return pageParamName;
    }
    public void setPageParam(String pageParamName) {
        this.pageParamName = pageParamName;
    }

    // **********************************************************************************
    //
    // 标签逻辑
    //
    // **********************************************************************************
    /**
     * 渲染V2内容
     * @return 渲染内容
     */
    @Override
    protected final String renderV2() {
        StringBuilder content = new StringBuilder();
        return content.toString();
    }

    /**
     * 渲染V3内容
     * @return 渲染内容
     */
    @Override
    protected final String renderV3() {
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
            hrefBuilder.append(linkUrl).append(paramChar).append(pageParamName).append("=").append(pageIndex);
        }
        hrefBuilder.append("\"");

        return hrefBuilder.toString();
    }
}