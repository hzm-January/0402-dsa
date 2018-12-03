package houzm.accumulation.dsa;

/**
 * Author: hzm_dream@163.com
 * Date:  2018/12/1 23:10
 * Modified By:
 * Description：顺序栈--支持扩容
 * <p>
 * 栈的操作：压栈，弹栈(出栈)
 */
public class SequenceStackDynamicAllocationDeep<T> {
    //栈
    private T[] stack;
    // 栈的深度
//    private Integer deep;
    // 栈中元素个数
    private int size;
    // 默认栈的深度
    private static final Integer DEFUALT_STACK_DEEP = 16;
    // 最深栈深度
    private static final Integer MAX_STACK_DEEP = Integer.MAX_VALUE-8;

    public SequenceStackDynamicAllocationDeep() {
        this.size = 0; //方便理解，可省略
        stack = (T[]) new Object[DEFUALT_STACK_DEEP];
    }

    public SequenceStackDynamicAllocationDeep(int initialCapacity) {
        this.size = 0; //方便理解，可省略
        stack = (T[]) new Object[initialCapacity];
    }

    /**
     * 压栈
     *
     * @param t
     * @return
     */
    public boolean push(T t) {
        //1. 栈满校验
        if (size == stack.length) {
            resizeGrow(size+1);
        }
        //2. 压栈
        stack[size++] = t;
        return true;
    }

    /**
     * 出栈
     *
     * @return
     */
    public T pop() {
        //1. 栈空校验
        if (size == 0) {
            throw new IllegalStateException(" stack is empty ");
        }
        //2. 取出value
        T popValue = stack[--size];
        resizeReduce(stack.length>>1); //0.5
        return popValue;
    }

    public static void main(String[] args) {
        System.out.println(1>>1);
    }
    /**
     * 扩容
     */
    private void resizeGrow(int minCapacity) {
//        if (minCapacity < 0) {
//            throw new IllegalStateException(" capacity illegal ");
//        }
        if (minCapacity < DEFUALT_STACK_DEEP) {
            minCapacity = DEFUALT_STACK_DEEP;
        }
        int oldCapacity = stack.length;
        int newCapacity = oldCapacity + oldCapacity >> 1; //1.5
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_STACK_DEEP > 0) {
            if (minCapacity > MAX_STACK_DEEP) {
                newCapacity = Integer.MAX_VALUE;
            } else {
                newCapacity = MAX_STACK_DEEP;
            }
        }
        T[] newStack = (T[]) new Object[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }
    /**
     * 缩容
     * @param minCapacity
     */
    private void resizeReduce(int minCapacity) {
        if (minCapacity < 0) {
            throw new IllegalStateException(" capacity illegal ");
        }
        if (size == stack.length / 4 && stack.length / 2 != 0) {
            int newCapacity = stack.length >> 1; //0.5
            if (minCapacity < newCapacity) {
                newCapacity = minCapacity;
            }
            T[] newStack = (T[]) new Object[newCapacity];
            System.arraycopy(stack, 0, newStack, 0, newCapacity);
            stack = newStack;
        }
    }

    /**
     * 获取当前栈中实际元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 清空栈
     */
    public void clear() {
        size = 0;
    }

}
