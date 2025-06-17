import java.util.ArrayList;
import java.util.Stack;

public class SearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    SearchTree() {
        super();
    }
    SearchTree(TreeNode<T> o) {
        super(o);
    }
    public boolean insert(T o) {
        return(insertRecursive(o, super.getRoot()));
    }
    private boolean insertRecursive(T o, TreeNode<T> root) {
        if(root == null) {
            return super.setRoot(new TreeNode<T>(o));
        }
        if(o.compareTo(root.getKey()) < 0) {
            if(root.getLeft() != null) {
                return insertRecursive(o, root.getLeft());
            } else {
                root.setLeft(new TreeNode<T>(o));
                return true;
            }
        }
        if(o.compareTo(root.getKey()) > 0) {
            if(root.getRight() != null) {
                return insertRecursive(o, root.getRight());
            } else {
                root.setRight(new TreeNode<T>(o));
                return true;
            }
        }
        return false;
    }
    public SearchTree<T> reorganize() {
        SearchTree<T> tree = new SearchTree<T>();
        ArrayList<TreeNode<T>> list = super.inorderArrayList();
        while(!list.isEmpty()) {
            int middle = list.size()/2;
            TreeNode<T> a = list.get(middle);
            T b = a.getKey();
            list.remove(middle);
            tree.insert(b);
        }
        return tree;
    }
    public int level(T o) {
        ArrayList<T> list = new ArrayList<T>();
        list = levelFinder(o, list);
        return list.size();
    }
    public ArrayList<T> levelFinder(T o, ArrayList<T> list) {
        T temp = null;
        T a = locateParent(o, getRoot(), temp);
        if(a == getRoot().getKey()) {
            return list;
        }
        list.add(a);
        return levelFinder(a, list);
    }
    public TreeNode<T> findParent(T x) {
        T temp = null;
        return search(locateParent(x, getRoot(), temp));
    }
    private T locateParent(T x, TreeNode<T> root, T parent) {
        if(root == null) {
            return null;
        }
        if(root.getKey() == x) {
            return parent;
        }
        T left = locateParent(x, root.getLeft(), root.getKey());
        if(left != null) { 
            return left;
        }
        T right = locateParent(x, root.getRight(), root.getKey());
        return right;
    }
    public boolean delete(T key) {
        TreeNode<T> a = search(key);
        TreeNode<T> h = a;
        if(a == null) {
            return false;
        }
        System.out.println(a);
        System.out.println(getRoot());
        TreeNode<T> prev = findParent(key);
        if(a.equals(getRoot())) {    //if a is root
            h = a.getLeft();
            while(h.getRight() != null) {   //traverse
                h = h.getRight();
            }
            TreeNode<T> hprev = findParent(h.getKey());
            if(h.getLeft() != null) {
                hprev.setRight(h.getLeft());
            } else {
                hprev.setRight(null);
            }
            h.setRight(a.getRight());
            h.setLeft(a.getLeft());
            setRoot(h);
            return true;
        }
        if(a.getLeft() == null && a.getRight() == null) {   //no child nodes
            if(prev.getLeft().getKey() == a.getKey()) {     //is a to the left or the right?
                prev.setLeft(h); 
                return true;
            } else {
                prev.setRight(h);
                return true;
            }
        }
        if((a.getLeft() == null && a.getRight() != null) || (a.getLeft() != null && a.getRight() == null)) {    //one child node
            if(prev.getLeft().getKey() == a.getKey()) {     //is a to the left or the right?
                if(a.getLeft() != null) {
                    prev.setLeft(a.getLeft());
                } else {
                    prev.setLeft(a.getRight());
                } 
                return true;
            } else {
                if(a.getLeft() != null) {
                    prev.setRight(a.getLeft());
                } else {
                    prev.setRight(a.getRight());
                } 
                return true;
            }
        }
        //two child nodes
        while(h.getRight() != null) {
            h = h.getRight();
        }
        TreeNode<T> hprev = findParent(h.getKey());
        if(h.getLeft() != null) {
            hprev.setRight(h.getLeft());
        }
        h.setRight(a.getRight());
        h.setLeft(a.getLeft());
        if(prev.getLeft().getKey() == a.getKey()) { //is a to the left or the right?
            prev.setLeft(h); 
            return true;
        } else {
            prev.setRight(h);
            return true;
        }
    }
}


