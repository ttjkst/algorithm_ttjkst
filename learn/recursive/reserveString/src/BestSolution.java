
/**
 * 如果我要反转字符，首先我要将剩余的字符翻转，在将自己与剩余的字符进行翻转
 * */
public class BestSolution {

    public void sweap(char[] s, int begin, int end){
         char tem = s[begin];
         s[begin] = s[end];
         s[end]   = tem;
    }
    
    public void reverHelp(char[] s,int begin,int end){
        if(begin>end){
            return;
        }
        reverHelp(s,begin+1,end-1);
        sweap(s,begin,end);
            
    }
    
    public void reverseString(char[] s) {
        if(s.length==0){
            return;
        }
        reverHelp(s,0,s.length-1);
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        BestSolution solution = new BestSolution();
        solution.reverseString(s);
        System.out.println(s);
    }
}