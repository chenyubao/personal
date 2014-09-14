package com.report.excel.Report4J.util;

import java.lang.reflect.Field;

public class CommonUtils {

	public static boolean checkFieldExist(String fieldName, Class<? extends Object> clazz) {
		Field [] fields = clazz.getFields();
		for (Field field : fields) {
			if (field.getName().equals(fieldName)){
				return true;
			}
		}
		return false;
	}

}
