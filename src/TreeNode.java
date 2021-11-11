/**
 * Node class to be used by MorseCodeTree
 * @author Randall Kim
 * @param <T> data stored in each node
 */
public class TreeNode<T> {
    private T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    /**
     * Constructs a TreeNode with data
     * @param dataNode data to be put into the node
     */
    public TreeNode(T dataNode){
        data = dataNode;
    }

    /**
     * Constructs a TreeNode that is a copy
     * @param node node to be copied
     */
    public TreeNode(TreeNode<T> node){
        data = node.getData();
    }

    /**
     * Returns the data in the node
     * @return data in the node
     */
    public T getData(){
        return data;
    }
}
