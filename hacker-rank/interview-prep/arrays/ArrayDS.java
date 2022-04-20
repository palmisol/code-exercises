package HackerRankInterviewPrep.Arrays;

import java.util.List;

public class ArrayDS {

    public static void main(String[] args) {

    }

    public static int sumSubset(List<List<Integer>> arr, int x, int y) {

        int a = arr.get(y).get(x);
        int b = arr.get(y).get(x + 1);
        int c = arr.get(y).get(x + 2);

        int d = arr.get(y + 1).get(x + 1);

        int e = arr.get(y + 2).get(x);
        int f = arr.get(y + 2).get(x + 1);
        int g = arr.get(y + 2).get(x + 2);

        return a + b + c + d + e + f + g;

    }

    public static int hourglassSum(List<List<Integer>> arr) {

        int x = 0, y = 0;

        int temp = Integer.MIN_VALUE;

        while (y < 4) {
            if (x < 4) {
                int sum = sumSubset(arr, x, y);
                if (sum > temp) {
                    temp = sum;
                }
                x++;
            } else {
                x = 0;
                y++;
            }
        }

        return temp;
    }


}
