package houzm.accumulation.skiplist;

import java.util.Random;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/24 13:52
 * description: 跳表
 * 定义：链表+多级索引的动态数据结构
 * 时间复杂度：
 *      查找：O(logn)
 *      插入：O(logn)
 *      删除：O(logn)
 * 时间复杂度分析：
 *      假设节点数为n，索引高度为h，每层节点数是上一层节点数的1/2
 *      第一层索引节点数为n/2
 *      第二层索引节点数为n/2^2
 *      第三层索引节点数为n/2^3
 *      ....
 *      第h层索引节点数为n/2^h
 *
 *      结论：最高索引层节点数有2个 n/2^h=2 => h = logn-1
 *      如果加上链表层，那么跳表的高度为h = logn
 *
 *      每层最多需要查找3个节点，总共需要遍历的节点数为3logn，则时间复杂度为f(n)=O(logn)
 *
 * 如何让跳表的查找时间复杂度退化为O(n)
 *      每次插入都插入到两个索引节点之间
 *      o   o
 *      o o o
 *      ooooooooooooo
 *      解决方案：
 *      使用随机函数保证跳表的时间复杂度为O(logn)。
 *      保证每次插入节点的时候，将该节点插入到部分索引中。
 *      如果随机函数返回K，那么将该节点插入到链表和小于k的所有索引层中
 * 空间复杂度：
 *      O(n)
 *      假设节点数为n，索引高度为h，每层节点数是上一层节点数的1/2
 *      第一层索引节点数为n/2
 *      第二层索引节点数为n/2^2
 *      第三层索引节点数为n/2^3
 *      ....
 *      第h层索引节点数为2
 *
 *      结论：等比数列求和，需要额外空间存储的节点为n-2
 * 如何降低跳表的空间复杂度：
 *      增大索引节点间距
 *      上面举例是每层节点数是上一层节点数的1/2，假设是1/3
 *      第一层索引节点数为n/2
 *      第二层索引节点数为n/2^2
 *      第三层索引节点数为n/2^3
 *      ....
 *      第h-2层索引节点数为9
 *      第h-1层索引节点数为3
 *      第h层索引节点数为1
 *      结论：等比数列求和，需要额外空间存储的节点为n/2，尽管空间复杂度还是O(n)，但是比间距为2的空间复杂度降低了一半
 *
 */
public class SkipList {

    //最高索引层--最高限制
    private final int MAX_LEVEL = 16;
    //最低索引层
    private int levelCount = 1;
    //带头链表
    private Node head = new Node();
    //随机数
    private Random random = new Random();

    /**
     * 根据值查找节点
     *
     * @param value
     * @return
     */
    public Node find(int value) {
        Node p = head;
        // 查找
        for (int i = MAX_LEVEL - 1; i >= 0; --i) { //遍历所有层级
            //遍历当前层级，并取到最后一个小于value的节点
            while (p.forwords[i] != null && p.forwords[i].data < value) {
                p = p.forwords[i];
            }
        }
        // 此时在最底层的链表上
        if (p.forwords[0] != null && p.forwords[0].data == value) {
            return p.forwords[0];
        }
        return null;
    }

    /**
     * 插入实现方式2
     *
     * @param value
     */
    public void insertSecond(int value) {
        // 随机获取元素要插入的最高索引层
        // 保证跳表的查询复杂度O(logn)，避免大量节点堆积在一起，查找退化为O(n)
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        // 初始化查找轨迹
        Node[] orbit = new Node[level];
        for (int i = level - 1; i >= 0; i++) {
            orbit[i] = head;
        }
        // 开始查找并记录查找轨迹
        for (int i = level - 1; i >= 0; i++) {
            //遍历当前层级，并取到最后一个小于value的节点
            while (orbit[i].forwords[i] != null && orbit[i].forwords[i].data < value) {
                orbit[i] = orbit[i].forwords[i];
            }
        }
        // 交换指针进行节点插入
        for (int i = 0; i < level; i++) {
            newNode.forwords[i] = orbit[i].forwords[i];
            orbit[i].forwords[i] = newNode;
        }
        // 更新此刻level最高层数
        if (levelCount < level) {
            levelCount = level;
        }
    }

    /**
     * 插入实现方式1
     *
     * @param value
     */
    public void insert(int value) {
        // 随机获取元素要插入的最高索引层
        // 保证跳表的查询复杂度O(logn)，避免大量节点堆积在一起，查找退化为O(n)
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        // 初始化查找轨迹
        Node[] path = new Node[level];
        // 开始查找并记录查找轨迹
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            //遍历当前层级，并取到最后一个小于value的节点
            while (p.forwords[i] != null && p.forwords[i].data < value) {
                p = p.forwords[i];
            }
            path[i] = p; //记录每一层最后一个小于value的节点到轨迹中
        }
        // 交换指针进行节点插入
        for (int i = 0; i < level; i++) {
            newNode.forwords[i] = path[i].forwords[i];
            path[i].forwords[i] = newNode;
        }
        // 更新此刻level最高层数
        if (levelCount < level) {
            levelCount = level;
        }
    }

    /**
     * 删除节点
     *
     * @param value
     */
    public void delete(int value) {
        // 定义数组记录查找轨迹
        Node[] path = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwords[i] != null && p.forwords[i].data < value) {
                p = p.forwords[i];
            }
            path[i] = p; //记录每一层最后一个小于value的节点到轨迹中
        }
        // 链表是否存在该节点
        if (p.forwords[0] != null && p.forwords[0].data == value) {
            //遍历轨迹，进行删除的交换指针操作
            for (int i = levelCount - 1; i >= 0; --i) {
                // 当前索引层是否存在该节点
                if (path[i].forwords[i] != null && path[i].forwords[i].data == value) {
                    path[i].forwords[i] = path[i].forwords[i].forwords[i]; //交换指针
                }
            }
        }

    }

    /**
     * 打印所有节点信息
     */
    public void printAll() {
        Node p = head;
        while (p.forwords[0] != null) {
            System.out.print(p.forwords[0] + " ");
            p = p.forwords[0];
        }
        System.out.println();
    }

    /**
     * 随机函数获取元素插入的最高层级
     * 目的：防止跳表查找复杂度退化为O(n)
     *
     * @return
     */
    public int randomLevel() {
        int level = 1;
        for (int i = 0; i < MAX_LEVEL; i++) {
            if (random.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    public class Node {
        private int data;
        private Node[] forwords = new Node[MAX_LEVEL];
        private int maxLevel;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node[] getForwords() {
            return forwords;
        }

        public void setForwords(Node[] forwords) {
            this.forwords = forwords;
        }

        public int getMaxLevel() {
            return maxLevel;
        }

        public void setMaxLevel(int maxLevel) {
            this.maxLevel = maxLevel;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
//                    ", forwords=" + Arrays.toString(forwords) +
                    ", maxLevel=" + maxLevel +
                    '}';
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.printAll();
        System.out.println(8 + " 在跳表中的节点信息：" + skipList.find(8));
        skipList.insert(1);
        skipList.insert(2);
        skipList.insert(3);
        skipList.printAll();
        skipList.insert(6);
        skipList.insert(5);
        skipList.insert(4);
        skipList.printAll();
        System.out.println(9 + " 在跳表中的节点信息：" + skipList.find(9));
        System.out.println(4 + " 在跳表中的节点信息：" + skipList.find(4));
        skipList.delete(4);
        System.out.println(4 + " 在跳表中的节点信息：" + skipList.find(4));
    }
}
