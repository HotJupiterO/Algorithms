public class SmallestElement {
    public int getKthSmallest(int[] array, int start, int end, int k) {
        if (k > 0 && k <= end - start + 1) {
            int pos = partition(array, start, end);
            if (pos - start == k - 1) return array[pos];
            if (pos - start > k - 1) return getKthSmallest(array, start, pos - 1, k);
            return getKthSmallest(array, pos + 1, end, k - pos + start - 1);
        }
        return Integer.MAX_VALUE;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end], j = start;
        for (int i = start; i <= end - 1; i++) {
            if (arr[i] <= pivot) {
                swap(arr, j, i);
                j++;
            }
        }
        swap(arr, j, end);
        return j;
    }
}