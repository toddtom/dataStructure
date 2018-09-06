package Tree.source;

import Tree.model.TreeModel;
import Tree.model.TreeType;

import java.util.Scanner;

public class TreeMain {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        TreeModel root=null;//root为指向二叉树根结点的引用
        int menusel;
        TreeType t=new TreeType();
        root=t.InitTree();//设置根元素
        //添加结点
        do{
            System.out.println("请选择菜单添加二叉树的结点");
            System.out.println("0.退出");
            System.out.println("1.添加二叉树的结点");
            menusel=input.nextInt();
            switch (menusel){
                case 1:
                    t.AddTreeNode(root);
                    break;
                case 0:
                    break;
            }
        }while (menusel!=0);
        //遍历
        do{
            System.out.println("请选择菜单遍历二叉树，输入0表示退出:");
            System.out.print("1.前序遍历\t");
            System.out.println("2.中序遍历");
            System.out.print("3.后序遍历\t");
            System.out.println("4.按层遍历");
            menusel=input.nextInt();
            switch (menusel){
                case 0:
                    break;
                case 1:
                    System.out.println("前序遍历DLR的结果：");
                    t.DLRTree(root);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("中序遍历LDR的结果：");
                    t.LDRTree(root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("后序遍历LRD的结果：");
                    t.LRDTree(root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("按层遍历的结果：");
                    t.LevelTree(root);
                    System.out.println();
                    break;
            }
        }while (menusel!=0);
        System.out.println("二叉树的深度为"+t.TreeDepth(root));
        t.ClearTree(root);
        root=null;
    }
}
