package houzm.accumulation.dsa.linear;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/6 17:38
 * description: 基数排序
 * <p>
 * 问题：对10万手机号进行排序
 */
public class RadixSort {
    public static void main(String[] args) {
        String[] arr = new String[]{"15261530518", "14416762734", "18777237343"};
        sort(arr);
    }

    public static void sort(String[] arr) {
        int length = arr[0].length(); //手机号长度
        for (int i = 0; i < length; i++) {
            int charIndex = length - 1;
            sort(arr, charIndex);
        }



    }

    private static void sort(String[] arr, int charIndex) {
        System.out.println(Arrays.toString(arr));
        //1. 获取每个手机号index位置数字最小值min和最大值max
        int max = max(arr, charIndex);
        int min = min(arr, charIndex);
        System.out.println("最大值：" + max + " 最小值：" + min);
        //2. 获取桶个数
        int bucktes = max - min + 1;

        //3. 定义桶数组，下标为min-max范围内的数字
        int[] countingArr = new int[bucktes];

        //4. 统计原始数组中元素出现的次数，存入桶中
        for (int i = 0; i < arr.length; i++) {
            Integer num = strToInt(arr[i], charIndex);
            countingArr[num - min]++;
        }
        System.out.println(Arrays.toString(countingArr));

        //5. 累计k = 原始数组中元素出现次数+原始数组中小于该元素的元素出现次数
        for (int i = 1; i < countingArr.length; i++) {
            countingArr[i] = countingArr[i - 1] + countingArr[i];
        }
        System.out.println(Arrays.toString(countingArr));

        //6. 定义新数组
        String[] result = new String[arr.length];
        //7. 获取原始数组的元素，放到新数组对应的位置
        for (int i = 0; i < arr.length; i++) {
            Integer num = strToInt(arr[i], charIndex);
            int index = countingArr[num - min] - 1;
            result[index] = arr[i];
            countingArr[num - min]--;
        }

        System.out.println(Arrays.toString(result));
    }

    /**
     * 寻找最大值
     *
     * @param arr
     * @param charIndex
     * @return
     */
    private static int max(String[] arr, int charIndex) {
        int max = strToInt(arr[0], charIndex);
        for (int i = 0; i < arr.length; i++) {
            Integer num = strToInt(arr[i], charIndex);
            if (max < num) {
                max = num;
            }
        }
        return max;
    }

    /**
     * 寻找最小值
     *
     * @param arr
     * @param charIndex
     * @return
     */
    private static int min(String[] arr, int charIndex) {
        int min = strToInt(arr[0], charIndex);
        for (int i = 0; i < arr.length; i++) {
            Integer num = strToInt(arr[i], charIndex);
            if (min > num) {
                min = num;
            }
        }
        return min;
    }

    private static Integer strToInt(String s, int charIndex) {
        return Integer.valueOf(String.valueOf(s.charAt(charIndex)));
    }
}
