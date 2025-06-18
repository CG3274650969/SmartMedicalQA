package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PatientMedication;

/**
 * 患者用药记录Service接口
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public interface IPatientMedicationService 
{
    /**
     * 查询患者用药记录
     * 
     * @param id 患者用药记录主键
     * @return 患者用药记录
     */
    public PatientMedication selectPatientMedicationById(Long id);

    /**
     * 查询患者用药记录列表
     * 
     * @param patientMedication 患者用药记录
     * @return 患者用药记录集合
     */
    public List<PatientMedication> selectPatientMedicationList(PatientMedication patientMedication);

    /**
     * 新增患者用药记录
     * 
     * @param patientMedication 患者用药记录
     * @return 结果
     */
    public int insertPatientMedication(PatientMedication patientMedication);

    /**
     * 修改患者用药记录
     * 
     * @param patientMedication 患者用药记录
     * @return 结果
     */
    public int updatePatientMedication(PatientMedication patientMedication);

    /**
     * 批量删除患者用药记录
     * 
     * @param ids 需要删除的患者用药记录主键集合
     * @return 结果
     */
    public int deletePatientMedicationByIds(String ids);

    /**
     * 删除患者用药记录信息
     * 
     * @param id 患者用药记录主键
     * @return 结果
     */
    public int deletePatientMedicationById(Long id);
}
