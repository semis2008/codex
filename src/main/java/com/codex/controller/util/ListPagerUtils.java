package com.codex.controller.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

public class ListPagerUtils {
	/** 
	 * 当前页码 
	 */  
	private int currentPage;  
	/** 
	 * 总页数 
	 */  
	private int totalPage;  
	/** 
	 * 总行数 
	 */  
	private int totalRows;  
	/** 
	 * 每页显示条数 
	 */  
	private int avgRows = 5;  
	/** 
	 * 原集合 
	 */  
	private List<Object> list;  
	public static void main(String[] args) {
		List<Object> lists = new ArrayList<Object>();
		for (int i=1;i<=95;i++) {
			lists.add(i);
		}
		System.out.println(ArrayUtils.toString(getPagerList(10, 10, lists)));
	}
	public ListPagerUtils() {  
		super();  
	}  


	public static List<Object> getPagerList(int currentPage, int avgRows, List<Object> list) {  
		List<Object> newList = new ArrayList<Object>();  
		for(int i = (currentPage - 1) * avgRows; i < list.size() && i < currentPage * avgRows; i++) {  
			newList.add(list.get(i));  
		}  
		return newList;  
	}  

}
