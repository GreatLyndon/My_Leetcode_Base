import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode currList : lists)
            if (null != currList)
                queue.add(currList);
        ListNode result = new ListNode();
        ListNode tail = result;
        while (0 < queue.size()) {
            ListNode temp = queue.poll();
            if (null != temp.next)
                queue.add(temp.next);
            tail.next = temp;
            tail = tail.next;
        }
        return result.next;
    }
}
