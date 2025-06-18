package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * AI提示词模板对象 ai_prompt_template
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public class AiPromptTemplate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 模板ID */
    private Long id;

    /** 模型ID */
    @Excel(name = "模型ID")
    private Long modelId;

    /** 模板名称 */
    @Excel(name = "模板名称")
    private String templateName;

    /** 模板内容 */
    @Excel(name = "模板内容")
    private String templateContent;

    /** 可用变量列表 */
    @Excel(name = "可用变量列表")
    private String variables;

    /** 模板描述 */
    @Excel(name = "模板描述")
    private String description;

    /** 是否默认(0否,1是) */
    @Excel(name = "是否默认(0否,1是)")
    private String isDefault;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setModelId(Long modelId) 
    {
        this.modelId = modelId;
    }

    public Long getModelId() 
    {
        return modelId;
    }

    public void setTemplateName(String templateName) 
    {
        this.templateName = templateName;
    }

    public String getTemplateName() 
    {
        return templateName;
    }

    public void setTemplateContent(String templateContent) 
    {
        this.templateContent = templateContent;
    }

    public String getTemplateContent() 
    {
        return templateContent;
    }

    public void setVariables(String variables) 
    {
        this.variables = variables;
    }

    public String getVariables() 
    {
        return variables;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setIsDefault(String isDefault) 
    {
        this.isDefault = isDefault;
    }

    public String getIsDefault() 
    {
        return isDefault;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("modelId", getModelId())
            .append("templateName", getTemplateName())
            .append("templateContent", getTemplateContent())
            .append("variables", getVariables())
            .append("description", getDescription())
            .append("isDefault", getIsDefault())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
