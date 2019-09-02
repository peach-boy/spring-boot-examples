package com.wxt.web;

import com.wxt.domain.entity.AccountDO;
import com.wxt.protocal.request.ChargeRequest;
import com.wxt.protocal.request.CreateAccountRequest;
import com.wxt.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/8/29 20:48
 * @Email:1414924381@qq.com
 */
@Api("账户相关")
@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "创建账户", notes = "account")
    @PostMapping("/create")
    public Boolean create(CreateAccountRequest request) {
        return accountService.create(request);
    }

    @ApiOperation(value = "充值", notes = "account")
    @PostMapping("/charge")
    public Boolean create(ChargeRequest request) {
        return accountService.charge(request);
    }

    @ApiOperation(value = "查询", notes = "account")
    @GetMapping("/queryAll")
    public List<AccountDO> queryAll() {
        return accountService.queryAll();
    }

}
