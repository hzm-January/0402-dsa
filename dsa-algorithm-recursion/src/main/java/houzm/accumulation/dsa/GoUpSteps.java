package houzm.accumulation.dsa;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/3 15:36
 * description: 递归实战--上台阶--斐波那契
 * <p>
 * 题目：若有n个台阶，每步可以走一个台阶或者两个台阶，问有多少种走法
 */
public class GoUpSteps {

    public static void main(String[] args) {
        System.out.println("有" + upSteps(4) + "走法");
        System.out.println("有" + upStepsNotRecursion(4) + "走法");
    }

    public static int upSteps(int n) {
        System.out.println(n);
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return upSteps(n - 1) + upSteps(n - 2);
    }

    /**
     * 使用非递归方法解决问题
     */
    public static int upStepsNotRecursion(int n) {
        int pre = 1;
        int prepre = 2;
        int ret = 0;
        for (int i = 3; i <= n; i++) {
            ret = pre + prepre;
            pre = prepre;
            prepre = ret;
        }
        return ret;
    }
}
