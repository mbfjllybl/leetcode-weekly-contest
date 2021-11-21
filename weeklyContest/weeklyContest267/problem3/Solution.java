package weeklyContest267.problem3;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.length() == 0) return "";
        int cols = encodedText.length() / rows;
        String res = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (i + j < cols) sb.append(encodedText.charAt(j * cols + i + j));
            }
        }
//        return ans.replaceAll("\\s+$","");

        return sb.toString().replaceAll("\\s+$","");
    }
}
