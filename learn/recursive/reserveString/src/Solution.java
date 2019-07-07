
/**
 * 如果我要反转字符，首先我要将剩余的字符翻转，在将自己与剩余的字符进行翻转
 * */
public class Solution {

    public void reverseSelf(char[] s,int index){
        char self = s[index];
        for (int i=index;i<s.length-1;i++){
            s[i]=s[i+1];
        }
        s[s.length-1]=self;
    }
    
    public void reverHelp(char[] s,int index){
        if(index==s.length-1){
            return;
        }
        reverHelp(s,index+1);
        reverseSelf(s,index);
            
    }
    
    public void reverseString(char[] s) {
        if(s.length==0){
            return;
        }
        reverHelp(s,0);
    }

    public static void main(String[] args) {
        char[] s = new char[]{'c'};
        Solution solution = new Solution();
        solution.reverseString(s);
        System.out.println(s);
    }
}