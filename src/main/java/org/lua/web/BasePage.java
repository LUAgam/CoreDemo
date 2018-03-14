/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;

/**
 * 分页数据容器，供分页使用
 * @author    $Author: XLShu$
 * @version   $Revision: 4277 $Date: 2014-4-17上午10:09:44$
 *
 */

public class BasePage {
    
    private Integer number;
    
    private Integer size;
    
    private Integer totalPages;
    
    private Integer numberOfElements;
    
    private Long totalElements;
    
    private boolean hasProviousPage;
    
    private boolean firstPage;
    
    private boolean nextPage;
    
    private boolean lastPage;
    
    private Iterator iterator;
    
    private List content;
    
    private boolean hasContent;
    
    private Sort sort;
    
    public BasePage(Page page,List content) {
        this.number = page.getNumber();
        this.size = page.getSize();
        this.totalPages = page.getTotalPages();
        this.numberOfElements = page.getNumberOfElements();
        this.totalElements = page.getTotalElements();
        this.hasProviousPage = page.hasPreviousPage();
        this.firstPage = page.isFirstPage();
        this.nextPage = page.hasNextPage();
        this.lastPage = page.isLastPage();
        this.iterator = page.iterator();
        this.content = content;
        this.hasContent = page.hasContent();
        this.sort = page.getSort();
    }
    
    public int getNumber(){
        return number;
    }

    public int getSize(){
        return size;
    }

    public int getTotalPages(){
        return totalPages;
    }

    public int getNumberOfElements(){
        return numberOfElements;
    }

    public long getTotalElements(){
        return totalElements;
    }

    public boolean hasPreviousPage(){
        return hasProviousPage;
    }

    public boolean isFirstPage(){
        return firstPage;
    }

    public boolean hasNextPage(){
        return nextPage;
    }

    public boolean isLastPage(){
        return lastPage;
    }

    public Iterator iterator(){
        return iterator;
    }

    public List getContent(){
        return content;
    }

    public boolean hasContent(){
        return hasContent;
    }

    public Sort getSort(){
        return sort;
    }
}

