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

        // First page
        buildPage(html, 1L);

        // Middle pages
        long totalPages = getTotalPages();
        if (totalPages > 10) {
            Long startPage = 0L;
            Long endPage   = 0L;

            if ((currentPage - 1) < 4) {
                // < 1 2 3 4 5 ... 188 >
                startPage = 2L;
                endPage   = 5L;
                for (Long i=startPage; i<=endPage; i++) {
                    buildPage(html, i);
                }
                html.append("<li class=\"disabled\"><span>...</span></li>");

            } else if ((totalPages - currentPage) < 4) {
                // < 1 ... 183 184 185 186 187 188 >
                html.append("<li class=\"disabled\"><span>...</span></li>");
                startPage = totalPages - 5L;
                endPage   = totalPages;
                for (Long i=startPage; i<endPage; i++) {
                    buildPage(html, i);
                }

            } else {
                // < 1 ... 52 53 54 55 56 57 58 ... 188 >
                startPage = currentPage - 3L;
                endPage   = currentPage + 4L;
                if (startPage > 2L) {
                    html.append("<li class=\"disabled\"><span>...</span></li>");
                }
                for (Long i=startPage; i<endPage; i++) {
                    buildPage(html, i);
                }
                if (endPage < totalPages) {
                    html.append("<li class=\"disabled\"><span>...</span></li>");
                }
            }

        } else {
            // < 1 2 3 4 5 6 7 >
            if (totalPages > 1) {
                for (long i=2L; i<totalPages; i++) {
                    buildPage(html, i);
                }
            }
        }

        // Last page
        if (totalPages > 1) {
            buildPage(html, totalPages);
        }

        html.append("</ul>");
        html.append("</nav>");
        html.append("</div>");

        return html.toString();
    }

    /**
     * Get total pages
     * @return page count
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
     * Build page link
     * @param html HTML Container
     * @param buildIndex build page index
     * @param pageIndex current page index
     * @param isJSCall js call
     * @param url URL
     * @param paramChar parameter chars
     */
    private final void buildPage(StringBuilder html, Long buildIndex) {
        String active = (buildIndex == currentPage) ? " class=\"active\"" : "";
        html.append("<li"+active+"><a href="+buildHref(buildIndex)+">"+buildIndex+"</a></li>");
    }

    /**
     * Build URL
     * @return URL
     */
    private final String buildHref(long pageIndex) {
        String contextPath = super.getServletContext().getContextPath();
        if (linkUrl == null || "".equals(linkUrl.trim())) {
            return contextPath;
        }

        StringBuilder hrefBuilder = new StringBuilder();
        hrefBuilder.append("\"");

        boolean isJSCall = (linkUrl.indexOf("javascript:") != -1);
        if (isJSCall) {
            String url = linkUrl;
            hrefBuilder.append("javascript:void(0);\" onclick=\"");
            if (url.indexOf("?page?") >= 0) {
                hrefBuilder.append(url.replace("?page?", String.valueOf(pageIndex)));
            } else {
                hrefBuilder.append(url);
            }

        } else {
            String url = contextPath + linkUrl;
            String paramChar = (url.indexOf("?") >= 0) ? "&" : "?";
            hrefBuilder.append(url).append(paramChar).append(page).append("=").append(pageIndex);
        }
        hrefBuilder.append("\"");

        return hrefBuilder.toString();
    }
}