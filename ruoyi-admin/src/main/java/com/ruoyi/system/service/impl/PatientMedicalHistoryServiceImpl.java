package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PatientMedicalHistoryMapper;
import com.ruoyi.system.domain.PatientMedicalHistory;
import com.ruoyi.system.service.IPatientMedicalHistoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 患者病史记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Service
public class PatientMedicalHistoryServiceImpl implements IPatientMedicalHistoryService 
{
    @Autowired
    private PatientMedicalHistoryMapper patientMedicalHistoryMapper;

    /**
     * 查询患者病史记录
     * 
     * @param id 患者病史记录主键
     * @return 患者病史记录
     */
    @Override
    public PatientMedicalHistory selectPatientMedicalHistoryById(Long id)
    {
        return patientMedicalHistoryMapper.selectPatientMedicalHistoryById(id);
    }

    /**
     * 查询患者病史记录列表
     * 
     * @param patientMedicalHistory 患者病史记录
     * @return 患者病史记录
     */
    @Override
    public List<PatientMedicalHistory> selectPatientMedicalHistoryList(PatientMedicalHistory patientMedicalHistory)
    {
        return patientMedicalHistoryMapper.selectPatientMedicalHistoryList(patientMedicalHistory);
    }

    /**
     * 新增患者病史记录
     * 
     * @param patientMedicalHistory 患者病史记录
     * @return 结果
     */
    @Override
    public int insertPatientMedicalHistory(PatientMedicalHistory patientMedicalHistory)
    {
        patientMedicalHistory.setCreateTime(DateUtils.getNowDate());
        return patientMedicalHistoryMapper.insertPatientMedicalHistory(patientMedicalHistory);
    }

    /**
     * 修改患者病史记录
     * 
     * @param patientMedicalHistory 患者病史记录
     * @return 结果
     */
    @Override
    public int updatePatientMedicalHistory(PatientMedicalHistory patientMedicalHistory)
    {
        return patientMedicalHistoryMapper.updatePatientMedicalHistory(patientMedicalHistory);
    }

    /**
     * 批量删除患者病史记录
     * 
     * @param ids 需要删除的患者病史记录主键
     * @return 结果
     */
    @Override
    public int deletePatientMedicalHistoryByIds(String ids)
    {
        return patientMedicalHistoryMapper.deletePatientMedicalHistoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除患者病史记录信息
     * 
     * @param id 患者病史记录主键
     * @return 结果
     */
    @Override
    public int deletePatientMedicalHistoryById(Long id)
    {
        return patientMedicalHistoryMapper.deletePatientMedicalHistoryById(id);
    }
}
