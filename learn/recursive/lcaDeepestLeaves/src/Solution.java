import java.util.ArrayDeque;
import java.util.Queue;

/**
 * question:
 * 5128. Lowest Common Ancestor of Deepest Leaves
 * Given a rooted binary tree, find the lowest common ancestor of its deepest leaves.
 *
 * Recall that:
 *
 * The node of a binary tree is a leaf if and only if it has no children
 * The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d+1.
 * The lowest common ancestor of a set S of nodes is the node A with the largest depth such that every node in S is in the subtree with root A.
 *
 * Example 1:
 *
 * Input: root = [1,2,3]
 * Output: [1,2,3]
 * Example 2:
 *
 * Input: root = [1,2,3,4]
 * Output: [4]
 * Example 3:
 *
 * Input: root = [1,2,3,4,5]
 * Output: [2,4,5]
 *
 *
 * */
public class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue  = new ArrayDeque<>();
        Queue<TreeNode> before = new ArrayDeque<>();
        Queue<Integer> dept    = new ArrayDeque<>();
        queue.offer(root);
        dept.offer(0);
        TreeNode result    = null;
        int  theLowestDept = 0;
        while(!queue.isEmpty()){
            TreeNode node        = queue.poll();
            Integer currDept     = dept.poll();
            TreeNode beforeNode  = before.isEmpty()?null:before.poll();
            int nextDept         = currDept+1;
            if(node.left!=null){
                before.offer(node);
                queue.offer(node.left);
                dept.offer(nextDept);
            }
            if(node.right!=null){
                before.offer(node);
                queue.offer(node.right);
                dept.offer(nextDept);
            }
            if(node.left==null&&node.right==null){
                if(theLowestDept<currDept){
                    result = beforeNode;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //no test
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        root.left   = node2;
        root.right  = node3;
        node2.left  = node4;

        TreeNode node = solution.lcaDeepestLeaves(root);
        System.out.print(node.val);

    }



}