package houzm.accumulation.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Package: houzm.accumulation.array
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/15 18:25
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： generic array
 */
public class ArrayGeneric<T> {

    protected T[] array; //数组
    protected int capacity; //初始容量
    protected int current; //数组中实际插入元素个数
    protected static final int DEFUALT_CAPACITY = 10; // 默认初始容量

    public ArrayGeneric(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public ArrayGeneric() {
        this.capacity = DEFUALT_CAPACITY;
        array = (T[]) new Object[DEFUALT_CAPACITY];
    }

    public T find(int index) {
        if (index < 0 || index > current) {
            System.out.println(" index illegal ");
            return null;
        }
        return array[index];
    }

    public boolean add(T value) {
        if (current == 0) {
            array[0] = value;
            ++current;
        }
        return insert(current - 1, value);
    }

    public boolean insert(int index, T value) {
        //1. 非法参数
        if (index < 0 || index > current) {
            System.out.println(" index illegal ");
            return false;
        }

        //2 临界值: 数组已满
        if (current == capacity) {
            System.out.println(" array has already bean filled ");
            return false;
        }

        //3. 临界值: 最大边界(最小边界在下面的逻辑中包含)
        if (index == current) {
            array[index] = value;
            ++current;
            return true;
        }

        for (int i = current; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        ++current;
        return true;
    }

    public T delete(int index) {
        //1. 非法参数
        if (index < 0 || index > current) {
            System.out.println(" index illegal ");
            return null;
        }
        //2. 临界值：数组为空
        if (current == 0) {
            System.out.println(" array is empty  ");
            return null;
        }
        T temp = array[index];
        //3. 临界值：删除最后一个元素
        if (index == current - 1) {
            array[index] = null;
            --current;
            return temp;
        }

        //4. 删除数组元素
        for (int i = current - 1; i > index; i--) {
            array[i - 1] = array[i];
        }
        array[current - 1] = null;
        --current;
        return temp;

    }

    public static void main(String[] args) {
        ArrayGeneric testarrays = new ArrayGeneric<Object>();
        //0. 数组准备
        IntStream.rangeClosed(0, 4).forEach(key -> {
            testarrays.insert(key, new Object());
        });
        System.out.println("arrays : " + testarrays);
        //1. 测试插入
        testarrays.insert(2, new ArrayList<Object>());
        System.out.println("arrays : " + testarrays);
        //2. 测试删除
        Object delete = testarrays.delete(3);
        System.out.println("delete old value : " + delete);
        System.out.println("arrays : " + testarrays);
        //3. 测试添加
        IntStream.rangeClosed(5, 9).forEach(key -> {
            testarrays.add(new Object());
        });
        System.out.println("arrays : " + testarrays);
        //4. 测试插入
        boolean insert = testarrays.insert(1, new Object());
        System.out.println("insert result : " + insert);
        System.out.println("arrays : " + testarrays);
    }

    @Override
    public String toString() {
        return "ArrayGeneric{" +
                "array=" + Arrays.toString(array) +
                ", capacity=" + capacity +
                ", currentSize=" + current +
                '}';
    }
}
