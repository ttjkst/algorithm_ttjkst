import java.util.HashMap;
import java.util.Map;

/**
 * question:
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * */
public class Solution {
    static Map<Integer,Integer> cache = new HashMap<>(30);
    static {
        //init
        cache.put(0,0);
        cache.put(1,1);
    }

    int fibHelp(int n){
        if(cache.containsKey(n)){
            return cache.get(n);
        }else{
            int i = fibHelp(n - 2) + fibHelp(n - 1);
            cache.put(n,i);
            return  i;
        }
    }

    public int fib(int N) {
        return fibHelp(N);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //no test
        int fib = solution.fib(10);
        System.out.println(fib);
    }



}