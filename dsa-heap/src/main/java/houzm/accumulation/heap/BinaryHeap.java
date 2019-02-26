package houzm.accumulation.heap;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2019/2/22 11:28
 * description: 二叉堆 (大顶堆) 通俗易懂版
 */
public class BinaryHeap {

    private int capacity;
    private int count;
    private int[] heap;
    private static final int DEFAULT_HEAP_CAPACITY = 16;

    public BinaryHeap() {
        this.capacity = DEFAULT_HEAP_CAPACITY + 1;
        heap = new int[this.capacity];
    }

    public BinaryHeap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(" the capacity is illegal ");
        }
        this.capacity = capacity + 1;
        heap = new int[this.capacity];
    }

    public boolean add(int data) {
        // empty
        if (count == 0) {
            heap[++count] = data;
            return true;
        }
        // fulled
        if (count == capacity) {
            System.out.println(" the heap is fulled ");
            return false;
        }
        heap[++count] = data;
//        System.out.println(Arrays.toString(heap));
        //堆化（从下到上）
        int n = count;
        while (n / 2 > 0 && heap[n] > heap[n / 2]) {
            int temp = heap[n / 2];
            heap[n / 2] = heap[n];
            heap[n] = temp;
            n = n / 2;
        }
//        System.out.println("堆化结果：" + Arrays.toString(heap));
        return true;
    }

    public boolean removeRoot() {
        if (count == 1) {
            heap[count] = 0;
        }
        // swap
        heap[1] = heap[count];
        heap[count--] = 0;
        // 堆化（从上到下）
        int n = 1;
        while (2 * n + 1 <= count) {
            if (heap[n] < heap[2 * n]) {
                int temp = heap[2 * n];
                heap[2 * n] = heap[n];
                heap[n] = temp;
                n = 2 * n;
            } else if (heap[n] < heap[(2 * n) + 1]) {
                int temp = heap[(2 * n) + 1];
                heap[(2 * n) + 1] = heap[n];
                heap[n] = temp;
                n = 2 * n + 1;
            } else {
                break;
            }
        }
        System.out.println("删除（从上到下堆化）结果：" + Arrays.toString(heap));
        return true;
    }

    //堆排序
    public int[] sort() {
        int[] copyHeap = new int[count + 1];
        System.arraycopy(heap, 1, copyHeap, 1, count);
        // 堆排序
        int n = count;
        while (n > 0) {
            int temp = copyHeap[n];
            copyHeap[n] = copyHeap[1];
            copyHeap[1] = temp;
            n--;
            // 从上往下堆化
            int m = 1;
            while (true) {
                int maxPos = m;
                if (m * 2 < n && copyHeap[m] < copyHeap[m * 2]) {
                    maxPos = m * 2;
                }
                if (m * 2 + 1 < n && copyHeap[maxPos] < copyHeap[m * 2 + 1]) {
                    maxPos = m * 2 + 1;
                }
                if (maxPos == m) {
                    break;
                }
                int tempSwap = copyHeap[maxPos];
                copyHeap[maxPos] = copyHeap[m];
                copyHeap[m] = tempSwap;
                m = maxPos;
            }
        }
        return copyHeap;
    }

    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(10);
        binaryHeap.add(9);
        binaryHeap.add(2);
        binaryHeap.add(5);
        binaryHeap.add(9);
        binaryHeap.add(2);
        binaryHeap.add(5);
        binaryHeap.add(9);
        binaryHeap.add(2);
        System.out.println(Arrays.toString(binaryHeap.heap));
        //删除堆顶
        binaryHeap.removeRoot();
        System.out.println(Arrays.toString(binaryHeap.heap));
        int[] sort = binaryHeap.sort();
        System.out.println("堆排序结果：" + Arrays.toString(sort));


    }
}
