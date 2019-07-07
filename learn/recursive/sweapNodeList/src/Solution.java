public class Solution {


    public ListNode swapPairs(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode next = head.next;
        int headVal   = head.val;
        head.val      = next.val;
        next.val      = headVal;
        swapPairs(head.next.next);
        return head;
    }

    public static void main(String[] args) {
        //no test
    }


    public static class  ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}