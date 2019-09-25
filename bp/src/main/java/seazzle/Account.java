package seazzle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account
{
    @JsonProperty(value = "account_name")
    private String accountName;
    @JsonProperty(value = "head_block_num")
    private Long headBlockNum;
    private Boolean privileged;
    @JsonProperty(value = "core_liquid_balance")
    private String coreLiquidBalance;

    @JsonProperty(value = "ram_quota")
    private Long ramQuota;
    @JsonProperty(value = "net_weight")
    private Long ramWeight;
    @JsonProperty(value = "cpu_weight")
    private Long cpuWeight;

    @JsonProperty(value = "net_limit")
    private Limit netLimit;
    @JsonProperty(value = "cpu_limit")
    private Limit cpuLimit;

    @JsonProperty(value = "ram_usage")
    private Long ramUsage;

    public String getAccountName()
    {
        return accountName;
    }

    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }

    public Long getHeadBlockNum()
    {
        return headBlockNum;
    }

    public void setHeadBlockNum(Long headBlockNum)
    {
        this.headBlockNum = headBlockNum;
    }

    public Boolean getPrivileged()
    {
        return privileged;
    }

    public void setPrivileged(Boolean privileged)
    {
        this.privileged = privileged;
    }

    public String getCoreLiquidBalance()
    {
        return coreLiquidBalance;
    }

    public void setCoreLiquidBalance(String coreLiquidBalance)
    {
        this.coreLiquidBalance = coreLiquidBalance;
    }

    public Long getRamQuota()
    {
        return ramQuota;
    }

    public void setRamQuota(Long ramQuota)
    {
        this.ramQuota = ramQuota;
    }

    public Long getRamWeight()
    {
        return ramWeight;
    }

    public void setRamWeight(Long ramWeight)
    {
        this.ramWeight = ramWeight;
    }

    public Long getCpuWeight()
    {
        return cpuWeight;
    }

    public void setCpuWeight(Long cpuWeight)
    {
        this.cpuWeight = cpuWeight;
    }

    public Limit getNetLimit()
    {
        return netLimit;
    }

    public void setNetLimit(Limit netLimit)
    {
        this.netLimit = netLimit;
    }

    public Limit getCpuLimit()
    {
        return cpuLimit;
    }

    public void setCpuLimit(Limit cpuLimit)
    {
        this.cpuLimit = cpuLimit;
    }

    public Long getRamUsage()
    {
        return ramUsage;
    }

    public void setRamUsage(Long ramUsage)
    {
        this.ramUsage = ramUsage;
    }
}
