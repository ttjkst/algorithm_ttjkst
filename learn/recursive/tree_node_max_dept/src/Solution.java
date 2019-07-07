import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {


    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left  = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left>right?left+1:right+1;
    }

    public static void main(String[] args) {
        Solution solution  = new Solution();
        TreeNode treeNode  = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(15);

        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode3;
        int i = solution.maxDepth(treeNode);
        System.out.println(i);
        //no test
    }



}