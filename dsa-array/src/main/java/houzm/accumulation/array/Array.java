package houzm.accumulation.array;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Package: houzm.accumulation.array
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/15 17:18
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 数组操作类
 */
public class Array {

    private int current; //实际存放元素个数
    private int capacity; //初始容量
    private int[] array;

    public Array(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public int find(int index) {
        if (index < 0) {
            System.out.println(" index illegal ");
            return -1;
        } else {
            return array[index]; //初始都为0，返回初始数字
        }

    }

    public boolean add(int value) {
        if (current == 0) {
            array[0] = value;
            return true;
        }
        return insert(current - 1, value);
    }

    /**
     * insert value to array
     * 此方法不支持任意位置插入，如：初始化后，插入三次在不同位置1|0|0|0|0|1|0|0|0|1，之后insert(5,2)
     *
     * @param index index of insert
     * @param value value of insert
     */
    public boolean insert(int index, int value) {

        //1. 非法校验
        if (index < 0 || index > current) {

            System.out.println(" index illegal ");
            return false;
        }

        //2. 数组是否已满
        if (current == capacity) {
            System.out.println("array has already been filled");
            return false;
        }
        if (current == 0) {
            //3. 数组第一次插入值
            array[0] = value;
            ++current;
            return true;
        }
        //4. 数组插入值
        for (int i = current; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        ++current;
        return true;

    }

    public int delete(int index) {

        //1. 非法校验
        if (index < 0) {
            return 0; //返回默认值
        }

        //2. 临界值 数组为空
        if (current == 0) {
            return 0; //如果数组为空，返回默认值
        }
        int temp = array[index];
        //2. 临界值 取当前数组中实际最后一个元素
        if (index == current - 1) {

            array[index] = 0;
            --current;
            return temp;
        }
        //3. 数组删除
        for (int i = current - 1; i > index; i--) {
            array[i - 1] = array[i];
        }
        array[current - 1] = 0;
        --current;
        return temp; //返回默认值
    }

    @Override
    public String toString() {
        return "Array{" +
                "currentSize=" + current +
                ", capacity=" + capacity +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    public static void main(String[] args) {
        Array testarray = new Array(10);
        IntStream.rangeClosed(0, 4).forEach((key) -> {
            testarray.insert(key, key);
        });
        System.out.println(testarray);
        int delete = testarray.delete(3);
        System.out.println(delete);
        System.out.println(testarray);


    }


}
