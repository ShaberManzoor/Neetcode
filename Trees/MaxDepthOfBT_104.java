package Trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxDepthOfBT_104 {
    public int maxDepthDFS(TreeNode root) {
        if(root==null) return 0;

        int leftDepth = 1 + maxDepthDFS(root.left);
        int rightDepth = 1 + maxDepthDFS(root.right);

        return Math.max(leftDepth, rightDepth);
    }

    public int maxDepthBFS(TreeNode root) {
        if(root==null) return 0;

        Queue<TreeNode> q = new ArrayDeque<>();
        int depth = 0;
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            //removing all the nodes at the same level
            for(int i=0;i<size;i++) {
                TreeNode node = q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }

            depth++;
        }

        return depth;
    }
}
