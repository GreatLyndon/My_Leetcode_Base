class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int cnt = 0;
        while (cur != null && cnt != k) {
            cur = cur.next;
            cnt++;
        }
        if (cnt == k) {
            cur = reverseKGroup(cur, k);
            while (cnt-- > 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }
}
