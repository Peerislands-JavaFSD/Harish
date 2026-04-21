package org.example.EmployeePayRoll;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//      ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//
//      PayrollProcessor processor=context.getBean("payRollProcessor", PayrollProcessor.class);
//      processor.processWithBonus("Arun",80000);

        ApplicationContext context=new AnnotationConfigApplicationContext("AppConfig.class");
        PayrollProcessor processor=context.getBean(PayrollProcessor.class);
        processor.processWithBonus("Arul", 80000);

    }
}