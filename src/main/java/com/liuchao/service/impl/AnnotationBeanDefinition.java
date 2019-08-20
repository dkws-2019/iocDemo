package com.liuchao.service.impl;

import com.liuchao.service.BeanDefinition;

public class AnnotationBeanDefinition implements BeanDefinition {
        private String beanClassName;
        private String beanName;
        private String beanId;

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public String getBeanName() {
        return beanName;
    }

    public String getBeanId() {
        return beanId;
    }
}
