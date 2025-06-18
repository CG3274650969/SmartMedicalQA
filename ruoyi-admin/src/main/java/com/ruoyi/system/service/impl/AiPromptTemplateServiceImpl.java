package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AiPromptTemplateMapper;
import com.ruoyi.system.domain.AiPromptTemplate;
import com.ruoyi.system.service.IAiPromptTemplateService;
import com.ruoyi.common.core.text.Convert;

/**
 * AI提示词模板Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Service
public class AiPromptTemplateServiceImpl implements IAiPromptTemplateService 
{
    @Autowired
    private AiPromptTemplateMapper aiPromptTemplateMapper;

    /**
     * 查询AI提示词模板
     * 
     * @param id AI提示词模板主键
     * @return AI提示词模板
     */
    @Override
    public AiPromptTemplate selectAiPromptTemplateById(Long id)
    {
        return aiPromptTemplateMapper.selectAiPromptTemplateById(id);
    }

    /**
     * 查询AI提示词模板列表
     * 
     * @param aiPromptTemplate AI提示词模板
     * @return AI提示词模板
     */
    @Override
    public List<AiPromptTemplate> selectAiPromptTemplateList(AiPromptTemplate aiPromptTemplate)
    {
        return aiPromptTemplateMapper.selectAiPromptTemplateList(aiPromptTemplate);
    }

    /**
     * 新增AI提示词模板
     * 
     * @param aiPromptTemplate AI提示词模板
     * @return 结果
     */
    @Override
    public int insertAiPromptTemplate(AiPromptTemplate aiPromptTemplate)
    {
        aiPromptTemplate.setCreateTime(DateUtils.getNowDate());
        return aiPromptTemplateMapper.insertAiPromptTemplate(aiPromptTemplate);
    }

    /**
     * 修改AI提示词模板
     * 
     * @param aiPromptTemplate AI提示词模板
     * @return 结果
     */
    @Override
    public int updateAiPromptTemplate(AiPromptTemplate aiPromptTemplate)
    {
        aiPromptTemplate.setUpdateTime(DateUtils.getNowDate());
        return aiPromptTemplateMapper.updateAiPromptTemplate(aiPromptTemplate);
    }

    /**
     * 批量删除AI提示词模板
     * 
     * @param ids 需要删除的AI提示词模板主键
     * @return 结果
     */
    @Override
    public int deleteAiPromptTemplateByIds(String ids)
    {
        return aiPromptTemplateMapper.deleteAiPromptTemplateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除AI提示词模板信息
     * 
     * @param id AI提示词模板主键
     * @return 结果
     */
    @Override
    public int deleteAiPromptTemplateById(Long id)
    {
        return aiPromptTemplateMapper.deleteAiPromptTemplateById(id);
    }
}
