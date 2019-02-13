package houzm.accumulation.dsa.singly.sentinelhead;

/**
 * Package: PACKAGE_NAME
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/15 19:36
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：  单向链表---哨兵头节点
 * <p>
 * 哨兵不存储数据，节点永远存在
 * 作用：简化空链表的插入和删除操作，减少对链表插入第一个节点或者删除最后一个节点的特殊处理
 */
public class SinglyLinkedList<T> {

    private Node sentinel = new Node(new Object(), null);

    //添加---链表尾部添加---顺序插入
    public void addToLast(T t) {
        linkLast(t);
    }

    //添加---链表头部添加
    public void addToHead(T t) {
        //1. 创建节点
        Node node = new Node(t, null);
        //2. 头部添加
        //2.2 头部节点不为空
        node.next = sentinel.next;
        sentinel.next = node;

    }

    //添加---链表指定节点后添加 O(1)
    public void addAfter(Node node, T t) {
        if (node == null) {
            throw new IllegalArgumentException(" the param of node is null ");
        }
        Node newNode = new Node(t, null);
        addAfter(node, newNode);
    }

    //添加--链表指定节点前添加
    public void addBefore(Node node, T t) {
        //1. 参数合法
        if (node == null) {
            throw new IllegalArgumentException(" the param of node is null ");
        }
        //2. 在指定节点前添加
        //2.2 找到node前一个节点，并在其之后添加新节点 O(n)
        Node newNode = new Node(t, null);
        Node p = sentinel.next;
        while (p != null && p.next != node) {
            p = p.next;
        }
        if (p == null) {
            throw new IllegalArgumentException(" the param of node is not exist in link list");
        }
        addAfter(p, newNode);
    }

    //删除--链表尾部删除
    public T deleteLast() {
        //找到尾节点，并删除
        Node node = sentinel;
        if (node.next == null) {
            //若当前链表只有哨兵节点
            return null;
        }
        while (node.next.next != null) {
            node = node.next;
        }

        T deleteNodeData = (T) node.next.data;
        node.next = null;
        return deleteNodeData;
    }

    //删除--链表头部删除
    public T deleteFirst() {
        Node head = sentinel.next;
        //1. 合法校验
        if (head == null) {
            throw new IllegalStateException(" the link list is empty ");
        }
        //2. 头部节点删除
        if (head.next == null) {
            //2.1 当前链表只有一个头节点，删除头节点
            return deleteOnlyHead();
        } else {
            //2.2 当前链表有多个节点
            T deleteNodeData = (T) head.data;
            Node newHead = head.next;
            sentinel.next = newHead;
            return deleteNodeData;
        }
    }

    //根据节点删除
    public T deleteByNode(Node node) {
        //1. 合法校验
        if (node == null) {
            throw new IllegalStateException(" the param of node is null ");
        }
        //2. 删除节点
        //2.1 找到前驱节点
        Node p = sentinel.next;

        while (p != null && p.next != node) {
            p = p.next;
        }
        if (p == null) {
            // 当前链表为空, 或者node在链表中不存在
            throw new IllegalStateException(" the value is not exist in link list ");
        }
        T deleteNodeData = (T) p.next.data;
        p.next = p.next.next;
        return deleteNodeData;
    }

    /**
     * 根据值删除
     *
     * @param t
     * @return
     */
    public Boolean deleteByValue(T t) {
        //1. 校验合法
        if (t == null) {
            throw new IllegalStateException(" the param is null ");
        }
        Node p = sentinel.next;
        while (p != null && p.next.data != t) {
            p = p.next;
        }
        if (p == null) {
            throw new IllegalStateException(" the value is not exist in link list ");
        }
        p.next = p.next.next;
        return true;
    }

    /**
     * 删除头结点 并且 当前链表只有一个节点为头结点
     *
     * @return
     */
    private T deleteOnlyHead() {
        T deleteNodeData = (T) sentinel.next.data;
        sentinel.next = null;
        return deleteNodeData;
    }

    /**
     * 在指定节点后，添加新节点
     *
     * @param node
     * @param newNode
     */
    private void addAfter(Node node, Node newNode) {
        newNode.next = node.next;
        node.next = newNode;
    }

    /**
     * 尾部添加新节点
     *
     * @param t
     */
    private void linkLast(T t) {
        //1. 创建新节点
        Node newNode = new Node(t, null);
        //2. 尾部添加
        Node p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        addAfter(p, newNode);
    }

    /**
     * 回文判断
     *
     * @return
     */
    public boolean palindrome() {
        boolean flag = false;
        //1. 边界条件判断
        if (sentinel.next == null) {
            return false;
        }
        //2. 判断是否回文
        //2.1 查找中间节点
        Node p = sentinel.next;
        Node q = sentinel.next;
        while (p.next != null && q.next.next != null) {
            p = p.next; //p走一个步长
            q = q.next.next; //q走两个步长
        }
        Node left = null;
        Node right = null;
        if (q.next == null) { //链表总节点数目为奇数，p 一定是中间节点
            right = p.next;
            left = inverse(p).next;
        } else { //链表总节点数目为偶数，p 不是唯一的中间节点，这时候中间节点有两个
            right = p.next;
            left = inverse(p);
        }
        //回文比较核心代码
        compareLF(left, right);
        return flag;
    }

    /**
     * 回文判断-辅助方法
     * 比较两个链表的节点对应位置是否相同
     *
     * @param left
     * @param right
     * @return
     */
    private boolean compareLF(Node left, Node right) {
        Node p = left;
        Node q = right;
        while (p != null && q != null) {
            if (p.data == q.data) {
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

    /**
     * 链表反转-有哨兵节点
     */
    public Node inverse(Node p) {
        //pre反转链表初始节点
        Node pre = null;
        Node head = sentinel.next;
        Node e = head;
        Node next = null;
        while (e != p) {
            // 为了向前移动e，保留e.next
            next = e.next;
            // 核心操作：调整当前节点的next后继指针
            e.next = pre;
            pre = e;
            // 往前移动e
            e = next;
        }
        e.next = pre;
        return e; //返回从中间节点开始，完成反转的链表开始节点
    }

    /**
     * 反转链表--有哨兵节点
     */
    public Node inverse() {
        // 反转后的头节点
        Node head = null;
        Node p = sentinel.next;
        Node pre = null;
        while (p != null) {
            Node next = p.next;
            if (next == null) {
                head = p;
            }
            p.next = pre;
            pre = p;
            //向前移动
            p = next;
        }
        return head;
    }

    /**
     * 节点
     *
     * @param <T>
     */
    public static class Node<T> {
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
