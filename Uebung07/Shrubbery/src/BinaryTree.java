public class BinaryTree<T> {
    private TreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(TreeNode<T> o) {
        this.root = o;
    }

    public TreeNode<T> getRoot() {
        return root;
    }
    

    public void setRoot(TreeNode<T> r) {
        this.root = r;
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    public void inorder() {
        TreeNode<T> t = getRoot();
        t.inorderTraversal();
    }

    public void preorder() {
        TreeNode<T> t = getRoot();
        t.preorderTraversal();
    }

    public void postorder() {
        TreeNode<T> t = getRoot();
        t.postorderTraversal();
    }

    public void levelorder() {
        TreeNode<T> t = getRoot();
        t.levelorderTraversal();
    }
    public int size() {
        TreeNode<T> t = getRoot();
        return t.getSize();
    }
    public int leaves() {
        TreeNode<T> t = getRoot();
        return t.getLeaves();
    }
    public int height() {
        TreeNode<T> t = getRoot();
        return t.getHeight();
    }
    public boolean insert(TreeNode<T> ti) {
        TreeNode<T> t = getRoot();
        do {
            if((int)t.getKey() > (int)ti.getKey()) {
                if(t.getLeft() != null) {
                    t = t.getLeft();
                } else {
                    t.setLeft(ti);
                    return true;
                }
            }
            System.out.println(t);
            if((int)t.getKey() < (int)ti.getKey()) {
                if(t.getRight() != null) {
                    t = t.getRight();
                } else {
                    t.setRight(ti);
                    return true;
                }
            }
            if ((int)t.getKey() == (int)ti.getKey()) {
                return false;   //duplicate entry
            }
        } while(true);
    }
}