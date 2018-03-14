package org.lua.constant;

import org.lua.entity.Resource;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ResourceFactory {

	
	public final static String MENU_TYPE="菜单";
	public final static String BUSINESS_TYPE="模块";

	public static final Resource MENU_WORK_PORTAL = new Resource("/admin/profile/portal", MENU_TYPE, "MENU:WORK:PORTAL", "我的门户");
	public static final Resource MENU_WORK_CALENDAR = new Resource("/admin/profile/calendar", MENU_TYPE, "MENU:WORK:CALENDAR", "我的日程");
	public static final Resource MENU_WORK_MESSAGE = new Resource("/admin/profile/message/0", MENU_TYPE, "MENU:WORK:MESSAGE", "我的消息");
	public static final Resource MENU_WORK_TASK = new Resource("/admin/profile/task", MENU_TYPE, "MENU:WORK:TASK", "我的待办");
	public static final Resource MENU_WORK_ALLCALENDAR = new Resource("/admin/profile/allcalendar", MENU_TYPE, "MENU:WORK:ALLCALENDAR", "日程展示");

	public static final Resource MENU_PROFILE_PERSON = new Resource("/admin/sys/person", MENU_TYPE, "MENU:PROFILE:PORTAL", "人员管理");
	public static final Resource MENU_PROFILE_DEPARTMENT = new Resource("/admin/sys/department", MENU_TYPE, "MENU:PROFILE:DEPARTMENT", "部门管理");

	public static final Resource MENU_AUTH_USER = new Resource("/admin/auth/user", MENU_TYPE, "MENU:AUTH:USER", "账号管理");
	public static final Resource MENU_AUTH_ROLE = new Resource("/admin/auth/role", MENU_TYPE, "MENU:AUTH:ROLE", "角色管理");
	public static final Resource MENU_AUTH_PERMISSION = new Resource("/admin/auth/permission", MENU_TYPE, "MENU:AUTH:PERMISSION", "权限管理");
	public static final Resource MENU_AUTH_GROUP = new Resource("/admin/auth/group", MENU_TYPE, "MENU:AUTH:GROUP", "岗位管理");
	public static final Resource MENU_AUTH_DEPGROUP= new Resource("/admin/auth/depgroup", MENU_TYPE, "MENU:AUTH:DEPGROUP", "本部门岗位管理");

	public static final Resource BUSINESS_TYPE_USER_ADD = new Resource("/admin/auth/user/add", BUSINESS_TYPE, "USER:ADD", "添加账号");

	public static List<Resource> resourceList = new LinkedList<Resource>();

	public static List<String> resourceType = new LinkedList<String>();

	public static Map<String, Resource> resourceMapping = new HashMap<String, Resource>();
	public static Map<String, Resource> resourceURLMapping = new HashMap<String, Resource>();
	
	public static Map<String, List<Resource>> resourceTypeMapping = new HashMap<String, List<Resource>>();
	

	private static class LazyHolder {
		private static final ResourceFactory instance = new ResourceFactory();
	}

	public static ResourceFactory getInstance() {
		return LazyHolder.instance;
	}

	private ResourceFactory() {

		resourceType.add(BUSINESS_TYPE);
		
		resourceList.add(MENU_WORK_PORTAL);
		resourceList.add(MENU_WORK_CALENDAR);
		resourceList.add(MENU_WORK_MESSAGE);
		resourceList.add(MENU_WORK_TASK);
		resourceList.add(MENU_WORK_ALLCALENDAR);
		resourceList.add(MENU_PROFILE_PERSON);
		resourceList.add(MENU_PROFILE_DEPARTMENT);
		resourceList.add(MENU_AUTH_USER);
		resourceList.add(MENU_AUTH_ROLE);
		resourceList.add(MENU_AUTH_PERMISSION);
		resourceList.add(MENU_AUTH_GROUP);
		resourceList.add(MENU_AUTH_DEPGROUP);

		resourceList.add(BUSINESS_TYPE_USER_ADD);
		
		for (Resource resource : resourceList) {
			resourceMapping.put(resource.getName(), resource);
			resourceURLMapping.put(resource.getUrl(), resource);
			
			List<Resource> resourceList = resourceTypeMapping.get(resource.getType());
			if (resourceList == null) {
				resourceTypeMapping.put(resource.getType(), new LinkedList<Resource>());
			}
			resourceTypeMapping.get(resource.getType()).add(resource);
		}

	}

	public List<Resource> getResourceList() {
		return resourceList;
	}

	public List<String> getAllResourceType() {
		return resourceType;
	}
	
	public List<Resource> getResourceListByType(String type) {
		return resourceTypeMapping.get(type);
	}

	public String getURLByName(String name) {
		Resource resource = resourceMapping.get(name);
		if (resource != null) {
			return resource.getUrl();
		}
		return null;
	}
	
	public Resource getResource(String url) {
		Resource resource = resourceURLMapping.get(url);
		if (resource != null) {
			return resource;
		}
		return null;
	}
}
