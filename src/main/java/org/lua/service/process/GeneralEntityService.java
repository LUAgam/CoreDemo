/**
 * 
 */
package org.lua.service.process;

import org.lua.entity.BaseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/** 
* @author AMGuo E-mail:www.guoao@foxmail.com 
* @version 创建时间：2017年3月29日 下午5:38:27 
* 类说明 
*/
/**
 * @author LUA
 *
 */
@Component
@Transactional(readOnly = true)
public class GeneralEntityService {
	
	@PersistenceContext
	EntityManager em;
	
	/**
	 * 通过类名及id查找实例
	 * @param domainClass
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public BaseEntity findOne(Class domainClass, Long id) {
		String hql = "SELECT entity FROM " + domainClass.getSimpleName() + " entity WHERE entity.id=?";
		Query query = em.createQuery(hql);
		query.setParameter(1, id);
		return (BaseEntity) query.getSingleResult();
	}
	
	/**
	 * 通过业务键查找实例
	 * @param entityid
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public BaseEntity findOne(String[] entityid) {
		String hql = "SELECT entity FROM " + entityid[0] + " entity WHERE entity.id=" + entityid[1];
		Query query = em.createQuery(hql);
		return (BaseEntity) query.getSingleResult();
	}
	
	/**
	 * 保存实例
	 * @param t
	 */
	@SuppressWarnings("rawtypes")
	@Transactional(readOnly = false)
	public void save(BaseEntity t){
		em.persist(t);
	}
	

}
