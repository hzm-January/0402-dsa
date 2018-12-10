package houzm.accumulation.dsa.square;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/4 11:03
 * description: 冒泡排序(Bubble Sort)
 *
 * 描述：
 *      相邻两个元素比较大小，如果不符合顺序规则，交换位置
 *      区域划分：已排序区，未排序区。
 *      每轮会确定一个元素的位置。
 *      无论如何优化：交换次数==逆序度
 *
 * 衡量该排序算法的因素
 *
 * 1. 排序算法的执行效率
 *
 * 1.1 时间复杂度分析
 * 1.1.1 最好情况时间复杂度：O(n)；
 * 1.1.2 最坏情况时间复杂度：O(n^2)；
 * 1.1.3 平均情况时间复杂度：
 *          最好情况：有序度：n*(n-1)/2，逆序度：0，满有序度：n*(n-1)/2；逆序度为0，交换次数为0，比较次数n^2
 *          最坏情况：有序度：0，逆序度：n*(n-1)/2，满有序度：n*(n-1)/2；逆序度为n*(n-1)/2，交换次数为n*(n-1)/2，比较次数n^2
 *          上述分析得出：交换次数平均为：n*(n-1)/4；比较次数平均为：n^2
 *          最终结论：n^2
 *
 * 1.2 系数，常数，低阶
 * 1.3 比较次数：；交换次数：；移动次数：；
 *
 *
 * 2. 排序算法的内存消耗(空间复杂度)：原地排序O(1)
 * 3. 排序算法的稳定性
 *      稳定---在比较后，如果大小相等的情况下算法没有交换元素，所以稳定
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = new int[]{6,4,5,1,3,2};
        int[] arr = new int[]{3, 5, 5, 1, 3, 2};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {
            //记录是否有交换发生的标志位，用于提前退出冒泡循环
            boolean flag = false;
            for (int i = arr.length - 1; i > j; i--) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break; //没有数据交换，退提前出，避免后续无效的比较
            }
        }
    }
}
