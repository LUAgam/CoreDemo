/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.util;

import com.schickit.utils.FileUtils;
import org.lua.constant.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * 
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 2 $ $Date: 2014-04-10 17:30:58 +0800 (Thu, 10 Apr 2014) $
 */

public class FileUploadUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);
	
	
	public static String getCurrentPath(HttpServletRequest request) {
		return request.getSession().getServletContext().getRealPath("/");
	}
	
	public static String getPath(HttpServletRequest request){
		String path =  request.getSession().getServletContext().getRealPath("/");
		return path.substring(0, path.lastIndexOf("\\", path.length()-2)+1);
	}
	
	//单文件上传 判断上传文件是否是空
	public static String getOriginalFilename(MultipartHttpServletRequest request) {
		Iterator<String> itr = request.getFileNames();
        while (itr.hasNext()) {
           return request.getFile(itr.next()).getOriginalFilename();
        }
        return null;
	}
	
	public static String upload(String dest, String newFileName, MultipartHttpServletRequest request) {
		logger.info("保存上传文件开始...");
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf;
        String ret = null;
        while (itr.hasNext()) {
            mpf = request.getFile(itr.next());
            
            if(!"".equals(mpf.getOriginalFilename()) && mpf.getOriginalFilename() != null){
            	if (newFileName != null) {
                	ret = dest + newFileName + "." + FileUtils.getFileExtension(mpf.getOriginalFilename());
                } else {
                	ret = dest + mpf.getOriginalFilename();
                }
            }
            
            logger.info("保存文件路径 " + ret);
            if(ret != null){
            	 File newFile = new File(ret);
                 
                 if(!newFile.exists()){
                 	newFile.mkdirs();
                 }
                 try {
                     mpf.transferTo(newFile);
                     
                 } catch(IOException e) {
                 	logger.error("上传文件出错！", e);
                 	throw new RuntimeException(Constant.ERROR_UPLOAD_FILES);
                 }
            }
            
        }
        return ret;
	}
	
	public static String upload(String dest, String newFileName, MultipartHttpServletRequest request, String newDest) {
		logger.info("保存上传文件开始...");
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf;
        String ret = null;
        while (itr.hasNext()) {
            mpf = request.getFile(itr.next());
            
            if(!"".equals(mpf.getOriginalFilename()) && mpf.getOriginalFilename() != null){
            	if (newFileName != null) {
                	ret = dest + newFileName + "." + FileUtils.getFileExtension(mpf.getOriginalFilename());
                } else {
                	ret = dest + mpf.getOriginalFilename();
                }
            }
            
            logger.info("保存文件路径 " + ret);
            if(ret != null){
            	 File newFile = new File(ret);
                 
                 if(!newFile.exists()){
                 	newFile.mkdirs();
                 }
                 try {
                     mpf.transferTo(newFile);
                     File destFile = new File(newDest + newFileName + "." + FileUtils.getFileExtension(mpf.getOriginalFilename()));
                     org.apache.commons.io.FileUtils.copyFile(newFile, destFile);
                     
                 } catch(IOException e) {
                 	logger.warn("上传文件出错！", e);
                 	return null;
                 }
            }
            
        }
        return ret;
	}
	//
	public static String upload(String dest, String newFileName, MultipartFile mpf, String newDest){
		String ret = null;
		if(!"".equals(mpf.getOriginalFilename()) && mpf.getOriginalFilename() != null){
        	if (newFileName != null) {
            	ret = dest + newFileName + "." + FileUtils.getFileExtension(mpf.getOriginalFilename());
            } else {
            	ret = dest + mpf.getOriginalFilename();
            }
        }
		logger.info("保存文件路径 " + ret);
        if(ret != null){
        	 File newFile = new File(ret);
             if(!newFile.exists()){
             	newFile.mkdirs();
             }
             try {
                 mpf.transferTo(newFile);
                 File destFile = new File(newDest + newFileName + "." + FileUtils.getFileExtension(mpf.getOriginalFilename()));
                 org.apache.commons.io.FileUtils.copyFile(newFile, destFile);
             } catch(IOException e) {
             	logger.warn("上传文件出错！", e);
             	return null;
             }
        }
		return ret;
	}
	
	public static File uploadFile(String dest, String newFileName, MultipartHttpServletRequest request) {
		logger.info("保存上传文件开始...");
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf;
        String ret = null;
        while (itr.hasNext()) {
            mpf = request.getFile(itr.next());
            
            if(!"".equals(mpf.getOriginalFilename()) && mpf.getOriginalFilename() != null){
            	if (newFileName != null) {
                	ret = dest + newFileName + "." + FileUtils.getFileExtension(mpf.getOriginalFilename());
                } else {
                	ret = dest + mpf.getOriginalFilename();
                }
            }
            
            logger.info("保存文件路径 " + ret);
            if(ret != null){
            	 File newFile = new File(ret);
                 
                 if(!newFile.exists()){
                 	newFile.mkdirs();
                 }
                 try {
                     mpf.transferTo(newFile);
                     
                 } catch(IOException e) {
                 	logger.warn("上传文件出错！", e);
                 	return null;
                 }
            }
            
        }
        return null;
	}
	
}
