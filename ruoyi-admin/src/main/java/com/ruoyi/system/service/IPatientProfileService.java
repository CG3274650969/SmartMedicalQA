package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PatientProfile;

/**
 * 患者档案Service接口
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public interface IPatientProfileService 
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
     * 批量删除患者档案
     * 
     * @param ids 需要删除的患者档案主键集合
     * @return 结果
     */
    public int deletePatientProfileByIds(String ids);

    /**
     * 删除患者档案信息
     * 
     * @param id 患者档案主键
     * @return 结果
     */
    public int deletePatientProfileById(Long id);
}
