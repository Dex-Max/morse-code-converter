import java.util.ArrayList;

/**
 * Tree that contains letters to convert morse code to English
 * @author Randall Kim
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
    private TreeNode<String> root;

    /**
     * Constructs a MorseCodeTree
     */
    public MorseCodeTree(){
        buildTree();
    }

    /**
     * Returns the root of the tree
     * @return the root of the tree
     */
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * Sets the root of the tree
     * @param newNode a TreeNode<T> that will be the new root
     */
    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = newNode;
    }

    /**
     * Inserts a String into the tree with a code
     * @param code the code for the new node to be added
     * @param result String to be added
     * @return reference to the current tree
     */
    @Override
    public LinkedConverterTreeInterface<String> insert(String code, String result) {
        addNode(root, code, result);
        return this;
    }

    /**
     * Recursive method to add a node into the tree
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of addNode
     * @param letter the data of the new TreeNode to be added
     */
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
        if(code.charAt(0) == '.'){
            if(root.left == null){
                root.left = new TreeNode<String>(letter);
            } else {
                addNode(root.left, code.substring(1), letter);
            }
        } else {
            if(root.right == null){
                root.right = new TreeNode<String>(letter);
            } else {
                addNode(root.right, code.substring(1), letter);
            }
        }
    }

    /**
     * Gets a node from the tree
     * @param code the code that describes the traversals within the tree
     * @return the String that the node contains
     */
    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    /**
     * Recursive method to get a node from the tree
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of fetchNode
     * @return String that the node contains
     */
    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        if(code.length() == 0){
            return root.getData();
        }

        if(code.charAt(0) == '.'){
            return fetchNode(root.left, code.substring(1));
        } else {
            return fetchNode(root.right, code.substring(1));
        }
    }

    /**
     * Delete a node from the tree
     * @param data data of node to be deleted
     * @return reference to the current tree
     * @throws UnsupportedOperationException
     */
    @Override
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Can not delete from this tree");
    }

    /**
     * Update a node on the tree
     * @return reference to the current tree
     * @throws UnsupportedOperationException
     */
    @Override
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Can not update this tree");
    }

    /**
     * Builds the tree with letters and corresponding morse codes
     */
    @Override
    public void buildTree() {
        String[] lettersByLevel = new String[]{"e", "t", "i", "a", "n", "m", "s", "u", "r", "w", "d", "k", "g", "o", "h", "v", "f", null, "l", null, "p", "j", "b", "x", "c", "y", "z", "q"};
        root = new TreeNode<>("");
        insert(".", "e");
        insert("-", "t");
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
    }

    /**
     * Converts the tree to an ArrayList
     * @return an ArrayList with values in all of the nodes
     */
    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);

        return list;
    }

    /**
     * Traverses the tree in order and adds to a list
     * @param root the root of the tree for this particular recursive instance
     * @param list the ArrayList that will hold the contents of the tree in LNR order
     */
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if(root == null){
            return;
        }

        LNRoutputTraversal(root.left, list);
        list.add(root.getData());
        LNRoutputTraversal(root.right, list);
    }
}
