package com.report.excel.Report4J.Interface;

public interface Row <T> {
    public Row <T> addMapInfo(Integer colIndex, String fieldName);
    
    public Object getRow();
}
