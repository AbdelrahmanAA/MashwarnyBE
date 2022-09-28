package com.developerxgroup.mashwarny.aspect;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class RestControllerAspect {
    private static final Logger logger = LoggerFactory.getLogger(RestControllerAspect.class);

    @Pointcut("within(com.developerxgroup.mashwarny.restcontroller..*)" )
    public void pointcut() {
    }

    @Before("pointcut()"+
            " && args(name)")
    public void logMethod(JoinPoint joinPoint, String name) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        logger.info("======= Class Name: {}, ===>>>> Method Name: {}, ===>>>> TimeStamp: {}, ===>>>> RequestID: {}",
                signature.getDeclaringTypeName(), signature.getMethod().getName(), new Date(), name);
    }

    @After("pointcut()"+
            "  && args(name)")
    public void logMethodAfter(JoinPoint joinPoint, String name) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        logger.info("======= Class Name: {}, ===>>>> Method Name: {}, ===>>>> TimeStamp: {}, ===>>>> RequestID: {}",
                signature.getDeclaringTypeName(), signature.getMethod().getName(), new Date(), name);

    }

}