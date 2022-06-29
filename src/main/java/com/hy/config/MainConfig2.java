package com.hy.config;

import com.hy.bean.Color;
import com.hy.bean.Person;
import com.hy.bean.Red;
import com.hy.condition.LinuxCondition;
import com.hy.condition.MyImportSelector;
import com.hy.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @author 胡阳
 * @ClassName MainConfig2
 * @description:
 * @date 2022年06月29日 15:06
 */
@Configuration
// 类中组件统一设置。满足当前条件，这个类中配置的所有 bean 注册才能生效
@Conditional({WindowsCondition.class})
@Import({Color.class, Red.class, MyImportSelector.class})
// @Import导入组件，id 默认是组件的全类名
public class MainConfig2 {

    // 默认是单实例的
    /*
    * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE  prototype
    * @see ConfigurableBeanFactory#SCOPE_SINGLETON  singleton
    * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
    * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION  session
    * @return\
    * @Scope：调整作用域
    * prototype：多实例的，IOC 容器启动并不会创建对象去调用方法创建对象放在容器中，
    *            每次获取的时候才会调用方法创建对象
    * singleton：单实例的（默认值）,IOC 容器启动会调用方法创建对象放到 IOC 容器中，
    *            以后每次获取就是直接从容器(map.get())中拿
    * request：同一次请求创建一个实例
    * session：同一个 session 创建一个实例
    *
    * 懒加载：
    *       单实例 bean，默认在容器启动的时候创建对象，
    *       懒加载，容器启动不创建对象。第一次使用(获取) Bean 创建对象，并初始化
    * */
//    @Scope
//    @Lazy
    @Bean(value = "person")
    public Person person() {
        System.out.println("给容器中添加 Person...");
        return new Person("张三", 25);
    }
    /*
     * @Conditional()，按照一定的条件，进行判断，满足条件，给容器中注册 bean
     *
     * 如果系统是 windows，给容器中注册("bill")
     * 如果系统是 Linux，给容器中注册("linus")
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 20);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02() {
        return new Person("Linus", 24);
    }

    /*
    * 给容器中注册组件的方式：
    * 1、包扫描 + 组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
    * 2、@Bean[导入的第三方包里面的组件]
    * 3、@Import[快速给容器中导入一个组件]
    *       1.@Import(要导入到容器中的组件)，容器中就会自动注册这个组件，id 默认是全类名
    *       2.ImportSelector：返回需要导入的组件的全类名的数组。
    * */


}
