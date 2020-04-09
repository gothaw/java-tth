package com.teamtreehouse.docgen;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Doc {

    /**
     * Description of class or method
     */
    String desc() default "";

    /**
     * Description of parameters, if annotated element is a method & has parameters
     */
    String[] params() default {};

    /**
     * Description of return value, if annotated element is a method & isn't void
     */
    String returnVal() default "";
}