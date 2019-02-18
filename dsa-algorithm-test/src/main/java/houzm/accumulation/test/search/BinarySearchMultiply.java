package houzm.accumulation.test.search;


/**
 * author: hzm_dream@163.com
 * date: 2019/2/18 18:27
 * description:
 */
public class BinarySearchMultiply {
    private static final int target = 2;
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 2, 7, 9, 4, 5, 2, 1, 6, 9};
        int index = find(arr, 0, arr.length);
    }

    private static int find(int[] arr, int start, int end) {
        int middle = start + ((end - start) >> 1);
        while (start <= end) {
            if (arr[middle] == target) {
                if (middle == 0 || arr[middle - 1] != middle) {
                    return arr[middle];
                }
                middle--;
            }
            if (arr[middle] < target) {

            }
        }
        return 0;
    }
}
