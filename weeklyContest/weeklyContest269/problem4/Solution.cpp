class p {
    public: int a, b, c;
    bool operator <(const p W) const {
        return c < W.c;
    }
};
class Solution {

public:
    int f[500010];
    int find(int x) {
        if (x != f[x]) f[x] = find(f[x]);
        return f[x];
    }
    vector<int> findAllPeople(int n, vector<vector<int>>& m, int fi) {
        for (int i = 0; i < n; i++) f[i] = i;
        vector<p> v;
        vector<int> tmp;

        for (int i = 0; i < m.size(); i++) {
            v.push_back({m[i][0],m[i][1],m[i][2]});
        }
        sort(v.begin(), v.end());
        f[fi] = f[0];
        vector<int> res;
        res.push_back(0);
        vector<bool> u(n + 1, 0);
        u[0]=1;
        u[fi] = 1;
        res.push_back(fi);
        for (int i = 0; i < v.size(); i++) {
            if (i != 0 && v[i].c != v[i-1].c) {
                for (int j = 0; j < tmp.size(); j++) {
                    if (f[find(tmp[j])] != f[find(0)]) f[tmp[j]] = tmp[j];
                    else {
                        if (u[tmp[j]] == false) {
                            res.push_back(tmp[j]);
                            u[tmp[j]] = 1;
                        }
                    }
                }
                tmp.clear();
            }
            int a = v[i].a, b = v[i].b;
            f[find(a)] = f[find(b)];
            tmp.push_back(a);
            tmp.push_back(b);

        }
        for (int j = 0; j < tmp.size(); j++) {
                    if (f[find(tmp[j])] != f[find(0)]) f[tmp[j]] = tmp[j];
                    else {
                        if (u[tmp[j]] == false) {
                            res.push_back(tmp[j]);
                            u[tmp[j]] = 1;
                        }
                    }
                }

        // for (int i = 0; i < n; i++) {
        //     if (f[find(0)] == f[find(i)]) res.push_back(i);
        // }
        return res;
    }
};
