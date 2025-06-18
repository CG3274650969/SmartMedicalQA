package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PatientMedicalHistory;

/**
 * 患者病史记录Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public interface PatientMedicalHistoryMapper 
{
    /**
     * 查询患者病史记录
     * 
     * @param id 患者病史记录主键
     * @return 患者病史记录
     */
    public PatientMedicalHistory selectPatientMedicalHistoryById(Long id);

    /**
     * 查询患者病史记录列表
     * 
     * @param patientMedicalHistory 患者病史记录
     * @return 患者病史记录集合
     */
    public List<PatientMedicalHistory> selectPatientMedicalHistoryList(PatientMedicalHistory patientMedicalHistory);

    /**
     * 新增患者病史记录
     * 
     * @param patientMedicalHistory 患者病史记录
     * @return 结果
     */
    public int insertPatientMedicalHistory(PatientMedicalHistory patientMedicalHistory);

    /**
     * 修改患者病史记录
     * 
     * @param patientMedicalHistory 患者病史记录
     * @return 结果
     */
    public int updatePatientMedicalHistory(PatientMedicalHistory patientMedicalHistory);

    /**
     * 删除患者病史记录
     * 
     * @param id 患者病史记录主键
     * @return 结果
     */
    public int deletePatientMedicalHistoryById(Long id);

    /**
     * 批量删除患者病史记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePatientMedicalHistoryByIds(String[] ids);
}
