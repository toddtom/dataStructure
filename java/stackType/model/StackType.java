package stackType.model;

public class StackType {
    public static final int MAXLEN=50;
    private StackModel[] data=new StackModel[MAXLEN];//数据元素
    private int top;//栈顶

    //初始化栈
    public StackType STInit(){
        StackType p;
        //申请栈内存
        if((p=new StackType())!=null){
            p.top=0;//设置栈顶为0
            return p;//返回指向栈的引用
        }
        return null;
    }

    //判断栈是否为空
    public boolean STIsEmpty(StackType s){
        boolean t;
        t=(s.top==0);
        return t;
    }
    //判断栈是否满
    public boolean STIsFull(StackType s){
        boolean t;
        t=(s.top==MAXLEN-1);
        return t;
    }

    //清空栈
    public void STClear(StackType s){
        s.top=0;
    }

    //释放内存
    public void STFree(StackType s){
        if(s!=null){
            s=null;
        }
    }

    //入栈操作
    public int PushST(StackType s,StackModel data){
        if(s.top>MAXLEN){
            System.out.println("栈溢出");
            return 0;
        }
        s.data[++s.top]=data;//入栈
        return 1;
    }

    //出栈操作
    public StackModel PopST(StackType s){
        if(s.top==0){
            System.out.println("栈为空");
            System.exit(0);
        }
        return s.data[s.top--];
    }

    //读栈顶操作
    StackModel PeekST(StackType s){
        if(s.top==0){
            System.out.println("栈为空");
            System.exit(0);
        }
        return s.data[s.top];
    }

    public StackModel[] getData() {
        return data;
    }

    public void setData(StackModel[] data) {
        this.data = data;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}
