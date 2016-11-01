package com.codex.test;

/**
 * Created by ningwang4 on 16/10/24.
 * 基于数组实现栈
 */
public class MyArrayStack {  //定义一个堆栈类

    int[] array;             //用int数组来保存数据，根据需要可以换类型
    int s_size;              //定义堆栈的宽度

    public MyArrayStack(int i) {    //定义一个带参数构造器
        array = new int[i];         //动态定义数组的长度
        s_size = 0;                     //堆栈的默认宽度为0
    }

    public MyArrayStack() {          //默认构造器
        this(50);                     //默认构造器可容纳50个元素
    }

    public void push(int i) { //压栈
        array[this.s_size] = i;
        this.s_size++;
    }

    public int pop() {     //从堆栈中取元素，从栈顶开始取
        if (this.s_size != 0) {
            int t = array[s_size - 1];        //用中间变量保存栈顶的元素
            array[s_size - 1] = 0;              //取完元素该位置设为0
            s_size--;                            //栈的大小减1
            return t;                             //返回栈顶元素
        } else {
            System.out.println("This stack is empty");    //当栈为空时显示提示信息，返回0
            return 0;
        }
    }

    public boolean isEmpty() {                   //判断栈是否为空
        return this.s_size == 0;
    }

    public int top() {                                 //从栈顶取值，功能和 pop() 方法一样
        if (!this.isEmpty()) {
            int t = array[this.s_size - 1];
            array[this.s_size - 1] = 0;
            this.s_size--;
            return t;
        } else {
            System.out.println("This stack is empty!");
            return 0;
        }
    }

    public void printAll() {                 //打印出堆栈中的所有元素的值，不是取出，元素依然在堆栈里
        if (!this.isEmpty()) {
            for (int i = this.s_size - 1; i >= 0; i--) {
                System.out.println(array[i]);
            }
        }
    }


    //下面是测试代码
    public static void main(String[] args) {
        MyArrayStack stack = new MyArrayStack();
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        //System.out.println(stack.isEmpty());
        stack.printAll();
        System.out.println("===========");
        System.out.println(stack.top());
        System.out.println(stack.top());
        System.out.println(stack.top());
        System.out.println(stack.top());
        System.out.println(stack.top());
    }
}
