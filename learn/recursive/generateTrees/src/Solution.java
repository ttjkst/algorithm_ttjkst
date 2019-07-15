import javafx.util.Pair;

import java.util.*;
import java.util.function.Predicate;

/**
 * question:
 *给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * */
public class Solution {

    private List<TreeNode> generateTreesHelp(int start,int end){
        if(start>end){
            List<TreeNode> emptyNode= new ArrayList<>(2);
            //塞入一个值使得合并的子树计算个永远不等于0
            emptyNode.add(null);
            return emptyNode;
        }
        List<TreeNode> result = new ArrayList<>();
        for (int i=start;i<=end;i++){
            List<TreeNode> left  = generateTreesHelp(start, i-1);
            List<TreeNode> right = generateTreesHelp(i+1, end);
            List<TreeNode> merge = merge(left, i, right);
            result.addAll(merge);
        }
        return  result;
    }

    private List<TreeNode> merge(List<TreeNode> left,int pickVal,List<TreeNode> right){
        List<TreeNode>  result= new ArrayList<>(left.size() * right.size());
        for (TreeNode leftNode : left) {
            for (TreeNode rightNode : right) {
                TreeNode root = new TreeNode(pickVal);
                root.left  = leftNode;
                root.right = rightNode;
                result.add(root);
            }
        }
        return result;
    }


    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return Collections.emptyList();
        }else{
            return  generateTreesHelp(1,n);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //no test
        List<TreeNode> treeNodes = solution.generateTrees(3);
        System.out.print("[");
        treeNodes.stream()
                .peek(x->System.out.print("["))
                .peek(x->solution.helpPrint(x))
                .peek(x->System.out.print("]")).forEach(x->{});
        System.out.print("]");
    }

    private void helpPrint(TreeNode node){
        if(node==null){
            System.out.print("null,");
            return;
        }
        System.out.print(node.val);
        System.out.print(",");
        if(node.left!=null) {
            helpPrint(node.left);
        }
        if(node.right!=null) {
            helpPrint(node.right);
        }
    }



}