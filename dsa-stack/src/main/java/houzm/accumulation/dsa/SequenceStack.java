package houzm.accumulation.dsa;

/**
 * Author: hzm_dream@163.com
 * Date:  2018/12/1 22:29
 * Modified By:
 * Description：顺序栈
 * <p>
 * 栈的操作：压栈，弹栈(出栈)
 */
public class SequenceStack<T> {

    //栈
    private T[] stack;
    // 栈的深度
    private Integer deep;
    // 栈顶索引
    private int topIndex;
    // 默认栈的深度
    private static final Integer DEFUALT_LENGTH = 16;

    public SequenceStack() {
        this.deep = DEFUALT_LENGTH;
        this.topIndex = 0; //方便理解，可省略
        stack = (T[]) new Object[deep];
    }

    public SequenceStack(int initialCapacity) {
        this.deep = initialCapacity;
        this.topIndex = 0; //方便理解，可省略
        stack = (T[]) new Object[deep];
    }

    /**
     * 压栈
     * @param t
     * @return
     */
    public boolean push(T t) {
        //1. 栈满校验
        if (topIndex == deep) {
            throw new IllegalStateException(" stack overflow ");
        }
        //2. 压栈
        stack[topIndex] = t;
        ++topIndex;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public T pop() {
        //1. 栈空校验
        if (topIndex == 0) {
            throw new IllegalStateException(" stack is empty ");
        }
        //2. 取出value
        T popValue = stack[topIndex - 1];
        --topIndex;
        return popValue;
    }

}
