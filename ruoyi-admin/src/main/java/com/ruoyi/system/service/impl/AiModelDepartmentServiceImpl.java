package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AiModelDepartmentMapper;
import com.ruoyi.system.domain.AiModelDepartment;
import com.ruoyi.system.service.IAiModelDepartmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 大模型科室关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Service
public class AiModelDepartmentServiceImpl implements IAiModelDepartmentService 
{
    @Autowired
    private AiModelDepartmentMapper aiModelDepartmentMapper;

    /**
     * 查询大模型科室关联
     * 
     * @param id 大模型科室关联主键
     * @return 大模型科室关联
     */
    @Override
    public AiModelDepartment selectAiModelDepartmentById(Long id)
    {
        return aiModelDepartmentMapper.selectAiModelDepartmentById(id);
    }

    /**
     * 查询大模型科室关联列表
     * 
     * @param aiModelDepartment 大模型科室关联
     * @return 大模型科室关联
     */
    @Override
    public List<AiModelDepartment> selectAiModelDepartmentList(AiModelDepartment aiModelDepartment)
    {
        return aiModelDepartmentMapper.selectAiModelDepartmentList(aiModelDepartment);
    }

    /**
     * 新增大模型科室关联
     * 
     * @param aiModelDepartment 大模型科室关联
     * @return 结果
     */
    @Override
    public int insertAiModelDepartment(AiModelDepartment aiModelDepartment)
    {
        aiModelDepartment.setCreateTime(DateUtils.getNowDate());
        return aiModelDepartmentMapper.insertAiModelDepartment(aiModelDepartment);
    }

    /**
     * 修改大模型科室关联
     * 
     * @param aiModelDepartment 大模型科室关联
     * @return 结果
     */
    @Override
    public int updateAiModelDepartment(AiModelDepartment aiModelDepartment)
    {
        return aiModelDepartmentMapper.updateAiModelDepartment(aiModelDepartment);
    }

    /**
     * 批量删除大模型科室关联
     * 
     * @param ids 需要删除的大模型科室关联主键
     * @return 结果
     */
    @Override
    public int deleteAiModelDepartmentByIds(String ids)
    {
        return aiModelDepartmentMapper.deleteAiModelDepartmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除大模型科室关联信息
     * 
     * @param id 大模型科室关联主键
     * @return 结果
     */
    @Override
    public int deleteAiModelDepartmentById(Long id)
    {
        return aiModelDepartmentMapper.deleteAiModelDepartmentById(id);
    }
}
