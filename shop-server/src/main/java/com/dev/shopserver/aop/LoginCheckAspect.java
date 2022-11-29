package com.dev.shopserver.aop;


import com.dev.shopserver.common.Constants;
import com.dev.shopserver.common.exception.ShopServerException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Objects;

/**
 * Aspect
 * 부가기능 로직을 구현한 'Advice' 와
 * 부가기능을 적용할 위치인 'Pointcut' 을 합쳐 모듈화한 개념
 *
 * 'AnnotationAwareAspectJAutoProxyCreator' 라는 자동 프록시 생성기가
 * Aspect 어노테이션이 달린 클래스를 'Advisor' 로 변환하여 저장
 *
 */
@Aspect
@Component
public class LoginCheckAspect {

    @Around("@annotation(com.dev.shopserver.aop.LoginCheck) && @annotation(loginCheck)")
    public Object checkLogin(ProceedingJoinPoint proceedingJoinPoint, LoginCheck loginCheck) throws Throwable{
        String userId = null;
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpSession session = request.getSession();

        String userLevel = loginCheck.checkLevel().toString();
        Enumeration<String> keys = session.getAttributeNames();
        if (!keys.hasMoreElements()) {
            throw new ShopServerException(Constants.ExceptionClass.USER,
                    HttpStatus.UNAUTHORIZED, "로그인 환경을 확인하세요.");
        }
        String key = keys.nextElement();
        switch (userLevel){
            case "USER": {
                userId = (String)session.getAttribute(key);
                break;
            }
            case "SELLER": {
                if(!key.equals("LOGIN_USER_ID")) userId = (String) session.getAttribute(key);
                break;
            }
            case "ADMIN": {
                userId = (String)session.getAttribute("LOGIN_ADMIN_ID");
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + userLevel);
        }
        if (userId == null){
            throw new ShopServerException(Constants.ExceptionClass.USER,
                    HttpStatus.UNAUTHORIZED, "로그인 환경을 확인하세요.");
        }

        Object[] modifiedArgs = modifyArgsWithUserID(userId, proceedingJoinPoint);

        return proceedingJoinPoint.proceed(modifiedArgs);

    }

    /**
     * 타겟 메소드 arg에 userId가 필요하다면 userId를 파라미터에 할당하는 메소드
     * @param userId userId
     * @param proceedingJoinPoint 어노테이션이 달린 method
     * @return 변형된 arguments
     */
    private Object[] modifyArgsWithUserID(String userId, ProceedingJoinPoint proceedingJoinPoint) {
        Object[] parameters = proceedingJoinPoint.getArgs();

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String[] parameterNames = signature.getParameterNames();

        for (int i = 0; i < parameterNames.length; i++) {
            if (parameterNames[i].equals(userId)) {
                parameters[i] = userId;
            }
        }
        return parameters;
    }


}
