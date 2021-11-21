package weeklyContest267.problem2;

import java.util.List;

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
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0, head), p = dummy;
        int now = 1;
        int count = 1;
        while (p != null) {
            ListNode q = p;
            int cnt = 0;
            int f = 0;
            for (int i = 0; i < count; i++) {
                if (q.next != null) {
                    q = q.next;
                    cnt++;
                }
                else {
                    f = 1;
                    break;
                }
            }
            if (cnt % 2 == 1) {
                now++;
                count += 1;
                p = q;
                continue;
            }
            if (cnt == 0 || cnt == 1) {
                break;
            }
            ListNode k = p.next;
            ListNode first = p.next, second = p.next.next;
            for (int i = 0; i < cnt - 1; i++) {
                ListNode tmp = second.next;
                second.next = first;
                first = second;
                second = tmp;
            }
            p.next = q;
            k.next = second;
            now++;
            count++;
            p = k;
        }
        return dummy.next;
    }
}
