package com.codex.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @Description: 采用SHAA加密
 * Email: zhanping.li@corp.elong.com
 * @author zhanpingli
 * @date Feb 1, 2016 2:38:02 PM
 * @version V1.0
 */
public class SHAUtil {

    /***
     * SHA加密 生成40位SHA码
     * 
     * @param inStr 待加密字符串
     * @return 返回40位SHA码
     */
    public static String shaEncode(String inStr) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
    
    public static final String ALGORITHM = "SHA-256";

    public static String SHA256Encrypt(String orignal) { 
        MessageDigest md = null; 
        try { 
            md = MessageDigest.getInstance(ALGORITHM); 
        } catch (NoSuchAlgorithmException e) { 
            e.printStackTrace(); 
        } 
        if (null != md) { 
            byte[] origBytes = orignal.getBytes(); 
            md.update(origBytes); 
            byte[] digestRes = md.digest(); 
            String digestStr = getDigestStr(digestRes); 
            return digestStr; 
        }

        return null; 
    }

    private static String getDigestStr(byte[] origBytes) { 
        String tempStr = null; 
        StringBuilder stb = new StringBuilder(); 
        for (int i = 0; i < origBytes.length; i++) { 
            tempStr = Integer.toHexString(origBytes[i] & 0xff); 
            if (tempStr.length() == 1) { 
                stb.append("0"); 
            } 
            stb.append(tempStr);

        } 
        return stb.toString(); 
    }

    /**
     * 测试主函数
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        String str = new String("amigoxiexiexingxing");
        System.out.println("原始：" + str);
        System.out.println("SHA后：" + shaEncode(str));
        
        System.out.println("SHA后：" + SHA256Encrypt(str));
    }
}
