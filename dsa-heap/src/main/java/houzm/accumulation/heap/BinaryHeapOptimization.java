package houzm.accumulation.heap;

import java.util.Arrays;

/**
 * Author: hzm_dream@163.com
 * Date:  2019/2/26 7:20
 * Modified By:
 * Description：binary heap （大顶堆） 代码优化版
 */
public class BinaryHeapOptimization {
    private int[] heap; //堆
    private int count; //堆中实际元素个数
    private int capacity; //堆容量
    private static final int DEFAULT_CAPACITY = 16; //默认堆容量

    public BinaryHeapOptimization() {
        this.capacity = DEFAULT_CAPACITY;
        heap = new int[capacity];
    }

    public BinaryHeapOptimization(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
    }

    // 插入元素
    public boolean add(int data) {
        if (count == capacity + 1) {
            System.out.println(" the heap is fulled ");
            return false;
        }
//        if (heap == null) {
//            heap[++count] = data;
//            return true;
//        }
        heap[++count] = data;
        int n = count;
        while (n / 2 > 0 && heap[n] > heap[n / 2]) {
            swap(heap, n, n / 2);
            n = n / 2;
        }
        return true;
    }

    // 删除堆顶元素
    public boolean removeRoot() {
        // swap
        swap(heap, 1, count);
        heap[count--]=0;
        // heapfiy
        int n = 1;
        while (true) {
            int maxPos = n;
            if (2 * n <= count && heap[n] < heap[2 * n]) {
                maxPos = 2 * n;
            }
            if (2 * n + 1 <= count && heap[maxPos] < heap[2 * n + 1]) {
                maxPos = 2 * n + 1;
            }
            if (maxPos == n) {
                break;
            }
            swap(heap, n, maxPos);
            n = maxPos;
        }
        return true;
    }

    /**
     * swap
     *
     * @param heap
     * @param n
     * @param m
     */
    private void swap(int[] heap, int n, int m) {
        int temp = heap[m];
        heap[m] = heap[n];
        heap[n] = temp;
    }

    public static void main(String[] args) {
        BinaryHeapOptimization heap = new BinaryHeapOptimization(16);
        heap.add(1);
        heap.add(6);
        heap.add(4);
        heap.add(7);
        heap.add(5);
        heap.add(9);
        heap.add(2);
        heap.add(8);
        heap.add(3);
        System.out.println(Arrays.toString(heap.heap));
        heap.removeRoot();
        System.out.println(Arrays.toString(heap.heap));
    }
}
