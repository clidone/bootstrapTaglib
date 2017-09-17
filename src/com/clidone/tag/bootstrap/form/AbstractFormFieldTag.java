package com.clidone.tag.bootstrap.form;

import java.util.UUID;

import javax.servlet.jsp.JspException;

import com.clidone.tag.AbstractTag;
import com.clidone.tag.ValueUtils;

/**
 * <strong>Abstract from field tag</strong>
 * @author wuhuaxia
 */
abstract class AbstractFormFieldTag extends AbstractTag {

    private static final long serialVersionUID = 8069768336105798918L;

    // **********************************************************************************
    //
    // Tag attributes
    //
    // **********************************************************************************
    // name
    protected String name = null;
    public void setName(String name) {
        this.name = name;
    }

    // value
    protected String value = null;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    // label
    protected String label = "";
    public void setLabel(String label) {
        this.label = label;
    }

    // labelSrOnly
    protected Boolean labelSrOnly = null;
    public void setLabelSrOnly(Boolean labelSrOnly) {
        this.labelSrOnly = labelSrOnly;
    }

    // labelXs
    protected int labelXs = 0;
    public void setLabelXs(int labelXs) {
        this.labelXs = labelXs;
    }

    // labelSm
    protected int labelSm = 0;
    public void setLabelSm(int labelSm) {
        this.labelSm = labelSm;
    }

    // labelMd
    protected int labelMd = 0;
    public void setLabelMd(int labelMd) {
        this.labelMd = labelMd;
    }

    // labelLg
    protected int labelLg = 0;
    public void setLabelLg(int labelLg) {
        this.labelLg = labelLg;
    }

    // required
    protected Boolean required = null;
    public void setRequired(Boolean required) {
        this.required = required;
    }

    // static
    protected Boolean staticFlag = null;
    public Boolean getStatic() {
        return staticFlag;
    }
    public void setStatic(Boolean staticFlag) {
        this.staticFlag = staticFlag;
    }

    // size
    protected String size = null;
    public void setSize(String size) {
        this.size = size;
    }

    // prefixAddon
    protected String prefixAddon = null;
    public void setPrefixAddon(String prefixAddon) {
        this.prefixAddon = prefixAddon;
    }

    // suffixAddon
    protected String suffixAddon = null;
    public void setSuffixAddon(String suffixAddon) {
        this.suffixAddon = suffixAddon;
    }

    // help
    protected String help = null;
    public void setHelp(String help) {
        this.help = help;
    }

    // **********************************************************************************
    //
    // Tag methods
    //
    // **********************************************************************************
    /**
     * Render commone attributes for form field
     * @exception JspException
     */
    protected void renderWrap() throws JspException {
        super.addBeforeWrap("<div class=\"form-group\">");

        String fieldId = super.getId();
        if (ValueUtils.isEmpty(fieldId)) {
            fieldId = UUID.randomUUID().toString();
            super.setId(fieldId);
        }
        super.addAttribute("id", fieldId);

        String srOnly = "";
        if (labelSrOnly != null && labelSrOnly.booleanValue()) {
            srOnly = " sr-only";
        }

        String requiredHTML = "";
        if (required != null && required.booleanValue()) {
            requiredHTML = "<span class=\"form-required\">*</span>&nbsp;";
        }

        FormTag formTag = (FormTag) super.findAncestorWithClass(this, FormTag.class);
        boolean isHorizontal = (formTag != null && ("h".equals(formTag.getLayout()) || "horizontal".equals(formTag.getLayout())));

        String labelColXs = "";
        String labelColSm = "";
        String labelColMd = "";
        String labelColLg = "";
        if (isHorizontal) {
            if (labelXs > 0) {
                labelColXs = " col-xs-" + labelXs;
            }
            if (labelSm > 0) {
                labelColSm = " col-sm-" + labelSm;
            }
            if (labelMd > 0) {
                labelColMd = " col-md-" + labelMd;
            }
            if (labelLg > 0) {
                labelColLg = " col-lg-" + labelLg;
            }
        }
        super.addBeforeWrap("<label class=\"control-label" + srOnly + labelColXs + labelColSm + labelColMd + labelColLg + "\" for=\""+fieldId+"\">"+requiredHTML+label+"</label>");

        if (isHorizontal) {
            String controlColXs = "";
            String controlColSm = "";
            String controlColMd = "";
            String controlColLg = "";
            if (labelXs > 0) {
                controlColXs = " col-xs-" + (12 - labelXs);
            }
            if (labelSm > 0) {
                controlColSm = " col-sm-" + (12 - labelSm);
            }
            if (labelMd > 0) {
                controlColMd = " col-md-" + (12 - labelMd);
            }
            if (labelLg > 0) {
                controlColLg = " col-lg-" + (12 - labelLg);
            }
            super.addBeforeWrap("<div class=\"" + controlColXs + controlColSm + controlColMd + controlColLg + "\">");
        }

        if (!ValueUtils.isEmpty(prefixAddon) || !ValueUtils.isEmpty(suffixAddon)) {
            super.addBeforeWrap("<div class=\"input-group\">");
            renderAddOn(prefixAddon);
            renderAddOn(suffixAddon);
            super.addAfterWrap("</div>");
        }

        if (!ValueUtils.isEmpty(help)) {
            super.addAfterWrap("<span id=\""+fieldId+"HelpBlock\" class=\"help-block\">" + help + "</span>");
        }

        if (isHorizontal) {
            super.addAfterWrap("</div>");
        }

        super.addAfterWrap("</div>");
    }

    /**
     * Render addOn
     * @param addOn
     */
    private void renderAddOn(String addOn) {
        if (ValueUtils.isEmpty(addOn)) {
            return;
        }

        String addOnHTML = null;
        if (addOn.startsWith("icon:")) {
            addOnHTML = super.renderIcon(addOn.replace("icon:", ""));
        } else {
            addOnHTML = addOn;
        }
        super.addBeforeWrap("<span class=\"input-group-addon\">"+addOnHTML+"</span>");
    }
}