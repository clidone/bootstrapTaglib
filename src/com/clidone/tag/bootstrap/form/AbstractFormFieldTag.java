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
    protected Object value = null;
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
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

    // fieldXs
    protected int fieldXs = 0;
    public void setFieldXs(int fieldXs) {
        this.fieldXs = fieldXs;
    }

    // fieldSm
    protected int fieldSm = 0;
    public void setFieldSm(int fieldSm) {
        this.fieldSm = fieldSm;
    }

    // fieldMd
    protected int fieldMd = 0;
    public void setFieldMd(int fieldMd) {
        this.fieldMd = fieldMd;
    }

    // fieldLg
    protected int fieldLg = 0;
    public void setFieldLg(int fieldLg) {
        this.fieldLg = fieldLg;
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

    // help
    protected String help = null;
    public void setHelp(String help) {
        this.help = help;
    }

    // addonSize
    protected String addonSize = null;
    public void setAddonSize(String addonSize) {
        this.addonSize = addonSize;
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
        addBeforeWrap("<div class=\"form-group\">");

        String fieldId = getId();
        if (ValueUtils.isEmpty(fieldId)) {
            fieldId = UUID.randomUUID().toString();
            setId(fieldId);
        }
        addAttribute("id", fieldId);

        addAttribute("name", name);

        String srOnly = "";
        if (labelSrOnly != null && labelSrOnly.booleanValue()) {
            srOnly = " sr-only";
        }

        String requiredHTML = "";
        if (required != null && required.booleanValue()) {
            requiredHTML = "<span class=\"form-required\">*</span>&nbsp;";
        }

        FormTag formTag = (FormTag) findAncestorWithClass(this, FormTag.class);
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
        addBeforeWrap("<label class=\"control-label" + srOnly + labelColXs + labelColSm + labelColMd + labelColLg + "\" for=\""+fieldId+"\">"+requiredHTML+label+"</label>");

        if (isHorizontal) {
            String controlColXs = "";
            String controlColSm = "";
            String controlColMd = "";
            String controlColLg = "";
            if (fieldXs > 0) {
                controlColXs = " col-xs-" + fieldXs;
            }
            if (fieldSm > 0) {
                controlColSm = " col-sm-" + fieldSm;
            }
            if (fieldMd > 0) {
                controlColMd = " col-md-" + fieldMd;
            }
            if (fieldLg > 0) {
                controlColLg = " col-lg-" + fieldLg;
            }
            addBeforeWrap("<div class=\"" + controlColXs + controlColSm + controlColMd + controlColLg + "\">");
        }

        boolean formStatic  = (formTag != null && formTag.getStatic() != null && formTag.getStatic().booleanValue());
        boolean fieldStatic = (staticFlag != null && staticFlag.booleanValue());

        if (!formStatic && !fieldStatic) {
            // handle addon
            boolean hasPrefixAddon = !ValueUtils.isEmpty(prefixAddon);
            boolean hasSuffixAddon = !ValueUtils.isEmpty(suffixAddon);
            if (hasPrefixAddon || hasSuffixAddon) {
                String size = ValueUtils.isEmpty(addonSize) ? "" : " input-group-" + addonSize;
                addBeforeWrap("<div class=\"input-group"+size+"\">");
            }
            if (hasPrefixAddon) {
                String addonHTML = renderAddOn(prefixAddon);
                addBeforeWrap(addonHTML);
            }
            if (hasSuffixAddon) {
                String addonHTML = renderAddOn(suffixAddon);
                addAfterWrap(addonHTML);
            }
            if (hasPrefixAddon || hasSuffixAddon) {
                addAfterWrap("</div>");
            }
        }

        if (!ValueUtils.isEmpty(help)) {
            addAfterWrap("<span id=\""+fieldId+"HelpBlock\" class=\"help-block\">" + help + "</span>");
        }

        if (isHorizontal) {
            addAfterWrap("</div>");
        }

        addAfterWrap("</div>");
    }

    /**
     * Render addOn
     * @param addOn
     */
    private String renderAddOn(String addOn) {
        if (ValueUtils.isEmpty(addOn)) {
            return "";
        }

        String addOnHTML = null;
        if (addOn.startsWith("icon:")) {
            addOnHTML = renderIcon(addOn.replace("icon:", ""), false);
        } else {
            addOnHTML = addOn;
        }
        return "<span class=\"input-group-addon\">"+addOnHTML+"</span>";
    }
}