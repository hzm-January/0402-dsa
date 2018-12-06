package houzm.accumulation.dsa;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/6 11:58
 * description: 计数排序
 *
 * 描述：使用桶排序思想
 * 分析：
 * 若原始数组为arr
 * 1. 获取数组中最大值max、最小值min
 * 2. 桶个数bucketNum=max-min+1
 * 3. 定义桶数组int[] countingArr = new int[bucketNum];说明：原始数组的元素个数保存在桶数组的索引值=原始数组数值-最小值
 * 4. 统计原始数组中元素出现的次数x，countingArr[arr[i]-min] = x;
 * 5. 统计桶数组，桶数组中记录的元素在原始数组中出现的个数累计，统计出 countingArr[k] = k+min元素在原始数组中个数+小于k+min元素在原始数组中个数
 * 举例：[1, 0, 2, 2, 1, 0, 1]  统计之后为  [1, 1, 3, 5, 6, 6, 7]
 * 6. 定义存放最终结果的数组int[] afterSortArr = new int[arr.length];
 * 7. 遍历取原始数组arr中的元素arr[i]，同时取出countingArr中对应该元素的值int index = countingArr[arr[i]-min]
 *      afterSortArr[index-1]= arr[i], 并对 countingArr[arr[i]-min] 减一
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 7, 3, 5, 4, 1};
        sort(arr);
    }

    public static int[] sort(int[] arr) {
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
        //5. 对桶数组进行统计，arr[k]= 原始数组中比k小的数的个数 + k的个数
        int count = 0;
        for (int i = 0; i < countingArr.length; i++) {
            count += countingArr[i];
            countingArr[i] = count;
        }
        System.out.println("桶数组统计结果：" + Arrays.toString(countingArr));
        //6. 定义排序后的最终数组
        int[] arrAfterSort = new int[arr.length];
        //7. 从后往前扫描原始数组，并找到在统计后桶中的值-1，即为该元素在原始索引
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = countingArr[arr[i] - min];
            arrAfterSort[index - 1] = arr[i];
            countingArr[arr[i] - min]--;
            System.out.println(Arrays.toString(arrAfterSort));
        }
        System.out.println("原始数组：" + Arrays.toString(arr));
        System.out.println("排序数组：" + Arrays.toString(arrAfterSort));
        return arrAfterSort;
    }

    /**
     * 获取最大值
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
     * 获取最小值
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
