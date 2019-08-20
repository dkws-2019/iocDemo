package com.liuchao.ioc;

import com.liuchao.annotation.Service;
import com.liuchao.service.BeanDefinitionRegistry;
import com.liuchao.service.BeanNameGenerator;
import com.liuchao.service.impl.AnnotationBeanDefinition;
import com.liuchao.service.impl.AnnotationBeanNameGenerator;

public class AnnoationBeanDefinitionReader {
   private BeanNameGenerator annotationBeanNameGenerator=new AnnotationBeanNameGenerator();
    private BeanDefinitionRegistry beanDefinitionRegistry;
   public AnnoationBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry){
       this.beanDefinitionRegistry=beanDefinitionRegistry;
   }
    public void registrys(String ...beanClassNames){
        for (String beanClassName:beanClassNames){
                registry(beanClassName);
        }
    }

    private void registry(String beanClassName) {
        doregistry(beanClassName,null);
    }

    private void doregistry(String beanClassName, String beanName) {
        AnnotationBeanDefinition annotationBeanDefinition=new AnnotationBeanDefinition();
        annotationBeanDefinition.setBeanClassName(beanClassName);
        String newbeanName="";
        if("".equals(beanName) || null ==beanName){
             newbeanName = annotationBeanNameGenerator.beanNameGenerator(annotationBeanDefinition);

        }
        Class<?> aClass=null;

        try {
           aClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        annotationBeanDefinition.setBeanName(newbeanName);

        annotationBeanDefinition.setBeanId(newbeanName);
        Service service = aClass.getAnnotation(Service.class);
        if(null!=service){
            beanDefinitionRegistry.registryBeanDefinition(newbeanName,annotationBeanDefinition);

        }
    }
}
