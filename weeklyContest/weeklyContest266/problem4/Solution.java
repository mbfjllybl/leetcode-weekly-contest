package weeklyContest266.problem4;
import java.util.*;

class Solution {
    Map<Integer, List<int[]>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    int[] QAQ;
    int n, ans;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        n = values.length;
        QAQ = values;
        for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
            map.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
        }
        set.add(0);
        dfs(0, maxTime);
        return ans;
    }

    private void dfs(int u, int left) {
        if (u == 0) {
            int tmp = 0;
            for (int i : set) {
                tmp += QAQ[i];
            }
            if (tmp > ans) ans = tmp;
        }
        List<int[]> list = map.get(u);

        for (int i = 0; i < list.size(); i++) {
            int cost = list.get(i)[1];
            if (left >= cost) {
                int next = list.get(i)[0];
                int f = 0;
                if (!set.contains(next)) {
                    set.add(next);
                    f = 1;
                }
                dfs(next, left - cost);
                if (f == 1) set.remove(next);
            }
        }
    }
//    public static void main(String[] args) {
//        int[] values = {1,2,3,4};
//        int[][] edges = {{0,1,10},{1,2,11},{2,3,12},{1,3,13}};
//        int maxTime = 50;
//        new Solution().maximalPathQuality(values,edges,maxTime);
//    }
}