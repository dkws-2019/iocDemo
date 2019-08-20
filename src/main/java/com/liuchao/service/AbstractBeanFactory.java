package com.liuchao.service;

import com.liuchao.service.impl.SimpleSingletonBeanRegistry;

public abstract class AbstractBeanFactory extends SimpleSingletonBeanRegistry implements BeanFactory{

    public Object getBean(String beanName) {
        BeanDefinition beanDefinition=getBeanDefinition(beanName);
        Object beanInstance=createBean(beanDefinition);
        return beanInstance;
    }

    public  abstract Object createBean(BeanDefinition beanDefinition);

    public abstract BeanDefinition getBeanDefinition(String beanName);
}
