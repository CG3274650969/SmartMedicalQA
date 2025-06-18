package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AiModelMapper;
import com.ruoyi.system.domain.AiModel;
import com.ruoyi.system.service.IAiModelService;
import com.ruoyi.common.core.text.Convert;

/**
 * AI大模型Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Service
public class AiModelServiceImpl implements IAiModelService 
{
    @Autowired
    private AiModelMapper aiModelMapper;

    /**
     * 查询AI大模型
     * 
     * @param id AI大模型主键
     * @return AI大模型
     */
    @Override
    public AiModel selectAiModelById(Long id)
    {
        return aiModelMapper.selectAiModelById(id);
    }

    /**
     * 查询AI大模型列表
     * 
     * @param aiModel AI大模型
     * @return AI大模型
     */
    @Override
    public List<AiModel> selectAiModelList(AiModel aiModel)
    {
        return aiModelMapper.selectAiModelList(aiModel);
    }

    /**
     * 新增AI大模型
     * 
     * @param aiModel AI大模型
     * @return 结果
     */
    @Override
    public int insertAiModel(AiModel aiModel)
    {
        aiModel.setCreateTime(DateUtils.getNowDate());
        return aiModelMapper.insertAiModel(aiModel);
    }

    /**
     * 修改AI大模型
     * 
     * @param aiModel AI大模型
     * @return 结果
     */
    @Override
    public int updateAiModel(AiModel aiModel)
    {
        aiModel.setUpdateTime(DateUtils.getNowDate());
        return aiModelMapper.updateAiModel(aiModel);
    }

    /**
     * 批量删除AI大模型
     * 
     * @param ids 需要删除的AI大模型主键
     * @return 结果
     */
    @Override
    public int deleteAiModelByIds(String ids)
    {
        return aiModelMapper.deleteAiModelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除AI大模型信息
     * 
     * @param id AI大模型主键
     * @return 结果
     */
    @Override
    public int deleteAiModelById(Long id)
    {
        return aiModelMapper.deleteAiModelById(id);
    }
}
