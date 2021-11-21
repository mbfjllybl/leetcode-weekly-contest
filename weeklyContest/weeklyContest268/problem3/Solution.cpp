class RangeFreqQuery {
public:
    vector<int> v[10010];
    RangeFreqQuery(vector<int>& arr) {
        for (int i = 0; i < 10010; i++) v[i].clear();
        for (int i = 0; i < arr.size(); i++) {
            v[arr[i]].push_back(i);
        }
    }

    int get(int x, int k) {
        return upper_bound(v[k].begin(), v[k].end(), x) - v[k].begin();
    }

    int query(int left, int right, int value) {
        return get(right, value) - get(left - 1, value);
    }
};

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery* obj = new RangeFreqQuery(arr);
 * int param_1 = obj->query(left,right,value);
 */