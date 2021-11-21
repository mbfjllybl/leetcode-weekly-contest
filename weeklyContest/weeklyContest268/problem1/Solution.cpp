class Solution {
public:
    int maxDistance(vector<int>& colors) {
        int ans = 0;
        for (int i = 1; i < colors.size(); i++) {
            if (colors[i] != colors[0] || colors[i] != colors[colors.size() - 1]) {
                ans = max(ans, max(i, (int)colors.size() - 1 - i));
            }
        }
        return ans;
    }
};