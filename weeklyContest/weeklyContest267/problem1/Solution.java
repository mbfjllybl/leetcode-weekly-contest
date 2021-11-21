package weeklyContest267.problem1;

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        int com = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                ans += Math.min(tickets[i], com);
            } else {
                ans += Math.min(tickets[i], com - 1);
            }
        }
        return ans;
    }
}
