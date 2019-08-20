package com.liuchao.ioc;

import com.liuchao.myService.OrderService;
import com.liuchao.service.BeanDefinitionRegistry;
import com.liuchao.service.BeanFactory;
import com.liuchao.service.impl.AnnotationBeanDefinitionRegistry;

public class IocTest {
    public static void main(String[] args) {
      /*  BeanDefinitionRegistry beanDefinitionRegistry=new AnnotationBeanDefinitionRegistry();

       AnnoationBeanDefinitionReader reader=new AnnoationBeanDefinitionReader(beanDefinitionRegistry);
        reader.registrys("com.liuchao.myService.OrderService","com.liuchao.myService.DoOrder");
        System.out.println(11111);

     AnnotationBeanDefinitionScanner scanner=new AnnotationBeanDefinitionScanner(beanDefinitionRegistry);
        scanner.scan("com");
        System.out.println(111111);*/
        AnnotationBeanFactory beanFactory=new AnnotationBeanFactory();
        beanFactory.scan("com.liuchao.myService");
        OrderService orderService =(OrderService) beanFactory.getBean("orderService");
        orderService.doOrder();
    }

}
