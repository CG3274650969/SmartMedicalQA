package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AiModelConfig;

/**
 * AI模型配置Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public interface AiModelConfigMapper 
{
    /**
     * 查询AI模型配置
     * 
     * @param id AI模型配置主键
     * @return AI模型配置
     */
    public AiModelConfig selectAiModelConfigById(Long id);

    /**
     * 查询AI模型配置列表
     * 
     * @param aiModelConfig AI模型配置
     * @return AI模型配置集合
     */
    public List<AiModelConfig> selectAiModelConfigList(AiModelConfig aiModelConfig);

    /**
     * 新增AI模型配置
     * 
     * @param aiModelConfig AI模型配置
     * @return 结果
     */
    public int insertAiModelConfig(AiModelConfig aiModelConfig);

    /**
     * 修改AI模型配置
     * 
     * @param aiModelConfig AI模型配置
     * @return 结果
     */
    public int updateAiModelConfig(AiModelConfig aiModelConfig);

    /**
     * 删除AI模型配置
     * 
     * @param id AI模型配置主键
     * @return 结果
     */
    public int deleteAiModelConfigById(Long id);

    /**
     * 批量删除AI模型配置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAiModelConfigByIds(String[] ids);
}
