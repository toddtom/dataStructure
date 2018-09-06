package Tree.model;

import java.util.Scanner;

public class TreeType {
    public static final int MAXLEN=20;
    Scanner input=new Scanner(System.in);
    //初始化二叉树的根
    public TreeModel InitTree(){
        TreeModel node;
        if((node=new TreeModel())!=null){
            System.out.println("请先输入一个根结点数据:");
            node.setData(input.next());
            node.setLeft(null);
            node.setRight(null);
            if(node!=null)//如果二叉树根结点不为空
            {
                return node;
            }else{
                return null;
            }
        }
        return null;
    }

    //添加结点
    public void AddTreeNode(TreeModel treeNode){
        TreeModel pnode,parent;
        String data;
        int menusel;
        if((pnode=new TreeModel())!=null){
            System.out.println("输入二叉树结点数据:");
            pnode.setData(input.next());
            pnode.setLeft(null);
            pnode.setRight(null);//设置左右子树为空
            System.out.println("输入该父结点数据:");
            data=input.next();
            parent=TreeFindNode(treeNode,data);// 查找指定数据的结点
            if(parent==null){
                System.out.println("未找到该父结点");
                pnode=null;//释放内存
                return;
            }
            System.out.println("1.添加该结点到左子树\n2.添加该结点到右子树");
            do{
                menusel=input.nextInt();//输入选择项
                if(menusel==1||menusel==2){
                    if(parent==null){
                        System.out.println("不存在父结点，请先设置父结点");
                    }else{
                        switch (menusel){
                            case 1://添加到左结点
                                if(parent.getLeft()!=null){
                                    System.out.println("左子树结点不为空");
                                }else{
                                    parent.setLeft(pnode);
                                }
                            break;
                            case 2://添加到右结点
                                if(parent.getRight()!=null){
                                    System.out.println("右子树结点不为空");
                                }else{
                                    parent.setRight(pnode);
                                }
                            break;
                            default:
                                System.out.println("无效参数");
                        }
                    }
                }
            }while(menusel!=1 && menusel!=2);
        }
    }

    //查找结点
    public TreeModel TreeFindNode(TreeModel treeNode,String data){
        TreeModel tree;
        if(treeNode==null){
            return null;
        }else{
            if(treeNode.getData().equals(data)){
                return treeNode;
            }else{
                //分别向左右子树递归查找
                if((tree=TreeFindNode(treeNode.getLeft(),data))!=null){
                    return tree;
                }else if((tree=TreeFindNode(treeNode.getRight(),data))!=null){
                    return tree;
                }else{
                    return null;
                }
            }
        }
    }

    //获取左子树
    public TreeModel TreeLeftNode(TreeModel treeNode){
        if(treeNode!=null){
            return treeNode.getLeft();
        }else{
            return null;
        }
    }

    //获取右子树
    public TreeModel TreeRightNode(TreeModel treeNode){
        if(treeNode!=null){
            return treeNode.getRight();
        }else{
            return null;
        }
    }

    //判断空树
    public int TreeIsEmpty(TreeModel treeNode){
        if(treeNode!=null){
            return 0;
        }else{
            return  1;
        }
    }

    //计算二叉树的深度
    public int TreeDepth(TreeModel treeNode){
        int depleft,depright;
        if(treeNode==null){
            return 0;//对于空树，深度为0
        }else{
            depleft=TreeDepth(treeNode.getLeft());//左子树深度，递归调用
            depright=TreeDepth(treeNode.getRight());//右子树深度，递归调用
            if(depleft>depright){
                return depleft+1;
            }else{
                return depright+1;
            }
        }
    }

    //清空二叉树
    public void ClearTree(TreeModel treeNode){
        if(treeNode!=null){
            ClearTree(treeNode.getLeft());//清空左子树
            ClearTree(treeNode.getRight());//清空右子树
            treeNode=null;//释放当前结点内存
        }
    }

    //显示结点数据
    public void TreeNodeData(TreeModel treeNode){
        System.out.println(treeNode.getData());
    }

    //按层遍历
    public void LevelTree(TreeModel treeNode){
        TreeModel treeModel;
        TreeModel[] trees=new TreeModel[MAXLEN];//定义一个顺序栈
        int head=0,tail=0;
        //如果队首引用不为空
        if(treeNode!=null){
            tail=(tail+1)%MAXLEN;//计算循环队列队尾序号
            trees[tail]=treeNode;//将二叉树根引用进队
        }
        //队列不为空进行循环
        while (head!=tail){
            head=(head+1)%MAXLEN;//计算循环队列的队首序号
            treeModel=trees[head];//获取队首元素
            TreeNodeData(treeModel);//处理队首元素
            //如果结点存在左子树
            if(treeModel.getLeft()!=null){
                tail=(tail+1)%MAXLEN;//计算循环队列的队尾序号
                trees[tail]=treeModel.getLeft();//将左子树引用进队
            }
            //如果结点存在右子树
            if(treeModel.getRight()!=null){
                tail=(tail+1)%MAXLEN;//计算循环队列的队尾序号
                trees[tail]=treeModel.getRight();//将右子树引用进队
            }
        }
    }

    //前序遍历
    public void DLRTree(TreeModel treeNode){
        if(treeNode!=null){
            TreeNodeData(treeNode);
            DLRTree(treeNode.getLeft());
            DLRTree(treeNode.getRight());
        }
    }

    //中序遍历
    public void LDRTree(TreeModel treeNode){
        if(treeNode!=null){
            DLRTree(treeNode.getLeft());
            TreeNodeData(treeNode);
            DLRTree(treeNode.getRight());
        }
    }

    //后序遍历
    public void LRDTree(TreeModel treeNode){
        if(treeNode!=null){
            DLRTree(treeNode.getLeft());
            DLRTree(treeNode.getRight());
            TreeNodeData(treeNode);
        }
    }
}
