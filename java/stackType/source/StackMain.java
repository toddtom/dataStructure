package stackType.source;

import stackType.model.StackModel;
import stackType.model.StackType;

import java.util.Scanner;

public class StackMain {
    public static void main(String[] args) {
        StackType st=new StackType();
        StackModel data=new StackModel();
        StackType stack=st.STInit();//初始化栈
        Scanner input=new Scanner(System.in);
        System.out.println("入栈操作:");
        System.out.println("输入姓名 年龄进行入栈操作:");
        do{
            StackModel d=new StackModel();
            d.setName(input.next());
            if(d.getName().equals("0")){
                break;//若输入0，则退出
            }else{
                d.setAge(input.nextInt());
                st.PushST(stack,d);
            }
        }while(true);
        String temp="1";
        System.out.println("出栈操作，按任意非0键进行出栈操作:");
        temp=input.next();
        while (!temp.equals("0")){
            data=st.PopST(stack);
            System.out.println("出栈的数据是:"+data.getName()+","+data.getAge());
            temp=input.next();
        }
        System.out.println("测试结束");
        st.STFree(st);//释放内存
    }
}
