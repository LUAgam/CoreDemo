/**
 * (c) 2010 SDGroup
 * <p>
 * http://www.sdgroup.com
 */

package org.lua.repository.base;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 分页数据容器，供分页使用
 * @author $Author: XLShu$
 * @version $Revision: 2014$ $Date: 2014-4-17上午10:09:44$
 *
 */

public class BasePage<T> implements Page<T> {


    /**
     * 当前页码 (page 从0开始）
     * 比如总页数数是2，那么页码就是0，1
     */
    private Integer number = 0;

    /**
     * 页面大小
     */
    private Integer size = 0;

    /**
     * 总页数
     */
    private Integer totalPages = 0;

    /**
     * 总记录数
     */
    private Long totalElements = 0l;

    /**
     * 内容
     */
    private List<T> content = new LinkedList<T>();

    /**
     * 排序
     */
    private Sort sort;


    public BasePage(int number, int size, Long total, List<T> content, Sort sort) {
        this.number = number;
        this.size = size;
        this.totalElements = total;

        totalPages = ((Long) (totalElements / size)).intValue();

        if ((totalElements % size) != 0) {
            totalPages++;
        }

        this.content = content;
        this.sort = sort;
    }


    public int getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public <S> Page<S> map(Converter<? super T, ? extends S> converter) {
        return null;
    }

    public List<T> getContent() {
        return content;
    }

    public boolean hasContent() {
        if (content.size() == 0) {
            return false;
        }
        return true;
    }


    public Iterator<T> iterator() {
        return content.iterator();
    }


    public Sort getSort() {
        return this.sort;
    }


    public boolean hasNextPage() {
        if (number < totalPages) {
            return true;
        }
        return false;
    }


    public boolean hasPreviousPage() {
        if (number > 1) {
            return true;
        }
        return false;
    }

    public Pageable nextPageable() {
        return null;
    }

    public Pageable previousPageable() {
        return null;
    }


    public boolean isFirstPage() {
        if (number == 1) {
            return true;
        }
        return false;
    }


    public boolean isLastPage() {
        if (number == totalPages) {
            return true;
        }
        return false;
    }


    public int getNumberOfElements() {
        return content.size();
    }

}

