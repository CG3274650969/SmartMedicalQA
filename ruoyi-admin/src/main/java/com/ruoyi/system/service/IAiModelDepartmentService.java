package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AiModelDepartment;

/**
 * 大模型科室关联Service接口
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public interface IAiModelDepartmentService 
{
    /**
     * 查询大模型科室关联
     * 
     * @param id 大模型科室关联主键
     * @return 大模型科室关联
     */
    public AiModelDepartment selectAiModelDepartmentById(Long id);

    /**
     * 查询大模型科室关联列表
     * 
     * @param aiModelDepartment 大模型科室关联
     * @return 大模型科室关联集合
     */
    public List<AiModelDepartment> selectAiModelDepartmentList(AiModelDepartment aiModelDepartment);

    /**
     * 新增大模型科室关联
     * 
     * @param aiModelDepartment 大模型科室关联
     * @return 结果
     */
    public int insertAiModelDepartment(AiModelDepartment aiModelDepartment);

    /**
     * 修改大模型科室关联
     * 
     * @param aiModelDepartment 大模型科室关联
     * @return 结果
     */
    public int updateAiModelDepartment(AiModelDepartment aiModelDepartment);

    /**
     * 批量删除大模型科室关联
     * 
     * @param ids 需要删除的大模型科室关联主键集合
     * @return 结果
     */
    public int deleteAiModelDepartmentByIds(String ids);

    /**
     * 删除大模型科室关联信息
     * 
     * @param id 大模型科室关联主键
     * @return 结果
     */
    public int deleteAiModelDepartmentById(Long id);
}
