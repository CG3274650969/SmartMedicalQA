package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.PatientConsultation;
import com.ruoyi.system.mapper.PatientProfileMapper;
import com.ruoyi.system.domain.PatientProfile;
import com.ruoyi.system.service.IPatientProfileService;
import com.ruoyi.common.core.text.Convert;

/**
 * 患者档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Service
public class PatientProfileServiceImpl implements IPatientProfileService 
{
    @Autowired
    private PatientProfileMapper patientProfileMapper;

    /**
     * 查询患者档案
     * 
     * @param id 患者档案主键
     * @return 患者档案
     */
    @Override
    public PatientProfile selectPatientProfileById(Long id)
    {
        return patientProfileMapper.selectPatientProfileById(id);
    }

    /**
     * 查询患者档案列表
     * 
     * @param patientProfile 患者档案
     * @return 患者档案
     */
    @Override
    public List<PatientProfile> selectPatientProfileList(PatientProfile patientProfile)
    {
        return patientProfileMapper.selectPatientProfileList(patientProfile);
    }

    /**
     * 新增患者档案
     * 
     * @param patientProfile 患者档案
     * @return 结果
     */
    @Transactional
    @Override
    public int insertPatientProfile(PatientProfile patientProfile)
    {
        patientProfile.setCreateTime(DateUtils.getNowDate());
        int rows = patientProfileMapper.insertPatientProfile(patientProfile);
        insertPatientConsultation(patientProfile);
        return rows;
    }

    /**
     * 修改患者档案
     * 
     * @param patientProfile 患者档案
     * @return 结果
     */
    @Transactional
    @Override
    public int updatePatientProfile(PatientProfile patientProfile)
    {
        patientProfile.setUpdateTime(DateUtils.getNowDate());
        patientProfileMapper.deletePatientConsultationByPatientId(patientProfile.getId());
        insertPatientConsultation(patientProfile);
        return patientProfileMapper.updatePatientProfile(patientProfile);
    }

    /**
     * 批量删除患者档案
     * 
     * @param ids 需要删除的患者档案主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePatientProfileByIds(String ids)
    {
        patientProfileMapper.deletePatientConsultationByPatientIds(Convert.toStrArray(ids));
        return patientProfileMapper.deletePatientProfileByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除患者档案信息
     * 
     * @param id 患者档案主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePatientProfileById(Long id)
    {
        patientProfileMapper.deletePatientConsultationByPatientId(id);
        return patientProfileMapper.deletePatientProfileById(id);
    }

    /**
     * 新增患者问诊记录信息
     * 
     * @param patientProfile 患者档案对象
     */
    public void insertPatientConsultation(PatientProfile patientProfile)
    {
        List<PatientConsultation> patientConsultationList = patientProfile.getPatientConsultationList();
        Long id = patientProfile.getId();
        if (StringUtils.isNotNull(patientConsultationList))
        {
            List<PatientConsultation> list = new ArrayList<PatientConsultation>();
            for (PatientConsultation patientConsultation : patientConsultationList)
            {
                patientConsultation.setPatientId(id);
                list.add(patientConsultation);
            }
            if (list.size() > 0)
            {
                patientProfileMapper.batchPatientConsultation(list);
            }
        }
    }
}
