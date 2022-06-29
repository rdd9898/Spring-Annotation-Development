package com.hy.config;

import com.hy.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.awt.event.PaintEvent;

/**
 * @author 胡阳
 * @ClassName MainConfig3
 * @description:
 * @date 2022年06月29日 16:17
 */
@Configuration
public class MainConfig3 {

    @Scope(value = "thread")
    @Bean(value = "person")
    public Person person() {
        return new Person("任丁丁", 25);
    }

}
