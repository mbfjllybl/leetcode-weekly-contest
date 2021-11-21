class Solution {
public:
    long long res = 0;
    int cnt = 0;
    string x;
    int BASE, goal;

    bool judge(long x) {
        string str = to_string(x);
        for (int i = 0, j = str.size() - 1; i < j; i++, j--) {
            if (str[i] != str[j]) return false;
        }
        return true;
    }

    long get(string s, int k) {
        long base = 1;
        long res = 0;
        for (int i = s.size() - 1; i >= 0; i--) {
            res += (s[i] - '0') * base;
            base *= k;
        }
        return res;
    }

    void dfs(int len, int i) {
        int pix = (len + 1) / 2;
        if (cnt == goal) {
            return;
        }
        if (i == pix) {
            string tmp = x;
            if (len % 2 == 0) {

                string y = x;
                reverse(y.begin(), y.end());
                x = x + y;
            } else {
                string y = x.substr(0, x.size() - 1);
                reverse(y.begin(), y.end());
                x = x + y;
            }
            if (judge(get(x, BASE))) {
                cnt++;
                // cout << get(x, BASE) << "!!!" << endl;
                res += get(x, BASE);
            }
            // cnt++;
            //  cout << x << endl;
            x=tmp;

            return;
        }
        if (i == 0) {
            for (int j = 1; j < BASE; j++) {
                x += j + '0';
                // cout << x + " ]]]]]" << endl;
                dfs(len, i + 1);
                x = x.substr(0, x.size() - 1);
                // cout << x + " ----" << endl;
            }
        } else {
            for (int j = 0; j < BASE; j++) {
                x += j + '0';
                dfs(len, i + 1);
                x = x.substr(0, x.size() - 1);
            }
        }
    }

    long long kMirror(int k, int n) {
        // cout << "!!!!!!!   " << (int)judge(10001) << endl;
        // cout << get("101", 3) << "!!!" << endl;
        BASE = k;
        goal = n;
        for (int i = 1; ; i++) {
            x = "";
            dfs(i, 0);
            if (cnt == goal) break;
        }

        return res;
    }
};