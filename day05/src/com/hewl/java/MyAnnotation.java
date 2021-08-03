package com.hewl.java;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author 何文亮
 * @date 2021-05-10
 */
@Inherited
@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "hello";
}
