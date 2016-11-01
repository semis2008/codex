package com.codex.test;

/**
 * Created by ningwang4 on 16/10/24.
 * 递归和非递归算法实现n!
 */
public class TestN {

    //递归
    public int factorial(int m) {
        if (m < 0)
            return 0;
        else if (m == 1)
            return 1;
        else
            return m * factorial(m--);
    }

    //非递归
    public int factorial2(int m) {
        if (m < 0)
            return 0;
        else if (m == 1)
            return 1;
        else {
            int sum = 1;
            for (int i = 2; i <= m; i++)
                sum = sum * i;
            return sum;

        }
    }
}
