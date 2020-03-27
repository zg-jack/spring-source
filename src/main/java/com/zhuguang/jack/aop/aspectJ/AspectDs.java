package com.zhuguang.jack.aop.aspectJ;

import com.zhuguang.jack.annotation.TargetSource;
import com.zhuguang.jack.druidConfig.DynamicDataSourceHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
/*
*要优先于事务执行
* */
@Order(-1)
public class AspectDs {

    @Around(value = "@annotation(targetSource)")
    public Object choiseDs(ProceedingJoinPoint joinPoint, TargetSource targetSource) {
        System.out.println("==========AspectDs============");

        String value = targetSource.value();

        if(value != null && !"".equals(value)) {
            DynamicDataSourceHolder.getLocal().set(value);
        } else {
            DynamicDataSourceHolder.getLocal().set("ds1");
        }

        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return null;
    }
}
