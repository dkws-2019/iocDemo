package com.liuchao.service.impl;

import com.liuchao.service.BeanDefinition;
import com.liuchao.service.BeanNameGenerator;

public class AnnotationBeanNameGenerator implements BeanNameGenerator {
    public String beanNameGenerator(BeanDefinition beanDefinition) {
        String beanClassName = beanDefinition.getBeanClassName();
        Class<?> aClass=null;
        try {
            aClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String simpleName = aClass.getSimpleName();
        String beanName=fistLower(simpleName);
        return beanName;
    }

    private static String fistLower(String simpleName) {
        String firstchar = simpleName.substring(0, 1);
        String newFirstChar=firstchar.toLowerCase();
        String replace =newFirstChar+simpleName.substring(1);
        return replace;
    }

    public static void main(String[] args) {
        System.out.println(fistLower("Annotation"));
    }
}
