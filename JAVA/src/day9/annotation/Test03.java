package day9.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
public class Test03 {
    //注解可以显示赋值，如果没默认值，就必须赋值,且无顺序要求
    @MyAnnotation2(age = 18)
    public void test() {
    }

    @MyAnnotation3("秦疆")
    public void test2() {
    }

    @Target(value = {ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyAnnotation2 {
        //注解的参数: 参数类型+参数名();
        String name() default "";

        int age();

        int id() default -1;//如果默认值为-1,代表不存在

        String[] schools() default {"西部开源", "清华大学"};
    }

    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyAnnotation3 {
        //value可以省略
        String value();
    }
}
