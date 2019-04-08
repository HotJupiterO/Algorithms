public class Solution {
    public int solution(int[] A, int[] B) {
        if (A.length == 0)
            return 0;

        int N = A.length;
        int currentLeftEnd = A[N - 1];
        int numNonOverlap = 1;

        for (int i = N - 2; i >= 0; i--) {
            if (B[i] < currentLeftEnd) {
                numNonOverlap++;
                currentLeftEnd = A[i];
            }

            if (A[i] > currentLeftEnd) {
                currentLeftEnd = A[i];
            }
        }

        return numNonOverlap;
    }
}