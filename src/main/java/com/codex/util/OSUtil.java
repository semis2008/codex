package com.codex.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class OSUtil {

  /**
   * 判断当前操作是否Windows.
   * 
   * @return true---是Windows操作系统
   */
  public static boolean isWindowsOS() {
    boolean isWindowsOS = false;
    String osName = System.getProperty("os.name");
    if (osName.toLowerCase().indexOf("windows") > -1) {
      isWindowsOS = true;
    }
    return isWindowsOS;
  }

  /**
   * 从request对象中获取客户端的ip地址，不推荐。 获取的ip受网络环境及nginx配置影响
   * 
   * @param request request对象
   * @return 客户端的IP地址
   */
  public static String getIpAddr(HttpServletRequest request) {
    String ip = request.getHeader("elongrealip");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("x-forwarded-for");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknow".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    if (!StringUtils.isBlank(ip) && ip.contains(",")) {// 线上环境，取到的ip如果包含,取第一个
      String[] ips = ip.split(",");
      for (int index = 0; index < ips.length; index++) {
        String strIp = (String) ips[index];
        if (!("unknown".equalsIgnoreCase(strIp))) {
          ip = strIp;
          break;
        }
      }
    }
    return ip;
  }

  /**
   * 获取本机IP地址，并自动区分Windows还是Linux操作系统
   * 
   * @return String
   */
  public static String getLocalIP() {
    String sIP = "";
    InetAddress ip = getInetAdress();

    if (null != ip) {
      sIP = ip.getHostAddress();
    }
    return sIP;
  }

  public static String getLocalName() {
    InetAddress ip = getInetAdress();
    if (ip == null) {
      return "";
    }
    return ip.getHostName();
  }

  public static String getCanonicalHostName() {
    InetAddress ip = getInetAdress();
    if (ip == null) {
      return "";
    }
    return ip.getCanonicalHostName();
  }

  private static InetAddress getInetAdress() {
    InetAddress ip = null;
    try {
      // 如果是Windows操作系统
      if (isWindowsOS()) {
        ip = InetAddress.getLocalHost();
      }
      // 如果是Linux操作系统
      else {
        boolean bFindIP = false;
        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        while (netInterfaces.hasMoreElements()) {
          if (bFindIP) {
            break;
          }
          NetworkInterface ni = netInterfaces.nextElement();
          // ----------特定情况，可以考虑用ni.getName判断
          // 遍历所有ip
          Enumeration<InetAddress> ips = ni.getInetAddresses();
          while (ips.hasMoreElements()) {
            ip = ips.nextElement();
            if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() // 127.开头的都是lookback地址
                && ip.getHostAddress().indexOf(":") == -1) {
              bFindIP = true;
              break;
            }
          }

        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ip;
  }

}
