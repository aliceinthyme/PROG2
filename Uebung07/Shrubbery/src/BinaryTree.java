import java.util.ArrayList;
import java.util.Stack;

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
    

    public boolean setRoot(TreeNode<T> r) {
        this.root = r;
        return true;
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
    public boolean insert(TreeNode<T> ti) { //only works for Integer keys so far!
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
    public ArrayList<TreeNode<T>> inorderArrayList() {
        ArrayList<TreeNode<T>> list = new ArrayList<TreeNode<T>>();
        Stack<TreeNode<T>> hold = new Stack<>();
        TreeNode<T> cur = this.getRoot();
        while(cur != null || !hold.isEmpty()) {
            while(cur != null) {
                if(cur != null) {
                    hold.push(cur);
                    cur = cur.getLeft();
                }
            }
            assert cur == null;
            cur = hold.pop();
            list.add(cur);
            cur = cur.getRight();
        }
        return list;
    }
    public TreeNode<T> search(T key) {
        Stack<TreeNode<T>> hold = new Stack<>();
        TreeNode<T> cur = this.getRoot();
        while(cur != null || !hold.isEmpty()) {
            while(cur != null) {
                if(cur != null) {
                    hold.push(cur);
                    cur = cur.getLeft();
                }
            }
            assert cur == null;
            cur = hold.pop();
            if(cur.getKey() == key) {
                return cur;
            }
            cur = cur.getRight();
        }
        return null;
    }
}