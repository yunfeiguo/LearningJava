package LCA_and_RMQ;

import yunfeiImplementAlgs4.BinaryTreeNode;

/*
 * implementation of Michael Bender and Martin Farach-Colton's algorithm
 */
/*
 * given a binary tree, use O(n) time for precomputing, such that
 * any query for lowest common ancestor of two nodes u and v only 
 * costs O(1) time.
 */
public class LCA {
    /* 
     * first construct an array of Euler tour E[0..2n-1]    
     * then construct an array of representative nodes R[0..n-1] 
     * (first index of a node in Euler tour)
     * then construct an array of levels (distance from root) L[0..2n-1] 
     * for each query (u,v), lowest common ancestor the node whose level is 
     * smallest in L[R[u],R[v]]
     */
    private BinaryTreeNode[] euler;
    private Map<Integer, BinaryTreeNode> euler2node;
    private Map<BinaryTreeNode, Integer> node2representatives;
    private int[] levels;
    private RMQ rmq; //range minimum query object for fast querying
    
    public LCA(BinaryTreeNode root) {
        this.euler = root.EulerTour();
        this.node2representatives = root.getRepresentatives();
        this.levels = root.getLevels();
        this.rmq = new RMQ(this.levels);
    }
    private BinaryTreeNode query(BinaryTreeNode u, BinaryTreeNode v) {
        if (!node2representatives.containsKey(u) || !node2representatives.containsKey(v)) {
            return null;
        }
        int firstU = this.node2representatives.get(u);
        int firstV = this.node2representatives.get(v);
        return euler[rmq.query(firstU, firstV)];        
    }
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(0);
        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(2);
        root.right.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(3);
        root.right.left.right = new BinaryTreeNode(4);
        LCA lca = new LCA(root);
        System.out.println(lca.query(root.left, root.right) == root);
        System.out.println(lca.query(root.left, root) == root);
        System.out.println(lca.query(root.right.left.right, root.right.right) == root.right);
    }
}