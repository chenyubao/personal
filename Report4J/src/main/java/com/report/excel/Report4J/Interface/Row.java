package com.report.excel.Report4J.Interface;

public interface Row <T> {
    public Row <T> addMapInfo(String colName, String fieldName);
    
    public Object getRow();
}
