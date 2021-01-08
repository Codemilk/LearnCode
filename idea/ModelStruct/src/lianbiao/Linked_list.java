package lianbiao;

public class Linked_list {

    public static void main(String[] args) {
        //测试
        //先创建节点
        HeroNode heroNode = new HeroNode(1, "a", "a1");
        HeroNode heroNode1 = new HeroNode(2, "b", "b2");
        HeroNode heroNode2 = new HeroNode(3, "c", "c3");
        HeroNode heroNode3 = new HeroNode(4, "d", "d4");

        //加入
         SingleLinkedList singleLinkedList=new SingleLinkedList();
         singleLinkedList.addhreO(heroNode);
         singleLinkedList.addhreO(heroNode1);
         singleLinkedList.addhreO(heroNode2);
         singleLinkedList.addhreO(heroNode3);

         HeroNode newhr=new HeroNode(2, "xx", "xx");



        singleLinkedList.update(newhr);
        singleLinkedList.delete(1);
        //显示
        singleLinkedList.printList();
    }

}

//定义linkedList 管理我们的英雄

class SingleLinkedList {
    //先初始化一个头节点
    private HeroNode head=new HeroNode(0, "", "");

    //添加节点到单项链表，不考虑编号顺序
    public void add(HeroNode heroNode){
        //1.找到当前链表的最后节点
        //因为head节点不能动，因此我们需要一个辅助temp
       HeroNode temp=head;
        //遍历链表

        while(true){
            if(temp.next==null){
                //说明这是一个空节点
                break;
            }
              temp=temp.next;
        }

        //退出这个循环的时候 说明找到了
        temp.next=heroNode;
    }
    //删除
    public void delete(int no){
        HeroNode temp=head;
        boolean flag=false;
        while(true){

             if(temp.next==null){
                 System.out.println("啥都没有");
                 break;
             }


            if(temp.next.no==no){
                //找到了
                flag=true;
                break;
            }

            temp=temp.next;

        }

        if(flag){
            //说明找到了
            temp.next=temp.next.next;

        }else{
            System.out.println("找不到");
        }

    }





    //添加
    public void addhreO(HeroNode heroNode){
        //因为头节点不可以动，还要找前一个节点
      HeroNode temp=head;
      boolean flag=false;

      while (true){

       if(temp.next==null){

              break;

            }else if(temp.next.no>heroNode.no){ //位置就找到了

               break;

            }else if(temp.next.no==heroNode.no){
               //说明已经存在了
               System.out.println("已经存在了");
               flag=true;

               break;
        }
          temp=temp.next;
 }

        if(flag){
            System.out.println("已存在不可以加入");
        }else {

            heroNode.next=temp.next;
            temp.next=heroNode;


        }
    }

    //显示链表
    public void printList(){

        if(head.next==null){
            System.out.println("啥都没有");
            return;
        }
       HeroNode temp=head.next;
        while(true){
            if(temp==null){
                break;
            }

            System.out.println(temp);
            temp=temp.next;
        }
    }

    //修改节点信息，根据编号来修改
    public void update(HeroNode  newHeroNode){
        //判断是否为空
        if(head.next==null){
            System.out.println("kontg");
        }

        //找到要修改的节点，根据no编号
        HeroNode temp=head.next;
        boolean flag=false;

        while(true){
            if(temp==null){
                break;//已经遍历完成

            }
            if(temp.no==newHeroNode.no){//找到了

                flag=true;
                break;

            }
            temp=temp.next;
        }
        if(flag){
            temp.name=newHeroNode.name;
            temp.nickName=newHeroNode.nickName;

        }else
        {
            System.out.println("没找到");
        }

    }
}





