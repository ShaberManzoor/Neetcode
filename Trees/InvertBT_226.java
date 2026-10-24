package Trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class InvertBT_226 {
    public TreeNode invertTreeDFS(TreeNode root) {
        if(root==null) return root;

        TreeNode left = root.left, right = root.right;
        
        root.left = invertTreeDFS(right);
        root.right = invertTreeDFS(left);

        return root;
    }

    public TreeNode invertTreeBFS(TreeNode root) {
        if(root==null) return root;

        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);

        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            TreeNode left = node.left;

            node.left = node.right;
            node.right = left;

            if(node.left!=null) st.push(node.left);
            if(node.right!=null) st.push(node.right);
        }

        return root;
    }
}
