/**
 * Package: PACKAGE_NAME
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/15 19:36
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： LinkedList 单向链表
 */
public class LinkedList<T> {

    private Node head = null;

    //添加---链表尾部添加---顺序插入
    public void addToLast(T t) {
        linkLast(t);
    }
    //添加---链表头部添加
    public void addToHead(T t) {
        //1. 创建节点
        Node node = new Node(t, null);
        //2. 头部添加
        if (head == null) {
            //2.1 头部节点为空
            head = node;
        } else {
            //2.2 头部节点不为空
            node.next = head;
            head = node;
        }

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
        if (node == head) {
            //2.1 node==head 在当前头部节点前添加 O(1)
            addToHead(t);
        } else {
            //2.2 找到node前一个节点，并在其之后添加新节点 O(n)
            Node newNode = new Node(t, null);
            Node p = head;
            while (p != null&&p.next!=node) {
                p = p.next;
            }
            if (p == null) {
                throw new IllegalArgumentException(" the param of node is not exist in link list");
            }
            addAfter(p, newNode);
        }
    }

    //删除--链表尾部删除
    public T deleteLast() {
        //1. 合法校验
        if (head == null) {
            throw new IllegalStateException(" the link list is empty ");
        }
        //2. 尾部节点删除
        if (head.next == null) {
            //2.1 当前链表只有一个头节点，删除头节点
            return deleteOnlyHead();
        } else {
            //2.2 当前链表有多个节点，找到尾节点，并删除
            Node node = head;
            while (node.next.next != null) {
                node = node.next;
            }
            T deleteNodeData = (T) node.next.data;
            node.next = null;
            return deleteNodeData;
        }
    }

    //删除--链表头部删除
    public T deleteFirst() {
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
            head = null;
            head = newHead;
            return deleteNodeData;
        }
    }

    //根据节点删除
    public T deleteByNode(Node node) {
        //1. 合法校验
        if (head == null) {
            throw new IllegalStateException(" the link list is empty ");
        }
        if (node == null) {
            throw new IllegalStateException(" the param of node is null ");
        }
        //2. 删除节点
        if (node == head) {
            //2.1 当前链表只有一个头节点，删除头节点
            return deleteOnlyHead();
        } else {
            //2.1 当前链表有多个节点
            //找到前驱节点
            Node p = head;
            while (p!=null && p.next != node) {
                p = p.next;
            }
            if (p == null) {
                return null;
            }
            T deleteNodeData = (T) p.next.data;
            p.next = null;
            return deleteNodeData;
        }
    }

    /**
     * 根据值删除
     * @param t
     * @return
     */
    public Boolean deleteByValue(T t) {
        if (head == null) {
            throw new IllegalStateException(" the link list is empty ");
        }
        if (t == null) {
            throw new IllegalStateException(" the param is null ");
        }
        boolean flag = false;
        if (t == head.data) {
            T deleteNodeData = deleteOnlyHead();
            if (deleteNodeData == t) {
                flag = true;
            }
        }else {
            Node p = head;
            while (p != null && p.next.data != t) {
                p = p.next;
            }
            if (p == null) {
                throw new IllegalStateException(" the value is not exist in link list ");
            }
            p.next = null;
            flag = true;
        }
        return flag;
    }

    /**
     * 删除头结点 并且 当前链表只有一个节点为头结点
     * @return
     */
    private T deleteOnlyHead() {
        T deleteNodeData = (T) head.data;
        head = null;
        return deleteNodeData;
    }

    /**
     * 在指定节点后，添加新节点
     * @param node
     * @param newNode
     */
    private void addAfter(Node node, Node newNode) {
        newNode.next = node.next;
        node.next = newNode;
    }

    private void linkLast(T t) {
        //1. 创建新节点
        Node newNode = new Node(t, null);
        //2. 尾部添加
        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            addAfter(p, newNode);
        }
    }


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
