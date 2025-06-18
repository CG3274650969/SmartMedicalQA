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
import com.ruoyi.system.domain.PatientMedicalHistory;
import com.ruoyi.system.service.IPatientMedicalHistoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 患者病史记录Controller
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Controller
@RequestMapping("/patientsystem/history")
public class PatientMedicalHistoryController extends BaseController
{
    private String prefix = "patientsystem/history";

    @Autowired
    private IPatientMedicalHistoryService patientMedicalHistoryService;

    @RequiresPermissions("patientsystem:history:view")
    @GetMapping()
    public String history()
    {
        return prefix + "/history";
    }

    /**
     * 查询患者病史记录列表
     */
    @RequiresPermissions("patientsystem:history:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PatientMedicalHistory patientMedicalHistory)
    {
        startPage();
        List<PatientMedicalHistory> list = patientMedicalHistoryService.selectPatientMedicalHistoryList(patientMedicalHistory);
        return getDataTable(list);
    }

    /**
     * 导出患者病史记录列表
     */
    @RequiresPermissions("patientsystem:history:export")
    @Log(title = "患者病史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PatientMedicalHistory patientMedicalHistory)
    {
        List<PatientMedicalHistory> list = patientMedicalHistoryService.selectPatientMedicalHistoryList(patientMedicalHistory);
        ExcelUtil<PatientMedicalHistory> util = new ExcelUtil<PatientMedicalHistory>(PatientMedicalHistory.class);
        return util.exportExcel(list, "患者病史记录数据");
    }

    /**
     * 新增患者病史记录
     */
    @RequiresPermissions("patientsystem:history:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存患者病史记录
     */
    @RequiresPermissions("patientsystem:history:add")
    @Log(title = "患者病史记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PatientMedicalHistory patientMedicalHistory)
    {
        return toAjax(patientMedicalHistoryService.insertPatientMedicalHistory(patientMedicalHistory));
    }

    /**
     * 修改患者病史记录
     */
    @RequiresPermissions("patientsystem:history:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PatientMedicalHistory patientMedicalHistory = patientMedicalHistoryService.selectPatientMedicalHistoryById(id);
        mmap.put("patientMedicalHistory", patientMedicalHistory);
        return prefix + "/edit";
    }

    /**
     * 修改保存患者病史记录
     */
    @RequiresPermissions("patientsystem:history:edit")
    @Log(title = "患者病史记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PatientMedicalHistory patientMedicalHistory)
    {
        return toAjax(patientMedicalHistoryService.updatePatientMedicalHistory(patientMedicalHistory));
    }

    /**
     * 删除患者病史记录
     */
    @RequiresPermissions("patientsystem:history:remove")
    @Log(title = "患者病史记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(patientMedicalHistoryService.deletePatientMedicalHistoryByIds(ids));
    }
}
