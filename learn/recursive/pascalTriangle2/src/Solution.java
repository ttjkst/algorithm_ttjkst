import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * question:
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * advanced:
 *  你可以优化你的算法到 O(k) 空间复杂度吗？
 * */
/***
 * 思路，计算第k 行需要数据保存k-1 行，其他的行可以不需要
 *
 *        0
 *      0 1 0
 *     0 1  1 0
 *    0 1  2  1 0
 *   0 1  3  3  1 0
 *  0 1  4  6  4  1 0
 *
 * 如果越界可以处理为0
 *
 * */
public class Solution {


    /**
     * 获取右上边的值
     * */
    public int getRightVal(int row,int clo,List<Integer> beforeRowList){
        int beforeClo = clo -1;
         //如果上一行小于0 则说明已经越界，如果上一行小于列数说明越界，所有越界都为0
        if(beforeClo<0||beforeClo<row){
            return 0;
        }else{
            return beforeRowList.get(row);
        }
    }
    /**
     * 获取左上边的值
     * */
    public int getLeftVal(int row,int clo,List<Integer> beforeRowList){
        int beforeClo = clo -1;
        int beforeRow = row -1;
        if(beforeClo<0||beforeRow<0){
            return 0;
        }else{
            return beforeRowList.get(beforeRow);
        }
    }
    /**
     * 生成当前的索引的值
     * */
    public  int generateOneNum(int row,int clo,List<Integer> beforeRowList){
        //第一行，第一列
        if(row==0){
            return 1;
        }
        int leftVal  = getLeftVal( row, clo, beforeRowList);
        int rightVal = getRightVal(row, clo, beforeRowList);
        return leftVal+rightVal;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> beforeRowList = Collections.emptyList();
        int needGenerateClo = rowIndex+1;
        for (int clos=0;clos<needGenerateClo;clos++){

            List<Integer> oneClo = new ArrayList(clos+1);
            for (int row=0;row<clos+1;row++){
                int generateOneNum = generateOneNum(row, clos, beforeRowList);
                oneClo.add(generateOneNum);
            }

            beforeRowList = oneClo;
        }
        return beforeRowList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> generate = solution.getRow(3);
        generate.forEach(y->System.out.print(String.format(" %s ",y)));
    }



}