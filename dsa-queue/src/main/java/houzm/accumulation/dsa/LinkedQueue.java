package houzm.accumulation.dsa;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/3 13:44
 * description: 链式队列--使用链表实现队列--有哨兵节点
 */
public class LinkedQueue<T> {

    private Node<T> sentinel = new Node(new Object(), null);

    /**
     * 入队
     *
     * @param t
     */
    public void enqueue(T t) {
        Node p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(t, null);
    }

    /**
     * 出队
     *
     * @return
     */
    public T dequeue() {
        if (sentinel.next == null) {
            throw new IllegalStateException(" queue is empty ");
        }
        T value = (T) sentinel.next.data;
        sentinel.next = sentinel.next.next;
        return value;
    }

    /**
     * 打印
     */
    public void printAll() {
        Node p = sentinel.next;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * 节点
     *
     * @param <T>
     */
    private static class Node<T> {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printAll();
    }

}
