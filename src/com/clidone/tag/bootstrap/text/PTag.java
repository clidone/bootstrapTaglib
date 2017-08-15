package com.clidone.tag.bootstrap.text;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * <strong>P tag</strong>
 * @author wuhuaxia
 */
public class PTag extends TagSupport {

    private static final long serialVersionUID = 2132841536119961228L;

    // 通过添加 .lead 类可以让段落突出显示。
    private boolean lead = false;
    public void setLead(boolean lead) {
        this.lead = lead;
    }

    // For highlighting a run of text due to its relevance in another context, use the <mark> tag.
    private String mark = null;
    public void setMark(String mark) {
        this.mark = mark;
    }

    // 对于被删除的文本使用 <del> 标签。
    private String del = null;
    public void setDel(String del) {
        this.del = del;
    }

    // 对于没用的文本使用 <s> 标签。
    private String s = null;
    public void setS(String s) {
        this.s = s;
    }

    // 对于没用的文本使用 <u> 标签。
    private String u = null;
    public void setU(String u) {
        this.u = u;
    }

    // 小号文本
    private String small = null;
    public void setSmall(String small) {
        this.small = small;
    }

    // 过增加 font-weight 值强调一段文本。
    private String b = null;
    public void setB(String b) {
        this.b = b;
    }

    // 用斜体强调一段文本。
    private String em = null;
    public void setEm(String em) {
        this.em = em;
    }

    // 对齐方式：left、center、right、justify、nowrap
    private String textAlign = "left";
    public void setAlign(String textAlign) {
        this.textAlign = textAlign;
    }

    // 背景颜色
    private String textBg = null;
    public void setBg(String textBg) {
        this.textBg = textBg;
    }

    // 大小写方式：lowercase、uppercase、capitalize
    private String textCase = null;
    public void setCase(String textCase) {
        this.textCase = textCase;
    }

    // 文本颜色
    private String textColor = null;
    public void setColor(String textColor) {
        this.textColor = textColor;
    }

    // 通过 <code> 标签包裹内联样式的代码片段。
    private String code = null;
    public void setCode(String code) {
        this.code = code;
    }

    // 通过 <kbd> 标签标记用户通过键盘输入的内容。
    private String kbd = null;
    public void setKbd(String kbd) {
        this.kbd = kbd;
    }

    // 多行代码可以使用 <pre> 标签。
    private String pre = null;
    public void setPre(String pre) {
        this.pre = pre;
    }

    // 通过 <var> 标签标记变量。
    private String var = null;
    public void setVar(String var) {
        this.var = var;
    }

    // 通过 <samp> 标签来标记程序输出的内容。
    private String samp = null;
    public void setSamp(String samp) {
        this.samp = samp;
    }
}