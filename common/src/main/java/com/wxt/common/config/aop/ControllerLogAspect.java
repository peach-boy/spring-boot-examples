package com.wxt.common.config.aop;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/9/3 21:55
 * @Email:1414924381@qq.com
 */
@Aspect
@Component
public class ControllerLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLogAspect.class);

    @Pointcut("execution(public * com.wxt..*.*Controller.*(..))")
    public void logAspect() {
    }

    @Around("logAspect()")
    public Object aroundExecution(ProceedingJoinPoint joinPoint)
            throws Throwable {
        long startTime = System.currentTimeMillis();
        Object[] params = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();

        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        String name = signature.getDeclaringType().getSimpleName() + "." + targetMethod.getName();

        String requestInfo = "WEB_REQ [" + name + "], PARAMS(" + StringUtils.repeat("{}", ",", params.length) + ")";
        LOGGER.info(requestInfo, JSONObject.toJSONString(params));
        try {
            //清空上下文
            Object resp = joinPoint.proceed(params);
            LOGGER.info("WEB_RESP [{}] RESULT:{}", name, resp);
            return resp;
        } catch (Throwable e) {
            LOGGER.error("WEB_EX [" + name + "]", e);
            throw e;
        } finally {
            LOGGER.info("WEB_COST [{}] COST MILLS:{}", name, (System.currentTimeMillis() - startTime));
        }
    }
}
