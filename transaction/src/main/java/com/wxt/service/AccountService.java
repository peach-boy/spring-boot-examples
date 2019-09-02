package com.wxt.service;

import com.wxt.domain.entity.AccountDO;
import com.wxt.domain.mapper.AccountMapper;
import com.wxt.protocal.request.ChargeRequest;
import com.wxt.protocal.request.CreateAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/8/29 20:49
 * @Email:1414924381@qq.com
 */
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public Boolean create(CreateAccountRequest request) {
        AccountDO personDO = new AccountDO();
        personDO.setAccountName(request.getAccountName());
        accountMapper.insert(personDO);
        return Boolean.TRUE;
    }

    public Boolean charge(ChargeRequest request) {
        BigDecimal tradeAmount = request.getChargeAmount();
        Integer accountId = request.getAccountId();

        AccountDO accountDO = accountMapper.getById(accountId);
        BigDecimal balance = accountDO.getBalance().add(tradeAmount);

        accountMapper.update(accountId, balance);
        return Boolean.TRUE;
    }

    public List<AccountDO> queryAll() {
        return accountMapper.queryAll();
    }
}
