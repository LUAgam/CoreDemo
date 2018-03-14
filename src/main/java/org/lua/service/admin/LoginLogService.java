/**
 * 
 */
package org.lua.service.admin;

import com.schickit.utils.DateUtils;
import org.lua.entity.LoginLog;
import org.lua.entity.User;
import org.lua.repository.LoginLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author onkyo
 *
 */
@Component
@Transactional(readOnly = true)
public class LoginLogService {
	
	@Autowired
    LoginLogDao loginLogDao;
	
	@Transactional(readOnly = false)
	public void login(User user, String sessionId) {
		LoginLog log = new LoginLog();
		log.setLogindatetime(DateUtils.getCurrentDateTime());
		log.setLoginUser(user);
		log.setSessionId(sessionId);
		this.loginLogDao.save(log);
	}
	
	@Transactional(readOnly = false)
	public void logout(String sessionId) {
		List<LoginLog> logList = this.loginLogDao.findBySessionId(sessionId);
		if (logList != null && logList.size()>0) {
			LoginLog log = logList.get(0);
			log.setLogoutdatetime(DateUtils.getCurrentDateTime());
			this.loginLogDao.save(log);
		}
		
	}

}
