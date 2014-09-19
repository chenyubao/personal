package com.report.excel.Report4J.core;

import java.util.List;

import com.report.excel.Report4J.Interface.HSSFReport;
import com.report.excel.Report4J.Interface.Header;

public class HeaderImpl implements Header {
	
	private Header parent = null;
	
	private String title;
	
	private List<String> styleList;
	
	private Pos pos;
	
	private boolean isChild;
	
	private List<Header> childList = null;
	
	private int level = 0;

	public HeaderImpl(String title) {
		this(title, true, null);
	}
	
	public HeaderImpl(String title, boolean isChild, Header parent){
		this.isChild = isChild;
		this.title = title;
		this.parent = parent;
		if (parent != null){
			level = parent.getLevel() + 1;
		}
	}

	public HeaderImpl(String colName, List<String> headStyle) {
	}

	public Pos write(HSSFReport hssfReport, Pos pos) {
		if (parent != null){
			parent.write(hssfReport, pos);
		} else {
			
		}
		return null;
	}

	public String getHeaderTitle() {
		return null;
	}

	public void setHeaderTitle(String title) {
		
	}

	public void setParentHeader(Header header) {
		
	}

	public Header getParentHeader() {
		return null;
	}

	public void addHeaderStyle(String style) {
		
	}

	public Header getParent() {
		return parent;
	}

	public void setParent(Header parent) {
		this.parent = parent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getStyleList() {
		return styleList;
	}

	public void setStyleList(List<String> styleList) {
		this.styleList = styleList;
	}

	public Pos getPos() {
		return pos;
	}

	public void setPos(Pos pos) {
		this.pos = pos;
	}

	public boolean isChild() {
		return isChild;
	}

	public void setChild(boolean isChild) {
		this.isChild = isChild;
	}

	public List<Header> getChildList() {
		return childList;
	}

	public void setChildList(List<Header> childList) {
		this.childList = childList;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHeight() {
		if (childList != null){
			return caculateHeight(0);
		}
		return 0;
	}

	public int caculateHeight(int i) {
		if (childList != null){
			int max = 0;
			for (Header header : childList){
				int height = header.caculateHeight(++i);
				if (height > max){
					max = height;
				}
			}
			return max;
		} else {
			return i;
		}
	}
	
	

}
