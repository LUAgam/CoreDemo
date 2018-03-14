/**
 * 
 */
package org.lua.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 用于注解Controller中的方法， 防止重复递交接口
 * 
 * 
 * @author JHuang
 *
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {

    boolean save() default false;

    boolean remove() default false;
}