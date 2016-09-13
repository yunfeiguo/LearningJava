package yunfeiImplementAlgs4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import edu.princeton.cs.algs4.In;

public class BinaryTreeNode {
    public BinaryTreeNode left;
    public BinaryTreeNode right;    
    public int key;
    public BinaryTreeNode(Integer key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }        
    /**
     * 
     * @param root
     * @return
     */
    public BinaryTreeNode[] EulerTour(BinaryTreeNode root) {
        return new BinaryTreeNode[0];
    }
    /**
     * output levels (distance from root) in Euler tour order
     * @return
     */
    public int[] getLevels(BinaryTreeNode root, BinaryTreeNode[] euler) {
        return new int[0];
    }
    /**
     * output leveles (distance from root) in Euler tour order
     * Euler tour will be calculated on the fly
     * @param root
     * @return
     */
    public int[] getLevels(BinaryTreeNode root) {
        return getLevels(root, EulerTour(root));
    }
    /**
     * take root of a binary tree and serialize it into text
     * @param root
     * @return
     */
    public static String serialize(BinaryTreeNode root) {
        StringBuilder sb = new StringBuilder();
        java.util.Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            BinaryTreeNode top = queue.poll();
            if(top == null){
                sb.append("#,");
            }
            else{
                sb.append(top.key + ",");
                queue.offer(top.left);
                queue.offer(top.right);
            }
        }
        
        return removeTrailingNulls(sb.toString());
    }
    /**
     * remove trailing # signs and commas 
     */
    private static String removeTrailingNulls(String s) {
        int newLength = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#' || s.charAt(i) == ',') {
                newLength = i;
            } else {
                break;
            }
        }
        return s.substring(0, newLength);
    }
    // Decodes your encoded data to tree.
    public static BinaryTreeNode deserialize(String data) {
        if(data.isEmpty() || data.charAt(0) == '#'){
            return null;
        }

        String[] arr = data.split(",");
        int idx = 0;

        BinaryTreeNode root = new BinaryTreeNode(Integer.valueOf(arr[0]));
        java.util.Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            BinaryTreeNode top = queue.poll();
            if(top == null){
                continue;
            }

            if (idx < arr.length - 1 && !arr[++idx].equals("#")) {
                top.left = new BinaryTreeNode(Integer.valueOf(arr[idx]));
            }
            if (idx < arr.length - 1 && !arr[++idx].equals("#")) {
                top.right = new BinaryTreeNode(Integer.valueOf(arr[idx]));
            }            
            queue.offer(top.left);
            queue.offer(top.right);
        }

        return root;
    }
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("processing " + args[i]);
            In in = new In(args[i]);
            System.out.println(serialize(deserialize(in.readAll().trim())));   
        }        
        System.out.println(serialize(deserialize("1,2,3")));
        System.out.println(serialize(deserialize("1,2,#,3,#")));
    }
}
