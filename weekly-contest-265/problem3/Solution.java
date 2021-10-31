package problem3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int dist[] = new int[1001];
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Arrays.fill(dist, -1);
        dist[start] = 0;
        while (queue.size() != 0) {
            int top = queue.poll();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] + top >= 0 && nums[i] + top <= 1000 && dist[nums[i] + top] == -1) {
                    dist[nums[i] + top] = dist[top] + 1;
                    queue.offer(nums[i] + top);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (-nums[i] + top >= 0 && -nums[i] + top <= 1000 && dist[-nums[i] + top] == -1) {
                    dist[-nums[i] + top] = dist[top] + 1;
                    queue.offer(-nums[i] + top);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] ^ top) >= 0 && (nums[i] ^ top) <= 1000 && dist[nums[i] ^ top] == -1) {
                    dist[nums[i] ^ top] = dist[top] + 1;
                    queue.offer(nums[i] ^ top);
                }
            }
        }

        if (goal >= 0 && goal <= 1000) return dist[goal];

        int res = Integer.MAX_VALUE;
        for (int i : nums) {
            int v = i + goal;
            if (v >= 0 && v <= 1000 && dist[v] != -1) res = Math.min(res, dist[v] + 1);

            v = -i + goal;
            if (v >= 0 && v <= 1000 && dist[v] != -1) res = Math.min(res, dist[v] + 1);

            v = i ^ goal;
            if (v >= 0 && v <= 1000 && dist[v] != -1) res = Math.min(res, dist[v] + 1);
        }

        if (res == Integer.MAX_VALUE) return -1;
        else return res;

    }
}