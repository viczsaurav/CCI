package leetcode;

import java.util.*;

public class BT_LevelOrderTraversal_BFS_P107 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        // Dequeue can be used like levelByLevelTraversalWithDeque in file LevelByLevelTraversal using size concept

        List<List<Integer>> out = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        if (root == null) return out;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                // Level Break
                out.add(0,level);
                level=new ArrayList<>();

                // queue empty means end of tree
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                level.add(node.val);
                if (node.left != null)  queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return out;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(levelOrderBottom(root).toString());
    }
}
