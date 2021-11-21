package weeklyContest267.problem4;

import java.util.List;

class Solution {
    int[] f;
    int get(int x) {
        if (x != f[x]) x = get(f[x]);
        return f[x];
    }
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        f = new int[n + 1];
        boolean[] res = new boolean[requests.length];
        for (int i = 0; i < n ; i++) f[i] = i;
        for (int i = 0; i < requests.length; i++) {
            int a = requests[i][0], b = requests[i][1];
            int fa = get(a), fb = get(b);
            if (f[fa] != f[fb]) {
                f[fa] = f[fb];
            }
            boolean ff = true;
            for (int j = 0; j < restrictions.length; j++) {
                int x = restrictions[j][0], y = restrictions[j][1];
                if (get(x) == get(y)) {
                    ff =false;
                    break;
                }
            }

            res[i] = ff;
            if (ff == false) {

                    f[fa] = fa;

            }
        }
        return res;
    }
}