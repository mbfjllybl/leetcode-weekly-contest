package biweeklyContest65.problem4;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(workers);
        Arrays.sort(tasks);
        int l = 1, r = tasks.length;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid, tasks, workers, pills, strength)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    private boolean check(int mid, int[] tasks, int[] workers, int pills, int strength) {
        if (workers.length < mid) return false;
        for (int i = 0, j = workers.length - mid; i < mid; i++, j++) {
            if (tasks[i] <= workers[j]) continue;
            int t = workers[j];
            while (t < tasks[i]) {
                t += strength;
                pills--;
                if (pills < 0) return false;
            }
        }
        return true;
    }
}

