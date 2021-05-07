package com.lhh.volunteerservicemanagement.common;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author lhh
 * @date 2021/5/5 10:05
 * 概要：
 */
public class UserResolver implements HanderMethodArgumentResolver {

    /**
     * 判断是否是注解类，返回true则调用resolveArgument方法
     * @param methodParameter
     * @return
     */
    @Override
    public Boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(AuthUserId.class);
    }

    /**
     * 对@AuthUserId进行业务处理
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @param webDataBinderFactory
     * @return
     */
    @Override
    public Object resolverArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) {
        // 从请求中获取token
        String authorization = nativeWebRequest.getHeader("token");
//        if ("".equals(authorization)){
//            throw new MyException("token不能为空！");
//        }
//        DecodedJWT v
        return null;
    }
}
