package com.codex.util;

import java.util.ResourceBundle;

/**
 * Provides configurations.
 * @author Jishi Liang
 * @version 1.0.0.0
 */
public class Configuration {

	private String resourceKey;
	private ResourceBundle resources;
	
	/**
	 * Initializes a new instance of the com.elong.hotel.common.util.Configuration.
	 */
	public Configuration() {
		this(null);
	}
	/**
	 * Initializes a new instance of the com.elong.hotel.common.util.Configuration with the configuration file resource key.
	 * @param resourceKey A java.lang.String indicating the key of the configuration resource file.
	 */
	public Configuration(String resourceKey) {
		this.setResourceKey(resourceKey);
	}
	/**
	 * Gets the key of the configuration resource file.
	 * @return A java.lang.String indicating the key of the configuration resource file.
	 */
	public String getResourceKey() {
		return this.resourceKey;
	}
	/**
	 * Sets the key of the configuration resource file.
	 * @param resourceKey A java.lang.String indicating the key of the configuration resource file.
	 */
	public void setResourceKey(String resourceKey) {
		if (resourceKey == null) {
			this.resourceKey = "";
			this.resources = null;
		}
		else {
			this.resourceKey = resourceKey;
			this.resources = ResourceBundle.getBundle(this.resourceKey);
		}
	}
	/**
	 * Gets the string value of the configuration..
	 * @param name A java.lang.String indicating the name of the configuration.
	 * @return A java.lang.String indicating the string value of the configuration.
	 */
	private String getString(String name) {
		ResourceBundle bundle = this.resources;
		if (bundle == null) {
			return null;
		}
		else {
			return bundle.getString(name);
		}
	}
	/**
	 * Gets the string value of the configuration.
	 * @param name A java.lang.String indicating the name of the configuration.
	 * @param defaultValue A java.lang.String indicating the default value used when the configuration does not exist.
	 * @return A java.lang.String indicating the string value of the configuration.
	 */
	public String get(String name, String defaultValue) {
		String str = this.getString(name);
		if (str == null) {
			return defaultValue;
		}
		else {
			return str;
		}
	}
	
	public int get(String name, int defaultValue) {
		String str = this.getString(name);
		if (str == null) {
			return defaultValue;
		}
		else {
			return Integer.parseInt(str);
		}
	}
	
	public short get(String name, short defaultValue) {
		String str = this.getString(name);
		if (str == null) {
			return defaultValue;
		}
		else {
			return Short.parseShort(str);
		}
	}
	
	public long get(String name, long defaultValue) {
		String str = this.getString(name);
		if (str == null) {
			return defaultValue;
		}
		else {
			return Long.parseLong(str);
		}
	}
	
	public byte get(String name, byte defaultValue) {
		String str = this.getString(name);
		if (str == null) {
			return defaultValue;
		}
		else {
			return Byte.parseByte(str);
		}
	}
	
	public double get(String name, double defaultValue) {
		String str = this.getString(name);
		if (str == null) {
			return defaultValue;
		}
		else {
			return Double.parseDouble(str);
		}
	}
	
	public float get(String name, float defaultValue) {
		String str = this.getString(name);
		if (str == null) {
			return defaultValue;
		}
		else {
			return Float.parseFloat(str);
		}
	}
	
	public boolean get(String name, boolean defaultValue) {
		String str = this.getString(name);
		if (str == null) {
			return defaultValue;
		}
		else {
			return Boolean.parseBoolean(str);
		}
	}
}
