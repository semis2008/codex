/**   
 * @(#)ConfigurationUtil.java	2015年4月24日	下午4:35:29	   
 *     
 * Copyrights (C) 2015艺龙旅行网保留所有权利
 */
package com.codex.controller.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 读取配置文件工具类
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2015年4月24日 下午4:35:29   wenji.wang     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		wenji.wang
 * @version		1.0  
 * @since		JDK1.7
 */
public class ConfigurationUtil {
	private ResourceBundle bundle;

	public ResourceBundle getBundle() {
		return bundle;
	}

	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	public ConfigurationUtil(String fileName) {
		setBundle(ResourceBundle.getBundle(fileName));
	}

	public String getStringConfig(String key) {
		return this.getBundle().getString(key).trim();
	}

	public Integer getIntegerConfig(String key) {
		return Integer.valueOf(this.getBundle().getString(key));
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		// 遍历文件夹路径
		String filePath = "/Users/user/Desktop/properties";
		// 获取所有文件名
		List<String> fileList = getFiles(filePath);
		// 遍历所有properties文件
		for (String fileName : fileList) {
			Properties properties = new Properties();
			properties.load(new FileInputStream(fileName));
			Enumeration enumeration = properties.propertyNames();
			while (enumeration.hasMoreElements()) {
				String key = (String) enumeration.nextElement();
				properties.setProperty(key, "$$" + key);
			}
			// 输出
			properties.store(new FileOutputStream(fileName), "修改时间：" + new Date());
		}
	}

	/**
	 * 
	 * 递归查找根目录下所有文件
	 *
	 * @param path
	 * @return
	 */
	private static List<String> getFiles(String path) {
		List<String> fileList = new ArrayList<String>();
		File root = new File(path);
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getFiles(file.getAbsolutePath());
			} else {
				fileList.add(file.getAbsolutePath());
			}
		}
		return fileList;
	}

}
