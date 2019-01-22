package houzm.accumulation.dsa;

import java.util.Arrays;
import java.util.stream.IntStream;
import javax.sound.midi.Soundbank;

/**
 * author: hzm_dream@163.com
 * date: 2019/1/7 12:13
 * description: 排列组合
 * <p>
 * 假设n个数
 * 1.最后一位有n种情况
 * 2.除最后一位外有n-1个数
 * 得出：n个数的排列组合 == n个n-1个数的排列组合
 */
public class PermutationAndCombination {
    public static void main(String[] args) {
        int[] array = new int[4];
        IntStream.rangeClosed(0, 3).forEach(key -> {
            array[key] = key;
        });
        System.out.println("初始数组：" + Arrays.toString(array));
        //求数组元素排列组合数
        permutationAndCombination(array, array.length, array.length);
    }

    private static void permutationAndCombination(int[] array, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(array[i] + "");
            }
            System.out.println();
        }
        for (int i = 0; i < k; i++) {
            int temp = array[i];
            array[i] = array[k - 1];
            array[k - 1] = temp;
            System.out.println(i+" 递："+Arrays.toString(array));
            permutationAndCombination(array, n, k - 1);
            System.out.println(i+" 归："+Arrays.toString(array));
            temp = array[i];
            array[i] = array[k - 1];
            array[k - 1] = temp;
        }
    }

}
