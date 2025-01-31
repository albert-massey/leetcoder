class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify handling the head
        ListNode current = dummy; // Pointer to construct the result list
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Carry for the next iteration
            current.next = new ListNode(sum % 10); // Create a new node with the last digit
            current = current.next; // Move to the next node
        }

        // If there's a remaining carry, create a new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next; // Skip the dummy node and return the actual result
    }
}