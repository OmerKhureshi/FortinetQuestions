package subset;

import java.util.Arrays;
import java.util.List;

public class Subsets {
    public boolean checkSubset(List<Integer> list, int sum, int len){

        boolean[][] sumArr = new boolean[sum + 1][len + 1];

        for (int i = 0; i < sumArr[0].length; i++) {
            sumArr[0][i] = true;
        }

        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i][0] = false;
        }

        for (int i = 1; i <= sum;i++) {
            for (int j = 1; j <= len; j++) {
                if (i - list.get(j-1) >= 0) {
                    sumArr[i][j] = sumArr[i][j-1] || sumArr[i - list.get(j-1)][j-1];
                } else {
                    sumArr[i][j] = sumArr[i][j-1];
                }
            }
        }

        return sumArr[sum][len];
    }
}
