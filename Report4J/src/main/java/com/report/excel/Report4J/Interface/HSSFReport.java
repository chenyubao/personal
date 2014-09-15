package com.report.excel.Report4J.Interface;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.report.excel.Report4J.core.Pos;
import com.report.excel.Report4J.util.Constant;

public class HSSFReport implements Report {
	
	private HSSFWorkbook report;
	
	private Map<String, HSSFSheet> sheetList;
	
	private HSSFSheet currentSheet;
	
	private int maxHeight;

	public <T> void build(String name, Collection<T> data, DataMapper<T> mapper) {
		if (data != null){
			report = new HSSFWorkbook();
			if (sheetList == null){
				sheetList = new HashMap<String, HSSFSheet>();
			}
			currentSheet = putSheet(name, sheetList);
			
			T t = getObjectInstance(data);
			Row<T> row = new RowImpl<T>(t);
			mapper.mapData(row);
			Collection<Header> headerList = row.getHeaders();
			getMaxHeight(headerList);
			writeHeaderToSheet(headerList, currentSheet);
		}
	}

	private void getMaxHeight(Collection<Header> headerList) {
		if (headerList != null){
			for (Header header : headerList){
				if (header.getHeight() > maxHeight){
					maxHeight = header.getHeight();
				}
			}
		}
	}

	private void writeHeaderToSheet(Collection<Header> headerList, HSSFSheet sheet) {
		writeHeaderToSheet(headerList, sheet, 0, 0);
	}

	private void writeHeaderToSheet(Collection<Header> headerList, HSSFSheet sheet, int startCol, int startRow) {
		if (CollectionUtils.isNotEmpty(headerList)){
			Pos pos = new Pos(startCol, startRow);
			for (Header header : headerList){
				pos = header.write(this, pos);
			}
		}
	}

	private HSSFSheet putSheet(String name, Map<String, HSSFSheet> sheetList) {
		if (name != null){
			if (sheetList.get(name) != null){
				throw new RuntimeException("The report name has been used");
			} else {
				sheetList.put(name, report.createSheet(name));
			}
			return sheetList.get(name);
		} else {
			String defaultName = Constant.REPORT + sheetList.size();
			sheetList.put(defaultName, report.createSheet(defaultName));
			return sheetList.get(defaultName);
		}
	}

	private <T> T getObjectInstance(Collection<T> data) {
		T t = null;
		for (T t1 : data){
			if (t1 != null){
				t = t1;
				break;
			}
		}
		return t;
	}

}
