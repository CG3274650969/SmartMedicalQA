package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.DepartmentSymptoms;

/**
 * 科室典型症状Service接口
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public interface IDepartmentSymptomsService 
{
    /**
     * 查询科室典型症状
     * 
     * @param id 科室典型症状主键
     * @return 科室典型症状
     */
    public DepartmentSymptoms selectDepartmentSymptomsById(Long id);

    /**
     * 查询科室典型症状列表
     * 
     * @param departmentSymptoms 科室典型症状
     * @return 科室典型症状集合
     */
    public List<DepartmentSymptoms> selectDepartmentSymptomsList(DepartmentSymptoms departmentSymptoms);

    /**
     * 新增科室典型症状
     * 
     * @param departmentSymptoms 科室典型症状
     * @return 结果
     */
    public int insertDepartmentSymptoms(DepartmentSymptoms departmentSymptoms);

    /**
     * 修改科室典型症状
     * 
     * @param departmentSymptoms 科室典型症状
     * @return 结果
     */
    public int updateDepartmentSymptoms(DepartmentSymptoms departmentSymptoms);

    /**
     * 批量删除科室典型症状
     * 
     * @param ids 需要删除的科室典型症状主键集合
     * @return 结果
     */
    public int deleteDepartmentSymptomsByIds(String ids);

    /**
     * 删除科室典型症状信息
     * 
     * @param id 科室典型症状主键
     * @return 结果
     */
    public int deleteDepartmentSymptomsById(Long id);
}
