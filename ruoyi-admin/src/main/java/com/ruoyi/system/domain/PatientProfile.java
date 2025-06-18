package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 患者档案对象 patient_profile
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public class PatientProfile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 档案ID */
    private Long id;

    /** 关联用户ID */
    @Excel(name = "关联用户ID")
    private Long userId;

    /** 血型 */
    @Excel(name = "血型")
    private String bloodType;

    /** 身高(cm) */
    @Excel(name = "身高(cm)")
    private BigDecimal height;

    /** 体重(kg) */
    @Excel(name = "体重(kg)")
    private BigDecimal weight;

    /** 紧急联系人 */
    @Excel(name = "紧急联系人")
    private String emergencyContact;

    /** 紧急联系电话 */
    @Excel(name = "紧急联系电话")
    private String emergencyPhone;

    /** 患者问诊记录信息 */
    private List<PatientConsultation> patientConsultationList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setBloodType(String bloodType) 
    {
        this.bloodType = bloodType;
    }

    public String getBloodType() 
    {
        return bloodType;
    }

    public void setHeight(BigDecimal height) 
    {
        this.height = height;
    }

    public BigDecimal getHeight() 
    {
        return height;
    }

    public void setWeight(BigDecimal weight) 
    {
        this.weight = weight;
    }

    public BigDecimal getWeight() 
    {
        return weight;
    }

    public void setEmergencyContact(String emergencyContact) 
    {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContact() 
    {
        return emergencyContact;
    }

    public void setEmergencyPhone(String emergencyPhone) 
    {
        this.emergencyPhone = emergencyPhone;
    }

    public String getEmergencyPhone() 
    {
        return emergencyPhone;
    }

    public List<PatientConsultation> getPatientConsultationList()
    {
        return patientConsultationList;
    }

    public void setPatientConsultationList(List<PatientConsultation> patientConsultationList)
    {
        this.patientConsultationList = patientConsultationList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("bloodType", getBloodType())
            .append("height", getHeight())
            .append("weight", getWeight())
            .append("emergencyContact", getEmergencyContact())
            .append("emergencyPhone", getEmergencyPhone())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("patientConsultationList", getPatientConsultationList())
            .toString();
    }
}
