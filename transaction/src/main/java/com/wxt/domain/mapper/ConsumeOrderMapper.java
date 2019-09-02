package com.wxt.domain.mapper;

import com.wxt.domain.entity.ConsumeOrderDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/8/30 21:07
 * @Email:1414924381@qq.com
 */
@Mapper
public interface ConsumeOrderMapper {
    int insert(ConsumeOrderDO consumeOrderDO);

    int update(@Param("innerOrderNo") Integer innerOrderNo, @Param("status") Integer status);

    ConsumeOrderDO getById(Integer innerOrderNo);
}
