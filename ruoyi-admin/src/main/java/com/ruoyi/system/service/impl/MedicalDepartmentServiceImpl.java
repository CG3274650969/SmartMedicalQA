package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MedicalDepartmentMapper;
import com.ruoyi.system.domain.MedicalDepartment;
import com.ruoyi.system.service.IMedicalDepartmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 医疗科室Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Service
public class MedicalDepartmentServiceImpl implements IMedicalDepartmentService 
{
    @Autowired
    private MedicalDepartmentMapper medicalDepartmentMapper;

    /**
     * 查询医疗科室
     * 
     * @param id 医疗科室主键
     * @return 医疗科室
     */
    @Override
    public MedicalDepartment selectMedicalDepartmentById(Long id)
    {
        return medicalDepartmentMapper.selectMedicalDepartmentById(id);
    }

    /**
     * 查询医疗科室列表
     * 
     * @param medicalDepartment 医疗科室
     * @return 医疗科室
     */
    @Override
    public List<MedicalDepartment> selectMedicalDepartmentList(MedicalDepartment medicalDepartment)
    {
        return medicalDepartmentMapper.selectMedicalDepartmentList(medicalDepartment);
    }

    /**
     * 新增医疗科室
     * 
     * @param medicalDepartment 医疗科室
     * @return 结果
     */
    @Override
    public int insertMedicalDepartment(MedicalDepartment medicalDepartment)
    {
        medicalDepartment.setCreateTime(DateUtils.getNowDate());
        return medicalDepartmentMapper.insertMedicalDepartment(medicalDepartment);
    }

    /**
     * 修改医疗科室
     * 
     * @param medicalDepartment 医疗科室
     * @return 结果
     */
    @Override
    public int updateMedicalDepartment(MedicalDepartment medicalDepartment)
    {
        medicalDepartment.setUpdateTime(DateUtils.getNowDate());
        return medicalDepartmentMapper.updateMedicalDepartment(medicalDepartment);
    }

    /**
     * 批量删除医疗科室
     * 
     * @param ids 需要删除的医疗科室主键
     * @return 结果
     */
    @Override
    public int deleteMedicalDepartmentByIds(String ids)
    {
        return medicalDepartmentMapper.deleteMedicalDepartmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除医疗科室信息
     * 
     * @param id 医疗科室主键
     * @return 结果
     */
    @Override
    public int deleteMedicalDepartmentById(Long id)
    {
        return medicalDepartmentMapper.deleteMedicalDepartmentById(id);
    }
}
