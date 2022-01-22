package guru.springframework.sfgdi;

import guru.springframework.sfgdi.config.SfgConfiguration;
import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.datasource.FakeDatasource;
import guru.springframework.sfgdi.services.PrototypeBean;
import guru.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println("--- The Best Pet is ---");
        System.out.println(petController.whichPetIsTheBest());

        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        MyController myController = (MyController) ctx.getBean("myController");

        System.out.println("------- Primary Bean");
        System.out.println(myController.sayHello());

        System.out.println("------ Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("--------- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("-------- Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        System.out.println("------------ Scope");

        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
        ;
        System.out.println("----------- " + singletonBean1.getCreatedTime());
        System.out.println("----------- " + singletonBean2.getCreatedTime());

        PrototypeBean p1 = ctx.getBean(PrototypeBean.class);
        PrototypeBean p2 = ctx.getBean(PrototypeBean.class);

        System.out.println("***********  " + p1.getCreatedTime());
        System.out.println("***********  " + p2.getCreatedTime());

        FakeDatasource fakeDatasource = ctx.getBean(FakeDatasource.class);
        System.out.println("Username ------>  " + fakeDatasource.getName());
        System.out.println("Password ------>  " + fakeDatasource.getPassword());
        System.out.println("JdbcUrl ------>  " + fakeDatasource.getJdbcUrl());

        System.out.println("--- Config bean");
        SfgConfiguration config = ctx.getBean(SfgConfiguration.class);
        System.out.println("Username ------>  " + config.getName());
        System.out.println("Password ------>  " + config.getPassword());
        System.out.println("JdbcUrl ------>  " + config.getJdbcUrl());
    }

}
