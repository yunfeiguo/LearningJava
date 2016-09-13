package LCA_and_RMQ;

import yunfeiImplementAlgs4.BinaryTreeNode;

/*
 * recursive method for LCA problem
 */
public class LinearithmicLCA {
    /**
     * given root and p, q in the tree, find lowest common ancestor of p and q
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static BinaryTreeNode findLCA(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        BinaryTreeNode leftAncestor = findLCA(root.left, p, q);
        BinaryTreeNode rightAncestor = findLCA(root.right, p, q);
        if (leftAncestor == null) {
            return rightAncestor;
        } else if (rightAncestor == null){
            return leftAncestor;
        } else {
            return root;
        }
    }
}
