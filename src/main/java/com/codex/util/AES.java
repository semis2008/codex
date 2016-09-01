package com.codex.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加解密算法(使用Base64做转码以及辅助加密)
 *
 */
public class AES {

    private static byte[] iv = { 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8 };

    /**
     * 
     * 加密
     *
     * 
     * 
     * @param encryptString
     * 
     * @param encryptKey 密钥
     * 
     * @return
     * 
     * @throws Exception
     * 
     */

    public static String encryptAES(String encryptString, String encryptKey) throws Exception {

        IvParameterSpec zeroIv = new IvParameterSpec(iv);

        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "AES");

        // 算法/模式/补码方式

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);

        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());

        return Base64Util.encode(encryptedData);

    }

    /**
     * 
     * 解密
     *
     * 
     * 
     * @param decryptString
     * 
     * @param decryptKey 密钥
     * 
     * @return
     * 
     * @throws Exception
     * 
     */

    public static String decryptAES(String decryptString, String decryptKey) throws Exception {

        byte[] byteMi = Base64Util.decode(decryptString);

        IvParameterSpec zeroIv = new IvParameterSpec(iv);

        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);

        byte decryptedData[] = cipher.doFinal(byteMi);

        return new String(decryptedData);

    }
    
    public static void main(String args[]) throws Exception{
        String content="dfdsfsafsafasfsafafa";
        String pwd="1234561234561234";
        System.out.println(encryptAES(content, pwd));
    }
}
