/**
 * (c) 2006 Joven
 * <p>
 * http://www.joven.com.cn
 * 版权所有 2006 上海悦闻信息技术有限公司
 */

package org.lua.repository.base;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 类功能描述注释
 *
 * @author $Author$
 * @version $Revision$ $Date$
 */
@NoRepositoryBean
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private final EntityManager entityManager;
    private final Class<T> domainClass;


    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);

        // This is the recommended method for accessing inherited class dependencies.
        this.domainClass = domainClass;
        this.entityManager = entityManager;
    }


    public Page<T> findPage(String where, Object[] queryParams, Pageable pageable) {
        String from = domainClass.getSimpleName() + " entity";
        return findPage(from, where, queryParams, pageable);
    }


    public Page<T> findPage(String from, String where, Object[] queryParams, Pageable pageable) {
        if (from == null) {
            from = domainClass.getSimpleName() + " entity";
        }

        String strHQL = "SELECT COUNT(*) FROM " + from;

        if (!StringUtils.isEmpty(where)) {
            strHQL += " WHERE " + where;
        }


        Query query = entityManager.createQuery(strHQL);
        setQueryParams(query, queryParams);

        Long totalCount = (Long) query.getSingleResult();

        strHQL = String.format("SELECT %s FROM %s", "entity", from);


        if (!StringUtils.isEmpty(where)) {
            strHQL += " WHERE " + where;
        }

        Iterator<Sort.Order> orderIt = pageable.getSort().iterator();
        LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
        while (orderIt.hasNext()) {
            Sort.Order order = (Sort.Order) orderIt.next();
            orderMap.put(order.getProperty(), order.getDirection().toString());
        }
        strHQL += buildOrderby(orderMap);

        query = entityManager.createQuery(strHQL);

        setQueryParams(query, queryParams);

        if (pageable != null) {
            query.setFirstResult(pageable.getOffset());
            query.setMaxResults(pageable.getPageSize());
        }


        //返回值
        BasePage<T> p = new BasePage<T>(pageable.getPageNumber(), pageable.getPageSize(), totalCount, query.getResultList(), pageable.getSort());

        return p;
    }

    private void setQueryParams(Query query, Object[] queryParams) {
        if (queryParams != null && queryParams.length > 0) {
            for (int i = 0; i < queryParams.length; i++) {
                query.setParameter(i + 1, queryParams[i]);
            }
        }
    }

    private String buildOrderby(LinkedHashMap<String, String> orderBy) {
        StringBuilder orderByJpql = new StringBuilder("");
        if (orderBy != null && orderBy.size() > 0) {
            orderByJpql.append(" order by ");
            for (String key : orderBy.keySet()) {
                orderByJpql.append("entity.").append(key).append(" ").append(
                        orderBy.get(key)).append(",");
            }
            orderByJpql.deleteCharAt(orderByJpql.length() - 1);
        }
        return orderByJpql.toString();
    }


    public List findAll(String hql, Object[] queryParams) {
        Query query = entityManager.createQuery(hql);
        setQueryParams(query, queryParams);
        return query.getResultList();
    }


}
