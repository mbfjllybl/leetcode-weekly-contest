package problem4;

class Solution {
    public boolean[][][] f = new boolean[41][41][2001];
    public int BASE = 1000;
    public boolean possiblyEquals(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        f[0][0][BASE] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= 2000; k++) {
                    if (!f[i][j][k]) continue;
                    if (k == BASE && i < n && j < m && s1.charAt(i) == s2.charAt(j)) f[i + 1][j + 1][k] = true;
                    if (j < m && k > BASE && Character.isLowerCase(s2.charAt(j))) f[i][j + 1][k - 1] = true;
                    if (i < n && k < BASE && Character.isLowerCase(s1.charAt(i))) f[i + 1][j][k + 1] = true;

                    int v = 0;
                    for (int u = i; u < n && Character.isDigit(s1.charAt(u)); u++) {
                        v = v * 10 + Integer.parseInt(s1.charAt(u) + "");
                        if (k + v <= 2000) f[u + 1][j][k + v] = true;
                    }

                    v = 0;
                    for (int u = j; u < m && Character.isDigit(s2.charAt(u)); u++) {
                        v = v * 10 + Integer.parseInt(s2.charAt(u) + "");
                        if (k >= v) f[i][u + 1][k - v] = true;
                    }
                }
            }
        }
        return f[n][m][BASE];
    }
}