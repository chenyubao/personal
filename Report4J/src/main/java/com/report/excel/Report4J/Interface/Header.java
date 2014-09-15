package com.report.excel.Report4J.Interface;

import com.report.excel.Report4J.core.Pos;

public interface Header {

	Pos write(HSSFReport hssfReport, Pos pos);
	
	String getHeaderTitle();
	
	void setHeaderTitle(String title);
	
	void setParentHeader(Header header);
	
	Header getParentHeader();
	
	void addHeaderStyle(String style);
	
	public int getLevel();
	
	void setLevel(int level);

	int getHeight();

	public int caculateHeight(int i);
}
