/**
 * (c) 2006 JOVEN
 * 
 * http://www.joven.com.cn
 */
package org.lua.constant;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Constant {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 2;
	public static final int SALT_SIZE = 8;
	
	public static final String MALE = "MALE";
	public static final String FEMALE = "FEMAIL";

	public static final int MESSAGE_READ_INTERVAL = 5 * 60 * 1000; // 3

	public static final String SESSION_CAPTCHA = "session_captcha";
	public static final String SESSION_USER = "session_user";
	public static final String SESSION_ADMIN = "session_admin";
	public static final String SESSION_PERSON = "session_person";
	public static final String SESSION_DEPARTMENT = "session_department";
	public static final String SESSION_MENU = "session_user_menu";

	public static final String TOKEN = "token";

	public static final String DELETE_MESSAGE = "该信息已被引用，无法删除！";
	
	public static final String DEFAULT_PASSWORD = "111111";

	public static final String TRUESTRING = "是";
	public static final String FALSESTRING = "否";

	public static final String MAN = "男";
	public static final String WOMAN = "女";

	public static final String DAY = "天";
	public static final String HOUR = "小时";
	public static final String MINUTE = "分";

	public static final Map<Boolean, String> boolToStringMap = new HashMap<Boolean, String>();
	static {
		boolToStringMap.put(true, "是");
		boolToStringMap.put(false, "否");
	}
	public static final Map<String, Boolean> stringToBooleanMap = new HashMap<String, Boolean>();
	static {
		stringToBooleanMap.put("是", true);
		stringToBooleanMap.put("否", false);
	}
	public static final Map<String, String> genderMap = new HashMap<String, String>();
	static {
		genderMap.put("MALE", "男");
		genderMap.put("FEMAIL", "女");
	}

	public static final Map<String, String> strToGenderMap = new HashMap<String, String>();
	static {
		strToGenderMap.put("男", "MALE");
		strToGenderMap.put("女", "FEMAIL");
	}

	public static final List<String> GENDER_LIST = new LinkedList<String>();
	static {
		GENDER_LIST.add("男");
		GENDER_LIST.add("女");
	}

	public static final String ONE = "一";
	public static final String TWO = "二";
	public static final String THREE = "三";
	public static final String FOUR = "四";
	/**
	 * 列表页面request中常量
	 */

	public static final String PRE_PAGE = "PAGE_";
	public static final String PRE_SEARCH = "SEARCH_";
	public static final String PRE_EXPORT_HEADER = "HEADER_";

	public static final String PAGE_NUMBER_KEY = "NUMBER_KEY";
	public static final String PAGE_SIZE_KEY = "SIZE_KEY";
	public static final String PAGE_TYPE_KEY = "TYPE_KEY";

	public static final String LABLE_BR = "<br>";

	public static final int DEFAULT_START_PAGE = 0;
	public static final int DEFAULT_PAGE_SIZE = 20;

	public static final String LIST_TYPE = "LIST";
	public static final String EXCEL_TYPE = "EXCEL";

	public static final String DEFAULT_SORT_KEY = "id";
	public static final String DEFAULT_SORT_TYPE = "DESC";
	public static final String SORT_TYPE_ASC = "ASC";
	public static final String SORT_TYPE_DESC = "DESC";

	public static final String LIST_SEARCHPAGE = "LIST";
	public static final String LIST_EXPORTEXCEL = "EXECL";

	/**
	 * AuditLog中的常量
	 */
	public static final String CREATE = "CREATE";
	public static final String MODIFY = "MODIFY";
	public static final String DELETE = "DELETE";

	/**permission
	 * Message中的常量
	 */
	public final static String UNREAD = "UNREAD";
	public final static String READ = "READ";
	public final static String DRAFT = "DRAFT";

	/**
	 * 发送邮件
	 */
	public static final String SEND_MAIL = "发送邮件:";

	/**permission
	 * ProcessService中的
	 */
	public static final String ERROR_WORK_FLOW_NAME_NOTNULL = "工作流模板名称不能为空！";
	public static final String ERROR_WORK_FLOW_BUSINESSapplyToProjcet_ID_NOTNULL = "业务ID不能为空！";

	public static final String NO_PROFESSIONAL = "无专业";

	public static final String ERROR_UPLOAD_FILES = "上传文件出错！";
	public static final String ERROR_KINDEDITORCONTROLLER_CHOOSE_FILES = "请选择文件。";
	public static final String ERROR_KINDEDITORCONTROLLER_NO_PROFESSIONAL = "上传目录没有写权限。";
	public static final String ERROR_KINDEDITORCONTROLLER_NAME_INACCURATE = "目录名不正确。";
	public static final String ERROR_KINDEDITORCONTROLLER_FILES_TOOBIG = "上传文件大小超过限制。";
	public static final String ERROR_KINDEDITORCONTROLLER_FILES_NAME_INACCURATE = "上传文件扩展名是不允许的扩展名。\n只允许";
	public static final String ERROR_KINDEDITORCONTROLLER_UPLOAD_FILES = "上传文件失败。";
	public static final String KINDEDITORCONTROLLER_FORM = "格式。";

	public static final String ERRORINFO_LOGINCONTROLLER_USE_PASSWORD_NOTNULL = "用户名和密码不能为空";
	public static final String ERRORINFO_LOGINCONTROLLER_USENAME_ERROR = "输入用户名错误";
	public static final String ERRORINFO_LOGINCONTROLLER_PASSWORD_ERROR = "输入密码错误";
	public static final String ERRORINFO_LOGINCONTROLLER_NO_USENAME = "该账号未开启";
	public static final String ERRORINFO_LOGINCONTROLLER_LEAVE = "该用户已离职";
	public static final String LOGIN_SUCCESS = "登录成功！";
	public static final String ERRORINFO_DEPARTMENTCONTORLLER_DEPARTMENT_NAME_EMPTY = "部门名称不能为空！";
	public static final String ERRORINFO_MENUCONTROLLER_CODE_EXISTS = "该模块编号已存在！";
	public static final String ERRORINFO_PERMISSIONCONTROLLER_PERMISSION_EXISTS = "该权限编号已存在!";
	public static final String ERRORINFO_PERSONCONTROLLER_UNMBER_CANNOT_REPEATED = "工号不能重复";
	public static final String ERROR_PERSONCONTROLLER_NAME_EMPTY = "姓名不能为空！<br>";
	public static final String ERROR_PERSONCONTROLLER_NUMBER_EMPTY = "工号不能为空！<br>";
	public static final String ERROR_PERSONCONTROLLER_DEPARTMENT_EMPTY = "部门不能为空！<br>";
	public static final String ERROR_PERSONCONTROLLER_GENDER_EMPTY = "性别不能为空！<br>";

	public static final String ERRORINFO_USERCONTROLLER_PASSWORD_RESETTING = "密码重置成功";
	public static final String ERRORINFO_USERCONTROLLER_PASSWORD_DIFFERENCE = "输入的密码不一致！";
	public static final String MESSAGE_CALENARCONTROLLER_TIME_NOTEMPTY = "开始时间不能为空！";
	public static final String MESSAGE_CALENARCONTROLLER_ENDTIME_NOTEMPTY = "非全天日程，结束时间不能为空！";
	public static final String MESSAGE_CALENARCONTROLLER_BEGINTIME_ENDTIME = "非全天日程，结束时间不能早于开始时间！";
	public static final String MESSAGE_CALENARCONTROLLER_NOPERMISSIONS_OPERATE = "无权进行该操作！";
	public static final String MESSAGECONTROLLER_REPLY = "回复：";
	public static final String RESOURCE_MENU = "菜单";
	public static final String MESSAGE_TONGYI = "同意";
	public static final String ERROR_WORK_FLOW_BUSINESS_ID_NOTNULL = "工作流业务键不为空！";
	public static final String ACTIVITI_MESSAGE = "message";
}
