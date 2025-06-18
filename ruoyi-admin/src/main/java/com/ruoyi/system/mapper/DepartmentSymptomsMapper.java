package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.DepartmentSymptoms;

/**
 * 科室典型症状Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public interface DepartmentSymptomsMapper 
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
     * 删除科室典型症状
     * 
     * @param id 科室典型症状主键
     * @return 结果
     */
    public int deleteDepartmentSymptomsById(Long id);

    /**
     * 批量删除科室典型症状
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDepartmentSymptomsByIds(String[] ids);
}
