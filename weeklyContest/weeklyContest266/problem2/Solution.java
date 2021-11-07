package weeklyContest266.problem2;

class Solution {
    public long countVowels(String word) {
        long res = 0;
        for (int i = 0; i < word.length(); i++) {
            Character x = word.charAt(i);
            if (x != 'a' && x != 'e' && x != 'i' && x != 'o' && x != 'u') continue;
            int l = i, r = word.length() - l - 1;
            res += 1 + l + r + (long)l * r;
        }
        return res;
    }
}