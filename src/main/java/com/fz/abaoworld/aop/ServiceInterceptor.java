package com.fz.abaoworld.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.fz.abaoworld.common.BaseException;
import com.fz.abaoworld.common.BaseRsp;
import com.fz.abaoworld.common.validate.CommonValidation;

@Aspect
@Component
@SuppressWarnings("all")
@Order(999)
public class ServiceInterceptor {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 
	 * aspectjMethod:仅仅拦截service实现类层. <br/>
	 *
	 */
    @Pointcut("execution(public  * com.fz.abaoworld.service.impl.*.*(..))")
    public void aspectjMethod() {
    };

    /**
     * Around 手动控制调用核心业务逻辑，以及调用前和调用后的处理,
     *
     * 注意：当核心业务抛异常后，立即退出，转向AfterAdvice 执行完AfterAdvice，再转到ThrowingAdvice
     *
     * @param pjp
     * @return
     * @throws Throwable
     */

    @Around(value = "aspectjMethod()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            Object[] args = pjp.getArgs();
            //打印请求参数
            printReqParams(pjp);
            for (Object object : args) {
                CommonValidation.valid(object);
            }
            result = pjp.proceed();
        } catch (BaseException e) {
        	logger.error("操作异常:{}", e.getMessage());
            result = new BaseException(e.getRspCode(), e.getRspMsg());
        } catch (Exception e) {
        	logger.error("系统异常:{}", e);
            result = BaseRsp.returnFail();
        }
        long end = System.currentTimeMillis();
        logger.info("方法  {}, 执行结果  {} 耗时:{}ms", getShortMethodName(pjp), JSONObject.toJSONString(result),(end-start));
        return result;
    }

    /**
     * 核心业务逻辑调用异常退出后，执行此Advice，处理错误信息
     *
     * 注意：执行顺序在Around Advice之后
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "aspectjMethod()", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
        MethodInvocationProceedingJoinPoint methodpoint = (MethodInvocationProceedingJoinPoint) joinPoint;
        logger.info("错误异常, 方法 {}, {} ", methodpoint.getSignature().toShortString(), ex.getMessage());
    }

    private void printReqParams(ProceedingJoinPoint pjp){

        Object[] args = pjp.getArgs();

        StringBuilder sb = new StringBuilder();

        sb.append("方法  {}, 入参【");

        String[]  jsonArgs = new String[args.length+1];

        String methodName=pjp.getSignature().toString();

        jsonArgs[0]=getShortMethodName(pjp);

        for(int i=0;i<args.length;i++){

            sb.append(args[i].getClass().getSimpleName()+"={},");

            jsonArgs[i+1]=JSONObject.toJSONString(args[i]);

        }

        if(sb.toString().endsWith(",")){

            sb.delete(sb.length()-1, sb.length());

        }

        sb.append("】");

        logger.info(sb.toString(),jsonArgs);

    }

    /**
     *
     * getShortMethodName:获取简短方法名. <br/>
     *PayRsp com.zb.payment.msd.facade.service.TestService.test(PayReq)==>> TestService.test(PayReq)
     * @param longMethodName
     * @return
     */
    private String getShortMethodName(ProceedingJoinPoint pjp){

        String longMethodName=pjp.getSignature().toString();

        String[] names=longMethodName.split("\\.");

        return names[names.length-2]+"."+names[names.length-1];
    }

}