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
//        swap(heap, 1, count);
        heap[1] = heap[count];
        heap[count--] = 0;
        // heapify
        heapify(heap, 1, count);
        return true;
    }

    private void heapify(int[] heap, int n, int max) {
        while (true) {
            int maxPos = n;
            if (2 * n <= max && heap[n] < heap[2 * n]) {
                maxPos = 2 * n;
            }
            if (2 * n + 1 <= max && heap[maxPos] < heap[2 * n + 1]) {
                maxPos = 2 * n + 1;
            }
            if (maxPos == n) {
                break;
            }
            swap(heap, n, maxPos);
            n = maxPos;
        }
    }

    // sort
    public int[] sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int[] arrCopy = new int[arr.length];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);
        // heapify
        for (int i = arrCopy.length - 1 >> 2; i > 0; i--) {
            heapify(arrCopy, i, arrCopy.length - 1);
        }
        // sort
        int n = count;
        while (n > 1) {
            swap(arrCopy, 1, n);
            n--;
            heapify(arrCopy, 1, n);
        }
        return arrCopy;
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
        int[] sort = heap.sort(heap.heap);
        System.out.println(Arrays.toString(sort));
    }
}
