package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AiModelUsage;

/**
 * 大模型使用统计Service接口
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public interface IAiModelUsageService 
{
    /**
     * 查询大模型使用统计
     * 
     * @param id 大模型使用统计主键
     * @return 大模型使用统计
     */
    public AiModelUsage selectAiModelUsageById(Long id);

    /**
     * 查询大模型使用统计列表
     * 
     * @param aiModelUsage 大模型使用统计
     * @return 大模型使用统计集合
     */
    public List<AiModelUsage> selectAiModelUsageList(AiModelUsage aiModelUsage);

    /**
     * 新增大模型使用统计
     * 
     * @param aiModelUsage 大模型使用统计
     * @return 结果
     */
    public int insertAiModelUsage(AiModelUsage aiModelUsage);

    /**
     * 修改大模型使用统计
     * 
     * @param aiModelUsage 大模型使用统计
     * @return 结果
     */
    public int updateAiModelUsage(AiModelUsage aiModelUsage);

    /**
     * 批量删除大模型使用统计
     * 
     * @param ids 需要删除的大模型使用统计主键集合
     * @return 结果
     */
    public int deleteAiModelUsageByIds(String ids);

    /**
     * 删除大模型使用统计信息
     * 
     * @param id 大模型使用统计主键
     * @return 结果
     */
    public int deleteAiModelUsageById(Long id);
}
