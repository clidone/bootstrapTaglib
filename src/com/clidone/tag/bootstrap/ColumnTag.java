package com.clidone.tag.bootstrap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;

import com.clidone.tag.AbstractBodyTag;
import com.clidone.tag.BootstrapConfigConst;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Column tag</strong>
 * @author wuhuaxia
 */
public class ColumnTag extends AbstractBodyTag {

    private static final long serialVersionUID = -3672878843482734152L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    private int xs = 0;
    public void setXs(int xs) {
        this.xs = xs;
    }

    private int sm = 0;
    public void setSm(int sm) {
        this.sm = sm;
    }

    private int md = 0;
    public void setMd(int md) {
        this.md = md;
    }

    private int lg = 0;
    public void setLg(int lg) {
        this.lg = lg;
    }

    private int xsPush = 0;
    public void setXsPush(int xsPush) {
        this.xsPush = xsPush;
    }

    private int smPush = 0;
    public void setSmPush(int smPush) {
        this.smPush = smPush;
    }

    private int mdPush = 0;
    public void setMdPush(int mdPush) {
        this.mdPush = mdPush;
    }

    private int lgPush = 0;
    public void setLgPush(int lgPush) {
        this.lgPush = lgPush;
    }

    private int xsPull = 0;
    public void setXsPull(int xsPull) {
        this.xsPull = xsPull;
    }

    private int smPull = 0;
    public void setSmPull(int smPull) {
        this.smPull = smPull;
    }

    private int mdPull = 0;
    public void setMdPull(int mdPull) {
        this.mdPull = mdPull;
    }

    private int lgPull = 0;
    public void setLgPull(int lgPull) {
        this.lgPull = lgPull;
    }

    private int xsOffset = 0;
    public void setXsOffset(int offset) {
        this.xsOffset = offset;
    }

    private int smOffset = 0;
    public void setSmOffset(int offset) {
        this.smOffset = offset;
    }

    private int mdOffset = 0;
    public void setMdOffset(int offset) {
        this.mdOffset = offset;
    }

    private int lgOffset = 0;
    public void setLgOffset(int offset) {
        this.lgOffset = offset;
    }

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    /**
     * @see AbstractBodyTag#renderV2()
     */
    @Override
    protected String renderV2() throws JspException {
        // Get request parameter _device_width_
        String deviceWidthName = (String) super.getServletContext().getAttribute(BootstrapConfigConst.BOOTSTRAP_TAGLIB_DEVICE_WIDTH_KEY);
        String deviceWidthStr = super.getRequest().getParameter(deviceWidthName);
        if (ValueUtils.isEmpty(deviceWidthStr)) {
            throw new JspException("Render culumn tag failure: request parameter _device_width_ is required.");
        }
        int deviceWidth = Integer.valueOf(deviceWidthStr);

        // Calculate column value and offset
        int columnValue = 0;
        int columnOffset = 0;
        if (deviceWidth < 768) {
            if (xs > 0) {
                columnValue = xs;
            } else {
                columnValue = 12;
            }
            if (xsOffset > 0) {
                columnOffset = xsOffset;
            }

        } else if (deviceWidth >= 768 && columnValue < 992) {
            if (sm > 0) {
                columnValue = sm;
            } else {
                columnValue = 12;
            }
            if (smOffset > 0) {
                columnOffset = smOffset;
            }

        } else if (deviceWidth >= 992 && columnValue < 1200) {
            if (md > 0) {
                columnValue = md;
            } else {
                columnValue = 12;
            }
            if (mdOffset > 0) {
                columnOffset = mdOffset;
            }

        } else {
            if (lg > 0) {
                columnValue = lg;
            } else {
                columnValue = 12;
            }
            if (lgOffset > 0) {
                columnOffset = lgOffset;
            }
        }

        BodyContent bodyContent = super.getBodyContent();

        StringBuilder tagHTML = new StringBuilder();
        tagHTML.append("<div").append(" style=\"").append(super.getStyleCss());
        tagHTML.append(" class=\"").append(super.getClassCss());
        tagHTML.append(" span").append(columnValue);
        if (columnOffset > 0) {
            tagHTML.append(" offset").append(columnOffset);
        }
        tagHTML.append("\" \">");
        tagHTML.append(bodyContent.getString());
        tagHTML.append("</div>");

        return tagHTML.toString();
    }

    /**
     * @see AbstractBodyTag#renderV3()
     */
    @Override
    protected String renderV3() throws JspException {
        BodyContent bodyContent = super.getBodyContent();

        StringBuilder tagHTML = new StringBuilder();
        tagHTML.append("<div").append(" style=\"").append(super.getStyleCss()).append(" class=\"").append(super.getClassCss());
        if (xs > 0) {
            tagHTML.append(" col-xs-").append(xs);
        }
        if (sm > 0) {
            tagHTML.append(" col-sm-").append(sm);
        }
        if (md > 0) {
            tagHTML.append(" col-md-").append(md);
        }
        if (lg > 0) {
            tagHTML.append(" col-lg-").append(lg);
        }
        if (xsPush > 0) {
            tagHTML.append(" col-xs-push-").append(xsPush);
        }
        if (smPush > 0) {
            tagHTML.append(" col-sm-push-").append(smPush);
        }
        if (mdPush > 0) {
            tagHTML.append(" col-md-push-").append(mdPush);
        }
        if (lgPush > 0) {
            tagHTML.append(" col-lg-push-").append(lgPush);
        }
        if (xsPull > 0) {
            tagHTML.append(" col-xs-pull-").append(xsPull);
        }
        if (smPull > 0) {
            tagHTML.append(" col-sm-pull-").append(smPull);
        }
        if (mdPull > 0) {
            tagHTML.append(" col-md-pull-").append(mdPull);
        }
        if (lgPull > 0) {
            tagHTML.append(" col-lg-pull-").append(lgPull);
        }
        if (xsOffset > 0) {
            tagHTML.append(" col-xs-offset-").append(xsOffset);
        }
        if (smOffset > 0) {
            tagHTML.append(" col-sm-offset-").append(smOffset);
        }
        if (mdOffset > 0) {
            tagHTML.append(" col-md-offset-").append(mdOffset);
        }
        if (lgOffset > 0) {
            tagHTML.append(" col-lg-offset-").append(lgOffset);
        }
        tagHTML.append("\" \">");
        tagHTML.append(bodyContent.getString());
        tagHTML.append("</div>");

        return tagHTML.toString();
    }
}