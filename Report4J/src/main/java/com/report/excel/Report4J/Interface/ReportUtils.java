package com.report.excel.Report4J.Interface;

import com.report.excel.Report4J.model.ReportType;

public class ReportUtils {
	/**
	 * 入口方法，返回一个Report对象
	 * @param t excel 文件类型, HSSFWorkbook / XSSFWorkbook
	 * @return
	 */
    public static Report createReport(ReportType type) {
    	switch(type){
    	case XLS : 
    		return new HSSFReport();
    	case XLSX :
    		return new XSSFReport();
    	}
    	return null;
    }
}
