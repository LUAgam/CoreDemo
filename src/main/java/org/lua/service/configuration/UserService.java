/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.service.configuration;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.ByteSource;
import org.lua.entity.User;
import org.lua.repository.UserDao;
import org.lua.service.mail.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * 
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4306 $ $Date: 2014-05-08 18:22:19 +0800 (星期四, 08 五月 2014) $
 */
@Component
@Transactional(readOnly = true)
public class UserService {
	
    final Logger logger = LoggerFactory.getLogger(UserService.class);
    
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MailService mailService;
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User findByPersonId(Long personId) {
		return this.userDao.findByPersonId(personId);
	}
	
	public User findOne(Long userId) {
		return this.userDao.findOne(userId);
	}
	
	public Page<User> findAll(Pageable pageable) {
		return this.userDao.findAll(pageable);
	}
	
	public Page<User> findAll(Specification<User> specification, Pageable pageable) {
		return this.userDao.findAll(specification, pageable);
	}
	
	public List<User> findAll(Specification<User> specification,Sort sort) {
	    return userDao.findAll(specification, sort);
	}
	
	public User findByUsername(String username) {
		return this.userDao.findByUsername(username);
	}
	
	private void entryptPassword(User user) {
		RandomNumberGenerator rng = new SecureRandomNumberGenerator();
		ByteSource salt = rng.nextBytes();
		
		
		String hashedPasswordBase64 = new Sha256Hash(user.getPassword(), salt.toHex(), 1024).toBase64();
		user.setPassword(hashedPasswordBase64);
		user.setSalt(salt.toHex());

	}
	
	@Transactional(readOnly = false)
	public void saveUser(User entity) {
		entryptPassword(entity);
		userDao.save(entity);
	}
	
	@Transactional(readOnly = false)
	public void remove(Long userId) {
		userDao.delete(userId);
	}
	
	@Transactional(readOnly = false)
	public String sendNewPassword(String username, String email) throws Exception {
		String error = null;
		User user = userDao.findByUsername(username);
		/*
		
		if (student == null && teacher == null) {
			error = "登录账号不存在";
		}
		
		if (error == null) {
			String newPassword = genRandomNum(8);
			user.setPassword(StringUtils.md5(newPassword));
			userDao.save(user);
			
		    Map model = new HashMap();
	        model.put("user", user.getPerson().getName());
	        model.put("content", "东华大学MBA旭日工商管理学院信息化系统新密码为：["+newPassword+"]。");
	        model.put("currentDate", DateUtils.getCurrentDateString());
			mailService.send("mbajx@dhu.edu.cn", email, "东华大学MBA旭日工商管理学院信息化系统，找回密码", "mailForgetPassWord.ftl", model);
			
			logger.info("密码重置："+user.getPerson().getName()+"的密码通过用户名和邮箱验证重新生成！");
			
		}*/
		
		return error;
	}
	
	/**
	  * 生成随即密码
	  * @param pwd_len 生成的密码的总长度
	  * @return  密码的字符串
	  */
	 public static String genRandomNum(int pwd_len){
	  //35是因为数组是从0开始的，26个字母+10个数字
	  final int  maxNum = 66;
	  int i;  //生成的随机数
	  int count = 0; //生成的密码的长度
	  char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
	    'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
	    'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
	    'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '!', '@', '#', '$', '%'};
	  
	  StringBuffer pwd = new StringBuffer("");
	  Random r = new Random();
	  while(count < pwd_len){
	   //生成随机数，取绝对值，防止生成负数，
	   
	   i = Math.abs(r.nextInt(maxNum));  //生成的数最大为36-1
	   
	   if (i >= 0 && i < str.length) {
	    pwd.append(str[i]);
	    count ++;
	   }
	  }
	  
	  return pwd.toString();
	 }

	public Page<User> getPage(Pageable pageable) {
		return userDao.findAll(pageable);
	}
	public Page<User> getPage(String where, Object[] queryParams, Pageable pageable) {
		return userDao.findPage(where, queryParams, pageable);
	}

	public Page<User> findByPage(Specification<User> specification, int pageNumber, int pSize) {
		Pageable pr = new PageRequest(pageNumber, pSize, new Sort(new Order(Direction.ASC, "id"),new Order(Direction.ASC, "id")));
		return userDao.findAll(specification, pr);
	}
	
	/**
	 * 查找部门所有用户
	 * @param depId
	 * @return
	 */
	public List<User> findByDepartment(Long depId){
		return userDao.findByDepartment(depId);
	}
	
}
