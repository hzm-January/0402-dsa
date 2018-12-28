package houzm.accumulation.tree.unique;

/**
 * Author: hzm_dream@163.com
 * Date:  2018/12/27 7:40
 * Modified By:
 * Description：二叉查找树(二叉搜索树)--无重复元素
 * 树：由n（n>=1）个有限结点组成一个具有层次关系的集合。把它叫做“树”是因为它看起来像一棵倒挂的树，也就是说它是根朝上，而叶朝下的。
 *     每个结点有零个或多个子结点；没有父结点的结点称为根结点；每一个非根结点有且只有一个父结点；
 *     除了根结点外，每个子结点可以分为多个不相交的子树；
 * 根节点：没有父节点的节点
 * 叶子节点(叶节点)：没有子节点的节点
 * 节点的高度：节点到叶子节点的最长路径(边数)
 * 节点的深度：根节点到节点的最长路径(边数)
 * 节点的层：节点的深度+1
 * 树的高度：根节点的高度
 * 二叉树：每个节点最多有左右两个子节点
 * 满二叉树：叶子节点都在最底层，除了叶子结点外，每个节点都有左右两个子节点
 * 完全二叉树：叶子节点在最底下两层，最后一层的叶子节点都靠左排列
 * 二叉查找树：树种的任意一个节点，其左子树的每个节点的值，都要小于这个节点的值，而右子树的每个节点的值都大于这个节点的值
 * 完全二叉查找树 时间复杂度：
 *      最好时间复杂度：O(logn)
 *          分析：
 *              树的第一层节点数：1
 *              树的第二层节点数：2
 *              树的第三层节点数：4
 *              ......
 *              树的第h层节点数(是区间)：1~2^(h-1)  (1个节点~满二叉树)
 *          得出：
 *              n>=1+2+4+.....+2^(h-2)+1
 *              n<=1+2+4+.....+2^(h-1)
 *          根据等比数列求和公式：
 *              h范围为：[log(n+1), logn+1]
 *          则：
 *              二叉树的高度<logn
 *      最坏时间复杂度：O(n)----此时树已退化为了链表
 *      平均时间复杂度：
 *      空间复杂度：O(1)
 */
public class BinarySearchTree {

    private Node root; //根节点

    /**
     * 插入
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
            } else { //p.data < value
                if (p.right == null) {
                    p.right = new Node(value);
                    return;
                }
                p = p.right;
            }
        }
    }

    /**
     * 查找
     * @param value
     * @return
     */
    public Node find(int value) {
        //1. 查找
        Node p = root;
        while (p != null) {
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

    /**
     * 删除
     * @param value
     */
    public void delete(int value) {
        //1. 查找要删除节点
        Node p = root;
        Node pp = null; //父节点
        while (p.left != null && p.data != value) {
            pp = p;
            if (p.data > value) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        // 要删除节点不存在
        if (p == null) {
            return;
        }
        //2. 交换节点
        //2.1 如果要删除节点有左右子节点，找到右子树的最小值
        if (p.left != null && p.right != null) {
            Node q = p;
            Node qp = null;
            while (q.left != null) {
                qp = q;
                q = q.left;
            }
//            p.data = q.data;
            p = q;
            pp = qp;
        }

        //2.2 要删除的节点只有一个子节点
        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {
            root = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }

    }

    /**
     * find min
     * @return
     */
    public Node findMin() {
        if (root == null) {
            return null;
        }
        Node p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    /**
     * find max
     * @return
     */
    public Node findMax() {
        if (root == null) {
            return null;
        }
        Node p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    /**
     * 中序遍历
     */
    public void inOrderPrint() {
        Node p = root;
        inOrder(p);
    }

    private void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        System.out.print(p.data+" ");
        inOrder(p.right);
    }

    //节点
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
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
        tree.insert(5);
        tree.insert(8);
        tree.inOrderPrint();
        System.out.println();
        System.out.println("max: "+tree.findMax().data);
        System.out.println("min: "+tree.findMin().data);
        tree.delete(3);
        tree.inOrderPrint();
        System.out.println();
        tree.delete(5);
        tree.inOrderPrint();
        System.out.println();
        System.out.println(tree.find(4).data);
        //打印结果
//        1 3 4 5 8
//        max: 8
//        min: 1
//        3 4 5 8
//        3 4 8
//        4
    }
}
