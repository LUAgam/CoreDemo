package org.lua.web.index.formbean;

import java.io.Serializable;
import java.util.Date;


public class EventJSON implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -561927252129444947L;
	
	///@JsonProperty(value = "id")
	public Long id;

	//@JsonProperty(value = "start")
    public Date start;

    //@JsonProperty(value = "end")
    public Date end;

    //@JsonProperty(value = "title")
    public String title;

    //@JsonProperty(value = "color")
    public String color;

    //@JsonProperty(value = "allDay")
    public boolean allDay;
    
    //@JsonProperty(value = "content")
    public String content;
    
    //@JsonProperty(value = "startStr")
    public String startStr;
    
    //@JsonProperty(value = "endStr")
    public String endStr;

    public EventJSON() {
    }
}
