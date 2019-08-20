package com.liuchao.service;

import com.liuchao.annotation.Autowired;
import com.liuchao.ioc.BeanWrapper;

import java.lang.reflect.Field;

public abstract class AbstractCapableAutowireBeanFactory extends AbstractBeanFactory{
    @Override
    public Object createBean(BeanDefinition beanDefinition) {
        String beanClassName = beanDefinition.getBeanClassName();
        BeanWrapper beanWrapper=beanInstance(beanClassName);
        //注册
        registrySingleton(beanClassName,beanWrapper.getBeanInstance());
        // 依赖注入

        populetonBean(beanWrapper);
        return beanWrapper.getBeanInstance();
    }

    private   void populetonBean(BeanWrapper beanWrapper){
        String beanClassName = beanWrapper.getBeanClassName();
        Class<?> aClass=null;
        try {
            aClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Field[] fields = aClass.getDeclaredFields();
        for(Field field:fields){
            Autowired autowired = field.getAnnotation(Autowired.class);
            if(null !=autowired){
              //  String fileName = field.getName();
                String fildName = autowired.value();
                if("".equals(fildName) ||null==fildName){
                    Class<?> type = field.getType();
                    String simpleName = type.getSimpleName();
                    String firstname = simpleName.substring(0, 1);
                    String firstlowerName = firstname.toLowerCase();
                    fildName=firstlowerName+simpleName.substring(1);
                }

                Object beanFieldInstance = getBean(fildName);

                beanWrapper.setProperty(field,beanFieldInstance);


            }

        }

    };

    private BeanWrapper beanInstance(String beanClassName){
        BeanWrapper beanWrapper=new BeanWrapper();
        beanWrapper.setBeanClassName(beanClassName);
        Class<?> aClass=null;
        Object o=null;
        try {
            aClass = Class.forName(beanClassName);
             o = aClass.newInstance();
            beanWrapper.setBeanInstance(o);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return beanWrapper;

    }
}
