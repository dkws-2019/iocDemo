package com.liuchao.service;

public interface BeanDefinitionRegistry {

    public void registryBeanDefinition(String beanName,BeanDefinition definition);

    public BeanDefinition getBeanDefinition(String beanName);

    public void removeBeanDefinition(String beanName);

    public boolean containsBeanDefinition(String beanName);
}
