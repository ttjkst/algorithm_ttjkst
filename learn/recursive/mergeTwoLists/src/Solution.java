
/**
 * question:
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1==null){
                return l2;
            }
            if(l2==null){
                return l1;
            }
            ListNode headNode = null;
            ListNode currNode = null;
            while (l1!=null&&l2!=null){
                if(l1.val>l2.val){
                    //init
                    if(headNode==null){
                        headNode = l1;
                        currNode = headNode;
                    }else{
                        //递推
                        currNode.next = l1;
                        currNode      = l1;
                    }
                    l1=l1.next;
                }else{
                    //init
                    if(headNode==null){
                        headNode = l2;
                        currNode = headNode;
                    }else{
                        //递推
                        currNode.next = l2;
                        currNode      = l2;
                    }
                    l2=l2.next;
                }
            }//end while
            if(l1!=null){
                currNode.next = l1;
            }
            if(l2!=null){
                currNode.next = l2;
            }
            return  headNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //no test
    }



}