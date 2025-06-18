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
import com.ruoyi.system.domain.PatientProfile;
import com.ruoyi.system.service.IPatientProfileService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 患者档案Controller
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
@Controller
@RequestMapping("/patientsystem/profile")
public class PatientProfileController extends BaseController
{
    private String prefix = "patientsystem/profile";

    @Autowired
    private IPatientProfileService patientProfileService;

    @RequiresPermissions("patientsystem:profile:view")
    @GetMapping()
    public String profile()
    {
        return prefix + "/profile";
    }

    /**
     * 查询患者档案列表
     */
    @RequiresPermissions("patientsystem:profile:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PatientProfile patientProfile)
    {
        startPage();
        List<PatientProfile> list = patientProfileService.selectPatientProfileList(patientProfile);
        return getDataTable(list);
    }

    /**
     * 导出患者档案列表
     */
    @RequiresPermissions("patientsystem:profile:export")
    @Log(title = "患者档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PatientProfile patientProfile)
    {
        List<PatientProfile> list = patientProfileService.selectPatientProfileList(patientProfile);
        ExcelUtil<PatientProfile> util = new ExcelUtil<PatientProfile>(PatientProfile.class);
        return util.exportExcel(list, "患者档案数据");
    }

    /**
     * 新增患者档案
     */
    @RequiresPermissions("patientsystem:profile:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存患者档案
     */
    @RequiresPermissions("patientsystem:profile:add")
    @Log(title = "患者档案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PatientProfile patientProfile)
    {
        return toAjax(patientProfileService.insertPatientProfile(patientProfile));
    }

    /**
     * 修改患者档案
     */
    @RequiresPermissions("patientsystem:profile:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PatientProfile patientProfile = patientProfileService.selectPatientProfileById(id);
        mmap.put("patientProfile", patientProfile);
        return prefix + "/edit";
    }

    /**
     * 修改保存患者档案
     */
    @RequiresPermissions("patientsystem:profile:edit")
    @Log(title = "患者档案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PatientProfile patientProfile)
    {
        return toAjax(patientProfileService.updatePatientProfile(patientProfile));
    }

    /**
     * 删除患者档案
     */
    @RequiresPermissions("patientsystem:profile:remove")
    @Log(title = "患者档案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(patientProfileService.deletePatientProfileByIds(ids));
    }
}
