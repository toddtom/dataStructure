package quene.resource;

import quene.model.QueneDataModel;
import quene.model.QueneTypeModel;

import java.util.Scanner;

public class QueneMain {
    public static void main(String[] args) {
        QueneTypeModel st=new QueneTypeModel();
        QueneDataModel data;
        Scanner input=new Scanner(System.in);
        QueneTypeModel stack =st.SQTypeInit();
        System.out.println("入队列操作:");
        System.out.println("输入姓名 年龄进行入队列操作:");
        do{
            QueneDataModel d=new QueneDataModel();
            d.setName(input.next());
            if(d.getName().equals("0")){
                break;//若输入0.则退出
            }else{
                d.setAge(input.nextInt());
                st.InSQType(stack,d);
            }
        }while (true);
        String temp="1";
        System.out.println("出队列操作：按任意非0键进行出栈操作：");
        temp=input.next();
        while (!temp.equals("0")){
            data=st.OutSQType(stack);
            System.out.println("出队列的数据是"+data.getName()+","+data.getAge());
            temp=input.next();
        }
        System.out.println("测试结束");
        st.SQTypeFree(stack);
    }
}
