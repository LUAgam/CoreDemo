/**
 * 
 */
package org.lua.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 日程事件或安排
 * @author JHuang
 *
 */
@Entity
@Table(name = "tbl_event")
public class Event extends BaseEntity<Event> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6143777323613141981L;
	//创建人
    @ManyToOne(fetch=FetchType.EAGER)
	private User owner;
	
    @ManyToOne(fetch=FetchType.LAZY)
	private Role role;
	//标题
	private String title;
	//开始时间
	private Date startDate;
	//结束时间
	private Date endDate;
	
	private String location;
	//内容
	private String content;
	//颜色
	private String color;
	//全天
	private boolean allDay;

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

}
