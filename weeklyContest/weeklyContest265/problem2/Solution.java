package weeklyContest265.problem2;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int last = head.val;
        head = head.next;
        int i = 1;
        while (head != null && head.next != null) {
            int next = head.next.val;
            int cur = head.val;
            if (cur > last && cur > next) list.add(i);
            if (cur < last && cur < next) list.add(i);
            head = head.next;
            last = cur;
            i++;
        }
        if (list.size() <= 1) return new int[]{-1, -1};
        int maxn = list.get(list.size() - 1) - list.get(0), minn = Integer.MAX_VALUE;
        for (int j = 0; j < list.size(); j++) {
            if (j + 1 < list.size()) {
                minn = Math.min(minn, list.get(j + 1) - list.get(j));
            }
        }

        return new int[]{minn, maxn};
    }
}
