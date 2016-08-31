package com.codex.controller.util;

import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;

/**
 * UUID生成工具类
 * 
 * @author Yang.Gao
 *
 */
public class UUIDUtil {

	public static String getUUID() {
		UUID uu = UUID.randomUUID();
		return uu.toString();
	}
	
	
	public static void main(String args[]){
	    System.out.println(OSUtil.getLocalName());
	    System.out.println(RandomStringUtils.randomAlphanumeric(8));
	    
	    
	}
}
