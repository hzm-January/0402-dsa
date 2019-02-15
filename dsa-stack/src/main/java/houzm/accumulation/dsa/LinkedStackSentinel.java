package houzm.accumulation.dsa;

/**
 * Author: hzm_dream@163.com
 * Date:  2018/12/1 23:04
 * Modified By:
 * Description：链式栈--哨兵节点
 */
public class LinkedStackSentinel<T> {

    private Node sentinel = new Node(new Object(), null);

    /**
     * 压栈
     *
     * @param t
     */
    public void push(T t) {
        if (t == null) {
            throw new IllegalStateException(" the param is null ");
        }
        Node p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(t, null);
    }

    /**
     * 弹栈
     *
     * @return
     */
    public T pop() {
        //2. 找到链尾节点前驱节点
        Node p = sentinel;
        if (p.next == null) {
            throw new IllegalStateException(" stack is empty ");
        }
        while (p.next.next != null) {
            p = p.next;
        }
        T value = (T) p.next.data;
        p.next = null;
        return value;

    }

    /**
     * 栈深度
     * @return
     */
    public int deep() {
        int deep = 0;
        Node p = sentinel.next;
        while (p != null) {
            deep++;
            p = p.next;
        }
        return deep;
    }


    /**
     * 打印所有节点
     */
    public void printAll() {
        if (sentinel.next == null) {
            System.out.println(" stack is empty ");
        }
        Node p = sentinel.next;
        while (p != null) {
            System.out.print(p.data + " ");
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

}
