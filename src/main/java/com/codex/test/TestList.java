package com.codex.test;

import java.util.*;

/**
 * Created by ningwang4 on 16/10/24.
 */
public class TestList {

    public void testAZ() {
        //初始化
        List<String> stringList = new LinkedList<String>();
        //添加a-z
        for(int i=0;i<26;i++) {
            char c = (char)(97+i);
            stringList.add(String.valueOf(c));
        }
        //打印
        printList(stringList,"排序前");
        //倒序
        reverse(stringList);
        //打印
        printList(stringList,"排序后");
    }

    private void printList(List list,String msg) {
        StringBuilder sb = new StringBuilder(64);
        for(Object obj:list) {
            sb.append(obj.toString()+",");
        }
        System.out.println(msg+sb.toString());
    }


    public static void reverse(List<?> list) {
        int size = list.size();
        if (size < 18 || list instanceof RandomAccess) {//数据量较小,或者支持快速随机访问的,一般是指数据结构为array,使用下标直接交换位置即可
            for (int i=0, mid=size>>1, j=size-1; i<mid; i++, j--)
                swap(list, i, j);
        } else {//数据结构基于链表的,如LinkedList,使用迭代器比较快
            ListIterator fwd = list.listIterator();
            ListIterator rev = list.listIterator(size);
            for (int i=0, mid=list.size()>>1; i<mid; i++) {
                Object tmp = fwd.next();
                fwd.set(rev.previous());
                rev.set(tmp);
            }
        }
    }

    public static void swap(List<?> list, int i, int j) {
        final List l = list;
        l.set(i, l.set(j, l.get(i)));
    }

    public static void main(String args[]) {
        TestList testList = new TestList();
        testList.testAZ();
    }

}
