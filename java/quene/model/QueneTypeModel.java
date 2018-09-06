package quene.model;

public class QueneTypeModel {
    public static final int QUENELEN=15;
    private QueneDataModel[] data=new QueneDataModel[QUENELEN];
    private int head;//队头
    private int tail;//队尾

    public QueneTypeModel SQTypeInit() {
        QueneTypeModel q;
        //申请内存
        if ((q = new QueneTypeModel()) != null) {
            q.head = 0;
            q.tail = 0;
            return q;
        } else {
            return null;
        }
    }

    //判断空队列
    public int SQTypeIsEmpty(QueneTypeModel q){
        int temp=0;
        if(q.head==q.tail){
            temp=1;
        }
        return temp;
    }

    //判断满队列
    public int SQTypeIsFull(QueneTypeModel q){
        int temp=0;
        if(q.tail==QUENELEN){
            temp=1;
        }
        return temp;
    }

    //清空队列
    public void SQTypeClear(QueneTypeModel q){
        q.head=0;
        q.tail=0;
    }

    //释放队列
    public void SQTypeFree(QueneTypeModel q){
        if(q!=null){
            q=null;
        }
    }

    //入队列
    public int InSQType(QueneTypeModel q,QueneDataModel data){
        if(q.tail==QUENELEN){
            System.out.println("队列已满，入队列失败");
            return 0;
        }else{
            q.data[q.tail++]=data;//入队列
            return 1;
        }
    }

    //出队列
    public QueneDataModel OutSQType(QueneTypeModel q){
        if(q.head==q.tail){
            System.out.println("队列为空，操作失败");
            System.exit(0);
        }else{
            return q.data[q.head++];
        }
        return null;
    }

    //读结点数据
    public QueneDataModel PeekSQType(QueneTypeModel q){
        if(SQTypeIsEmpty(q)==1){
            System.out.println("空队列");
            return null;
        }else{
            return q.data[q.head];
        }
    }

    //计算队列长度
    public int SQTypeLen(QueneTypeModel q){
        return q.tail-q.head;
    }
}
