package houzm.accumulation.dsa;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/3 14:12
 * description: 循环队列--数组实现
 * 循环队列可以避免 顺序队列中 元素入队时候的搬移操作
 * <p>
 * 队满条件：(tail+1)%queue.length == head
 * 队空条件：head==tail
 * 注：循环队列会浪费一个数组存储空间
 */
public class CircularQueue<T> {

    private T[] queue; //队列
    private int head; //队头指针
    private int tail; //队尾指针

    private static final Integer DEFAULT_CAPACITY = 16;

    public CircularQueue() {
        queue = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public CircularQueue(int initialCapacity) {
        queue = (T[]) new Object[initialCapacity];
    }

    public T dequeue() {
        if (isEmpty()) {
            //队空
            throw new IllegalStateException(" the queue is empty ");
        }
        T value = queue[head];
        head = (head + 1) % queue.length;
        return value;
    }


    /**
     * 入队
     *
     * @param t
     */
    public boolean enqueue(T t) {

        if (isFull()) {
            //队满
            throw new IllegalStateException(" the queue is full ");
            //例如tail = 9 head =0  length =10 (9+1)%10==0 此时tail位置为空，但是队列已满
            //所以 循环队列会浪费一个数组存储空间
        }
        //正常队尾添加
        queue[tail] = t;
        tail = (tail + 1) % queue.length;
        return true;
    }

    public void printAll() {
        if (isEmpty()) {
            //队满
            throw new IllegalStateException(" the queue is empty ");
        }
        System.out.print("队列所有元素：");
        int p = head;
        while (p != tail) {
            System.out.print(queue[p] + " ");
            p = (p + 1) % queue.length;
        }
        System.out.println();
    }

    /**
     * 是否队满
     *
     * @return
     */
    private boolean isFull() {
        return (tail + 1) % queue.length == head;
    }

    /**
     * 是否队空
     *
     * @return
     */
    private boolean isEmpty() {
        return head == tail;
    }

    public static void main(String[] args) {
        CircularQueue<Integer> circularQueue = new CircularQueue<>(4);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.printAll();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        circularQueue.printAll();
        circularQueue.enqueue(6); //the queue is full
    }
}
