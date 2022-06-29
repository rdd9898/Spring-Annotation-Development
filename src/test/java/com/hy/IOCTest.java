package com.hy;

import com.hy.bean.Person;
import com.hy.config.MainConfig;
import com.hy.config.MainConfig2;
import com.hy.config.MainConfig3;
import com.hy.scope.ThreadScope;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 胡阳
 * @ClassName IOCTest
 * @description:
 * @date 2022年06月28日 20:31
 */
public class IOCTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    @SuppressWarnings("resource")
    public void test01() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }

    @Test
    @SuppressWarnings("resource")
    public void test02() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] definitionNames = applicationContext.getBeanDefinitionNames();
//        for (String name : definitionNames) {
//            System.out.println(name);
//        }
//        // 默认是单例的
        System.out.println("IOC 容器创建完成...");
        Object bean = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean2 == bean);
    }

    @Test
    public void test03() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig3.class);
        // 向容器中注册自定义的Scope
        applicationContext.getBeanFactory().registerScope(ThreadScope.THREAD_SCOPE, new ThreadScope());

        // 使用容器获取bean
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread() + "," + applicationContext.getBean("person"));
                System.out.println(Thread.currentThread() + "," + applicationContext.getBean("person"));
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04() {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        // 动态获取环境变量的值；Windows 10
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name : definitionNames) {
            System.out.println(name);
        }
        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    @Test
    public void testImport() {
        printBeans(applicationContext);
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }

}
