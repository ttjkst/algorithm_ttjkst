import java.util.ArrayList;
import java.util.List;


/**
 * question:
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 * */
/***
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
    public int getRightVal(int row,int clo,List<List<Integer>> hasGenerateList){
        int beforeClo = clo -1;
         //如果上一行小于0 则说明已经越界，如果上一行小于列数说明越界，所有越界都为0
        if(beforeClo<0||beforeClo<row){
            return 0;
        }else{
            return hasGenerateList.get(beforeClo).get(row);
        }
    }
    /**
     * 获取左上边的值
     * */
    public int getLeftVal(int row,int clo,List<List<Integer>> hasGenerateList){
        int beforeClo = clo -1;
        int beforeRow = row -1;
        if(beforeClo<0||beforeRow<0){
            return 0;
        }else{
            return hasGenerateList.get(beforeClo).get(beforeRow);
        }
    }
    /**
     * 生成当前的索引的值
     * */
    public  int generateOneNum(int row,int clo,List<List<Integer>> hasGenerateList){
        //第一行，第一列
        if(row==0){
            return 1;
        }
        int leftVal  = getLeftVal( row, clo, hasGenerateList);
        int rightVal = getRightVal(row, clo, hasGenerateList);
        return leftVal+rightVal;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        int needGenerateClo = numRows;
        for (int clos=0;clos<needGenerateClo;clos++){

            List<Integer> oneClo = new ArrayList(clos+1);
            for (int row=0;row<clos+1;row++){
                int generateOneNum = generateOneNum(row, clos, result);
                oneClo.add(generateOneNum);
            }

            result.add(oneClo);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> generate = solution.generate(5);
        generate.forEach(x->{
            x.forEach(y->System.out.print(String.format(" %s ",y)));
            System.out.println();
        });
    }



}