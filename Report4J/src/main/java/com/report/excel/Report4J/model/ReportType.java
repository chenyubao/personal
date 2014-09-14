package com.report.excel.Report4J.model;

public enum ReportType {
    XLS(0), XLSX(1);
    
    private Integer type;
    
    private ReportType(Integer type){
    	this.type = type;
    }

	@Override
	public String toString() {
		return String.valueOf(this.type);
	}
    
    
}
