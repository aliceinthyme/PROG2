import java.util.*;

public class TreeNode<T> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T key;

    public TreeNode(T key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public T getKey() {
        return key;
    }

    public void setLeft(TreeNode<T> l) {
        this.left = l;
    }

    public void setRight(TreeNode<T> r) {
        this.right = r;
    }

    public void setKey(T o) {
        this.key = o;
    }

    @Override
    public String toString() {
        String temp1 = "null";
        String temp2 = "null";
        if (this.left != null) {
            temp1 = " LeftNode= " + left.getKey();
        }
        if (this.right != null) {
            temp2 = " RightNode= " + right.getKey();
        }
        return "Key=" + this.getKey() + temp1 + temp2;
    }

    public void inorderTraversal() {
        if (left != null) {
            left.inorderTraversal();
        }
        System.out.print(this.getKey() + " ");
        if (right != null) {
            right.inorderTraversal();
        }
    }

    public void preorderTraversal() {
        System.out.print(this.getKey() + " ");
        if (left != null) {
            left.preorderTraversal();
        }
        if (right != null) {
            right.preorderTraversal();
        }
    }

    public void postorderTraversal() {
        if (left != null) {
            left.postorderTraversal();
        }
        if (right != null) {
            right.postorderTraversal();
        }
        System.out.print(this.getKey() + " ");
    }

    public void levelorderTraversal() {
        ArrayList<TreeNode<T>> t1 = new ArrayList<TreeNode<T>>();
        t1.add(this);
        while (!t1.isEmpty()) {
            TreeNode<T> cur = t1.getFirst();
            t1.removeFirst();
            System.out.print(cur.getKey() + " ");
            if (cur.getLeft() != null) {
                t1.add(cur.getLeft());
            }
            if (cur.getRight() != null) {
                t1.add(cur.getRight());
            }
        }
    }

    public int getSize() {
        return calcSize(0);
    }
    private int calcSize(int a) {
        a++;
        if (left != null) {
            a = left.calcSize(a);     
        }
        if (right != null) {
            a = right.calcSize(a);   
        }
        return a;
    }
    public int getLeaves() {
        return calcLeaves(0);
    }
    private int calcLeaves(int a) {
        if(left == null && right == null) {
            a++;
        }
        if (left != null) {
            a = left.calcLeaves(a);     
        }
        if (right != null) {
            a = right.calcLeaves(a);   
        }
        return a;
    }
    public int getHeight() {
        return calcHeight(1);
    }
    //this is probably not correct, but I really am not sure how to do it better rn?
    private int calcHeight(int a) {
        if(left != null && right != null) {
            a++;
        }
        if (left != null) {
            a = left.calcHeight(a);     
        }
        if (right != null) {
            a = right.calcHeight(a);   
        }
        return a;
    }
}