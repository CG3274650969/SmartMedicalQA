package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AiModelConfigMapper;
import com.ruoyi.system.domain.AiModelConfig;
import com.ruoyi.system.service.IAiModelConfigService;
import com.ruoyi.common.core.text.Convert;

/**
 * AI模型配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Service
public class AiModelConfigServiceImpl implements IAiModelConfigService 
{
    @Autowired
    private AiModelConfigMapper aiModelConfigMapper;

    /**
     * 查询AI模型配置
     * 
     * @param id AI模型配置主键
     * @return AI模型配置
     */
    @Override
    public AiModelConfig selectAiModelConfigById(Long id)
    {
        return aiModelConfigMapper.selectAiModelConfigById(id);
    }

    /**
     * 查询AI模型配置列表
     * 
     * @param aiModelConfig AI模型配置
     * @return AI模型配置
     */
    @Override
    public List<AiModelConfig> selectAiModelConfigList(AiModelConfig aiModelConfig)
    {
        return aiModelConfigMapper.selectAiModelConfigList(aiModelConfig);
    }

    /**
     * 新增AI模型配置
     * 
     * @param aiModelConfig AI模型配置
     * @return 结果
     */
    @Override
    public int insertAiModelConfig(AiModelConfig aiModelConfig)
    {
        aiModelConfig.setCreateTime(DateUtils.getNowDate());
        return aiModelConfigMapper.insertAiModelConfig(aiModelConfig);
    }

    /**
     * 修改AI模型配置
     * 
     * @param aiModelConfig AI模型配置
     * @return 结果
     */
    @Override
    public int updateAiModelConfig(AiModelConfig aiModelConfig)
    {
        aiModelConfig.setUpdateTime(DateUtils.getNowDate());
        return aiModelConfigMapper.updateAiModelConfig(aiModelConfig);
    }

    /**
     * 批量删除AI模型配置
     * 
     * @param ids 需要删除的AI模型配置主键
     * @return 结果
     */
    @Override
    public int deleteAiModelConfigByIds(String ids)
    {
        return aiModelConfigMapper.deleteAiModelConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除AI模型配置信息
     * 
     * @param id AI模型配置主键
     * @return 结果
     */
    @Override
    public int deleteAiModelConfigById(Long id)
    {
        return aiModelConfigMapper.deleteAiModelConfigById(id);
    }
}
