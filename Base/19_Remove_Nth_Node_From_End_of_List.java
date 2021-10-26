class Solution<ListNode> {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        ListNode p1 = head;
        int count = 1;
        while (p1.next != null) {
            p1 = p1.next;
            count++;
        }
        p1 = head;
        count -= n;
        while (count > 1) {
            count--;
            p1 = p1.next;
        }
        if (count == 0)
            head = head.next;
        else
            p1.next = p1.next.next;

        return head;
    }
}
