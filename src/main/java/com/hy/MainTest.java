package com.hy;

import com.hy.bean.Person;
import com.hy.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 胡阳
 * @ClassName MainTest
 * @description: 测试类
 * @date 2022年06月28日 17:12
 */
public class MainTest {

    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println(person);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s : namesForType) {
            System.out.println(s);
        }
    }

}
