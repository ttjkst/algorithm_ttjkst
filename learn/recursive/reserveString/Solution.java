class Solution {
    
    public void reverseHelpPrint(char[] s,int index){
        System.out.print(s[index]);
    }
    
    public void reverHelp(char[] s,int index){
        if(index==-1){
            return;
        }
        reverHelp(s,index-1);
        reverseHelpPrint(s,index);
            
    }
    
    public void reverseString(char[] s) {
        reverHelp(s,s.length-1);
    }
}