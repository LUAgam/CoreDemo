package org.lua.web.activiti;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {
	
	final static Logger logger = LoggerFactory.getLogger(Util.class);
	
	public static String[] list(){
		String basePath=Util.class.getResource("/").getPath();
		basePath=basePath.substring(1,basePath.length());
		
		String path = basePath + "diagrams";
		
		
		logger.info("diagrams:               " + path);
		return new File(path).list();
	}

}
