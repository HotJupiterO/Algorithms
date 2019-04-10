class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int counter = 1;
        int length = A.length;
        if (length <= 1) return length;
        int prev = B[0];
        for (int i = 1; i < length; i++) {
            if (A[i] > prev) {
                counter++;
                prev = B[i];
            }
        }
        return counter;
        
    }
}