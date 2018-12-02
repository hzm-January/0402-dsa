package houzm.accumulation.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/15 18:25
 * Description： generic array resizeGrow
 */
public class ArrayGenericResize<T> {


    protected T[] array; //数组
    protected int currentSize; //数组中实际插入元素个数
    protected static final int DEFUALT_CAPACITY = 10; // 默认初始容量
    protected static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8; //允许数组最大容量

    public ArrayGenericResize(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public ArrayGenericResize() {
        array = (T[]) new Object[DEFUALT_CAPACITY];
    }

    /**
     * 查找
     *
     * @param index
     * @return
     */
    public T find(int index) {
        if (index < 0 || index > currentSize) {
            System.out.println(" index illegal ");
            return null;
        }
        return array[index];
    }

    /**
     * 添加
     *
     * @param value
     * @return
     */
    public boolean add(T value) {
        if (currentSize == 0) {
            array[0] = value;
            ++currentSize;
        }
        return insert(currentSize - 1, value);
    }

    /**
     * 插入
     *
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, T value) {
        //1. 非法参数
        if (index < 0 || index > currentSize) {
            System.out.println(" index illegal ");
            return false;
        }

        //2 临界值: 数组已满
        if (currentSize == array.length) {
            //扩容1.5
            resizeGrow(array.length + array.length >> 1);
        }

        //3. 临界值: 最大边界(最小边界在下面的逻辑中包含)
        if (index == currentSize) {
            array[index] = value;
            ++currentSize;
            return true;
        }

        for (int i = currentSize; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        ++currentSize;
        return true;
    }

    /**
     * 扩容
     *
     * @param minCapacity
     */
    private void resizeGrow(int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalStateException(" capacity illegal ");
        }
        int oldCapacity = array.length;
        int newCapacity = oldCapacity + oldCapacity >> 1; //1.5
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            if (newCapacity > MAX_ARRAY_SIZE) {
                newCapacity = Integer.MAX_VALUE;
            } else {
                newCapacity = MAX_ARRAY_SIZE;
            }
        }
        T[] newarray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newarray, 0, array.length);
        array = newarray;
    }

    /**
     * 缩容
     *
     * @param minCapacity
     */
    private void resizeReduce(int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalStateException(" capacity illegal ");
        }
        if (currentSize == array.length / 4 && array.length / 2 != 0) {
            int newCapacity = array.length >> 1; //0.5
            if (minCapacity < newCapacity) {
                newCapacity = minCapacity;
            }
            T[] newarray = (T[]) new Object[newCapacity];
            System.arraycopy(array, 0, newarray, 0, newCapacity);
            array = newarray;
        }
    }

    public T delete(int index) {
        //1. 非法参数
        if (index < 0 || index > currentSize) {
            System.out.println(" index illegal ");
            return null;
        }
        //2. 临界值：数组为空
        if (currentSize == 0) {
            System.out.println(" array is empty  ");
            return null;
        }
        T temp = array[index];
        //3. 临界值：删除最后一个元素
        if (index == currentSize - 1) {
            array[index] = null;
            --currentSize;
            return temp;
        }

        //4. 删除数组元素
        for (int i = currentSize - 1; i > index; i--) {
            array[i - 1] = array[i];
        }
        array[currentSize - 1] = null;
        --currentSize;
        //缩容
        resizeReduce(array.length >> 1);
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
                ", capacity=" + array.length +
                ", currentSize=" + currentSize +
                '}';
    }
}
