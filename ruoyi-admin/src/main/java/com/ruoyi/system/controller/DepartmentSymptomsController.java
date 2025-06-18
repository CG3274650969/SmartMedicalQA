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
import com.ruoyi.system.domain.DepartmentSymptoms;
import com.ruoyi.system.service.IDepartmentSymptomsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 科室典型症状Controller
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Controller
@RequestMapping("/doctorsystem/symptoms")
public class DepartmentSymptomsController extends BaseController
{
    private String prefix = "doctorsystem/symptoms";

    @Autowired
    private IDepartmentSymptomsService departmentSymptomsService;

    @RequiresPermissions("doctorsystem:symptoms:view")
    @GetMapping()
    public String symptoms()
    {
        return prefix + "/symptoms";
    }

    /**
     * 查询科室典型症状列表
     */
    @RequiresPermissions("doctorsystem:symptoms:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DepartmentSymptoms departmentSymptoms)
    {
        startPage();
        List<DepartmentSymptoms> list = departmentSymptomsService.selectDepartmentSymptomsList(departmentSymptoms);
        return getDataTable(list);
    }

    /**
     * 导出科室典型症状列表
     */
    @RequiresPermissions("doctorsystem:symptoms:export")
    @Log(title = "科室典型症状", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DepartmentSymptoms departmentSymptoms)
    {
        List<DepartmentSymptoms> list = departmentSymptomsService.selectDepartmentSymptomsList(departmentSymptoms);
        ExcelUtil<DepartmentSymptoms> util = new ExcelUtil<DepartmentSymptoms>(DepartmentSymptoms.class);
        return util.exportExcel(list, "科室典型症状数据");
    }

    /**
     * 新增科室典型症状
     */
    @RequiresPermissions("doctorsystem:symptoms:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存科室典型症状
     */
    @RequiresPermissions("doctorsystem:symptoms:add")
    @Log(title = "科室典型症状", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DepartmentSymptoms departmentSymptoms)
    {
        return toAjax(departmentSymptomsService.insertDepartmentSymptoms(departmentSymptoms));
    }

    /**
     * 修改科室典型症状
     */
    @RequiresPermissions("doctorsystem:symptoms:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DepartmentSymptoms departmentSymptoms = departmentSymptomsService.selectDepartmentSymptomsById(id);
        mmap.put("departmentSymptoms", departmentSymptoms);
        return prefix + "/edit";
    }

    /**
     * 修改保存科室典型症状
     */
    @RequiresPermissions("doctorsystem:symptoms:edit")
    @Log(title = "科室典型症状", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DepartmentSymptoms departmentSymptoms)
    {
        return toAjax(departmentSymptomsService.updateDepartmentSymptoms(departmentSymptoms));
    }

    /**
     * 删除科室典型症状
     */
    @RequiresPermissions("doctorsystem:symptoms:remove")
    @Log(title = "科室典型症状", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(departmentSymptomsService.deleteDepartmentSymptomsByIds(ids));
    }
}
