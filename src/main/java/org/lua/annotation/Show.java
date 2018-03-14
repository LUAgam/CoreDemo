package org.lua.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
* @author AMGuo E-mail:www.guoao@foxmail.com 
* @version 创建时间：2017年3月30日 下午5:35:43 
* 类说明 
*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Show {

	/**
	 * 页面显示的label
	 */
	String title() default "";
	
	/**
	 * 页面显示的顺序
	 */
	int pos() default 1;
	
	/**
	 * 合并几列单元格
	 */
	int colspan() default 1;
}
