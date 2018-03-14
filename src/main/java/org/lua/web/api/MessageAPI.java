/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.web.api;

import com.schickit.utils.StringUtils;
import org.lua.web.chart.formbeans.InStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * 消息REST API
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4277 $ $Date: 2014-04-27 16:12:43 +0800 (星期日, 27 四月 2014) $
 */
@Controller
@RequestMapping(value="/api/message")
public class MessageAPI {
	
	@RequestMapping(value="/instorages", method = RequestMethod.GET)
	@ResponseBody
	public InStorage instorage(@RequestBody InStorage data, HttpServletResponse respons) {
		respons.setHeader("Access-Control-Allow-Origin", "*");
		InStorage ret = new InStorage();
		Random r = new Random();
		Double d = r.nextDouble() * 1000;
		ret.setInStorageNumber(StringUtils.numberToString(d, 2));
		
		return ret;
	}
	
//	@RequestMapping(value="/unread/messageId", method = RequestMethod.GET)
//	public void markUnread(Integer messageId) {
//		messageService.unread(messageId);
//	}
//	
//	@RequestMapping(value="/read/messageId", method = RequestMethod.GET)
//	public void markRead(Integer messageId) {
//		messageService.read(messageId);
//	}

}
