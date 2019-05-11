package com.xuliugen.choosedb.demo.aspect;

import com.xuliugen.choosedb.demo.anno.MyAnnnotaion;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

/**
 * Created by zcl on 2019-05-10.
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AnnoAspect {

    @Pointcut("@annotation(com.xuliugen.choosedb.demo.anno.MyAnnnotaion)")
    public void aspect() {
    }

    @Before("aspect()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();//方法签名
        Method method = signature.getMethod();
        System.out.println("方法签名：" + method.getName());
        MyAnnnotaion myAnnnotaion = method.getAnnotation(MyAnnnotaion.class);
        System.out.println("注解参数信息：" + myAnnnotaion.inEnable());
        try {
            System.out.println("注解参数信息:" + joinPoint.getTarget().getClass().getMethod("getAnnoMessage", String.class).getAnnotation(MyAnnnotaion.class).inEnable());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
