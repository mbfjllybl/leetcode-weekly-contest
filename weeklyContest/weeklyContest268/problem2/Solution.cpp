
class Solution {
public:
    int wateringPlants(vector<int>& plants, int capacity) {
        int res = 0;
        int cur = capacity;
        for (int i = 0; i < plants.size(); i++) {
            if (cur >= plants[i]) {
                res++;
                cur -= plants[i];
            } else {
                cur = capacity - plants[i];
                res += 2 * (i);
                res++;
            }
            //cout << res << endl;
        }
        return res;
    }
};