package com.codex.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: Regex
 * @Description: 匹配正则表达式
 * @author chenweina
 * @date 2015年7月8日 下午12:29:07
 * 
 */
public class Regex {

	/**
	 * 验证用户名，待讨论
	 */
	// public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";

	/**
	 * 验证密码
	 */
	public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

	/**
	 * 验证手机号
	 */
	public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

	/**
	 * 验证手机号，支持"XXX-XXXXXXX"、"XXXX-XXXXXXXX"、"XXX-XXXXXXX"、"XXX-XXXXXXXX"、"XXXXXXX"和"XXXXXXXX"
	 */
	public static final String REGEX_PHONE = "^(\\(\\d{3,4}\\)|\\d{3,4}-)?\\d{7,8}$";

	/**
	 * 验证邮箱
	 */
	public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

	/**
	 * 验证汉字
	 */
	public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

	/**
	 * 验证身份证
	 */
	public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

	/**
	 * 验证URL
	 */
	public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

	/**
	 * 验证IP地址
	 */
	public static final String REGEX_IP_ADDR = "(?<=(\\b|\\D))(((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))(?=(\\b|\\D))";

	/**
	 * 验证IP是否是局域网
	 */
	public static final String REGEX_IP_INNER = "(127[.]0[.]0[.]1)|" + "(localhost)|" + "(10[.]\\d{1,3}[.]\\d{1,3}[.]\\d{1,3})|"
			+ "(172[.]((1[6-9])|(2\\d)|(3[01]))[.]\\d{1,3}[.]\\d{1,3})|" + "(192[.]168[.]\\d{1,3}[.]\\d{1,3})";

	public static final String REGEX_NUMBER = "^[0-9]*$";

	/**
	 * @Title: IsMatch
	 * @Description: 判断是否匹配字符串
	 * @param @param content
	 * @param @param regx
	 * @param @return 设定文件
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean IsMatch(String content, String regx) {
		if (null != regx && !"".equals(regx)) {
			Pattern pattern = Pattern.compile(regx);
			Matcher matcher = pattern.matcher(content);
			return matcher.matches();
		} else if (content == regx) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String ip = "ok";// "10.66.2.29";
		System.out.println(IsMatch(ip, REGEX_NUMBER));
	}
}
