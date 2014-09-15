package com.report.excel.Report4J.Interface;

import java.util.Collection;

public interface Report {
    public <T> void build(String name, Collection<T> data, DataMapper<T> mapper);
}
