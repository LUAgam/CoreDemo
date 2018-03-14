/**
 * 
 */
package org.lua.entity;

import java.util.Map;

/** 
* @author AMGuo E-mail:www.guoao@foxmail.com 
* @version 创建时间：2017年3月24日 下午2:01:46 
* 类说明 
*/
/**
 * @author LUA
 *
 */
public interface StateMachine {
	
	public int getColumn();
	
	public String getCurrentState();
	
	public String[] getAllState();
	
	public String[] getNextAction();
	
	public String getNextStatus(String action);
	
	public BaseEntity doAction(String action);
	
	public Map allVariable();

}
