package com.liuchao.ioc;

import com.liuchao.annotation.Service;
import com.liuchao.service.BeanDefinitionRegistry;
import com.liuchao.service.BeanNameGenerator;
import com.liuchao.service.impl.AnnotationBeanDefinition;
import com.liuchao.service.impl.AnnotationBeanNameGenerator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class AnnotationBeanDefinitionScanner {
    private BeanNameGenerator annotationBeanNameGenerator=new AnnotationBeanNameGenerator();
    private BeanDefinitionRegistry beanDefinitionRegistry;
    public AnnotationBeanDefinitionScanner(BeanDefinitionRegistry beanDefinitionRegistry){
        this.beanDefinitionRegistry=beanDefinitionRegistry;
    }

    public void scan(String ... basepackages){
        for(String basepackage:basepackages){
            doScan(basepackage);
        }
    }

    private  void doScan(String basepackage) {
        //com.liuchao.myService 换成com/liuchao/myservice
        String newbasepackage = basepackage.replace(".", "/");
        Enumeration<URL> enumerationUrl=null;
        try {
            enumerationUrl = this.getClass().getClassLoader().getResources(newbasepackage);
        } catch (IOException e) {
            e.printStackTrace();
        }
            while (enumerationUrl.hasMoreElements()){
                URL url = enumerationUrl.nextElement();
                //path是/D:/ideaworspack/com/liuchao/myservice
                String path = url.getPath();
                if("file".equals(url.getProtocol())){
                    File parentFile=new File(path.substring(1));
                    doScanBeanDefinition(basepackage,parentFile);
                }
            }

    }

    private void doScanBeanDefinition(String basepackage, File parentFile) {
        File[] files = parentFile.listFiles();
        for(File file:files){
            if(file.isDirectory()){
                String newBasePackage=basepackage+"."+file.getName();
                doScanBeanDefinition(newBasePackage,file);
            }else{
                String name = file.getName();
                if(name.endsWith(".class")){//说明已经取到了class文件所以要文件全名带包的
                    doRegisterBeanDefinition(basepackage+"."+name.split("\\.")[0],null);
                }
            }
        }
    }

    private void doRegisterBeanDefinition(String beanClassName,String beanName) {
        System.out.println(beanClassName);
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
