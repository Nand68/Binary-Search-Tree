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
    public TreeNode deleteNode(TreeNode root, int key) {
        //Search the node to delete
        if (root == null) {
            return null; // Base case: tree is empty
        }
        //Find node in left subtree
        if(key<root.val){
            root.left = deleteNode(root.left, key);
        }
        //Find node in right subtree
        else if(key>root.val){
            root.right = deleteNode(root.right, key);
        }
        else{
            //Check all Cases
            //CASE1: LEAF NODE 
            if(root.left == null && root.right==null){
                return null;
            }
            //CASE2: 1 CHILD
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            //CASE 3: 2 CHILDERN
            TreeNode IS = findInorder(root.right);
            root.val = IS.val;
            root.right= deleteNode(root.right, IS.val);
            
        }
        return root;
        
    }
    public TreeNode findInorder(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}
