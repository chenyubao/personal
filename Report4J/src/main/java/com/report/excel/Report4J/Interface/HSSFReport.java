package com.report.excel.Report4J.Interface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HSSFReport implements Report {

	public <T> void build(Collection<T> data, DataMapper<T> mapper) {
		if (data != null){
			List<Row<T>> rowList = new ArrayList<Row<T>>();
			for (T t : data){
				Row<T> row = new RowImpl<T>(t);
				mapper.mapData(t, row);
				rowList.add(row);
			}
		}
	}

}
