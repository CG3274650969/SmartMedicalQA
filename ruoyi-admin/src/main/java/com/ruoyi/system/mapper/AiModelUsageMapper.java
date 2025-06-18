package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AiModelUsage;

/**
 * 大模型使用统计Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public interface AiModelUsageMapper 
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
     * 删除大模型使用统计
     * 
     * @param id 大模型使用统计主键
     * @return 结果
     */
    public int deleteAiModelUsageById(Long id);

    /**
     * 批量删除大模型使用统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAiModelUsageByIds(String[] ids);
}
