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
/***
 * addition:
 * <<      :     左移运算符，num << 1,相当于num乘以2
 *
 * >>      :     右移运算符，num >> 1,相当于num除以2
 *
 * >>>    :     无符号右移，忽略符号位，空位都以0补齐
 * */
public class Solution {
    /***
     * 会栈溢出
     * */
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
    public int badkthGrammar(int N, int K) {
        N  = N-1;
        K  = K-1;
        if(cache.size()<=N){
            generateKthGramerCache(N);
        }
        return cache.get(N).get(K);
    }
    /***************/

    public int mykthGrammar(int N, int K) {
        int[] array = new int[1<<N];
        System.out.println(String.format(" %s ",0));
        for(int i=1;i<N;i++){
            //获取每行最大的那个
            int max= (1<<i)-1;
            for (int j=max;j>=max/2;j=j-2){
                array[j]=1-array[j/2];
                array[j-1]=array[j/2];
            }
            for (int index =0;index<=max;index++){
                System.out.print(String.format(" %s ",array[index]));
            }
            System.out.println();
        }
        return  array[K-1];
    }


    public int kthGrammar2(int N, int K) {
        //必须为0
        int[] lastrow = new int[1 << N];
//        System.out.println(String.format(" %s ",0));
        //重第2行开始 进行求解kthGrammar
        for (int i = 1; i < N; ++i) {
            for (int j = (1 << (i-1)) - 1; j >= 0; --j) {
                lastrow[2*j] = lastrow[j];
                lastrow[2*j+1] = 1 - lastrow[j];
            }
//            int max= (1<<i)-1;
//            for (int index =0;index<=max;index++){
//                System.out.print(String.format(" %s ",lastrow[index]));
//            }
//            System.out.println();
        }
        return lastrow[K-1];
    }
    public int kthGrammar(int N, int K) {
        if(N==1){
            return 0;
        }
        return (K%2==0)?(1- kthGrammar(N - 1, K / 2)):kthGrammar (N-1,K/2);
    }

    public int kthGrammar3(int N, int K) {
        if(K==0){
            K=1;
        }
        if(N==1){
            return 0;
        }
        int before = kthGrammar3(N - 1, (K +1)/ 2);
        return (K%2==0)?(1- before): before;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.kthGrammar3(3, 3);
        System.out.println(i);
    }



}