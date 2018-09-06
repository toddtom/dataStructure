package Graph.model;

import java.util.Scanner;

public class GraphType {
    public static Scanner input=new Scanner(System.in);
    //创建邻接矩阵图
    public static void CreateGraph(GraphModel graph){
        int i,j,k;
        int weight;//权
        char eStartV,eEndV;//边的起始顶点
        System.out.println("输入图中各顶点信息(建议输入单字符):");
        for(i=0;i<graph.getVertexNum();i++){
            System.out.println("第"+(i+1)+"个顶点");
            graph.Vertex[i]=(input.next().toCharArray())[0];//保存到各顶点数组元素中
        }
        System.out.println("输入构成各边的顶点及权值:");
        for(k=0;k<graph.getEdgeNum();k++){
            System.out.println("第"+(k+1)+"条边:");
            eStartV=input.next().charAt(0);
            eEndV=input.next().charAt(0);
            weight=input.nextInt();
            for(i=0;eStartV!=graph.Vertex[i];i++);//在已有顶点中查找开始点
            for(j=0;eEndV!=graph.Vertex[j];j++);//在已有顶点中查找终结点
            graph.edgeWeight[i][j]=weight;//对应位置保存权值，表示有一条边
            //若是无向图
            if(graph.getGType()==0){
                graph.edgeWeight[j][i]=weight;//在对角位置保存权值
            }
        }
    }

    //清空图
    public static void ClearGraph(GraphModel graph){
        int i,j;
        //清空矩阵
        for(i=0;i<graph.getVertexNum();i++){
            for(j=0;j<graph.getVertexNum();j++){
                graph.edgeWeight[i][j]=GraphModel.MAXVALUE;//设置矩阵中各元素的值为MAXVALUE
            }
        }
    }

    //输出邻接矩阵
    public static void OutGraph(GraphModel graph){
        int i,j;
        for(j=0;j<graph.getVertexNum();j++){
            System.out.print("\t"+graph.Vertex[j]);//在第一行输出顶点信息
        }
        System.out.println("");
        for(i=0;i<graph.getVertexNum();i++){
            System.out.print(graph.Vertex[i]);
            for(j=0;j<graph.getVertexNum();j++){
                //若权值为最大
                if(graph.edgeWeight[i][j]==GraphModel.MAXVALUE){
                    System.out.print("\tZ");//以Z表示无穷大
                }else{
                    System.out.print("\t"+graph.edgeWeight[i][j]);//输出边的权值
                }
            }
            System.out.println("");
        }
    }

    //从第N个结点开始，深度遍历图
    public static void DeepTraOne(GraphModel graph,int n){
        int i;
        graph.isTrav[n]=1;//标记该顶点已处理
        System.out.println("->"+graph.Vertex[n]);//输出结点数据
        //添加处理结点的操作
        for(i=0;i<graph.getVertexNum();i++){
            if(graph.edgeWeight[n][i]!=GraphModel.MAXVALUE && graph.isTrav[n]==0){
                DeepTraOne(graph,i);//递归遍历
            }
        }
    }

    //深度优先遍历
    public static void DeepTraGraph(GraphModel graph){
        int i;
        //清除各顶点遍历标志
        for(i=0;i<graph.getVertexNum();i++){
            graph.isTrav[i]=0;
        }
        System.out.println("深度优先遍历结点:");
        for(i=0;i<graph.getVertexNum();i++){
            //若该结点未遍历
            if(graph.isTrav[i]==0){
                DeepTraOne(graph,i);//调用函数遍历
            }
        }
        System.out.println("");
    }
}
