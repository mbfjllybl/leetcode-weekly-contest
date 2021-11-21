package biweeklyContest65.problem2;



class Robot {

    String[] s = {"East", "North", "West", "South"};
    String now = s[0];
    int k = 0;
    int i, j;
    //n = x
    //m = y
    int n, m;
    int f;

    public Robot(int width, int height) {
        n = width - 1;
        m = height - 1;
        f = n + n + m + m;
    }

    public void move(int num) {
        if (num / f != 0) {
            if (i == 0 && j ==0) {
                now = s[3];
                k=3;
            }
        }
        num %= f;

        while (num > 0) {
            if (now.equals(s[0])) {
                if (i < n) {
                    int last = n - i;
                    if (num <= last) {
                        i += num;
                        break;
                    } else {
                        i = n;
                        num -= last;
                        continue;
                    }

                }

                else {
                    j++;
                    k ++;
                    k %= 4;
                    now = s[k];
                }
            } else if (now.equals(s[1])) {
                if (j < m) {
                    int last = m - j;
                    if (num <= last) {
                        j += num;
                        break;
                    } else {
                        j = m;
                        num -= last;
                        continue;
                    }
                }

                else {
                    i--;
                    k ++;
                    k %= 4;
                    now = s[k];
                }
            } else if (now.equals(s[2])) {
                if (i > 0) {
                    int last = i;
                    if (num <= last) {
                        i -= num;
                        break;
                    } else {
                        i = 0;
                        num -= last;
                        continue;
                    }
                }

                else {
                    j--;
                    k ++;
                    k %= 4;
                    now = s[k];
                }
            } else {
                if (j > 0) {
                    int last = j;
                    if (num <= last) {
                        j -= num;
                        break;
                    } else {
                        j = 0;
                        num -= last;
                        continue;
                    }
                }

                else {
                    i++;
                    k ++;
                    k %= 4;
                    now = s[k];
                }
            }
            num--;
        }
    }

    public int[] getPos() {
        return new int[] {i, j};
    }

    public String getDir() {
        return now;
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.move(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
