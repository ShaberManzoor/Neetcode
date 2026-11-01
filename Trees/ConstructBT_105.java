package Trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBT_105 {
    // For storing the val of index in inorder traversal
    Map<Integer, Integer> pos = new HashMap<>();
    private int preInd = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for(int i=0;i<n;i++) {
            pos.put(inorder[i], i);
        }

        return build(preorder, 0, n-1);
    }

    public TreeNode build(int[] preorder, int st, int end) {
        if(st>end) return null;

        int rootVal = preorder[preInd++];
        TreeNode root = new TreeNode(rootVal);

        int mid = pos.get(rootVal);

        root.left = build(preorder, st, mid-1); 
        root.right = build(preorder, mid+1, end);

        return root; 
    }
}
