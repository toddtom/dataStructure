package Graph.model;

public class GraphModel {
    public static final int MAXNUM=20;//最大顶点数
    public static final int MAXVALUE=65535;//保存邻接矩阵中的特殊符号的最大值
    public char[] Vertex=new char[MAXNUM];//保存顶点信息(序号或者字母)
    private int GType;//图的类型(0:无向图,1:有向图)
    private int vertexNum;//顶点数量
    private int edgeNum;//边的数量
    public int[][] edgeWeight=new int[MAXNUM][MAXNUM];//保存边的权
    public int[] isTrav=new int[MAXNUM];//遍历标志

    public int getGType() {
        return GType;
    }

    public void setGType(int GType) {
        this.GType = GType;
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    public void setEdgeNum(int edgeNum) {
        this.edgeNum = edgeNum;
    }

}
