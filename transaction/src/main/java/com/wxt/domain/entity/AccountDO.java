package com.wxt.domain.entity;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/8/29 22:24
 * @Email:1414924381@qq.com
 */
public class AccountDO {
    private Integer id;

    private BigDecimal balance;

    private String accountName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
