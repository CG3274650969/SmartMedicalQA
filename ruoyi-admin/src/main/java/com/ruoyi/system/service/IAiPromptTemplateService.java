package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AiPromptTemplate;

/**
 * AI提示词模板Service接口
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public interface IAiPromptTemplateService 
{
    /**
     * 查询AI提示词模板
     * 
     * @param id AI提示词模板主键
     * @return AI提示词模板
     */
    public AiPromptTemplate selectAiPromptTemplateById(Long id);

    /**
     * 查询AI提示词模板列表
     * 
     * @param aiPromptTemplate AI提示词模板
     * @return AI提示词模板集合
     */
    public List<AiPromptTemplate> selectAiPromptTemplateList(AiPromptTemplate aiPromptTemplate);

    /**
     * 新增AI提示词模板
     * 
     * @param aiPromptTemplate AI提示词模板
     * @return 结果
     */
    public int insertAiPromptTemplate(AiPromptTemplate aiPromptTemplate);

    /**
     * 修改AI提示词模板
     * 
     * @param aiPromptTemplate AI提示词模板
     * @return 结果
     */
    public int updateAiPromptTemplate(AiPromptTemplate aiPromptTemplate);

    /**
     * 批量删除AI提示词模板
     * 
     * @param ids 需要删除的AI提示词模板主键集合
     * @return 结果
     */
    public int deleteAiPromptTemplateByIds(String ids);

    /**
     * 删除AI提示词模板信息
     * 
     * @param id AI提示词模板主键
     * @return 结果
     */
    public int deleteAiPromptTemplateById(Long id);
}
