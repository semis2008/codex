package com.codex.controller.util;

import java.util.Random;


public class PasswordGenerator {
	
	private static char[] charPool =  {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k','l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w','x', 'y', 'z',
									'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
									'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K','L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W','X', 'Y', 'Z'};

	/**
	 * 生成随即密码
	 * 
	 * @param passwordLength
	 *            生成的密码的总长度
	 * @return 密码的字符串
	 */
	public static String generate(int passwordLength) {
		// 35是因为数组是从0开始的，26个字母+10个数字
		final int maxNum = 62;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		
		StringBuffer pwd = new StringBuffer("");
		
		Random r = new Random();
		
		while (count < passwordLength) {
			// 生成随机数，取绝对值，防止生成负数，

			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

			if (i >= 0 && i < charPool.length) {
				pwd.append(charPool[i]);
				count++;
			}
		}

		return pwd.toString();
	}
	
	public static void main(String[] args){
		String password = PasswordGenerator.generate(6);
		System.out.print(password);
	}

}
