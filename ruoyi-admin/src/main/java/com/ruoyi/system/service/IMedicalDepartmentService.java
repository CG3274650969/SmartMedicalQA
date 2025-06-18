package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.MedicalDepartment;

/**
 * 医疗科室Service接口
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public interface IMedicalDepartmentService 
{
    /**
     * 查询医疗科室
     * 
     * @param id 医疗科室主键
     * @return 医疗科室
     */
    public MedicalDepartment selectMedicalDepartmentById(Long id);

    /**
     * 查询医疗科室列表
     * 
     * @param medicalDepartment 医疗科室
     * @return 医疗科室集合
     */
    public List<MedicalDepartment> selectMedicalDepartmentList(MedicalDepartment medicalDepartment);

    /**
     * 新增医疗科室
     * 
     * @param medicalDepartment 医疗科室
     * @return 结果
     */
    public int insertMedicalDepartment(MedicalDepartment medicalDepartment);

    /**
     * 修改医疗科室
     * 
     * @param medicalDepartment 医疗科室
     * @return 结果
     */
    public int updateMedicalDepartment(MedicalDepartment medicalDepartment);

    /**
     * 批量删除医疗科室
     * 
     * @param ids 需要删除的医疗科室主键集合
     * @return 结果
     */
    public int deleteMedicalDepartmentByIds(String ids);

    /**
     * 删除医疗科室信息
     * 
     * @param id 医疗科室主键
     * @return 结果
     */
    public int deleteMedicalDepartmentById(Long id);
}
