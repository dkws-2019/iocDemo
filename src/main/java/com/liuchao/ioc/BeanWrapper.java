package com.liuchao.ioc;

import java.lang.reflect.Field;

public class BeanWrapper {
    private String beanClassName;
    private Object beanInstance;

    public String getBeanClassName() {
        return beanClassName;
    }

    public Object getBeanInstance() {
        return beanInstance;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public void setBeanInstance(Object beanInstance) {
        this.beanInstance = beanInstance;
    }

    public void setProperty(Field field,Object value){
        field.setAccessible(true);
        try {
            field.set(beanInstance,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
