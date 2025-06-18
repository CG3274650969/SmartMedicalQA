package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PatientConsultation;

/**
 * 患者问诊记录Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public interface PatientConsultationMapper 
{
    /**
     * 查询患者问诊记录
     * 
     * @param id 患者问诊记录主键
     * @return 患者问诊记录
     */
    public PatientConsultation selectPatientConsultationById(Long id);

    /**
     * 查询患者问诊记录列表
     * 
     * @param patientConsultation 患者问诊记录
     * @return 患者问诊记录集合
     */
    public List<PatientConsultation> selectPatientConsultationList(PatientConsultation patientConsultation);

    /**
     * 新增患者问诊记录
     * 
     * @param patientConsultation 患者问诊记录
     * @return 结果
     */
    public int insertPatientConsultation(PatientConsultation patientConsultation);

    /**
     * 修改患者问诊记录
     * 
     * @param patientConsultation 患者问诊记录
     * @return 结果
     */
    public int updatePatientConsultation(PatientConsultation patientConsultation);

    /**
     * 删除患者问诊记录
     * 
     * @param id 患者问诊记录主键
     * @return 结果
     */
    public int deletePatientConsultationById(Long id);

    /**
     * 批量删除患者问诊记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePatientConsultationByIds(String[] ids);
}
