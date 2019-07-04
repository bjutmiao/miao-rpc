package com.miao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixw3
 * @create 2019-07-04 16:34
 */

/*
 * push的操作都在 stack1中，pop的操作都在 stack2
 */
public class StacksQueue {

    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    /*
     *  push之前 先判断 stack2是否为空
     *  若不为空，把stack2中的数据先pop，在push到stack1，直到stack2为空
     *  然后push到stack1
     */
    void push(int i){
        while (stack2.getLength()>0){
            stack1.push(stack2.pop());
        }
        stack1.push(i);
    }

    /*
     * pop之前 把stack1中的数据 全部移到stack2
     * 先判断stack1是否为空
     * 若不为空 把stack1中数据先pop 在push到stack2
     * 然后stack2 pop数据
     */
    Integer pop(){
        while (stack1.getLength()>0){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StacksQueue ssq = new StacksQueue();
        ssq.push(1);
        ssq.push(2);
        ssq.push(3);
        System.out.println(ssq.pop());
        ssq.push(4);
        ssq.push(5);
        System.out.println(ssq.pop());
        System.out.println(ssq.pop());
        System.out.println(ssq.pop());
    }
}


class Stack {
    List<Integer> list = new ArrayList<>();

    int getLength(){
        return this.list.size();
    }
    void push(int i){
        list.add(i);
    }

    Integer pop(){
        return list.size()> 0 ? list.remove(list.size()-1) : null;
    }
}
