package com.Linker_List;

public class linked {
    public static void main(String[] args){
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleList = new SingleLinkedList();
//        singleList.add(hero1);
//        singleList.add(hero4);
//        singleList.add(hero2);
//        singleList.add(hero3);
        singleList.addByOrder(hero1);
        singleList.addByOrder(hero4);  // 添加顺序提前
        singleList.addByOrder(hero2);
        singleList.addByOrder(hero3);
        singleList.list();
    }

}
/**
 * 单项链表
 */
class SingleLinkedList{
    //  头节点，不保存数据，只作为一个起点
    private HeroNode head = new HeroNode(0,"","");
    /**
     * 添加节点
     * 不考虑编号，只将新加入的节点放在链表最后
     */
    public void add(HeroNode node){
        //  遍历到next为null时，才进行添加
        HeroNode temp = head;
        while(true){
            //  找到链表的最后，就推出循环
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next = node;
    }
    public void addByOrder(HeroNode node){
        //  head变量保持不动
        HeroNode temp=head;
        boolean exist=false;    //  添加的节点是否已经存在
        while(true){
            if(temp.next==null){
                //  如果到链表尾，跳出循环
                break;
            }
            // 如果当前节点的 next 编号，大于目标节点编号，则找到
            // 应该将目标节点添加到  temp 与 next 之间
            if(temp.next.no>node.no){
                break;
            }
            // 如果他们相等，则表示链表中已经存在目标节点了
            if(temp.next.no ==node.no){
                exist = true;
                break;
            }
            //  没找到，继续后移
            temp=temp.next;
        }
        if(exist){
            System.out.printf("准备插入的英雄编号%d已存在，不能加入！\n",node.no);
            return;
        }
        node.next=temp.next;
        temp.next=node;
    }
    /**
     * 打印链表中的数据
     */
    public void list(){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

/**
 * 定义链表节点
 */
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName){
        this.no=no;
        this.name=name;
        this.nickName=nickName;

    }

    @Override
    public String toString() {
        return "HeroNode{"+
                "no="+no+
                ", name='" + name +'\''+
                ", nickName='" + nickName+'\''+
                '}';
    }
}
