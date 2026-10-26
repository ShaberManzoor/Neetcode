package Trees;

public class GoodNodes_1448 {
    int count = 0;
    public int goodNodes(TreeNode root) {
        solve(root, Integer.MIN_VALUE);
        return count;
    }

    //max represents the maximum value while reaching the node
    public void solve(TreeNode node, int max) {
        if(node.val>=max) count++;

        max = Math.max(node.val, max);
        if(node.left!=null) solve(node.left, max);
        if(node.right!=null) solve(node.right, max);
    }
}
