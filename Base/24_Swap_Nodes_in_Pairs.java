class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode ans = new ListNode();
        ListNode pointer = ans;
        if (head == null || head.next == null)
            return head;

        while (head != null && head.next != null) {
            pointer.next = head.next;
            head.next = head.next.next;
            pointer.next.next = head;
            pointer = head;
            head = head.next;
        }

        return ans.next;
    }
}
