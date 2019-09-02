package com.wxt.domain.mapper;

import com.wxt.domain.entity.AccountDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/8/29 22:12
 * @Email:1414924381@qq.com
 */
@Mapper
public interface AccountMapper {
    int insert(AccountDO accountDO);

    int update(@Param("id") Integer id, @Param("newBalance") BigDecimal newBalance);

    List<AccountDO> queryAll();

    AccountDO getById(Integer id);
}
