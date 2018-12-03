package houzm.accumulation.dsa;

/**
 * author: hzm_dream@163.com
 * date: 2018/12/3 15:22
 * description: 递归实战--电影院找自己的座位在第几排
 *
 *
 * 周末你带着女朋友去电影院看电影，现在坐在第几排啊？电影院里面太黑了，看不清，没法数
 *
 * 分析：
 * 看不清，没法数。于是需要就问前面一排的人他是第几排，你想只要在他的数字上加一，就知道自己坐在哪一排了
 * 但是前面的人也不知道自己再第几排，所以需要问前面的人，一直问到第一排，然后再一排排告诉后面自己在第几排
 *
 * 去第一排的过程叫：递
 * 从第一排回来的过程叫：归
 *
 */
public class FindSeat {

    public static void main(String[] args) {
        System.out.println("在第几排："+find(8));
        System.out.println("在第几排："+findNotRecursion(8));

    }

    public static int find(int n) {
        if (n == 1) {
            return 1;
        }
        return find(n-1)+1;
    }

    /**
     * 使用非递归方法解决问题
     */
    public static int findNotRecursion(int n) {
        int ret = 1;
        for (int i = 2; i <= n; i++) {
            ret = ret +1;
        }
        return ret;
    }
}
