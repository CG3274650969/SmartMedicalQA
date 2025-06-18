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
import com.ruoyi.system.domain.PatientConsultation;
import com.ruoyi.system.service.IPatientConsultationService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 患者问诊记录Controller
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Controller
@RequestMapping("/patientsystem/consultation")
public class PatientConsultationController extends BaseController
{
    private String prefix = "patientsystem/consultation";

    @Autowired
    private IPatientConsultationService patientConsultationService;

    @RequiresPermissions("patientsystem:consultation:view")
    @GetMapping()
    public String consultation()
    {
        return prefix + "/consultation";
    }

    /**
     * 查询患者问诊记录列表
     */
    @RequiresPermissions("patientsystem:consultation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PatientConsultation patientConsultation)
    {
        startPage();
        List<PatientConsultation> list = patientConsultationService.selectPatientConsultationList(patientConsultation);
        return getDataTable(list);
    }

    /**
     * 导出患者问诊记录列表
     */
    @RequiresPermissions("patientsystem:consultation:export")
    @Log(title = "患者问诊记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PatientConsultation patientConsultation)
    {
        List<PatientConsultation> list = patientConsultationService.selectPatientConsultationList(patientConsultation);
        ExcelUtil<PatientConsultation> util = new ExcelUtil<PatientConsultation>(PatientConsultation.class);
        return util.exportExcel(list, "患者问诊记录数据");
    }

    /**
     * 新增患者问诊记录
     */
    @RequiresPermissions("patientsystem:consultation:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存患者问诊记录
     */
    @RequiresPermissions("patientsystem:consultation:add")
    @Log(title = "患者问诊记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PatientConsultation patientConsultation)
    {
        return toAjax(patientConsultationService.insertPatientConsultation(patientConsultation));
    }

    /**
     * 修改患者问诊记录
     */
    @RequiresPermissions("patientsystem:consultation:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PatientConsultation patientConsultation = patientConsultationService.selectPatientConsultationById(id);
        mmap.put("patientConsultation", patientConsultation);
        return prefix + "/edit";
    }

    /**
     * 修改保存患者问诊记录
     */
    @RequiresPermissions("patientsystem:consultation:edit")
    @Log(title = "患者问诊记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PatientConsultation patientConsultation)
    {
        return toAjax(patientConsultationService.updatePatientConsultation(patientConsultation));
    }

    /**
     * 删除患者问诊记录
     */
    @RequiresPermissions("patientsystem:consultation:remove")
    @Log(title = "患者问诊记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(patientConsultationService.deletePatientConsultationByIds(ids));
    }
}
