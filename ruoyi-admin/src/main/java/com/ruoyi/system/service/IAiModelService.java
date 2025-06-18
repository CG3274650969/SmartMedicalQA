package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AiModel;

/**
 * AI大模型Service接口
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public interface IAiModelService 
{
    /**
     * 查询AI大模型
     * 
     * @param id AI大模型主键
     * @return AI大模型
     */
    public AiModel selectAiModelById(Long id);

    /**
     * 查询AI大模型列表
     * 
     * @param aiModel AI大模型
     * @return AI大模型集合
     */
    public List<AiModel> selectAiModelList(AiModel aiModel);

    /**
     * 新增AI大模型
     * 
     * @param aiModel AI大模型
     * @return 结果
     */
    public int insertAiModel(AiModel aiModel);

    /**
     * 修改AI大模型
     * 
     * @param aiModel AI大模型
     * @return 结果
     */
    public int updateAiModel(AiModel aiModel);

    /**
     * 批量删除AI大模型
     * 
     * @param ids 需要删除的AI大模型主键集合
     * @return 结果
     */
    public int deleteAiModelByIds(String ids);

    /**
     * 删除AI大模型信息
     * 
     * @param id AI大模型主键
     * @return 结果
     */
    public int deleteAiModelById(Long id);
}
