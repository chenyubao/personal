package com.report.excel.Report4J.Interface;

import java.util.Collection;

public interface Row <T> {
    public Row <T> addMapInfo(String colName, String fieldName);
    
    public Object getRow();

	public Collection<Header> getHeaders();
}
