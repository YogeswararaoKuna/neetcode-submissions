/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    public int helper(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        left=Math.max(0,left);
        right=Math.max(0,right);
        int ans=left+right+root.val;
        max=Math.max(ans,max);
        return Math.max(left,right)+root.val;
    }
}
