package com.xuliugen.choosedb.demo.anno;

import java.lang.annotation.*;

/**
 * Created by zcl on 2019-05-10.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnnotaion {
    public boolean inEnable() default true;
}
