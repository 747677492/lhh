package com.lhh.volunteerservicemanagement.common;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lhh
 * @date 2021/5/5 10:01
 * 概要：
 */
public interface HanderMethodArgumentResolver {

    public Boolean supportsParameter(MethodParameter methodParameter);

    public Object resolverArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory);
}