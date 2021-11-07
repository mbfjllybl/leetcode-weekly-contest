package weeklyContest266.problem1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean judege(String word, int l, int r) {
        if (l > r) return false;
        if (r - l + 1 < 5) return false;
        Set<Character> set = new HashSet<>();
        for (int i = l; i <= r; i++) {
            Character x = word.charAt(i);
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') set.add(x);
            else return false;
        }
        if (set.size() == 5) return true;
        else return false;
    }

    public int countVowelSubstrings(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < word.length(); j++) {
                if (judege(word, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }
}
