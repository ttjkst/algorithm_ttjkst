import java.util.stream.IntStream;

/**
 * question:
 *实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * */
public class Solution {


    ///has some problem
    public double myPow2(double x, int n) {
        if(n==1){
            return x;
        }
        if(n==-1){
            return  1/x;
        }
        if(n==0){
            return 1;
        }
        double half = myPow2(x, n / 2);
        return  half * half *(n%2==1?(x>0?x:1/x):1);
    }


    public double myPow1(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1;
        for (int i=0;i<=n;i++){
            result=result*x;
        }
        return result;
    }

    public double myPow(double x, int n) {
            return myPow2(x,n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double v = solution.myPow2(34.00515, -3);
        System.out.println(v);
    }



}