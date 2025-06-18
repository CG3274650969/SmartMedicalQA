package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * AI模型配置对象 ai_model_config
 * 
 * @author ruoyi
 * @date 2025-06-13
 */
public class AiModelConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 配置ID */
    private Long id;

    /** 模型ID */
    @Excel(name = "模型ID")
    private Long modelId;

    /** API端点 */
    @Excel(name = "API端点")
    private String apiEndpoint;

    /** API密钥(加密存储) */
    @Excel(name = "domain参数")
    private String domain;

    /** API密钥(加密存储) */
    @Excel(name = "APPID")
    private String appid;

    /** API密钥(加密存储) */
    @Excel(name = "APISecret")
    private String apiSecret;

    /** API密钥(加密存储) */
    @Excel(name = "API密钥(加密存储)")
    private String apiKey;

    /** API版本 */
    @Excel(name = "API版本")
    private String apiVersion;

    /** 温度参数 */
    @Excel(name = "温度参数")
    private BigDecimal temperature;

    /** 最大token数 */
    @Excel(name = "最大token数")
    private Long maxTokens;

    /** 超时时间(秒) */
    @Excel(name = "超时时间(秒)")
    private Long timeout;

    /** 速率限制(次/分钟) */
    @Excel(name = "速率限制(次/分钟)")
    private Long rateLimit;

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

    public void setApiEndpoint(String apiEndpoint) 
    {
        this.apiEndpoint = apiEndpoint;
    }

    public String getApiEndpoint() 
    {
        return apiEndpoint;
    }


    //    大模型连接
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    //    大模型连接

    public void setApiKey(String apiKey)
    {
        this.apiKey = apiKey;
    }

    public String getApiKey() 
    {
        return apiKey;
    }

    public void setApiVersion(String apiVersion) 
    {
        this.apiVersion = apiVersion;
    }

    public String getApiVersion() 
    {
        return apiVersion;
    }

    public void setTemperature(BigDecimal temperature) 
    {
        this.temperature = temperature;
    }

    public BigDecimal getTemperature() 
    {
        return temperature;
    }

    public void setMaxTokens(Long maxTokens) 
    {
        this.maxTokens = maxTokens;
    }

    public Long getMaxTokens() 
    {
        return maxTokens;
    }

    public void setTimeout(Long timeout) 
    {
        this.timeout = timeout;
    }

    public Long getTimeout() 
    {
        return timeout;
    }

    public void setRateLimit(Long rateLimit) 
    {
        this.rateLimit = rateLimit;
    }

    public Long getRateLimit() 
    {
        return rateLimit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("modelId", getModelId())
            .append("apiEndpoint", getApiEndpoint())

                //    大模型连接
            .append("domain", getDomain())
            .append("appid", getAppid())
            .append("apiSecret", getApiSecret())
                //    大模型连接
            .append("apiKey", getApiKey())
            .append("apiVersion", getApiVersion())
            .append("temperature", getTemperature())
            .append("maxTokens", getMaxTokens())
            .append("timeout", getTimeout())
            .append("rateLimit", getRateLimit())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
