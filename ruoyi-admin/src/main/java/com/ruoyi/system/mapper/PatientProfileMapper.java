package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PatientProfile;
import com.ruoyi.system.domain.PatientConsultation;

/**
 * 患者档案Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public interface PatientProfileMapper 
{
    /**
     * 查询患者档案
     * 
     * @param id 患者档案主键
     * @return 患者档案
     */
    public PatientProfile selectPatientProfileById(Long id);

    /**
     * 查询患者档案列表
     * 
     * @param patientProfile 患者档案
     * @return 患者档案集合
     */
    public List<PatientProfile> selectPatientProfileList(PatientProfile patientProfile);

    /**
     * 新增患者档案
     * 
     * @param patientProfile 患者档案
     * @return 结果
     */
    public int insertPatientProfile(PatientProfile patientProfile);

    /**
     * 修改患者档案
     * 
     * @param patientProfile 患者档案
     * @return 结果
     */
    public int updatePatientProfile(PatientProfile patientProfile);

    /**
     * 删除患者档案
     * 
     * @param id 患者档案主键
     * @return 结果
     */
    public int deletePatientProfileById(Long id);

    /**
     * 批量删除患者档案
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePatientProfileByIds(String[] ids);

    /**
     * 批量删除患者问诊记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePatientConsultationByPatientIds(String[] ids);
    
    /**
     * 批量新增患者问诊记录
     * 
     * @param patientConsultationList 患者问诊记录列表
     * @return 结果
     */
    public int batchPatientConsultation(List<PatientConsultation> patientConsultationList);
    

    /**
     * 通过患者档案主键删除患者问诊记录信息
     * 
     * @param id 患者档案ID
     * @return 结果
     */
    public int deletePatientConsultationByPatientId(Long id);
}
