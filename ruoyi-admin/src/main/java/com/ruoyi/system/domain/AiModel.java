package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * AI大模型对象 ai_model
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public class AiModel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 模型ID */
    private Long id;

    /** 模型名称 */
    @Excel(name = "模型名称")
    private String name;

    /** 模型类型(如GPT-4,Claude等) */
    @Excel(name = "模型类型(如GPT-4,Claude等)")
    private String modelType;

    /** 模型版本 */
    @Excel(name = "模型版本")
    private String version;

    /** 提供商 */
    @Excel(name = "提供商")
    private String provider;

    /** 模型描述 */
    @Excel(name = "模型描述")
    private String description;

    /** 头像URL */
    @Excel(name = "头像URL")
    private String avatar;

    /** 状态(0正常,1停用) */
    @Excel(name = "状态(0正常,1停用)")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setModelType(String modelType) 
    {
        this.modelType = modelType;
    }

    public String getModelType() 
    {
        return modelType;
    }

    public void setVersion(String version) 
    {
        this.version = version;
    }

    public String getVersion() 
    {
        return version;
    }

    public void setProvider(String provider) 
    {
        this.provider = provider;
    }

    public String getProvider() 
    {
        return provider;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("modelType", getModelType())
            .append("version", getVersion())
            .append("provider", getProvider())
            .append("description", getDescription())
            .append("avatar", getAvatar())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
