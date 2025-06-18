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
import com.ruoyi.system.domain.AiModelUsage;
import com.ruoyi.system.service.IAiModelUsageService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 大模型使用统计Controller
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Controller
@RequestMapping("/doctorsystem/usage")
public class AiModelUsageController extends BaseController
{
    private String prefix = "doctorsystem/usage";

    @Autowired
    private IAiModelUsageService aiModelUsageService;

    @RequiresPermissions("doctorsystem:usage:view")
    @GetMapping()
    public String usage()
    {
        return prefix + "/usage";
    }

    /**
     * 查询大模型使用统计列表
     */
    @RequiresPermissions("doctorsystem:usage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AiModelUsage aiModelUsage)
    {
        startPage();
        List<AiModelUsage> list = aiModelUsageService.selectAiModelUsageList(aiModelUsage);
        return getDataTable(list);
    }

    /**
     * 导出大模型使用统计列表
     */
    @RequiresPermissions("doctorsystem:usage:export")
    @Log(title = "大模型使用统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AiModelUsage aiModelUsage)
    {
        List<AiModelUsage> list = aiModelUsageService.selectAiModelUsageList(aiModelUsage);
        ExcelUtil<AiModelUsage> util = new ExcelUtil<AiModelUsage>(AiModelUsage.class);
        return util.exportExcel(list, "大模型使用统计数据");
    }

    /**
     * 新增大模型使用统计
     */
    @RequiresPermissions("doctorsystem:usage:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存大模型使用统计
     */
    @RequiresPermissions("doctorsystem:usage:add")
    @Log(title = "大模型使用统计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AiModelUsage aiModelUsage)
    {
        return toAjax(aiModelUsageService.insertAiModelUsage(aiModelUsage));
    }

    /**
     * 修改大模型使用统计
     */
    @RequiresPermissions("doctorsystem:usage:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AiModelUsage aiModelUsage = aiModelUsageService.selectAiModelUsageById(id);
        mmap.put("aiModelUsage", aiModelUsage);
        return prefix + "/edit";
    }

    /**
     * 修改保存大模型使用统计
     */
    @RequiresPermissions("doctorsystem:usage:edit")
    @Log(title = "大模型使用统计", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AiModelUsage aiModelUsage)
    {
        return toAjax(aiModelUsageService.updateAiModelUsage(aiModelUsage));
    }

    /**
     * 删除大模型使用统计
     */
    @RequiresPermissions("doctorsystem:usage:remove")
    @Log(title = "大模型使用统计", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aiModelUsageService.deleteAiModelUsageByIds(ids));
    }
}
