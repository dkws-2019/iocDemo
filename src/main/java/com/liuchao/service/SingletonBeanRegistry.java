package com.liuchao.service;

public interface SingletonBeanRegistry {

    public void registrySingleton(String beanName,Object beanInstance);

    public Object getSingletonBean(String beanName);
}
