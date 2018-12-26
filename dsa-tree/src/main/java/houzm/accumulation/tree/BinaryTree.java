package houzm.accumulation.tree;

/**
 * Author: hzm_dream@163.com
 * Date:  2018/12/27 7:40
 * Modified By:
 * Description：
 */
public class BinaryTree {

    public void insert(int value) {

    }

    public class Node {
        private int data;
        private Node left;
        private Node right;

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
}
