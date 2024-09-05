package com.Linker_List;

public class double_list {
    public static void main(String[] args){
        DoubleLinkedList doubleLinkedList;
        // 测试新增
        HNode hero1 = new HNode(1, "宋江", "及时雨");
        HNode hero2 = new HNode(2, "卢俊义", "玉麒麟");
        HNode hero3 = new HNode(3, "吴用", "智多星");
        HNode hero4 = new HNode(4, "林冲", "豹子头");
        doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero4);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        System.out.println("更新前");
        doubleLinkedList.print();
        HNode hero4New = new HNode(4, "林冲-修改测试", "豹子头-修改测试");
        doubleLinkedList.update(hero4New);
        System.out.println("更新后");
        doubleLinkedList.print();
        System.out.println("删除前");
        doubleLinkedList.print();
        doubleLinkedList.delete(1);
        doubleLinkedList.delete(4);
        doubleLinkedList.delete(3);
        System.out.println("删除后");
        doubleLinkedList.print();
    }
}

/**
 * 双向链表实现
 */
class DoubleLinkedList{
    private HNode head = new HNode(0,"","");
    /**
     * 添加节点到链表尾部
     */
    public void add(HNode node){
        HNode temp = head;      //保持链表头不变
        while(temp.next!=null){
            temp=temp.next;
        }
        //将节点添加到链表尾
        temp.next=node;
        node.pre=temp;

    }
    /**
     * 更新链表
     */
    public void update(HNode node){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HNode temp=head.next;
        boolean exist = false;
        while(true){
            //如果是链表尾
            if(temp==null){
                break;
            }
            //如果已找到
            if(temp.no==node.no){
                exist=true;
                break;
            }
            temp=temp.next;
        }
        //如果已找到，修改信息
        if(exist){
            temp.name=node.name;
            temp.nickName=node.nickName;
        }else{
            System.out.printf("未找到%d的英雄", node.no);
        }
    }
    /**
     * 删除节点
     */
    public void delete(int no){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HNode cur = head.next;
        boolean exist=false;
        while (true) {
            if (cur == null) {
                break;
            }
            // 找到与自己相同的 id
            if (cur.no == no) {
                exist = true;
                break;
            }
            cur = cur.next;
        }
        if (!exist) {
            System.out.printf("未找到匹配的编号 %d \n", no);
            return;
        }
        // 完成自我删除
        // 这里有一个边界问题：当 cur 是末尾节点的时候，next 为空，不处理
        if (cur.next != null) {
            cur.next.pre = cur.pre;
        }
        cur.pre.next = cur.next;
    }
    /**
     * 打印链表
     */
    public void print() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HNode cur = head.next;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }
}
class HNode{
    public int no;
    public String name;
    public String nickName;
    public HNode next;
    public HNode pre;

    public HNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}