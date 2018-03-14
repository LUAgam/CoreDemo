/**
 * 
 */
package org.lua.web.index.formbean;

import org.hibernate.validator.constraints.NotEmpty;
import org.lua.web.BaseFormBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * @author onkyo
 *
 */
public class EventFB extends BaseFormBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4150816183926705714L;

	@NotEmpty(message="标题不能为空！")
	private String title;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date startDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date endDate;
	
	private boolean allDay;
	
	private String location;
	
	private String content;
	
	private String color;

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

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
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
	
}
