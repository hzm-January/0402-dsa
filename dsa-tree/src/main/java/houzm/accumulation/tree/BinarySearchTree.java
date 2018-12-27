package houzm.accumulation.tree;

/**
 * Author: hzm_dream@163.com
 * Date:  2018/12/27 7:40
 * Modified By:
 * Description：二叉查找树(二叉搜索树)
 * 二叉查找树：树种的任意一个节点，其左子树的每个节点的值，都要小于这个节点的值，而右子树的每个节点的值都大于这个节点的值
 * 时间复杂度：
 * 最好时间复杂度：O(logn)
 * 最坏时间复杂度：O(n)----此时树已退化为了链表
 * 平均时间复杂度：
 * 空间复杂度：
 */
public class BinarySearchTree {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        tree.insert(5);
        tree.insert(8);
        tree.insert(3);
        tree.insert(4);
        tree.printAll();
        System.out.println();
        tree.delete(8);
        tree.printAll();
        System.out.println();
        tree.delete(4);
        tree.printAll();
        System.out.println();
    }

    private Node root;

    public void printAll() {
        inOrder(root);
    }

    private void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        System.out.print(p + " ");
        inOrder(p.right);
    }

    /**
     * 插入
     *
     * @param value
     */
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        Node p = root;
        while (p != null) {
            if (p.data > value) {
                if (p.left == null) {
                    p.left = new Node(value);
                    return;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new Node(value);
                    return;
                }
                p = p.right;
            }
        }
    }

    public Node find(int value) {
        Node p = root;
        while (p != null && p.data != value) {
            if (p.data > value) {
                p = p.left;
            } else if (p.data < value) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    public void delete(int value) {
        //1. search
        Node p = root;
        Node pp = null;
        while (p != null && p.data != value) {
            pp = p;
            if (p.data > value) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }

        if (p.left != null && p.right != null) {
            Node q = p;
            Node qp = null;
            while (q != null) {
                qp = q;
                if (q.left != null) {
                    q = q.left;
                } else {
                    q = q.right;
                }
            }
            // q即为右子树最小
//            p.data = q.data;
            p = q;
            pp = qp;
        }

        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {
            root = null;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    public class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
