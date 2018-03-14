package org.lua.util;

import org.lua.datatables.JSONParam;

import java.util.HashMap;

public class JSONParamUtils {
	
	public static HashMap<String, String> convertToMap(JSONParam[] params) {
		HashMap<String, String> ret = new HashMap<String, String>();
		for (JSONParam param : params) {
			ret.put(param.getName(), param.getValue());
		}
		return ret;
	}

}
