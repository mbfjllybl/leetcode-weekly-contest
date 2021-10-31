package problem3;

class Solution {
    public int[] f = new int[1001];
    public int[] tmp;

    public int get(int x) {
        if (f[x] != -1) return f[x];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < tmp.length; i++) {
            if (judge(x + tmp[i])) res = Math.min(res, 1 + get(x + tmp[i]));
            if (judge(x - tmp[i])) res = Math.min(res, 1 + get(x - tmp[i]));
            if (judge(x ^ tmp[i])) res = Math.min(res, 1 + get(x ^ tmp[i]));
        }
        f[x] = res;
        return f[x];
    }

    boolean judge(int x) {
        if (x >= 0 && x <= 1000) return true;
        else return false;
    }
    public int minimumOperations(int[] nums, int start, int goal) {
        for (int i = 0; i <= 1000; i++) {
            f[i] = -1;
        }

        tmp = nums;
        f[start] = 0;
        int res = Integer.MAX_VALUE;

        if (judge(goal)) return get(goal);

        for (int i = 0; i < nums.length; i++) {
            if (judge(goal + nums[i])) res = Math.min(res, 1 + get(goal + nums[i]));
            if (judge(goal - nums[i])) res = Math.min(res, 1 + get(goal - nums[i]));
            if (judge(goal ^ nums[i])) res = Math.min(res, 1 + get(goal ^ nums[i]));
        }

        if (res == Integer.MAX_VALUE) return -1;
        else return res;
    }
}