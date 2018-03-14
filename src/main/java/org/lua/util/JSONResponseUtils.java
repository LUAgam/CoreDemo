/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.util;

import org.lua.datatables.JSONResponse;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;


/**
 * 
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4277 $ $Date: 2014-04-27 16:12:43 +0800 (星期日, 27 四月 2014) $
 */

public class JSONResponseUtils {

	public static JSONResponse convert(Page page, HashMap<String, String> paramMap) {
	    String sEcho = paramMap.get("sEcho");  
	    String sColumns = paramMap.get("sColumns");  
	    
		JSONResponse resp = new JSONResponse();
		resp.columns = sColumns;
		resp.echo = sEcho;
		resp.data = page.getContent();
		resp.totalDisplayRecords = Integer.valueOf(String.valueOf(page.getTotalElements()));
		
		return resp;
	}
	
	public  static JSONResponse convert(Page page, HashMap<String, String> paramMap, List realData) {
		String sEcho = paramMap.get("sEcho");  
	    String sColumns = paramMap.get("sColumns");  
	    
		JSONResponse resp = new JSONResponse();
		resp.columns = sColumns;
		resp.echo = sEcho;
		resp.data = realData;
		resp.totalDisplayRecords = Integer.valueOf(String.valueOf(page.getTotalElements()));
		
		return resp;
	}
}
