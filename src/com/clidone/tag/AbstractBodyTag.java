package com.clidone.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.clidone.tag.bootstrap.IBootstrapTag;

/**
 * <strong>抽象Body标签对象</strong>
 * @author wuhuaxia
 */
public abstract class AbstractBodyTag extends BodyTagSupport implements IBootstrapTag {

    // **********************************************************************************
    //
    // 数据成员
    //
    // **********************************************************************************
    private static final long serialVersionUID = -6152630007445070508L;


    // **********************************************************************************
    //
    // 属性
    //
    // **********************************************************************************


    // **********************************************************************************
    //
    // 标签逻辑
    //
    // **********************************************************************************
    /**
     * 处理标签开始逻辑
     */
    @Override
    public int doStartTag() throws JspException {
        // 组织内容
        StringBuilder builder = new StringBuilder();

        // 输出内容
        try {
            BodyContent bodyContent = super.getBodyContent();
            JspWriter writer = bodyContent.getEnclosingWriter();
            writer.println(builder.toString());
            bodyContent.writeOut(writer);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    /**
     * 处理标签结束逻辑
     */
    @Override
    public int doEndTag() throws JspException {
        // 组织内容
        StringBuilder builder = new StringBuilder();

        // 输出内容
        try {
            BodyContent bodyContent = super.getBodyContent();
            JspWriter writer = bodyContent.getEnclosingWriter();
            writer.println(builder.toString());
            bodyContent.writeOut(writer);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    /**
     * 处理标签完成逻辑
     */
    @Override
    public int doAfterBody() throws JspException {
        // 组织内容
        StringBuilder builder = new StringBuilder();

        // 输出内容
        try {
            BodyContent bodyContent = super.getBodyContent();
            JspWriter writer = bodyContent.getEnclosingWriter();
            writer.println(builder.toString());
            bodyContent.writeOut(writer);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return 0;
    }
}