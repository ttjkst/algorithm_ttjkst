import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * question:
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 *
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * 例子:
 *
 * 输入: N = 1, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 2
 * 输出: 1
 *
 * 输入: N = 4, K = 5
 * 输出: 1
 *
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 * 注意：
 *
 * N 的范围 [1, 30].
 * K 的范围 [1, 2^(N-1)].
 *
 *
 * */
public class Solution {
    public static List<List<Integer>> cache = new ArrayList<>(30);
    static {
        cache.add(Arrays.asList(0));
    }
    public void generateKthGramerCache(int N){
        if(cache.size()>N){
            return;
        }else{
            generateKthGramerCache(N-1);
            List<Integer> integers = cache.get(N - 1);
            List<Integer> needGenerate = new ArrayList<>();
            for (Integer integer : integers) {
                if(integer==0){
                    needGenerate.add(0);
                    needGenerate.add(1);
                }else{
                    needGenerate.add(1);
                    needGenerate.add(0);
                }
            }
            cache.add(needGenerate);
        }
    }
    public int kthGrammar(int N, int K) {
        N  = N-1;
        K  = K-1;
        if(cache.size()<=N){
            generateKthGramerCache(N);
        }
        return cache.get(N).get(K);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.kthGrammar(1,1);
        int i = solution.kthGrammar(30, 434991989);
        System.out.println(i);
    }



}