package houzm.accumulation.test.util;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/10 12:37
 * description: 排序练习 工具类
 */
public class SortUtil {

    public static final int TEN = 10;
    public static final int HUNDRED = 100;
    public static final int THOUSAND = 1000;
    public static final int MYRIAD = 10000;
    public static final int LAKH = 100000;
    public static final int MILLION = 1000000;

    /**
     * 创建数组并初始化--可能有重复元素
     *
     * @param initial 量级
     * @return
     */
    public static int[] initIntArray(int initial) {
        int[] arr = new int[initial];
        IntStream.rangeClosed(0, initial - 1).forEach(key -> {
            int num = (int) (Math.random() * initial) + 1;
//            int num = new Random().nextInt() + 1;
            arr[key] = num;
        });
        return arr;
    }

    /**
     * @param initial
     * @return
     */
    public static int[] initIntArrayNoRepeatDisorder(int initial) {
        return disorder(initIntArrayNoRepeat(initial));
    }


    /**
     * 创建数组并初始化--无重复--使用随机函数生成
     * 发现返回数据已经部分具有一定的顺序，@TODO 具体还不知道什么原因，可能是toArray做了优化
     *
     * @param initial 量级
     * @return
     */
    public static int[] initIntArrayNoRepeat(int initial) {
        int[] arr = new int[initial];
        Set<Integer> set = new HashSet<>();
        initIntArrayNoRepeat(initial, set);
        Integer[] arrInteger = set.toArray(new Integer[set.size()]);
        for (int i = 0; i < arrInteger.length; i++) {
            arr[i] = arrInteger[i];
        }
        return arr;
    }

    /**
     * 辅助方法--创建数组并初始化--无重复--使用随机函数生成
     *
     * @param initial
     * @param set
     */
    private static void initIntArrayNoRepeat(int initial, Set<Integer> set) {
        IntStream.rangeClosed(0, initial).forEach(key -> {
            if (set.size() > initial) {
                return;
            }
//            int num = new Random().nextInt() + 1;
            set.add((int) (Math.random() * initial) + 1);
        });
        if (set.size() < initial) {
            initIntArrayNoRepeat(initial, set);
        }
    }


    /**
     * 辅助方法
     * 打乱数组元素顺序
     *
     * @param arr
     * @return
     */
    private static int[] disorder(int[] arr) {
        int[] arrDisorder = new int[arr.length];
        System.arraycopy(arr, 0, arrDisorder, 0, arr.length);
        int p = 0; //快指针初始索引
        int q = 0; //慢指针初始索引
        int n = 3; //快指针每次累加次数
        int m = 2; //慢指针每次累加次数
        while (p <= arr.length - 1 - n) {
            p += n;
            int temp = arrDisorder[q];
            arrDisorder[q] = arrDisorder[p];
            arrDisorder[p] = temp;
            q += m;
        }
        return arrDisorder;
    }

    /**
     * 获取当前时间毫秒值，并打印
     *
     * @return
     */
    public static long logStartTime() {
        long startTime = System.currentTimeMillis();
        System.out.println("start time : " + startTime);
        return startTime;
    }

    /**
     * 打印程序执行时间
     *
     * @param startTime 开始执行程序的时间，毫秒值
     */
    public static void logEndTime(long startTime) {
        long endTime = System.currentTimeMillis();
        System.out.println("end time : " + endTime);
        System.out.println("use time in the unit of milliseconds : " + (endTime - startTime) + " ms");
        System.out.println("use time in the unit of seconds : " + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime) + " s");
    }
}
