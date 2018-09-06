package Graph.resource;

import Graph.model.GraphModel;
import Graph.model.GraphType;

import java.util.Scanner;

public class GraphMain {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        GraphModel graph=new GraphModel();//定义保存邻接表结构的图
        System.out.println("输入生成图的类型(0:无向图,1:有向图):");
        graph.setGType(input.nextInt());//图的种类
        System.out.println("输入图的顶点数量:");
        graph.setVertexNum(input.nextInt());//图的顶点数
        System.out.println("输入图的边数量:");
        graph.setEdgeNum(input.nextInt());
        GraphType.ClearGraph(graph);//清空图
        GraphType.CreateGraph(graph);//生成邻接表结构的图
        System.out.println("该图的邻接矩阵数据如下:");
        GraphType.OutGraph(graph);//输出邻接矩阵
        GraphType.DeepTraGraph(graph);//深度优先遍历
    }

}
