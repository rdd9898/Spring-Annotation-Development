package com.hy.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author 胡阳
 * @ClassName MyImportSelector
 * @description:
 * @date 2022年06月29日 20:46
 */
// 自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    //返回值：就是要导入到容器中的组件全类名
    //AnnotationMetadata：当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[0];
    }

}
