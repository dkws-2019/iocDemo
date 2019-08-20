package com.liuchao.service.impl;

import com.liuchao.service.BeanDefinition;
import com.liuchao.service.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

public class AnnotationBeanDefinitionRegistry implements BeanDefinitionRegistry {
    private Map<String,BeanDefinition> beanDefinitionContent=new HashMap<String ,BeanDefinition>();

    public void registryBeanDefinition(String beanName, BeanDefinition definition) {
        beanDefinitionContent.put(beanName,definition);
    }

    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionContent.get(beanName);
    }

    public void removeBeanDefinition(String beanName) {
        beanDefinitionContent.remove(beanName);
    }

    public boolean containsBeanDefinition(String beanName) {

        return beanDefinitionContent.containsKey(beanName);
    }
}
