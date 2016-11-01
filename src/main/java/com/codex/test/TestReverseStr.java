package com.codex.test;

/**
 * Created by ningwang4 on 16/10/26.
 * <p/>
 * 英文句子倒序 what are you doing   -->  doing you are what
 */
public class TestReverseStr {

    public static void main(String args[]) {
        String str = "much. very you love I";
        System.out.println(reverse(str));
    }

    public static String reverse(String s) {
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                pos = 0;
            else
                pos++;
            sb.insert(pos, c);
        }
        return sb.toString() ;
    }
}
