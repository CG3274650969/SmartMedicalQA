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
import com.ruoyi.system.domain.PatientMedication;
import com.ruoyi.system.service.IPatientMedicationService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 患者用药记录Controller
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Controller
@RequestMapping("/patientsystem/medication")
public class PatientMedicationController extends BaseController
{
    private String prefix = "patientsystem/medication";

    @Autowired
    private IPatientMedicationService patientMedicationService;

    @RequiresPermissions("patientsystem:medication:view")
    @GetMapping()
    public String medication()
    {
        return prefix + "/medication";
    }

    /**
     * 查询患者用药记录列表
     */
    @RequiresPermissions("patientsystem:medication:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PatientMedication patientMedication)
    {
        startPage();
        List<PatientMedication> list = patientMedicationService.selectPatientMedicationList(patientMedication);
        return getDataTable(list);
    }

    /**
     * 导出患者用药记录列表
     */
    @RequiresPermissions("patientsystem:medication:export")
    @Log(title = "患者用药记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PatientMedication patientMedication)
    {
        List<PatientMedication> list = patientMedicationService.selectPatientMedicationList(patientMedication);
        ExcelUtil<PatientMedication> util = new ExcelUtil<PatientMedication>(PatientMedication.class);
        return util.exportExcel(list, "患者用药记录数据");
    }

    /**
     * 新增患者用药记录
     */
    @RequiresPermissions("patientsystem:medication:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存患者用药记录
     */
    @RequiresPermissions("patientsystem:medication:add")
    @Log(title = "患者用药记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PatientMedication patientMedication)
    {
        return toAjax(patientMedicationService.insertPatientMedication(patientMedication));
    }

    /**
     * 修改患者用药记录
     */
    @RequiresPermissions("patientsystem:medication:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PatientMedication patientMedication = patientMedicationService.selectPatientMedicationById(id);
        mmap.put("patientMedication", patientMedication);
        return prefix + "/edit";
    }

    /**
     * 修改保存患者用药记录
     */
    @RequiresPermissions("patientsystem:medication:edit")
    @Log(title = "患者用药记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PatientMedication patientMedication)
    {
        return toAjax(patientMedicationService.updatePatientMedication(patientMedication));
    }

    /**
     * 删除患者用药记录
     */
    @RequiresPermissions("patientsystem:medication:remove")
    @Log(title = "患者用药记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(patientMedicationService.deletePatientMedicationByIds(ids));
    }
}
