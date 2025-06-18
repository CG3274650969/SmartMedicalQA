package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 患者用药记录对象 patient_medication
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public class PatientMedication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long id;

    /** 患者ID */
    @Excel(name = "患者ID")
    private Long patientId;

    /** 药品名称 */
    @Excel(name = "药品名称")
    private String medicationName;

    /** 剂量 */
    @Excel(name = "剂量")
    private String dosage;

    /** 用药频率 */
    @Excel(name = "用药频率")
    private String frequency;

    /** 用药目的 */
    @Excel(name = "用药目的")
    private String purpose;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 开药医生 */
    @Excel(name = "开药医生")
    private String doctorName;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

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

    public void setMedicationName(String medicationName) 
    {
        this.medicationName = medicationName;
    }

    public String getMedicationName() 
    {
        return medicationName;
    }

    public void setDosage(String dosage) 
    {
        this.dosage = dosage;
    }

    public String getDosage() 
    {
        return dosage;
    }

    public void setFrequency(String frequency) 
    {
        this.frequency = frequency;
    }

    public String getFrequency() 
    {
        return frequency;
    }

    public void setPurpose(String purpose) 
    {
        this.purpose = purpose;
    }

    public String getPurpose() 
    {
        return purpose;
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

    public void setDoctorName(String doctorName) 
    {
        this.doctorName = doctorName;
    }

    public String getDoctorName() 
    {
        return doctorName;
    }

    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public String getNotes() 
    {
        return notes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("patientId", getPatientId())
            .append("medicationName", getMedicationName())
            .append("dosage", getDosage())
            .append("frequency", getFrequency())
            .append("purpose", getPurpose())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("doctorName", getDoctorName())
            .append("notes", getNotes())
            .append("createTime", getCreateTime())
            .toString();
    }
}
