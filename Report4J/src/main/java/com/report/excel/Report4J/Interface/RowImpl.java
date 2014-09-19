package com.report.excel.Report4J.Interface;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import com.report.excel.Report4J.core.ColumnImpl;
import com.report.excel.Report4J.core.HeaderImpl;
import com.report.excel.Report4J.util.CommonUtils;

public class RowImpl<T> implements Row<T> {
	
	private Map<Header, Column> colMap;
	
	private T t;
	
	public RowImpl(T t){
		colMap = new HashMap<Header, Column>();
		this.t = t; 
	}

	public RowImpl() {
		colMap = new HashMap<Header, Column>();
	}

	public Row<T> addMapInfo(String colName, String fieldName) {
		return addMapInfo(colName, fieldName, null, null);
	}

	public Object getRow() {
		
		return null;
	}

	public Collection<Header> getHeaders() {
		if (MapUtils.isNotEmpty(colMap)){
			return colMap.keySet();
		}
		return null;
	}

	public Row<T> addMapInfo(String colName, String fieldName,
			List<String> headStyle, List<String> colStyle) {
		if (StringUtils.isNotBlank(colName) && StringUtils.isNotBlank(fieldName)){
			if (CommonUtils.checkFieldExist(fieldName, t.getClass())){
				Header header = new HeaderImpl(colName, headStyle);
				Column col = new ColumnImpl(fieldName, colStyle);
				colMap.put(header, col);
			}
		}
		return this;
	}

	public Row<T> addMapInfo(String colName, String fieldName,
			List<String> headStyle) {
		return addMapInfo(colName, fieldName, headStyle, null);
	}

}
