package houzm.accumulation.dsa.doubly.sentinelhead;

/**
 * author: hzm_dream@163.com
 * date: 2019/2/13 14:32
 * description: 双向链表
 */
public class DoublyLinkedList<T> {

    private Node<T> head = new Node<T>((T)new Object(), null, null);

    //链表尾部添加
    public boolean addToLast(T t) {
        Node<T> newNode = new Node<>(t, null, null);
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        newNode.prev = p;
        p.next = newNode;
        return true;
    }

    //链表头部添加
    public boolean addToHead(T t) {
        Node<T> newNode = new Node<>(t, null, null);
        newNode.prev = head;
        newNode.next = head.next;
        head.next = newNode;
        return true;
    }

    //链表指定结点后添加
    public boolean addAfter(Node node, T t) {
//        Node<T> newNode = new Node<>(t, node, node.next);
//        node.next = newNode;
        node.next = new Node<>(t, node, node.next);
        return true;
    }

    //链表指定结点前添加
    public boolean addBefore(Node node, T t) {
        node.prev = new Node<T>(t, node.prev, node);
        return true;
    }

    //链表尾部删除
    public boolean removeLast() {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        if (p.prev == null) {
            //当前链表只有一个头哨兵结点
            return false;
        }
        p.prev.next = null;
        return true;
    }

    //链表头部删除
    public boolean removeHead() {
        if (head.next == null) {
            return true;
        }
        if (head.next.next != null) {
            head.next.next.prev = null;
        }
        head.next = head.next.next;
        return true;
    }

    //根据结点删除
    public boolean delNode(Node node) {
        // 校验链表是否为空
        if (head == null) {
            return false;
        }
        // 校验结点存在于链表
        Node p = head;
        while (p.next != null && p.data != node.data) {
            p = p.next;
        }
        if (p == null) {
            return false; //结点不存在
        }

        node.next.prev = node.prev; // 更改前驱指针
        node.prev.next = node.next; // 更改后继指针
        return true;
    }

    //根据值删除结点
    public boolean delNode(T t) {
        // 校验链表是否为空
        if (head == null) {
            return false;
        }
        // 定位结点
        Node p = head;
        while (p != null) {
            if (p.data == t) {
                break;
            }
        }
        if (p == null) {
            return false;
        }
        p.next.prev = p.prev;
        p.prev.next = p.next;
        return true;
    }

    //回文判断
    public boolean isPalindrome() {
        //获取中点
        Node p = null;
        Node q = null;
        while (p != null && q != null) {
            p = p.next;
            q = q.next.next;
        }
        Node left = null;
        Node right = null;
        if (q.next == null) {
            // 链表中有奇数个结点
            right = p.next;
            left = inverse(p).next;
        } else {
            // 链表中有偶数个结点
            right = p.next;
            left = inverse(p);
        }

        return compareLF(left, right);
    }

    //比较左右链表结点
    private boolean compareLF(Node left, Node right) {
        Node p = left;
        Node q = right;
        while (p != null && q != null) {
            if (p.next == q.next) {
                p = p.next;
                q = q.next;
                continue;
            } else {
                break;
            }
        }
        if (p == null && q == null) {
            return true;
        }
        return false;
    }

    //翻转链表
    private Node inverse(Node node) {
        Node p = node;
        Node next = null;
        Node prev = null;
        while (p.prev != head) {
            next = node.next;
            prev = node.prev;
            node.next = prev;
            node.prev = next;
            p = prev;
        }
        return node;
    }
    //链表翻转
    /**
     * 结点
     *
     * @param <T>
     */
    public class Node<T> {

        private T data; //数据
        private Node prev; //前驱指针
        private Node next; //后继指针

        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
}
