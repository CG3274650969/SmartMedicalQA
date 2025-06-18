package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PatientConsultationMapper;
import com.ruoyi.system.domain.PatientConsultation;
import com.ruoyi.system.service.IPatientConsultationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 患者问诊记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Service
public class PatientConsultationServiceImpl implements IPatientConsultationService 
{
    @Autowired
    private PatientConsultationMapper patientConsultationMapper;

    /**
     * 查询患者问诊记录
     * 
     * @param id 患者问诊记录主键
     * @return 患者问诊记录
     */
    @Override
    public PatientConsultation selectPatientConsultationById(Long id)
    {
        return patientConsultationMapper.selectPatientConsultationById(id);
    }

    /**
     * 查询患者问诊记录列表
     * 
     * @param patientConsultation 患者问诊记录
     * @return 患者问诊记录
     */
    @Override
    public List<PatientConsultation> selectPatientConsultationList(PatientConsultation patientConsultation)
    {
        return patientConsultationMapper.selectPatientConsultationList(patientConsultation);
    }

    /**
     * 新增患者问诊记录
     * 
     * @param patientConsultation 患者问诊记录
     * @return 结果
     */
    @Override
    public int insertPatientConsultation(PatientConsultation patientConsultation)
    {
        patientConsultation.setCreateTime(DateUtils.getNowDate());
        return patientConsultationMapper.insertPatientConsultation(patientConsultation);
    }

    /**
     * 修改患者问诊记录
     * 
     * @param patientConsultation 患者问诊记录
     * @return 结果
     */
    @Override
    public int updatePatientConsultation(PatientConsultation patientConsultation)
    {
        return patientConsultationMapper.updatePatientConsultation(patientConsultation);
    }

    /**
     * 批量删除患者问诊记录
     * 
     * @param ids 需要删除的患者问诊记录主键
     * @return 结果
     */
    @Override
    public int deletePatientConsultationByIds(String ids)
    {
        return patientConsultationMapper.deletePatientConsultationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除患者问诊记录信息
     * 
     * @param id 患者问诊记录主键
     * @return 结果
     */
    @Override
    public int deletePatientConsultationById(Long id)
    {
        return patientConsultationMapper.deletePatientConsultationById(id);
    }
}
