import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * question:
 * 反转一个单链表。
 *
 * advanced:
 *  你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * */

public class Solution {


    /**
     * 获取最后链表在最后一个
     * */
    public ListNode getLastNode(ListNode curr){
        if(curr.next!=null){
            return  getLastNode(curr.next);
        }else{
            return  curr;
        }
    }


    /**
     * 递归
     * */
    public ListNode reverseList1(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode realLastNode = reverseList1(head.next);
        ListNode lastNode     = getLastNode(head);
        lastNode.next         = head;
        head.next             = null;
        return realLastNode;
    }

    public ListNode bestReverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 迭代
     * */
    public ListNode reverseList2(ListNode head) {
        if(head==null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            ListNode next = head.next;
            head.next     = null;
            head          = next;
        }
        ListNode curr    = null;
        ListNode newHead = null;
        while (!stack.isEmpty()) {
            if (newHead != null) {
                curr.next = stack.pop();
                curr      = curr.next;
            } else {
                curr         = stack.pop();
                newHead      = curr;
            }
        }
        return newHead;
    }


    /**
     * 最好的方法
     * */
    public ListNode bestReverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    public ListNode reverseList(ListNode head) {
        return reverseList2(head);
    }


    public static void main(String[] args) {
        ListNode listNode = null;
        Solution solution = new Solution();
        solution.reverseList(listNode);
        //no test
    }

}