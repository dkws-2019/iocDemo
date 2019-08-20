package com.liuchao.ioc;

import com.liuchao.service.BeanDefinitionRegistry;
import com.liuchao.service.BeanNameGenerator;
import com.liuchao.service.impl.AnnotationBeanNameGenerator;

public class AnnotationBeanFactory extends DefaultBeanFactory {
    private AnnoationBeanDefinitionReader annotationBeanDefinitionReader;
    private AnnotationBeanDefinitionScanner annotationBeanDefinitionScanner;

    public AnnotationBeanFactory(){
        this.annotationBeanDefinitionReader = new AnnoationBeanDefinitionReader(this);
        this.annotationBeanDefinitionScanner = new AnnotationBeanDefinitionScanner(this);
    }

    public void scan(String ...basepackage){
        annotationBeanDefinitionScanner.scan(basepackage);
    }

    public void registers(String... annotatedClassNames){
        annotationBeanDefinitionReader.registrys(annotatedClassNames);

    }

}
