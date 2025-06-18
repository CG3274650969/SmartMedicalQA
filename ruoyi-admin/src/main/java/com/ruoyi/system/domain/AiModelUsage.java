package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大模型使用统计对象 ai_model_usage
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public class AiModelUsage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long id;

    /** 模型ID */
    @Excel(name = "模型ID")
    private Long modelId;

    /** 统计日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "统计日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 使用次数 */
    @Excel(name = "使用次数")
    private Long usageCount;

    /** 平均响应时间(ms) */
    @Excel(name = "平均响应时间(ms)")
    private BigDecimal avgResponseTime;

    /** 成功率(%) */
    @Excel(name = "成功率(%)")
    private BigDecimal successRate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setModelId(Long modelId) 
    {
        this.modelId = modelId;
    }

    public Long getModelId() 
    {
        return modelId;
    }

    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }

    public void setUsageCount(Long usageCount) 
    {
        this.usageCount = usageCount;
    }

    public Long getUsageCount() 
    {
        return usageCount;
    }

    public void setAvgResponseTime(BigDecimal avgResponseTime) 
    {
        this.avgResponseTime = avgResponseTime;
    }

    public BigDecimal getAvgResponseTime() 
    {
        return avgResponseTime;
    }

    public void setSuccessRate(BigDecimal successRate) 
    {
        this.successRate = successRate;
    }

    public BigDecimal getSuccessRate() 
    {
        return successRate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("modelId", getModelId())
            .append("date", getDate())
            .append("usageCount", getUsageCount())
            .append("avgResponseTime", getAvgResponseTime())
            .append("successRate", getSuccessRate())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
