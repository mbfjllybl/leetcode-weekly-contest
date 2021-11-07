package weeklyContest266.problem3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Pair {
    double x;
    int y;
    int z;

    public Pair(double x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Pair() {
    }
}

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair pair, Pair t1) {
                if (pair.x <= t1.x) return 1;
                else return -1;
            }
        });
        for (int i = 0; i < quantities.length; i++) {
            queue.offer(new Pair(quantities[i], 1, quantities[i]));
        }
        int sz = quantities.length;
        if (sz == n) return (int)queue.peek().x;
        while (sz < n) {
            Pair tmp = queue.poll();
            sz++;
            queue.offer(new Pair(tmp.z / (double)(tmp.y + 1), tmp.y + 1, tmp.z));
        }
        return (int)Math.ceil(queue.peek().x);
    }
}
/*
99984
[132,59628,33680,40235,359,942,531,444,548,544,672,853,231,647,139,342,10,51250,702,80891,818,299,63,772,684,889,578,175,49129,303,430,84823,364,875,464,66531,740,523,654,149,527,572,166,184,21805,547,293,89490,493,81,135,103,198,867,410,370,542]
 */