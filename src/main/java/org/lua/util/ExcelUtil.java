/**
 *        (c) 2013 Shanghai SDGroup Information GmbH
 *
 *        http://www.sdgroup.com/
 */

package org.lua.util;

import com.schickit.utils.ClassUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author    $Author: XLShu$
 * @version   $Revision: 2 $Date: 2013-9-25下午3:27:02$
 *
 */

public class ExcelUtil {
	private static Map<String, HSSFCellStyle> cellStypeMap;
	/**
	 * exportParameter 
	 * key 
	 * @param entityList
	 * @param exportParameter
	 * @return
	 */
	public static Workbook create(List entityList, Map<String, String> exportParameter) {
		 HSSFWorkbook workbook = new HSSFWorkbook();  
         //产生工作表对象  
         HSSFSheet sheet = workbook.createSheet(); 
         
	     sheet.autoSizeColumn(1);
         initCellStyleMap(workbook);
         int i=0;
         HSSFRow row = sheet.createRow(i);//创建一行  
         for (String columnName : exportParameter.keySet()) {
             HSSFCell cell = row.createCell(i);//创建一列  
             cell.setCellType(HSSFCell.CELL_TYPE_STRING);  
             cell.setCellValue(columnName);
             
             cell.setCellStyle(cellStypeMap.get("head"));
             if (columnName != null) {
            	 sheet.setColumnWidth(i, columnName.getBytes().length*2*256 + 500);
            	// sheet.setColumnWidth(i, columnName.length()*cell.getCellStyle().getFont(workbook).getBoldweight() + 50);
             }
            
             i++;
         }
         
         i=1;
        for (Object o : entityList)  
         {  
             row = sheet.createRow(i);//创建一行
             int j=0;
             for (String columnName : exportParameter.keySet()) {
                 
            	 HSSFCell cell = row.createCell(j);//创建一列  
            	 cell.setCellType(HSSFCell.CELL_TYPE_STRING);  
            	 cell.setCellStyle(cellStypeMap.get("content"));
            	 try {
	            	 if (exportParameter.get(columnName).indexOf("_") > 0) {
	            		 String[] field = exportParameter.get(columnName).split("_");
	
	            		 Object value = ClassUtils.getField(o, field[0]);
	            		 Object value1 = ClassUtils.getField(value, field[1]);
	
	            		 if (value1 != null) {
	            			 if ("true".equals(value1.toString())) {
	            				 cell.setCellValue("是"); 
	            			 } else if ("false".equals(value1.toString())) {
	            				 cell.setCellValue("否"); 
	            			 } else {
	            				 cell.setCellValue(value1.toString()); 
	            				 
	            			 }
	            		 }
	
	            	 } else {
	            		 Object value = ClassUtils.getField(o, exportParameter.get(columnName));
	            		 if (value != null) {
	            			 if ("true".equals(value.toString())) {
	            				 cell.setCellValue("是"); 
	            			 } else if ("false".equals(value.toString())) {
	            				 cell.setCellValue("否"); 
	            			 } else {
	            				 cell.setCellValue(value.toString()); 
	            			 }
	            		 }
	                     
	            	 }
            	 }catch(Exception e) {
            		 e.printStackTrace();
            	 }
            	
                 j++;
             }
             i++;
         } 
    
         
         return workbook;
	}
	
	
    /** 
     * Jsp/Servlet + POI 导出 Excel 
     *  
     * @param response  HttpServletResponse 
     * @param wb  HSSFWorkbook/XSSFWorkbook 
     * @param fileName  xxx.xls(97-03)/xxx.xlsx(07-10) 
     * @throws IOException 
     */ 
    public static void exportExcel(HttpServletResponse response, Workbook wb, String fileName) { 
    	String codedFileName = null;  
    	OutputStream fOut = null;  
        try  
        {
	        // 如果文件名有中文，必须URL编码 
	    	codedFileName = URLEncoder.encode(fileName, "UTF-8"); 
	        response.reset(); 
	        // ContentType 可以不设置 
	        response.setContentType("application/vnd.ms-excel;charset=UTF-8"); 
	        response.setHeader("Content-Disposition", "attachment;filename=" + codedFileName); 
	        wb.write(response.getOutputStream()); 
	        fOut = response.getOutputStream();  
        }  catch (Exception e) {
        	
        }  finally{  
	            try  
	            {  
	                fOut.flush();  
	                fOut.close();  
	            }  
	            catch (IOException e)  
	            {}  

	   }  
    }
    
    private static void initCellStyleMap(HSSFWorkbook wb) {
		cellStypeMap = new HashMap<String, HSSFCellStyle>();
		//
		HSSFCellStyle cellStyle = wb.createCellStyle();
		HSSFFont cellFont = wb.createFont();
		// 表头样式（黑体，15号，加粗，左右居中，垂直居中）
		cellStyle = wb.createCellStyle();
		cellFont = wb.createFont();
		cellFont.setFontHeightInPoints((short) 18);// 字体
		cellFont.setFontName("宋体"); // 黑体
		cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
		cellStyle.setFont(cellFont);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 指定单元格居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
		cellStypeMap.put("head", cellStyle);
		// 列名样式
		cellStyle = wb.createCellStyle();
		cellFont = wb.createFont();
		cellFont.setFontHeightInPoints((short) 15);
		cellFont.setFontName("宋体");
		cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		cellStyle.setFont(cellFont);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 指定单元格居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
		cellStypeMap.put("title", cellStyle);
		// 正常样式
		cellStyle = wb.createCellStyle();
		cellFont = wb.createFont();
		cellFont.setFontHeightInPoints((short) 12);
		cellFont.setFontName("宋体");
		cellStyle.setFont(cellFont);
		cellStyle.setWrapText(false);// 自动换行
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 指定单元格居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
		cellStypeMap.put("content", cellStyle);
	}
}
