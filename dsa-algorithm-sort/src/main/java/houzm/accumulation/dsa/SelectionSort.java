package houzm.accumulation.dsa;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/4 14:59
 * description: 选择排序(Selection sort)
 *
 * 描述：
 *  每轮循环，找到一个最值，将值与未排序区的第一个元素互换位置
 *
 *  1. 排序算法执行效率
 *  1.1 时间复杂度
 *  1.1.1 最好情况时间复杂度：O(n^2)
 *  1.1.2 最坏情况时间复杂度：O(n^2)
 *  1.1.3 平均情况时间复杂度：
 *          最好情况：有序度：n*(n-1)/2；逆序度：0；满有序度：n*(n-1)/2；逆序度为0，交换次数为0，比较次数n^2
 *          最坏情况：有序度：0；逆序度：n*(n-1)/2；满有序度：n*(n-1)/2；逆序度为n*(n-1)/2，交换次数为n*(n-1)/2，比较次数n^2
 *          上述分析得出：交换次数为n*(n-1)/4；比较次数为n^2
 *          平均情况：n^2
 *  1.2 常数，低阶，系数
 *  1.3 比较次数，交换次数，移动次数；
 *  2. 排序算法的内存消耗(空间复杂度)：原地排序O(1)
 *  3. 排序算法的稳定性：不稳定---3,5,5,1,3,2 第一个5与最后一个2交换，第二个5与3交换，顺序改变
 *
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{6,4,5,1,3,2};
//        int[] arr = new int[]{3,5,5,1,3,2};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int n = -1;
            for (int j = i; j < arr.length; j++) {
                if (temp > arr[j]) {
                    temp = arr[j];
                    n = j;
                }
            }
            if (n != -1) {
                // 找到本轮最小值元素
                arr[n] = arr[i];
                arr[i] = temp;
            }
        }
    }

}
