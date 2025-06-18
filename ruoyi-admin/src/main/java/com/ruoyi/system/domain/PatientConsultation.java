package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 患者问诊记录对象 patient_consultation
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public class PatientConsultation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 问诊ID */
    private Long id;

    /** 患者ID */
    @Excel(name = "患者ID")
    private Long patientId;

    /** 科室ID */
    @Excel(name = "科室ID")
    private Long departmentId;

    /** 主诉 */
    @Excel(name = "主诉")
    private String chiefComplaint;

    /** 症状描述 */
    @Excel(name = "症状描述")
    private String symptoms;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 状态(0:进行中,1:已完成,2:已取消) */
    @Excel(name = "状态(0:进行中,1:已完成,2:已取消)")
    private Long status;

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
    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }
    public void setChiefComplaint(String chiefComplaint) 
    {
        this.chiefComplaint = chiefComplaint;
    }

    public String getChiefComplaint() 
    {
        return chiefComplaint;
    }
    public void setSymptoms(String symptoms) 
    {
        this.symptoms = symptoms;
    }

    public String getSymptoms() 
    {
        return symptoms;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("patientId", getPatientId())
            .append("departmentId", getDepartmentId())
            .append("chiefComplaint", getChiefComplaint())
            .append("symptoms", getSymptoms())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
