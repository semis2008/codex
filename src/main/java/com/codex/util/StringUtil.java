package com.codex.util;

/**
 * Created by SEELE on 2016/9/2.
 */
public class StringUtil {

    public static Boolean isEmpty(String str) {
        if(str==null||str.isEmpty()) {
            return true;
        }
        return false;

    }
}
