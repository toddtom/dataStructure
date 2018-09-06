package Tree.model;

public class TreeModel {
    private String data;//元素类型
    private TreeModel left;//左子树
    private TreeModel right;//右子树

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TreeModel getLeft() {
        return left;
    }

    public void setLeft(TreeModel left) {
        this.left = left;
    }

    public TreeModel getRight() {
        return right;
    }

    public void setRight(TreeModel right) {
        this.right = right;
    }
}
