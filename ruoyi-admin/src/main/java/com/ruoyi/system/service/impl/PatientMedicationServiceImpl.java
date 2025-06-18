package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PatientMedicationMapper;
import com.ruoyi.system.domain.PatientMedication;
import com.ruoyi.system.service.IPatientMedicationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 患者用药记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Service
public class PatientMedicationServiceImpl implements IPatientMedicationService 
{
    @Autowired
    private PatientMedicationMapper patientMedicationMapper;

    /**
     * 查询患者用药记录
     * 
     * @param id 患者用药记录主键
     * @return 患者用药记录
     */
    @Override
    public PatientMedication selectPatientMedicationById(Long id)
    {
        return patientMedicationMapper.selectPatientMedicationById(id);
    }

    /**
     * 查询患者用药记录列表
     * 
     * @param patientMedication 患者用药记录
     * @return 患者用药记录
     */
    @Override
    public List<PatientMedication> selectPatientMedicationList(PatientMedication patientMedication)
    {
        return patientMedicationMapper.selectPatientMedicationList(patientMedication);
    }

    /**
     * 新增患者用药记录
     * 
     * @param patientMedication 患者用药记录
     * @return 结果
     */
    @Override
    public int insertPatientMedication(PatientMedication patientMedication)
    {
        patientMedication.setCreateTime(DateUtils.getNowDate());
        return patientMedicationMapper.insertPatientMedication(patientMedication);
    }

    /**
     * 修改患者用药记录
     * 
     * @param patientMedication 患者用药记录
     * @return 结果
     */
    @Override
    public int updatePatientMedication(PatientMedication patientMedication)
    {
        return patientMedicationMapper.updatePatientMedication(patientMedication);
    }

    /**
     * 批量删除患者用药记录
     * 
     * @param ids 需要删除的患者用药记录主键
     * @return 结果
     */
    @Override
    public int deletePatientMedicationByIds(String ids)
    {
        return patientMedicationMapper.deletePatientMedicationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除患者用药记录信息
     * 
     * @param id 患者用药记录主键
     * @return 结果
     */
    @Override
    public int deletePatientMedicationById(Long id)
    {
        return patientMedicationMapper.deletePatientMedicationById(id);
    }
}
