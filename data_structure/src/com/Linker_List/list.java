package com.Linker_List;
import java.util.LinkedList;
import java.util.Arrays;
public class list {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        //初始化时赋值
        LinkedList<Integer> lis = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        //增加元素
        list.add(10);
        list.add(20);
        //在头部添加
        list.addFirst(5);
        //在指定位置添加
        list.add(1,15); //在索引1处插入15
        //删除元素
        //删除头部元素
        list.removeFirst();
        //尾部
        list.removeLast();
        //删除指定位置
        list.remove(1);
        //修改元素
        //修改指定位置
        list.set(1,25);
        //查找元素
        //获取头部元素
        int first= list.getFirst();
        //尾部
        int last=list.getLast();
        //获取指定位置
        int elem = list.get(1);
        //判断链表是否为空
        boolean isEmpty=list.isEmpty();
        //获取长度
        int size = list.size();

    }
}
