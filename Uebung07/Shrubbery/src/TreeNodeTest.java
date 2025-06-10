public class TreeNodeTest {

    public static void main(String[] args) {
        try {
            TreeNode<Integer> t1 = new TreeNode<Integer>(8);
            TreeNode<Integer> t2 = new TreeNode<Integer>(4);
            TreeNode<Integer> t3 = new TreeNode<Integer>(1);
            TreeNode<Integer> t4 = new TreeNode<Integer>(6);
            TreeNode<Integer> t5 = new TreeNode<Integer>(11);
            TreeNode<Integer> t6 = new TreeNode<Integer>(5);
            TreeNode<Integer> t7 = new TreeNode<Integer>(7);
            t1.setLeft(t2);
            t1.setRight(t3);
            t2.setLeft(t4);
            t2.setRight(t5);
            t3.setLeft(t6);
            t3.setRight(t7);
            System.out.println(t1.toString());
            System.out.println(t2.toString());
            System.out.println(t3.toString());

            t1.inorderTraversal();
            System.out.println("\n");
            t1.preorderTraversal();
            System.out.println("\n");
            t1.postorderTraversal();
            System.out.println("\n");
            t1.levelorderTraversal();
            System.out.println("\n");
            BinaryTree<Integer> b1 = new BinaryTree<Integer>(t1);
            b1.inorder();
            System.out.println("\n");
            b1.preorder();
            System.out.println("\n");
            b1.postorder();
            System.out.println("\n");
            b1.levelorder();
            System.out.println("\n");
            System.out.println(b1.size());
            System.out.println(b1.leaves());
            System.out.println(b1.height());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException detected!");
        }
    }

}