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
import com.ruoyi.system.domain.AiModel;
import com.ruoyi.system.service.IAiModelService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * AI大模型Controller
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Controller
@RequestMapping("/doctorsystem/model")
public class AiModelController extends BaseController
{
    private String prefix = "doctorsystem/model";

    @Autowired
    private IAiModelService aiModelService;

    @RequiresPermissions("doctorsystem:model:view")
    @GetMapping()
    public String model()
    {
        return prefix + "/model";
    }

    /**
     * 查询AI大模型列表
     */
    @RequiresPermissions("doctorsystem:model:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AiModel aiModel)
    {
        startPage();
        List<AiModel> list = aiModelService.selectAiModelList(aiModel);
        return getDataTable(list);
    }

    /**
     * 导出AI大模型列表
     */
    @RequiresPermissions("doctorsystem:model:export")
    @Log(title = "AI大模型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AiModel aiModel)
    {
        List<AiModel> list = aiModelService.selectAiModelList(aiModel);
        ExcelUtil<AiModel> util = new ExcelUtil<AiModel>(AiModel.class);
        return util.exportExcel(list, "AI大模型数据");
    }

    /**
     * 新增AI大模型
     */
    @RequiresPermissions("doctorsystem:model:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存AI大模型
     */
    @RequiresPermissions("doctorsystem:model:add")
    @Log(title = "AI大模型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AiModel aiModel)
    {
        return toAjax(aiModelService.insertAiModel(aiModel));
    }

    /**
     * 修改AI大模型
     */
    @RequiresPermissions("doctorsystem:model:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AiModel aiModel = aiModelService.selectAiModelById(id);
        mmap.put("aiModel", aiModel);
        return prefix + "/edit";
    }

    /**
     * 修改保存AI大模型
     */
    @RequiresPermissions("doctorsystem:model:edit")
    @Log(title = "AI大模型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AiModel aiModel)
    {
        return toAjax(aiModelService.updateAiModel(aiModel));
    }

    /**
     * 删除AI大模型
     */
    @RequiresPermissions("doctorsystem:model:remove")
    @Log(title = "AI大模型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aiModelService.deleteAiModelByIds(ids));
    }
}
