/**
 *        (c) 2006 Joven 
 *
 *        http://www.joven.com.cn
 *        版权所有 2006 上海悦闻信息技术有限公司
 */

package org.lua.repository.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义的扩展JpaRepository类
 *
 * @author       $Author$
 * @version      $Revision$ $Date$
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> { 

	Page<T> findPage(String where, Object[] queryParams, Pageable pageable);
	
	Page<T> findPage(String from, String where, Object[] queryParams, Pageable pageable);
	
	List findAll(String hql, Object[] queryParams);
	
}
