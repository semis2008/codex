package com.codex.controller.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * cookie工具类
 * 
 * @author Yang.Gao
 *
 */
public class CookieUtil {

	/**
	 * 根据制定的key从请求中获取cookie中的值
	 * 
	 * @param request
	 *            原始请求
	 * @param key
	 *            获取的cookie的标识符
	 * @return
	 */
	public static String getCookie(HttpServletRequest request, String key) {
		String result = "";
		if (StringUtils.isEmpty(key) || request == null
				|| request.getCookies() == null
				|| request.getCookies().length == 0) {
			return result;
		}
		for (Cookie cookie : request.getCookies()) {
			if (key.equals(cookie.getName())) {
				result = cookie.getValue();
				break;
			}
		}
		return result;
	}
	
	/**
     * 添加cookie
     * @param name cookie的key
     * @param value cookie的value
     * @param domain domain
     * ＠param  path path 
     * @param maxage  最长存活时间 单位为秒
     * @param response
     */
    public static void addCookie(String name ,String value,String domain,
            int maxage,String path, HttpServletResponse response){
        Cookie cookie = new Cookie(name,value);
        if(domain!=null){
            cookie.setDomain(domain);
        }
        cookie.setMaxAge(maxage);
        cookie.setPath(path);
        response.addCookie(cookie);
    }
     
    /**
     * 往根下面存一个cookie
     * * @param name cookie的key
     * @param value cookie的value
     * @param domain domain
     * @param maxage  最长存活时间 单位为秒
     * @param response
     */
    public static void addCookie(String name ,String value,String domain,
            int maxage, HttpServletResponse response){
        addCookie(name, value,domain, maxage, "/" , response);
    }
    
    public static void removeCookie(String name, String domain, HttpServletRequest request, HttpServletResponse response) {
      String cookieVal = getCookie(request,name);
      if(cookieVal!=null){
          CookieUtil.addCookie(name, null, domain, 0, response);
      }
    }
}
