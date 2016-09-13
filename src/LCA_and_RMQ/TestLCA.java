package LCA_and_RMQ;

import yunfeiImplementAlgs4.BinaryTreeNode;

public class TestLCA {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {   
            BinaryTreeNode root = new BinaryTreeNode(0);
            LCA lca = new LCA(root);
            System.out.println(lca.query(root.left, root.right) == root);
            System.out.println(lca.query(root.left, root) == root);
            System.out.println(lca.query(root.right.left.right, root.right.right) == root.right);
        }
    }
}
