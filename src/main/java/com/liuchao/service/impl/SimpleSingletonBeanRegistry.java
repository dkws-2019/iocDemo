package com.liuchao.service.impl;

import com.liuchao.service.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class SimpleSingletonBeanRegistry implements SingletonBeanRegistry {
    Map<String,Object> signletonBean=new HashMap<String,Object>();

    public void registrySingleton(String beanName, Object beanInstance) {
        signletonBean.put(beanName,beanInstance);
    }

    public Object getSingletonBean(String beanName) {
        return signletonBean.get(beanName);
    }
}
