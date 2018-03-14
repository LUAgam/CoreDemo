package org.lua.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author AMGuo E-mail:www.guoao@foxmail.com
 * @version 创建时间：2017年2月20日 下午2:03:35 类说明
 */
public class StringUtils {

	/**
	 * source是否包含contain
	 * 
	 * @param source
	 * @return
	 */
	public static boolean contain(String source, String contain) {
		if (!com.schickit.utils.StringUtils.isEmpty(source) && !com.schickit.utils.StringUtils.isEmpty(contain)) {
			if (source.indexOf(contain) >= 0)
				return true;
			else
				return false;
		} else
			throw new NullPointerException();
	}

	/**
	 * 读取字符串第i次出现特定符号的位置
	 * 
	 * @param string
	 * @param i
	 * @return
	 */
	public static int getCharacterPosition(String string, int i, String character) {
		Matcher slashMatcher = Pattern.compile(character).matcher(string);
		int mIdx = 0;
		while (slashMatcher.find()) {
			mIdx++;
			if (mIdx == i) {
				break;
			}
		}
		return slashMatcher.start();
	}

	public static String removeRepeat(String powerCutArea) {
		String[] array = powerCutArea.split("-");
		List<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			arrayList.add(array[i]);
		}
		List<String> list = zz(arrayList);
		String powerCutAreaNew = "";
		for (String string : list) {
			powerCutAreaNew = powerCutAreaNew + "-" + string;
		}
		return powerCutAreaNew.substring(1, powerCutAreaNew.length());
	}

	/**
	 * 去除list中重复的，重复的只保留一个
	 * 
	 * @param arrayList
	 * @return
	 */
	private static List<String> zz(List<String> arrayList) {
		for (int i = 0; i < arrayList.size(); i++) {
			String first = arrayList.get(i);
			for (int j = i + 1; j < arrayList.size(); j++) {
				String second = arrayList.get(j);
				if (first.equals(second)) {
					arrayList.remove(i);
					zz(arrayList);
					break;
				}

			}
		}
		return arrayList;
	}

	public static String getNext(String[] states, String status) {
		String stateNew = "";
		if (status == null || status.equals(""))
			stateNew = states[0];
		else {
			for (int i = 0; i < states.length - 1; i++) {
				if (states[i].equals(status))
					stateNew = states[i + 1];
			}
		}
		return stateNew;
	}

	public static String getPrevious(String[] states, String status) {
		String stateNew = "";
		if (status == null || status.equals(""))
			stateNew = states[1];
		else {
			for (int i = 1; i < states.length; i++) {
				if (states[i].equals(status))
					stateNew = states[i - 1];
			}
		}
		return stateNew;
	}
}
