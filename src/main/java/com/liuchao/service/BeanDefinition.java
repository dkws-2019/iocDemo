package com.liuchao.service;

public interface BeanDefinition {

    public void setBeanClassName(String beanClassName);

    public void setBeanName(String beanName) ;

    public void setBeanId(String beanId);

    public String getBeanClassName() ;

    public String getBeanName();


    public String getBeanId();
}
