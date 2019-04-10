import java.util.Random;

public class Solution {
    public int solution(int[] A) {
        /*int result = A[0];
        int check = 0;
        int length = A.length;
        while (check != length - 1) {
            Random r = new Random();
            int randomNumber = r.nextInt(6) + 1;
            if (check + randomNumber < length) {
                result += A[check + randomNumber];
                check += randomNumber;
            }
        }
        return result;*/
        int[] maxSums = new int[A.length];
        maxSums[0] = A[0];
        for (int i = 1; i < maxSums.length; i++) {
            maxSums[i] = Integer.MIN_VALUE;
            for (int j = 1; j <= 6 && i - j >= 0; j++) {
                maxSums[i] = Math.max(maxSums[i], maxSums[i - j] + A[i]);
            }
        }
        return maxSums[maxSums.length - 1];

    }

}