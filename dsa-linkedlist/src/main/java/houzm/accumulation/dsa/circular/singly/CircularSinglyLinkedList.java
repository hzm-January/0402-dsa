package houzm.accumulation.dsa.circular.singly;

/**
 * author: hzm_dream@163.com
 * date: 2019/2/14 15:13
 * description: 单向循环链表
 */
public class CircularSinglyLinkedList<T> {

    private Node head; //头结点

    public boolean addToLast(T t) {
        Node<T> newNode = new Node<>(t, head);
        if (head == null) {
            head = newNode;
            head.next = head;
            return true;
        }
        Node p = head;
        while (p.next != head) {
            p = p.next;
        }
        p.next = newNode;
        return true;
    }

    public boolean addToHead(T t) {
        Node<T> newNode = new Node<>(t, null);
        if (head == null) {
            head = newNode;
            head.next = head;
            return true;
        }
        // 找到尾结点
        newNode.next = head;
        Node p = head;
        while (p.next != head) {
            p = p.next;
        }
        head = newNode; // 更新head
        p.next = head; // 更新尾结点后继指针
        return true;
    }

    public boolean removeToHead(){
        return true;
    }

    @Override
    public String toString() {
        StringBuilder allNode = new StringBuilder(100);
        Node p = head;
        if (p == null) {
            return "";
        }
        while (p.next != head) {
            allNode.append(p.data);
            allNode.append(" ");
            p = p.next;
        }
        allNode.append(p.data);
        return allNode.toString();
    }

    public class Node<T>{
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
