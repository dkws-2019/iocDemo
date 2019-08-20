package com.liuchao.ioc;

import com.liuchao.service.AbstractCapableAutowireBeanFactory;
import com.liuchao.service.BeanDefinition;
import com.liuchao.service.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultBeanFactory extends AbstractCapableAutowireBeanFactory implements BeanDefinitionRegistry {
    private Map<String,BeanDefinition> beanDefinitionMap=new HashMap<String,BeanDefinition>();
    public void registryBeanDefinition(String beanName, BeanDefinition definition) {
        beanDefinitionMap.put(beanName,definition);
    }

    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    public void removeBeanDefinition(String beanName) {
        beanDefinitionMap.remove(beanName);
    }

    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }
}
