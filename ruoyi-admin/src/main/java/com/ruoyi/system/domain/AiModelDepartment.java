package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大模型科室关联对象 ai_model_department
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public class AiModelDepartment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 关联ID */
    private Long id;

    /** 模型ID */
    @Excel(name = "模型ID")
    private Long modelId;

    /** 科室ID */
    @Excel(name = "科室ID")
    private Long departmentId;

    /** 权重(用于排序) */
    @Excel(name = "权重(用于排序)")
    private Long weight;

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

    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }

    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("modelId", getModelId())
            .append("departmentId", getDepartmentId())
            .append("weight", getWeight())
            .append("createTime", getCreateTime())
            .toString();
    }
}
