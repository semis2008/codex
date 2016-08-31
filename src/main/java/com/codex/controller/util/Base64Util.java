package com.codex.controller.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
public class Base64Util {
 
 
    /**
     * 将二进制数据编码为BASE64字符串
     * @param binaryData
     * @return
     */
    public static String encode(byte[] binaryData) {
        try {
            return new String(Base64.encodeBase64(binaryData,true), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
    
    public static String encodeStr(String data){
    	if(StringUtils.isEmpty(data)){
    		return "";
    	}
    	return encode(data.getBytes());
    }
     
    /**
     * 将BASE64字符串恢复为二进制数据
     * @param base64String
     * @return
     */
    public static byte[] decode(String base64String) {
        try {
            return Base64.decodeBase64(base64String.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
    
    public static String decodeStr(String data){
    	if(StringUtils.isEmpty(data)){
    		return "";
    	}
    	return new String(decode(data)); 
    }
    
    public static void main(String args[]){
    	String aaa = "张帆";
    	System.out.println(encodeStr(aaa));
    	
    	
    	
    }
 
}
