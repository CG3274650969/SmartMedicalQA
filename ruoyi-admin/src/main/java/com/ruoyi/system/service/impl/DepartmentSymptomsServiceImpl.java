package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DepartmentSymptomsMapper;
import com.ruoyi.system.domain.DepartmentSymptoms;
import com.ruoyi.system.service.IDepartmentSymptomsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 科室典型症状Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Service
public class DepartmentSymptomsServiceImpl implements IDepartmentSymptomsService 
{
    @Autowired
    private DepartmentSymptomsMapper departmentSymptomsMapper;

    /**
     * 查询科室典型症状
     * 
     * @param id 科室典型症状主键
     * @return 科室典型症状
     */
    @Override
    public DepartmentSymptoms selectDepartmentSymptomsById(Long id)
    {
        return departmentSymptomsMapper.selectDepartmentSymptomsById(id);
    }

    /**
     * 查询科室典型症状列表
     * 
     * @param departmentSymptoms 科室典型症状
     * @return 科室典型症状
     */
    @Override
    public List<DepartmentSymptoms> selectDepartmentSymptomsList(DepartmentSymptoms departmentSymptoms)
    {
        return departmentSymptomsMapper.selectDepartmentSymptomsList(departmentSymptoms);
    }

    /**
     * 新增科室典型症状
     * 
     * @param departmentSymptoms 科室典型症状
     * @return 结果
     */
    @Override
    public int insertDepartmentSymptoms(DepartmentSymptoms departmentSymptoms)
    {
        departmentSymptoms.setCreateTime(DateUtils.getNowDate());
        return departmentSymptomsMapper.insertDepartmentSymptoms(departmentSymptoms);
    }

    /**
     * 修改科室典型症状
     * 
     * @param departmentSymptoms 科室典型症状
     * @return 结果
     */
    @Override
    public int updateDepartmentSymptoms(DepartmentSymptoms departmentSymptoms)
    {
        return departmentSymptomsMapper.updateDepartmentSymptoms(departmentSymptoms);
    }

    /**
     * 批量删除科室典型症状
     * 
     * @param ids 需要删除的科室典型症状主键
     * @return 结果
     */
    @Override
    public int deleteDepartmentSymptomsByIds(String ids)
    {
        return departmentSymptomsMapper.deleteDepartmentSymptomsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除科室典型症状信息
     * 
     * @param id 科室典型症状主键
     * @return 结果
     */
    @Override
    public int deleteDepartmentSymptomsById(Long id)
    {
        return departmentSymptomsMapper.deleteDepartmentSymptomsById(id);
    }
}
