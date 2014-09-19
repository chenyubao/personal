package com.report.excel.Report4J.Interface;

import java.util.Collection;
import java.util.List;

public interface Row <T> {
    public Row <T> addMapInfo(String colName, String fieldName);
    
    public Row <T> addMapInfo(String colName, String fieldName, 
    		List<String> headStyle, List<String> colStyle);
    
    public Row <T> addMapInfo(String colName, String fieldName, List<String> headStyle);
    
    public Object getRow();

	public Collection<Header> getHeaders();
}
