class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
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