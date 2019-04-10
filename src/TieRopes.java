class Solution {
    public int solution(int K, int[] A) {
        int counter = 0;
        int current = 0;
        for (int i = 0; i < A.length; i++) {
            current += A[i];
            if (current >= K) {
                counter+=1;
                current = 0;
            }
        }
        return counter;
        
    }
}