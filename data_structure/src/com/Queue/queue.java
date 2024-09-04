package com.Queue;



public class queue {
    public static void main(String[] args){
        ArrayQueue queue = new ArrayQueue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("查看队列中的数据");
        queue.show();
        System.out.println("查看队头数据："+ queue.head());
        System.out.println("查看队尾数据："+ queue.tail());
        System.out.println("获取队列数据："+ queue.get());
        System.out.println("查看队列数据");
        queue.show();
    }
}
class ArrayQueue{
    private int maxSize;    //队列最大容量
    private int front;      //队列头，指向队列头的前一个位置
    private int rear;       //队列尾，指向队列尾的数据
    private int arr[];      //用于存储数据，模拟队列

    public ArrayQueue(int arrMaxSize){
        //构造函数
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=-1;
        rear=-1;
    }
    /*
    取出队列数据
     */
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("队列空");
        }
        return arr[++front];
    }
    /*
    往队列中存数据
     */
    public void add(int n){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        arr[++rear]=n;
    }
    /**
     * 显示队列中的数据
     */
    public void show(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d] = %d \n",i,arr[i]);
        }
    }
    /**
     * 查看队列的头部数据，只查看，不取出
     */
    public int head(){
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return arr[front+1];        //front指向队列头前一个元素，取头要加1

    }
    /**
     * 查看队尾数据
     */
    public int tail(){
        if(isEmpty()){
            throw new RuntimeException("队列空");
        }
        return arr[rear];
    }
    /**
     * 队列是否已满
     */
    private boolean isFull(){
        return rear == maxSize-1;
    }
    /**
     * 队列是否为空
     */
    private boolean isEmpty(){
        return rear==front;
    }
}