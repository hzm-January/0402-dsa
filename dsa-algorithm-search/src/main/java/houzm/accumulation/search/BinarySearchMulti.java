package houzm.accumulation.search;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/12 15:21
 * description: 二分查找--含有重复元素
 */
public class BinarySearchMulti {
    public static void main(String[] args) {
        //生成目标数组
        int[] arr = new int[]{3, 5, 8, 7, 4, 5, 2, 1, 6, 9};
        //目标元素
        int value = 5;
        //1. 查找最后一个目标元素
        //2. 查找第一个目标元素
        binarySearchFirst(arr, value);
        //3.
    }

    /**
     * 查找第一个目标元素
     *
     * @param arr
     * @param value
     */
    private static int binarySearchFirst(int[] arr, int value) {
        int valueOfIndex = binarySearchFirst(arr, value, 0, arr.length - 1);
        return valueOfIndex;
    }

    private static int binarySearchFirst(int[] arr, int value, int low, int high) {

        int middle = low + ((high - low) >> 2);
        if (low <= high) {

        }
        while (low <= high) {

            if (arr[middle] == value) {
                return middle;
            } else if (arr[middle] > value) {

            }
        }
        return 0;
    }
}
