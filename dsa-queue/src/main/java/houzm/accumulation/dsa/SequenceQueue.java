package houzm.accumulation.dsa;

import java.util.Arrays;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/3 10:35
 * description: 顺序队列--使用数组实现的队列
 *
 */
public class SequenceQueue<T> {

    private T[] queue; //队列
    private int head; //队头
    private int tail; //队尾
    private static final Integer DEFAULT_QUEUE_LENGTH = 16;

    public SequenceQueue(Integer initialCapacity) {
        queue = (T[]) new Object[initialCapacity];
    }

    public SequenceQueue() {
        queue = (T[]) new Object[DEFAULT_QUEUE_LENGTH];
    }

    /**
     * 入队
     * 为了减少元素搬移次数，实现的时候只有在堆满的时候并且head前有空位置才进行元素搬移
     * 复杂度O(1)，在堆满搬移的时候使用均摊时间复杂度分析，将搬移的O(n)均摊到剩下的插入操作
     * @param t
     */
    public void enqueue(T t) {
        if (tail == queue.length) {
            //队满
//            throw new IllegalStateException(" the queue is full ");
            //队列元素搬移
            if (head == 0) {
                //如果head==0 && tail==queue.length 说明队满
                throw new IllegalStateException(" the queue is full ");
            } else {
                //如果head!=0 && tail==queue.length 说明队列0-head有空位置，可以迁移
                for (int i = head; i < tail; i++) {
                    queue[i-head] = queue[i];
                }
                tail = tail-head;
                head = 0;
            }
        }
        queue[tail++] = t;
    }

    /**
     * 出队
     */
    public T dequeue() {
        if (head == tail) {
            //队空
            throw new IllegalStateException(" the queue is empty ");
        }
        //
        return queue[head++];
    }

    /**
     * 打印所有队列元素
     */
    private void printAll() {
        System.out.print("队列所有元素：");
        for (int i = head; i < tail; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        SequenceQueue<Integer> queue = new SequenceQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printAll();
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.printAll();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.printAll();

    }
}
