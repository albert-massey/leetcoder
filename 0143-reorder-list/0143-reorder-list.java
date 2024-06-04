/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null; 
        
        slow = head;
        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        
    }
    
    private ListNode reverse(ListNode slow) { 
        if(slow == null) return null;
        ListNode prev = null;
        ListNode curr = slow;
        while(curr.next != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr.next = prev;
        // System.out.print(curr.val);
        return curr;
    }
    
//     private void merge(ListNode head1, ListNode head2) {
//         ListNode temp1 = head1.next;
//         ListNode temp2 = head2.next;
        
//         while(head1.next != null) {
//         head1.next = head2;
//         head2.next = temp1;
//         head1 = temp1;
//         head2 = temp2;
//         }
//     }
}