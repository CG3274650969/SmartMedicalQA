package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 患者病史记录对象 patient_medical_history
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public class PatientMedicalHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long id;

    /** 患者ID */
    @Excel(name = "患者ID")
    private Long patientId;

    /** 病史类型(1:疾病史,2:手术史,3:过敏史,4:家族史) */
    @Excel(name = "病史类型(1:疾病史,2:手术史,3:过敏史,4:家族史)")
    private Long historyType;

    /** 名称(疾病/过敏源/手术名称) */
    @Excel(name = "名称(疾病/过敏源/手术名称)")
    private String name;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 详细描述 */
    @Excel(name = "详细描述")
    private String description;

    /** 严重程度 */
    @Excel(name = "严重程度")
    private String severity;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setPatientId(Long patientId) 
    {
        this.patientId = patientId;
    }

    public Long getPatientId() 
    {
        return patientId;
    }

    public void setHistoryType(Long historyType) 
    {
        this.historyType = historyType;
    }

    public Long getHistoryType() 
    {
        return historyType;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }

    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setSeverity(String severity) 
    {
        this.severity = severity;
    }

    public String getSeverity() 
    {
        return severity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("patientId", getPatientId())
            .append("historyType", getHistoryType())
            .append("name", getName())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("description", getDescription())
            .append("severity", getSeverity())
            .append("createTime", getCreateTime())
            .toString();
    }
}
