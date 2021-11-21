package biweeklyContest65.problem1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            int count = map1.getOrDefault(word1.charAt(i), 0);
            count++;
            map1.put(word1.charAt(i), count);
        }
        for (int i = 0; i < word2.length(); i++) {
            int count = map2.getOrDefault(word2.charAt(i), 0);
            count++;
            map2.put(word2.charAt(i), count);
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character x = entry.getKey();
            int count = entry.getValue();
            int other = map2.getOrDefault(x, 0);
            if (Math.abs(other - count) <= 3) continue;
            else return false;
        }
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            Character x = entry.getKey();
            int count = entry.getValue();
            int other = map1.getOrDefault(x, 0);
            if (Math.abs(other - count) <= 3) continue;
            else return false;
        }
        return true;
    }
}
