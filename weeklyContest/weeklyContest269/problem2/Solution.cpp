class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        vector<long long> sum(nums.size() + 2, 0);
        for (int i = 1; i <= nums.size(); i++) sum[i] = sum[i - 1] + nums[i - 1];
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            if (i - k < 0) res.push_back(-1);
            else if (i + k >= nums.size()) res.push_back(-1);
            else {
                res.push_back((sum[i+k+1]-sum[i-k])/(2*k+1));
            }
        }
        return res;
    }
};