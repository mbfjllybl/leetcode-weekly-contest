package biweeklyContest65.problem3;

import java.util.*;

class Solution {
    class pair {
        int a, b;

        public pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        List<pair> list = new ArrayList<>();
        int[] ans = new int[queries.length];
        System.out.println(list.size());
        for (int i = 0; i < queries.length; i++) {
            list.add(i, new pair(queries[i], i));
        }
        list.sort(new Comparator<pair>() {
            @Override
            public int compare(pair pair, pair t1) {
                if (pair.a >= t1.a) return 1;
                else return -1;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        List<pair> sm = new ArrayList<>(items.length);
        for (int i = 0; i < items.length; i++) {
            sm.add(i, new pair(items[i][0], items[i][1]));
        }


        sm.sort((p, q) -> {
            if (p.a >= q.a) return 1;
            else return -1;
        });
        for (int i = 0; i < sm.size(); i++) {
            System.out.println(sm.get(i));
        }
        int mx = 0;
        for (int i = 0, j = -1; i < queries.length; i++) {
            pair p = list.get(i);
            while (j + 1 < sm.size() && sm.get(j+1).a <= p.a) {

                j++;
                mx = Math.max(sm.get(j).b, mx);
            }

            ans[p.b] = mx;

        }
        return ans;
    }
}
