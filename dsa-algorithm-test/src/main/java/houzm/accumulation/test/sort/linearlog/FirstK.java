package houzm.accumulation.test.sort.linearlog;

/**
 * author: hzm_dream@163.com
 * date: 2019/2/18 17:40
 * description:
 */
public class FirstK {
    private static final int k = 1;

    public static void main(String[] args) {
        int[] arr = new int[]{9, 7, 8, 6, 4, 1, 3, 5, 4, 2};
        int value = find(arr, 0, arr.length - 1);
        System.out.println(value);
    }

    private static int find(int[] arr, int start, int end) {
        int pivot = partition(arr, start, end);
        if (pivot + 1 == k) {
            return arr[pivot];
        }
        if (pivot + 1 < k) {
            return find(arr, pivot + 1, end);
        }
        return find(arr, start, pivot - 1);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int p = start;
        int q = start;
        while (p <= end && q <= end) {
            if (arr[q] > pivot) {
                int temp = arr[p];
                arr[p] = arr[q];
                arr[q] = temp;
                p++;
            }
            q++;
        }
        arr[end] = arr[p];
        arr[p] = pivot;
        return p;
    }
}
