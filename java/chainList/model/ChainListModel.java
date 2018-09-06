package chainList.model;

public class ChainListModel {
    private DataModel nodeData=new DataModel();
    private ChainListModel nextNode;
    //追加结点
    public ChainListModel CLAddEnd(ChainListModel head,DataModel nodeData){
        ChainListModel node,htemp;
        if((node=new ChainListModel())==null){
            System.out.println("申请内存失败");
            return null;
        }else{
            node.nodeData=nodeData;//保存数据
            node.nextNode=null;//设置结点引用为空，即表尾
            if(head==null){
                head=node;
                return head;
            }
            htemp=head;
            //查找链表末尾
            while (htemp.nextNode!=null){
                htemp=htemp.nextNode;
            }
            htemp.nextNode=node;
            return head;
        }
    }
    //在链表头部添加结点
    public ChainListModel CLAddFirst(ChainListModel head,DataModel nodeData){
        ChainListModel node;
        if((node=new ChainListModel())==null){
            System.out.println("申请内存失败");
            return null;
        }else{
            node.nodeData=nodeData;
            node.nextNode=head;//指向头引用所指结点
            head=node;//头引用指向新增结点
            return head;
        }
    }
    //查找结点
    public ChainListModel CLFindNode(ChainListModel head,String key){
        ChainListModel htemp;
        htemp=head;//保存头部引用
        //若结点有效，则进行查找
        while (htemp!=null){
            //若结点关键字与传入关键字相同
            if(htemp.nodeData.getKey().compareTo(key)==0){
                return htemp;//返回该结点引用
            }
            htemp=htemp.nextNode;//处理下一结点
        }
        return null;//若没有找到，返回空
    }
    //插入结点
    public ChainListModel CLInsertNode(ChainListModel head,String findKey,DataModel nodeData){
        ChainListModel node,nodetemp;
        if((node=new ChainListModel())==null){
            System.out.println("申请内存失败");
            return null;
        }
        node.nodeData=nodeData;//保存结点中的数据
        nodetemp=CLFindNode(head,findKey);
        //若找到要插入的结点
        if(nodetemp!=null){
            node.nextNode=nodetemp.nextNode;//新插入的结点指向关键结点的下一结点
            nodetemp.nextNode=node;//设置关键结点指向新插入结点
        }else{
            System.out.println("未找到正确的插入位置");
            //free(node);//释放内存
        }
        return head;//返回头引用
    }
    //删除结点
    public int CLDeleteNode(ChainListModel head,String key){
        ChainListModel node,htemp;//node保存删除结点的前一结点
        htemp=head;
        node=head;
        while (htemp!=null){
            if(htemp.nodeData.getKey().compareTo(key)==0){
                node.nextNode=htemp.nextNode;//使前一结点指向当前结点的下一结点
                //free(htemp);//释放内存
                return 1;
            }else{
                node=htemp;//指向当前结点
                htemp=htemp.nextNode;//指向下一结点
            }
        }
        return 0;//未删除
    }
    //计算链表长度
    public int CLLength(ChainListModel head){
        ChainListModel htemp;
        int len=0;
        htemp=head;
        //遍历链表
        while (htemp!=null){
            len++;//累加结点数量
            htemp=htemp.nextNode;//处理下一结点
        }
        return len;
    }
    //遍历链表
    public void CLAllNode(ChainListModel head){
        ChainListModel htemp;
        DataModel nodeData;
        htemp=head;
        System.out.println("当前链表共有"+CLLength(head)+"个结点，链表数据结构如下：");
        //循环处理链表每个结点
        while (htemp!=null){
            nodeData=htemp.nodeData;
            System.out.println("结点("+nodeData.getKey()+","+nodeData.getName()+","+nodeData.getAge()+")");
            htemp=htemp.nextNode;
        }
    }

    public DataModel getNodeData() {
        return nodeData;
    }

    public void setNodeData(DataModel nodeData) {
        this.nodeData = nodeData;
    }

    public ChainListModel getNextNode() {
        return nextNode;
    }

    public void setNextNode(ChainListModel nextNode) {
        this.nextNode = nextNode;
    }
}
