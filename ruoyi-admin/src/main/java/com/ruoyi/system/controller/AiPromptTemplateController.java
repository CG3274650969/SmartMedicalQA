package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.AiPromptTemplate;
import com.ruoyi.system.service.IAiPromptTemplateService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * AI提示词模板Controller
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Controller
@RequestMapping("/doctorsystem/template")
public class AiPromptTemplateController extends BaseController
{
    private String prefix = "doctorsystem/template";

    @Autowired
    private IAiPromptTemplateService aiPromptTemplateService;

    @RequiresPermissions("doctorsystem:template:view")
    @GetMapping()
    public String template()
    {
        return prefix + "/template";
    }

    /**
     * 查询AI提示词模板列表
     */
    @RequiresPermissions("doctorsystem:template:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AiPromptTemplate aiPromptTemplate)
    {
        startPage();
        List<AiPromptTemplate> list = aiPromptTemplateService.selectAiPromptTemplateList(aiPromptTemplate);
        return getDataTable(list);
    }

    /**
     * 导出AI提示词模板列表
     */
    @RequiresPermissions("doctorsystem:template:export")
    @Log(title = "AI提示词模板", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AiPromptTemplate aiPromptTemplate)
    {
        List<AiPromptTemplate> list = aiPromptTemplateService.selectAiPromptTemplateList(aiPromptTemplate);
        ExcelUtil<AiPromptTemplate> util = new ExcelUtil<AiPromptTemplate>(AiPromptTemplate.class);
        return util.exportExcel(list, "AI提示词模板数据");
    }

    /**
     * 新增AI提示词模板
     */
    @RequiresPermissions("doctorsystem:template:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存AI提示词模板
     */
    @RequiresPermissions("doctorsystem:template:add")
    @Log(title = "AI提示词模板", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AiPromptTemplate aiPromptTemplate)
    {
        return toAjax(aiPromptTemplateService.insertAiPromptTemplate(aiPromptTemplate));
    }

    /**
     * 修改AI提示词模板
     */
    @RequiresPermissions("doctorsystem:template:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AiPromptTemplate aiPromptTemplate = aiPromptTemplateService.selectAiPromptTemplateById(id);
        mmap.put("aiPromptTemplate", aiPromptTemplate);
        return prefix + "/edit";
    }

    /**
     * 修改保存AI提示词模板
     */
    @RequiresPermissions("doctorsystem:template:edit")
    @Log(title = "AI提示词模板", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AiPromptTemplate aiPromptTemplate)
    {
        return toAjax(aiPromptTemplateService.updateAiPromptTemplate(aiPromptTemplate));
    }

    /**
     * 删除AI提示词模板
     */
    @RequiresPermissions("doctorsystem:template:remove")
    @Log(title = "AI提示词模板", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aiPromptTemplateService.deleteAiPromptTemplateByIds(ids));
    }
}
