package chainList.source;

import chainList.model.ChainListModel;
import chainList.model.DataModel;

import java.util.Scanner;

public class ChainListMain {
    public static void main(String[] args) {
        ChainListModel node,head=null;
        ChainListModel CL=new ChainListModel();
        String key,findKey;
        Scanner input=new Scanner(System.in);
        System.out.println("链表测试，先输入链表中的数据，格式为：关键字，姓名，年龄");
        do{
            DataModel nodeData=new DataModel();
            nodeData.setKey(input.next());
            if(nodeData.getKey().equals("0")){
                break;//若输入0，则退出
            }else{
                nodeData.setName(input.next());
                nodeData.setAge(input.nextInt());
                head=CL.CLAddEnd(head,nodeData);//在链表尾部添加结点
            }
        }while (true);
        CL.CLAllNode(head);//显示所有结点
        System.out.println("演示插入结点，输入插入位置的关键字：");
        findKey=input.next();//输入插入位置关键字
        System.out.println("输入插入结点的数据(关键字 姓名 年龄)");
        DataModel nodeData=new DataModel();
        nodeData.setKey(input.next());
        nodeData.setName(input.next());
        nodeData.setAge(input.nextInt());
        head= CL.CLInsertNode(head,findKey,nodeData);
        CL.CLAllNode(head);

        System.out.println("演示删除结点，输入要删除的关键字:");
        key=input.next();//输入删除结点关键字
        CL.CLDeleteNode(head,key);
        CL.CLAllNode(head);

        System.out.println("演示在链表中查找，输入查找关键字:");
        key=input.next();//输入查找关键字
        node= CL.CLFindNode(head,key);
        if(node!=null){
            nodeData=node.getNodeData();
            System.out.println("关键字"+key+"对应的结点为"+nodeData.getKey()+","+nodeData.getName()
                    +","+nodeData.getAge());
        }else{
            System.out.println("在链表中未找到关键字为"+key+"的结点");
        }
    }
}
