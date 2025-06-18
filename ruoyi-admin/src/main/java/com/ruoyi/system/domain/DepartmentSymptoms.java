package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 科室典型症状对象 department_symptoms
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public class DepartmentSymptoms extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 症状ID */
    private Long id;

    /** 科室ID */
    @Excel(name = "科室ID")
    private Long departmentId;

    /** 症状名称 */
    @Excel(name = "症状名称")
    private String symptomName;

    /** 症状描述 */
    @Excel(name = "症状描述")
    private String description;

    /** 常见病因 */
    @Excel(name = "常见病因")
    private String commonCauses;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Long orderNum;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }

    public void setSymptomName(String symptomName) 
    {
        this.symptomName = symptomName;
    }

    public String getSymptomName() 
    {
        return symptomName;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setCommonCauses(String commonCauses) 
    {
        this.commonCauses = commonCauses;
    }

    public String getCommonCauses() 
    {
        return commonCauses;
    }

    public void setOrderNum(Long orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Long getOrderNum() 
    {
        return orderNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("departmentId", getDepartmentId())
            .append("symptomName", getSymptomName())
            .append("description", getDescription())
            .append("commonCauses", getCommonCauses())
            .append("orderNum", getOrderNum())
            .append("createTime", getCreateTime())
            .toString();
    }
}
