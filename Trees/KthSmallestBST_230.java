package Trees;

public class KthSmallestBST_230 {
    int count = 0;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    public void inorder(TreeNode node, int k) {
        if(node==null) return;

        inorder(node.left, k);

        count++;
        if(count==k) {
            ans = node.val;
            return;
        }
        inorder(node.right, k);
    }
}
