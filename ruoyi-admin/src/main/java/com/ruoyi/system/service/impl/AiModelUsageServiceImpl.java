package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AiModelUsageMapper;
import com.ruoyi.system.domain.AiModelUsage;
import com.ruoyi.system.service.IAiModelUsageService;
import com.ruoyi.common.core.text.Convert;

/**
 * 大模型使用统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Service
public class AiModelUsageServiceImpl implements IAiModelUsageService 
{
    @Autowired
    private AiModelUsageMapper aiModelUsageMapper;

    /**
     * 查询大模型使用统计
     * 
     * @param id 大模型使用统计主键
     * @return 大模型使用统计
     */
    @Override
    public AiModelUsage selectAiModelUsageById(Long id)
    {
        return aiModelUsageMapper.selectAiModelUsageById(id);
    }

    /**
     * 查询大模型使用统计列表
     * 
     * @param aiModelUsage 大模型使用统计
     * @return 大模型使用统计
     */
    @Override
    public List<AiModelUsage> selectAiModelUsageList(AiModelUsage aiModelUsage)
    {
        return aiModelUsageMapper.selectAiModelUsageList(aiModelUsage);
    }

    /**
     * 新增大模型使用统计
     * 
     * @param aiModelUsage 大模型使用统计
     * @return 结果
     */
    @Override
    public int insertAiModelUsage(AiModelUsage aiModelUsage)
    {
        aiModelUsage.setCreateTime(DateUtils.getNowDate());
        return aiModelUsageMapper.insertAiModelUsage(aiModelUsage);
    }

    /**
     * 修改大模型使用统计
     * 
     * @param aiModelUsage 大模型使用统计
     * @return 结果
     */
    @Override
    public int updateAiModelUsage(AiModelUsage aiModelUsage)
    {
        aiModelUsage.setUpdateTime(DateUtils.getNowDate());
        return aiModelUsageMapper.updateAiModelUsage(aiModelUsage);
    }

    /**
     * 批量删除大模型使用统计
     * 
     * @param ids 需要删除的大模型使用统计主键
     * @return 结果
     */
    @Override
    public int deleteAiModelUsageByIds(String ids)
    {
        return aiModelUsageMapper.deleteAiModelUsageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除大模型使用统计信息
     * 
     * @param id 大模型使用统计主键
     * @return 结果
     */
    @Override
    public int deleteAiModelUsageById(Long id)
    {
        return aiModelUsageMapper.deleteAiModelUsageById(id);
    }
}
