/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.web;


/**
 * 树状结构数据
 * 
 * @author $Author: XLShu$
 * @version $Revision: 2014$ $Date: 2014-7-24下午3:16:23$
 * 
 */
public class BaseTreeBean {

    /**
     * 主键
     */
    private Long id;

    /**
     * 树标题
     */
    private String title;

    private Long pId;
  
    private boolean isParent = false;
    
    private boolean open = true;
    
    private String url;
    
    private String target;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public boolean isParent() {
		return isParent;
	}

	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
