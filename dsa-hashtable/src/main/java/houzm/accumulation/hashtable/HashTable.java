package houzm.accumulation.hashtable;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/28 15:32
 * description: 哈希表
 */
public class HashTable<K, V> {

    private int capacity; //初始容量
    private float loadFactor; //加载因子
    private final static int DEFAULT_CAPACITY = 16; //默认初始容量
    private final static int MAXIMUM_CAPACITY = 1 << 30; //最大容量
    private final static float DEFAULT_LOAD_FACTORY = 0.75f; //默认加载因子
    private int threshold; //加载因子


    public HashTable(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity : " + initialCapacity);
        }
        if (loadFactor < 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
//        this.threshold =
    }


    public class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }


    }
}
