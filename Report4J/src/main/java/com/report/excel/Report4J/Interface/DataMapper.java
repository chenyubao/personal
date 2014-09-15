package com.report.excel.Report4J.Interface;

public interface DataMapper<T> {
    public void mapData(Row<T> row);
}
