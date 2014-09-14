package com.report.excel.Report4J.Interface;

public interface DataMapper<T> {
    public void mapData(T t, Row<T> row);
}
