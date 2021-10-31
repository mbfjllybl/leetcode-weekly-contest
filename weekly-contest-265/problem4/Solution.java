package problem4;

class Solution {
    boolean f[][] = new boolean[50][50];

    public boolean possiblyEquals(String s1, String s2) {
        s1 = " " + s1;
        s2 = " " + s2;
        for (int i = 0; i < 50; i++)
            for (int j = 0; j < 50; j++) {
                f[i][j] = false;
            }

        int len1 = 0, ll1 = 0;
        f[0][0] = true;

        for (int i = 1; i < s1.length(); i++) {
            if (Character.isDigit(s1.charAt(i))) {
                len1 = len1 + Integer.parseInt(s1.charAt(i) + "");
                ll1++;
            } else {
                len1 = 0;
                ll1 = 0;
            }
            int len2 = 0, ll2 = 0;
            for (int j = 1; j < s2.length(); j++) {

                if (Character.isDigit(s2.charAt(j))) {
                    len2 = len2 * 10 + Integer.parseInt(s2.charAt(j) + "");
                    ll2++;
                } else {
                    len2 = 0;
                    ll2 = 0;
                }

                if (len1 == 0 && len2 == 0) {
                    if (s1.charAt(i) == s2.charAt(j))
                        f[i][j] = f[i - 1][j - 1];
                    else f[i][j] = false;
                    continue;
                }
                if (len1 == 0 || len2 == 0) {
                    int nums1 = len1, nums2 = len2;
                    if (nums1 >= nums2) {
                        if (i - ll1 + 1 - 1 >= 0 && j - ll2 + 1 - 1 - (nums1 - nums2) >= 0)
                            f[i][j] = f[i - ll1 + 1 - 1][j - ll2 + 1 - 1 - (nums1 - nums2)];
                        else f[i][j] = false;
                    } else {
                        if (i - ll1 + 1 - 1 - (nums2 - nums1) >= 0 && j - ll2 + 1 - 1 >= 0)
                            f[i][j] = f[i - ll1 + 1 - 1 - (nums2 - nums1)][j - ll2 + 1 - 1];
                        else f[i][j] = false;
                    }
                    continue;
                }

                boolean ff = false;
                int nums1 = 0;
                for (int l = 1; l <= ll1; l++) {
                    nums1 = nums1 * 10 + Integer.parseInt(s1.charAt(i - l + 1) + "");
                    int nums2 = 0;
                    for (int r = 1; r <= ll2; r++) {
                        nums2 = nums2 * 10 + Integer.parseInt(s2.charAt(j - r + 1) + "");
                        if (nums1 >= nums2) {
                            if (i - l + 1 - 1 >= 0 && j - r + 1 - 1 - (nums1 - nums2) >= 0)
                                if(f[i - l + 1 - 1][j - r + 1 - 1 - (nums1 - nums2)]) ff=true;

                        } else {
                            if (i - l + 1 - 1 - (nums2 - nums1) >= 0 && j - r + 1 - 1 >= 0)
                                if(f[i - l + 1 - 1 - (nums2 - nums1)][j - r + 1 - 1]) ff=true;

                        }

                    }
                }
                f[i][j]=ff;
            }

        }


        return f[s1.length() - 1][s2.length() - 1];
    }
}