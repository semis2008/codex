package com.codex.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ningwang4 on 16/10/24.
 * 基于链表实现的栈
 */
public class MyQueueStack {

    String val;
    List<String> stackList = new LinkedList<String>();


    void push(String val) {
        stackList.add(val);

    }

    String pop() {
        if(stackList.size()==0) {
            return null;
        }
        return stackList.remove(stackList.size()-1);
    }

}
