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
import com.ruoyi.system.domain.AiModelDepartment;
import com.ruoyi.system.service.IAiModelDepartmentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 大模型科室关联Controller
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Controller
@RequestMapping("/doctorsystem/ai-department")
public class AiModelDepartmentController extends BaseController
{
    private String prefix = "doctorsystem/department";

    @Autowired
    private IAiModelDepartmentService aiModelDepartmentService;

    @RequiresPermissions("doctorsystem:department:view")
    @GetMapping()
    public String department()
    {
        return prefix + "/department";
    }

    /**
     * 查询大模型科室关联列表
     */
    @RequiresPermissions("doctorsystem:department:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AiModelDepartment aiModelDepartment)
    {
        startPage();
        List<AiModelDepartment> list = aiModelDepartmentService.selectAiModelDepartmentList(aiModelDepartment);
        return getDataTable(list);
    }

    /**
     * 导出大模型科室关联列表
     */
    @RequiresPermissions("doctorsystem:department:export")
    @Log(title = "大模型科室关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AiModelDepartment aiModelDepartment)
    {
        List<AiModelDepartment> list = aiModelDepartmentService.selectAiModelDepartmentList(aiModelDepartment);
        ExcelUtil<AiModelDepartment> util = new ExcelUtil<AiModelDepartment>(AiModelDepartment.class);
        return util.exportExcel(list, "大模型科室关联数据");
    }

    /**
     * 新增大模型科室关联
     */
    @RequiresPermissions("doctorsystem:department:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存大模型科室关联
     */
    @RequiresPermissions("doctorsystem:department:add")
    @Log(title = "大模型科室关联", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AiModelDepartment aiModelDepartment)
    {
        return toAjax(aiModelDepartmentService.insertAiModelDepartment(aiModelDepartment));
    }

    /**
     * 修改大模型科室关联
     */
    @RequiresPermissions("doctorsystem:department:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AiModelDepartment aiModelDepartment = aiModelDepartmentService.selectAiModelDepartmentById(id);
        mmap.put("aiModelDepartment", aiModelDepartment);
        return prefix + "/edit";
    }

    /**
     * 修改保存大模型科室关联
     */
    @RequiresPermissions("doctorsystem:department:edit")
    @Log(title = "大模型科室关联", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AiModelDepartment aiModelDepartment)
    {
        return toAjax(aiModelDepartmentService.updateAiModelDepartment(aiModelDepartment));
    }

    /**
     * 删除大模型科室关联
     */
    @RequiresPermissions("doctorsystem:department:remove")
    @Log(title = "大模型科室关联", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aiModelDepartmentService.deleteAiModelDepartmentByIds(ids));
    }
}
