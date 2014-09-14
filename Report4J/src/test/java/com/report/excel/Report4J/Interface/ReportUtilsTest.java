package com.report.excel.Report4J.Interface;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.report.excel.Report4J.Interface.DataMapper;
import com.report.excel.Report4J.Interface.Report;
import com.report.excel.Report4J.Interface.ReportUtils;
import com.report.excel.Report4J.Interface.Row;
import com.report.excel.Report4J.domain.Student;
import com.report.excel.Report4J.model.ReportType;

import junit.framework.TestCase;

public class ReportUtilsTest extends TestCase {
    @Test
    public void testCreateReport(){
    	Report report = ReportUtils.createReport(ReportType.XLS);
    	List<Student> stuList = buildTestStudents();
    	report.build(stuList, new DataMapper<Student>(){

			public void mapData(Student t, Row<Student> row) {
				row.addMapInfo(1, "name")
				   .addMapInfo(2, "major")
				   .addMapInfo(3, "age");
			}
    		
    	});
    }

	private List<Student> buildTestStudents() {
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(new Student("Tom", "software", 21));
		stuList.add(new Student("Jack", "hardware", 20));
		stuList.add(new Student("Leon", "english", 24));
		stuList.add(new Student("Wiki", "design", 22));
		return stuList;
	}
}
