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
import com.ruoyi.system.domain.MedicalDepartment;
import com.ruoyi.system.service.IMedicalDepartmentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医疗科室Controller
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Controller
@RequestMapping("/doctorsystem/department")
public class MedicalDepartmentController extends BaseController
{
    private String prefix = "doctorsystem/department";

    @Autowired
    private IMedicalDepartmentService medicalDepartmentService;

    @RequiresPermissions("doctorsystem:department:view")
    @GetMapping()
    public String department()
    {
        return prefix + "/department";
    }

    /**
     * 查询医疗科室列表
     */
    @RequiresPermissions("doctorsystem:department:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MedicalDepartment medicalDepartment)
    {
        startPage();
        List<MedicalDepartment> list = medicalDepartmentService.selectMedicalDepartmentList(medicalDepartment);
        return getDataTable(list);
    }

    /**
     * 导出医疗科室列表
     */
    @RequiresPermissions("doctorsystem:department:export")
    @Log(title = "医疗科室", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MedicalDepartment medicalDepartment)
    {
        List<MedicalDepartment> list = medicalDepartmentService.selectMedicalDepartmentList(medicalDepartment);
        ExcelUtil<MedicalDepartment> util = new ExcelUtil<MedicalDepartment>(MedicalDepartment.class);
        return util.exportExcel(list, "医疗科室数据");
    }

    /**
     * 新增医疗科室
     */
    @RequiresPermissions("doctorsystem:department:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存医疗科室
     */
    @RequiresPermissions("doctorsystem:department:add")
    @Log(title = "医疗科室", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MedicalDepartment medicalDepartment)
    {
        return toAjax(medicalDepartmentService.insertMedicalDepartment(medicalDepartment));
    }

    /**
     * 修改医疗科室
     */
    @RequiresPermissions("doctorsystem:department:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MedicalDepartment medicalDepartment = medicalDepartmentService.selectMedicalDepartmentById(id);
        mmap.put("medicalDepartment", medicalDepartment);
        return prefix + "/edit";
    }

    /**
     * 修改保存医疗科室
     */
    @RequiresPermissions("doctorsystem:department:edit")
    @Log(title = "医疗科室", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MedicalDepartment medicalDepartment)
    {
        return toAjax(medicalDepartmentService.updateMedicalDepartment(medicalDepartment));
    }

    /**
     * 删除医疗科室
     */
    @RequiresPermissions("doctorsystem:department:remove")
    @Log(title = "医疗科室", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(medicalDepartmentService.deleteMedicalDepartmentByIds(ids));
    }
}
