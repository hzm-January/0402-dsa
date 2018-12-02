package houzm.accumulation.dsa;

/**
 * Author: hzm_dream@163.com
 * Date:  2018/12/1 23:04
 * Modified By:
 * Description：链式栈
 */
public class LinkedStack<T> {

    private Node head = null;

    /**
     * 压栈
     *
     * @param t
     */
    public void push(T t) {
        if (t == null) {
            throw new IllegalStateException(" the param is null ");
        }
        if (head == null) {
            head = new Node(t, null);
        } else {
            Node newNode = new Node(t, null);
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
        }
    }

    /**
     * 弹栈
     * @return
     */
    public T pop() {
        //1. 合法校验
        if (head == null) {
            throw new IllegalStateException(" stack is empty ");
        }
        //2. 找到链尾节点前驱节点
        Node p = head;
        if (p.next == null) {
            T value = (T) p.data;
            head = null;
            return value;
        }
        while (p.next.next != null) {
            p = p.next;
        }
        T value = (T) p.next.data;
        p.next = null;
        return value;

    }

    /**
     * 打印所有节点
     */
    public void printAll() {
        if (head == null) {
            System.out.println(" stack is empty ");
        }
        Node p = head;
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
