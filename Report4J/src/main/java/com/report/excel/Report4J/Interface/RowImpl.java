package com.report.excel.Report4J.Interface;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.report.excel.Report4J.util.CommonUtils;

public class RowImpl<T> implements Row<T> {
	
	private Map<String, String> colMap;
	
	private Header header;
	
	private T t;
	
	public RowImpl(T t){
		colMap = new HashMap<String, String>();
		this.t = t; 
	}

	public Row<T> addMapInfo(String colName, String fieldName) {
		if (StringUtils.isNotBlank(colName) && StringUtils.isNotBlank(fieldName)){
			if (CommonUtils.checkFieldExist(fieldName, t.getClass())){
				colMap.put(colName, fieldName);
			}
		}
		return this;
	}

	public Object getRow() {
		
		return null;
	}

}
