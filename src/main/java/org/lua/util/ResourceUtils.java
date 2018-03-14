package org.lua.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: kady
 * Date: 13-6-13
 * Time: 下午12:09
 * To change this template use File | Settings | File Templates.
 */
public final class ResourceUtils {

    private ResourceUtils(){}

    private static Properties properties;
    
    private static final String APPLICATION = "/application.properties";
    
    public static final String SOLR_URL = "solr.url";
    
    public static final String OPENOFFICE_HOME = "openoffice.home";
    
    public static final String MEETING_DOC = "meeting.doc";//文档地址,对应proporties
    
    public static final String EMPLOYEE_IMAGE = "employee.image"; 

    public static final String FILEUPLOAD_HEADERIMAGE = "fileupload.headerimage";
    
    public static final String FILEUPLOAD_NEWS = "fileupload.news";
    
    public static final String FILEUPLOAD_LGEA = "fileupload.lgea";
    
    public static final String FILEUPLOAD_ENVIRONMENT = "fileupload.environment";
    
    public static final String FILEUPLOAD_DOCUMENT = "fileupload.document";
    
    public static final String FILEUPLOAD_MESSAGE_ATTACHMENT = "fileupload.message.attachment";
    
    public static final String FILEUPLOAD_BIGIMAGE = "fileupload.bigimage";
    
    public static final String FILEUPLOAD_SITE_BIGIMAGR = "fileupload.site.bigimage";

    public static final String FILEUPLOAD_ARTICLE = "fileupload.article";
    
    public static final String FILEUPLOAD_SITE_ARTICLE = "fileupload.site.article";
    
    public static final String FILEUPLOAD_TUTORIMAGE = "fileupload.tutorimage";
    
    public static final String FILEUPLOAD_TUTORNOTICE = "fileupload.tutorNotice";
    
    public static final String FILEUPLOAD_PERSONHEADIMAGE = "fileupload.personimage";
    
    public static final String FILEUPLOAD_SITE_DHUSTART = "fileupload.site.dhustart";
    
    public static final String FILEUPLOAD_DHUSTART = "fileupload.dhustart";
    
    public static final String FILEUPLOAD_VIDEO = "fileupload.video";
    
    public static final String FILEUPLOAD_SITE_VIDEO = "fileupload.site.video";
    
    public static final String FILEUPLOAD_MAGAZINE = "fileupload.magazine";
    
    public static final String FILEUPLOAD_SITE_MAGAZINE = "fileupload.site.magazine";
    
    public static final String FILEUPLOAD_CHAIRACTIVITY = "fileupload.chairactivity";
    
    public static final String FILEUPLOAD_SITE_CHAIRACTIVITY = "fileupload.site.chairactivity";
   
    public static final String FILEUPLOAD_CATEGORY = "fileupload.category";
    
    public static final String FILEUPLOAD_SITE_CATEGORY = "fileupload.site.category";
    
    
    public static final String FILEUPLOAD_CONSULATION = "fileupload.consuation";
    
    public static final String FILEUPLOAD_SITE_CONSULATION = "fileupload.site.consuation";
    
    public static final String FILEUPLOAD_CATALOGDOCUMENT_ALL = "fileupload.catalogdocument.all";
    
    public static final String FILEUPLOAD_CATALOGDOCUMENT_PDF = "fileupload.catalogdocument.pdf";
    
    /**
     * 技术通知附件文件存储路径
     */
    public static final String FILEUPLOAD_TECHNOLOGYNOTICEFILE = "fileupload.technologynoticefile";
    
    public static final String FILEUPLOAD_WORKFLOWNOTICEFILE = "fileupload.workflownoticefile";
    
    // 前台附件
    public static final String FILEUPLOAD_ATTACHMENT = "fileupload.attachment";
    public static final String FILEUPLOAD_SITE_ATTACHMENT = "fileupload.site.attachment";
    
    public static final String FILEUPLOAD_APPROVEFILE = "fileupload.approvefile";
    

    public static final String FILEUPLOAD_EXCEL = "fileupload.excel";
    
    public static final String FILEUPLOAD_CATALOGDOCUMENT = "fileupload.catalogDocument";
    
    static {
        InputStream fileStream  = ResourceUtils.class.getResourceAsStream(APPLICATION);//"/application.properties";
        properties = new Properties();
        try {
            properties.load(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProperties() {
        return properties;
    }

    public static String getProperty(String name){
        return getProperties().getProperty(name);
    }
}
