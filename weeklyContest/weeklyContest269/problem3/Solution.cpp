class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        int mn = INT_MAX, mnpos = 0;
        int mx = INT_MIN, mxpos = 0;
        for (int i = 0; i < nums.size(); i++) {
            int x = nums[i];
            if (x < mn) {
                mn = x;
                mnpos = i;
            }
            if (x > mx) {
                mx = x;
                mxpos = i;
            }
        }
        int res = 0;
        res = max(mnpos, mxpos) + 1;
        res = min(res, (int)nums.size() - 1 - min(mnpos, mxpos) + 1);
        res = min(res, min(mnpos, mxpos) + 1 + (int)nums.size() - 1 - max(mnpos, mxpos) + 1);
        return res;
    }
};
