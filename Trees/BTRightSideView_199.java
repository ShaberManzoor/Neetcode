package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BTRightSideView_199 {
    // DFS Approach
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        solve(root, res, 0);

        return res;
    }

    public void solve(TreeNode root, List<Integer> res, int currDepth) {
        if(root==null) return;

        if(res.size()==currDepth) res.add(root.val);

        solve(root.right, res, currDepth+1);
        solve(root.left, res, currDepth+1);
    }

    // BFS Approach
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode node = new TreeNode(0);
            for(int i=0;i<size;i++) {
                node = q.poll();

                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }

            res.add(node.val);
        }

        return res;
    }
}
