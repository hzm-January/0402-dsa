package houzm.accumulation.test.util;

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
     * 创建数组并初始化
     * @param initial 量级
     * @return
     */
    public static int[] initIntArray(int initial) {
        int[] arr = new int[initial];
        IntStream.rangeClosed(0, initial-1).forEach(key -> {
            int num = (int) (Math.random() * initial) + 1;
//            int num = new Random().nextInt() + 1;
            arr[key] = num;
        });
        return arr;
    }

    public static long logStartTime() {
        long startTime = System.currentTimeMillis();
        System.out.println("start time : " + startTime);
        return startTime;
    }

    public static void logEndTime(long startTime) {
        long endTime = System.currentTimeMillis();
        System.out.println("end time : " + endTime);
        System.out.println("use time in the unit of milliseconds : " + (endTime - startTime)+" ms");
        System.out.println("use time in the unit of seconds : " + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime)+" s");
    }
}
