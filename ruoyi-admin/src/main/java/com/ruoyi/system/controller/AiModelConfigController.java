//package com.ruoyi.system.controller;
//
//import java.util.List;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import com.ruoyi.common.annotation.Log;
//import com.ruoyi.common.enums.BusinessType;
//import com.ruoyi.system.domain.AiModelConfig;
//import com.ruoyi.system.service.IAiModelConfigService;
//import com.ruoyi.common.core.controller.BaseController;
//import com.ruoyi.common.core.domain.AjaxResult;
//import com.ruoyi.common.utils.poi.ExcelUtil;
//import com.ruoyi.common.core.page.TableDataInfo;
//
///**
// * AI模型配置Controller
// *
// * @author ruoyi
// * @date 2025-06-13
// */
//@Controller
//@RequestMapping("/doctorsystem/config")
//public class AiModelConfigController extends BaseController
//{
//    private String prefix = "doctorsystem/config";
//
//    @Autowired
//    private IAiModelConfigService aiModelConfigService;
//
//    @RequiresPermissions("doctorsystem:config:view")
//    @GetMapping()
//    public String config()
//    {
//        return prefix + "/config";
//    }
//
//    /**
//     * 查询AI模型配置列表
//     */
//    @RequiresPermissions("doctorsystem:config:list")
//    @PostMapping("/list")
//    @ResponseBody
//    public TableDataInfo list(AiModelConfig aiModelConfig)
//    {
//        startPage();
//        List<AiModelConfig> list = aiModelConfigService.selectAiModelConfigList(aiModelConfig);
//        return getDataTable(list);
//    }
//
//    /**
//     * 导出AI模型配置列表
//     */
//    @RequiresPermissions("doctorsystem:config:export")
//    @Log(title = "AI模型配置", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    @ResponseBody
//    public AjaxResult export(AiModelConfig aiModelConfig)
//    {
//        List<AiModelConfig> list = aiModelConfigService.selectAiModelConfigList(aiModelConfig);
//        ExcelUtil<AiModelConfig> util = new ExcelUtil<AiModelConfig>(AiModelConfig.class);
//        return util.exportExcel(list, "AI模型配置数据");
//    }
//
//    /**
//     * 新增AI模型配置
//     */
//    @RequiresPermissions("doctorsystem:config:add")
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存AI模型配置
//     */
//    @RequiresPermissions("doctorsystem:config:add")
//    @Log(title = "AI模型配置", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(AiModelConfig aiModelConfig)
//    {
//        return toAjax(aiModelConfigService.insertAiModelConfig(aiModelConfig));
//    }
//
//    /**
//     * 修改AI模型配置
//     */
//    @RequiresPermissions("doctorsystem:config:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, ModelMap mmap)
//    {
//        AiModelConfig aiModelConfig = aiModelConfigService.selectAiModelConfigById(id);
//        mmap.put("aiModelConfig", aiModelConfig);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存AI模型配置
//     */
//    @RequiresPermissions("doctorsystem:config:edit")
//    @Log(title = "AI模型配置", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(AiModelConfig aiModelConfig)
//    {
//        return toAjax(aiModelConfigService.updateAiModelConfig(aiModelConfig));
//    }
//
//    /**
//     * 删除AI模型配置
//     */
//    @RequiresPermissions("doctorsystem:config:remove")
//    @Log(title = "AI模型配置", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids)
//    {
//        return toAjax(aiModelConfigService.deleteAiModelConfigByIds(ids));
//    }
//}
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
import com.ruoyi.system.domain.AiModelConfig;
import com.ruoyi.system.service.IAiModelService;
import com.ruoyi.system.service.IAiModelConfigService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * AI模型配置Controller
 *
 * @author ruoyi
 * @date 2025-06-13
 */
@Controller
@RequestMapping("/doctorsystem/config")
public class AiModelConfigController extends BaseController
{
    private String prefix = "doctorsystem/config";

    @Autowired
    private IAiModelConfigService aiModelConfigService;

    @Autowired
    private IAiModelService aiModelService; // ✅ 注入模型服务

    @RequiresPermissions("doctorsystem:config:view")
    @GetMapping()
    public String config()
    {
        return prefix + "/config";
    }

    /**
     * 查询AI模型配置列表
     */
    @RequiresPermissions("doctorsystem:config:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AiModelConfig aiModelConfig)
    {
        startPage();
        List<AiModelConfig> list = aiModelConfigService.selectAiModelConfigList(aiModelConfig);
        return getDataTable(list);
    }

    /**
     * 导出AI模型配置列表
     */
    @RequiresPermissions("doctorsystem:config:export")
    @Log(title = "AI模型配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AiModelConfig aiModelConfig)
    {
        List<AiModelConfig> list = aiModelConfigService.selectAiModelConfigList(aiModelConfig);
        ExcelUtil<AiModelConfig> util = new ExcelUtil<>(AiModelConfig.class);
        return util.exportExcel(list, "AI模型配置数据");
    }

    /**
     * 新增AI模型配置
     */
    @RequiresPermissions("doctorsystem:config:add")
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<AiModel> modelList = aiModelService.selectAiModelList(new AiModel()); // ✅ 查询模型列表
        mmap.put("modelList", modelList); // ✅ 传入前端
        return prefix + "/add";
    }

    /**
     * 新增保存AI模型配置
     */
    @RequiresPermissions("doctorsystem:config:add")
    @Log(title = "AI模型配置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AiModelConfig aiModelConfig)
    {
        return toAjax(aiModelConfigService.insertAiModelConfig(aiModelConfig));
    }

    /**
     * 修改AI模型配置
     */
    @RequiresPermissions("doctorsystem:config:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AiModelConfig aiModelConfig = aiModelConfigService.selectAiModelConfigById(id);
        List<AiModel> modelList = aiModelService.selectAiModelList(new AiModel()); // ✅ 查询模型列表
        mmap.put("modelList", modelList); // ✅ 传入前端
        mmap.put("aiModelConfig", aiModelConfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存AI模型配置
     */
    @RequiresPermissions("doctorsystem:config:edit")
    @Log(title = "AI模型配置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AiModelConfig aiModelConfig)
    {
        return toAjax(aiModelConfigService.updateAiModelConfig(aiModelConfig));
    }

    /**
     * 删除AI模型配置
     */
    @RequiresPermissions("doctorsystem:config:remove")
    @Log(title = "AI模型配置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(aiModelConfigService.deleteAiModelConfigByIds(ids));
    }
}
