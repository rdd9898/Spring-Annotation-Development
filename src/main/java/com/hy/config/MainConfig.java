package com.hy.config;

import com.hy.bean.Person;
import com.hy.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author 胡阳
 * @ClassName MainConfig
 * @description: 配置类==配置文件
 * @date 2022年06月28日 17:16
 */
@Configuration  // 告诉 Spring 这是一个配置类
//@ComponentScan(value = "com.hy", includeFilters = {
//        /*
//        * type：指定你要排除的规则，是按照注解进行排除，还是按照给定的类型进行排除，还是按照正则表达式进行排除，等等
//        * classes：除了@Controller和@Service标注的组件之外，IOC 容器中剩下的组件我都要，即相当于是我要排除 @Controller 和
//        *          @Service 这俩注解标注的组件。
//        * */
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//}, useDefaultFilters = false)
//@ComponentScan(value = "com.hy", includeFilters = {
//        /*
//         * type：指定你要排除的规则，是按照注解进行排除，还是按照给定的类型进行排除，还是按照正则表达式进行排除，等等
//         * classes：除了@Controller和@Service标注的组件之外，IOC 容器中剩下的组件我都要，即相当于是我要排除 @Controller 和
//         *          @Service 这俩注解标注的组件。
//         * */
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class})
//}, useDefaultFilters = false)
@ComponentScans(value = {
        @ComponentScan(value = "com.hy", includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        }, useDefaultFilters = false)
})
// @ComponentScan value:指定要扫描的包
// excludeFilters = Filter[]，指定扫描的时候按照什么规则排除哪些组件
// includeFilters = Filter[]，指定扫码的时候只需要包含哪些组件
// FilterType.ANNOTATION：按照注解
// FilterType.ASSIGNABLE_TYPE：按照给定的类型
// FilterType.ASPECTJ：按照ASPECTJ表达式
// FilterType.REGEX：按照正则表达式
// FilterType.CUSTOM：使用自定义规则
public class MainConfig {

    // 给容器中注册一个Bean；类型为返回值的类型，id 默认是用方法名作为 id
    @Bean(value = "person")
    public Person person() {
         return new Person("lisi", 20);
    }

}
