package com.report.excel.Report4J.Interface;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.report.excel.Report4J.util.CommonUtils;

public class RowImpl<T> implements Row<T> {
	
	private Map<Integer, String> colMap;
	
	private T t;
	
	public RowImpl(T t){
		colMap = new HashMap<Integer, String>();
		this.t = t; 
	}

	public Row<T> addMapInfo(Integer colIndex, String fieldName) {
		if (colIndex != null && StringUtils.isNotBlank(fieldName)){
			if (CommonUtils.checkFieldExist(fieldName, t.getClass())){
				colMap.put(colIndex, fieldName);
			}
		}
		return this;
	}

	public Object getRow() {
		
		return null;
	}

}
