package houzm.accumulation.dsa;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/6 11:58
 * description: 计数排序
 * <p>
 * 描述：使用桶排序思想
 * 分析：
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 7, 3, 5, 4, 1};
        sort(arr);
    }

    public static void sort(int[] arr) {
        //1. 找出最大最小值
        int max = max(arr);
        int min = min(arr);
        System.out.println("最大值：" + max + "最小值：" + min);
        //2. 桶个数
        int bucketNum = max - min + 1;
        System.out.println("桶个数：" + bucketNum);
        //3. 根据桶个数定义数组（元素含义：存储每个值在原始数组中存在的个数；索引值含义：原始数组中的值-原始数组最小值）
        int[] countingArr = new int[bucketNum];
        System.out.println(Arrays.toString(countingArr));
        //4. 统计元素在原始数组中出现的个数，存入桶数组
        for (int i = 0; i < arr.length; i++) {
            //桶数组的索引值=原始数组的值-原始数组最小值
            countingArr[arr[i] - min]++;
        }
        System.out.println("桶数组：" + Arrays.toString(countingArr));
        //5. 对桶数组进行统计
        int count = 0;
        for (int i = 0; i < countingArr.length; i++) {
            count += countingArr[i];
            countingArr[i] = count;
        }
        System.out.println("桶数组统计结果：" + Arrays.toString(countingArr));
        //5. 定义排序后的最终数组
        int[] arrAfterSort = new int[arr.length];
        //6. 从后往前扫描原始数组，并找到在桶中的个数
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = countingArr[arr[i] - min];
            arrAfterSort[index - 1] = arr[i];
            countingArr[arr[i] - min]--;
            System.out.println(Arrays.toString(arrAfterSort));
        }
        System.out.println("原始数组：" + Arrays.toString(arr));
        System.out.println("排序数组：" + Arrays.toString(arrAfterSort));
    }

    /**
     * @param arr
     * @return
     */
    private static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * @param arr
     * @return
     */
    private static int min(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
}
