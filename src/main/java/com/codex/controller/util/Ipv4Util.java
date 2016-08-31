/**
 * @Package com.elong.hotel.ebk.security.allopatry.utils
 * @Description: TODO
 * Copyright: Copyright (c) 2015 
 * Email: wenji.wang@corp.elong.com
 * 
 * @author wenji.wang
 * @date 2015年10月21日 下午5:43:09
 * @version V1.0
 */
package com.codex.controller.util;

public class Ipv4Util {

	/**
	 * 将字符串型ip转成uint型ip
	 * @param strIp
	 * @return
	 */
	public static long Ip2Long(String strIp) {
		String[] ss = strIp.split("\\.");
		if (ss.length != 4) {
			return 0;
		}
		byte[] bytes = new byte[ss.length];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(ss[i]);
		}
		return bytesToUint(bytes);
	}

	/**
	 * 
	 * 将uint型ip转成字符串型
	 *
	 * @param longIp
	 * @return
	 */
	public static String uint2Ip(long longIp) {
		byte[] bytes = longToBytes(longIp);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			sb.append(bytes[i] & 0xFF);
			if (i < 3) {
				sb.append(".");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String ip1 = "192.168.0.1";
		long intIp2 = Ip2Long(ip1);
		System.out.println(intIp2);
	}

	/**
	 * 
	 * 将long型转为byte数组
	 *
	 * @param n
	 * @return
	 */
	@SuppressWarnings("unused")
	private static byte[] longToBytes(long n) {
		byte[] b = new byte[8];
		b[7] = (byte) (n & 0xff);
		b[6] = (byte) (n >> 8 & 0xff);
		b[5] = (byte) (n >> 16 & 0xff);
		b[4] = (byte) (n >> 24 & 0xff);
		b[3] = (byte) (n >> 32 & 0xff);
		b[2] = (byte) (n >> 40 & 0xff);
		b[1] = (byte) (n >> 48 & 0xff);
		b[0] = (byte) (n >> 56 & 0xff);
		return b;
	}

	/**
	 * 
	 * byte字节数组转long
	 *
	 * @param array
	 * @return
	 */
	@SuppressWarnings("unused")
	private static long bytesToLong(byte[] array) {
		return ((((long) array[0] & 0xff) << 56) | (((long) array[1] & 0xff) << 48) | (((long) array[2] & 0xff) << 40)
				| (((long) array[3] & 0xff) << 32) | (((long) array[4] & 0xff) << 24) | (((long) array[5] & 0xff) << 16)
				| (((long) array[6] & 0xff) << 8) | (((long) array[7] & 0xff) << 0));
	}

	/**
	 * 
	 * int转byte数组
	 *
	 * @param n
	 * @return
	 */
	@SuppressWarnings("unused")
	private static byte[] intToBytes(int n) {
		byte[] b = new byte[4];
		b[3] = (byte) (n & 0xff);
		b[2] = (byte) (n >> 8 & 0xff);
		b[1] = (byte) (n >> 16 & 0xff);
		b[0] = (byte) (n >> 24 & 0xff);
		return b;
	}

	/**
	 * 
	 * byte数组转int
	 *
	 * @param b
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int bytesToInt(byte b[]) {
		return b[3] & 0xff | (b[2] & 0xff) << 8 | (b[1] & 0xff) << 16 | (b[0] & 0xff) << 24;
	}

	/**
	 * 
	 * uint转byte数组
	 *
	 * @param n
	 * @return
	 */
	@SuppressWarnings("unused")
	private static byte[] uintToBytes(long n) {
		byte[] b = new byte[4];
		b[3] = (byte) (n & 0xff);
		b[2] = (byte) (n >> 8 & 0xff);
		b[1] = (byte) (n >> 16 & 0xff);
		b[0] = (byte) (n >> 24 & 0xff);
		return b;
	}

	/**
	 * 
	 * byte数组转无符号整型
	 *
	 * @param array
	 * @return
	 */
	@SuppressWarnings("unused")
	private static long bytesToUint(byte[] array) {
		return ((long) (array[3] & 0xff)) | ((long) (array[2] & 0xff)) << 8 | ((long) (array[1] & 0xff)) << 16
				| ((long) (array[0] & 0xff)) << 24;
	}

	/**
	 * 
	 * short转byte数组
	 *
	 * @param n
	 * @return
	 */
	@SuppressWarnings("unused")
	private static byte[] shortToBytes(short n) {
		byte[] b = new byte[2];
		b[1] = (byte) (n & 0xff);
		b[0] = (byte) ((n >> 8) & 0xff);
		return b;
	}

	/**
	 * 
	 * byte数组转short
	 *
	 * @param b
	 * @return
	 */
	@SuppressWarnings("unused")
	private static short bytesToShort(byte[] b) {
		return (short) (b[1] & 0xff | (b[0] & 0xff) << 8);
	}

	/**
	 * 
	 * 无符号short转byte数组
	 *
	 * @param n
	 * @return
	 */
	@SuppressWarnings("unused")
	private static byte[] ushortToBytes(int n) {
		byte[] b = new byte[2];
		b[1] = (byte) (n & 0xff);
		b[0] = (byte) ((n >> 8) & 0xff);
		return b;
	}

	/**
	 * 
	 * byte数组转无符号short
	 *
	 * @param b
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int bytesToUshort(byte b[]) {
		return b[1] & 0xff | (b[0] & 0xff) << 8;
	}

	/**
	 * 
	 * 无符号byte转byte数组
	 *
	 * @param n
	 * @return
	 */
	@SuppressWarnings("unused")
	private static byte[] ubyteToBytes(int n) {
		byte[] b = new byte[1];
		b[0] = (byte) (n & 0xff);
		return b;
	}

	/**
	 * 
	 * byte数组转无符号byte
	 *
	 * @param array
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int bytesToUbyte(byte[] array) {
		return array[0] & 0xff;
	}

}
