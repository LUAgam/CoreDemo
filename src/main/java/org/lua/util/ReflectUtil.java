package org.lua.util;

import java.lang.reflect.Method;

/**
 * @author AMGuo E-mail:www.guoao@foxmail.com
 * @version 创建时间：2017年3月31日 上午10:12:14 类说明
 */
public class ReflectUtil {

	/**
	 * 通过属性名称和实体实例返回对应属性的值
	 * 
	 * @param name
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static String getValue(String name,Object value) throws Exception {
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		Method m = value.getClass().getMethod("get" + name);
		String attrValue = (String) value.getClass().getMethod("get" + name).invoke(value);
		if (attrValue == null) {
			m = value.getClass().getMethod("set" + name, String.class);
			m.invoke(value, "");
		}
		return attrValue;
	}

}
