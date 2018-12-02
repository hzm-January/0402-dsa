package houzm.accumulation.dsa.inaction;

import houzm.accumulation.dsa.SequenceStackDynamicAllocationDeep;

/**
 * Author: hzm_dream@163.com
 * Date:  2018/12/2 18:46
 * Modified By:
 * Description：栈实现浏览器前进后退
 *
 *  stack         bak stack
 * ----------    ----------
 * |        |    |        |
 * |        |    |        |
 * |   c    |    |        |
 * |   b    |    |    e   |
 * |   a    |    |    d   |
 * ----------    ----------
 */
public class Browser {

    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.showCurrentPage();
        browser.open("http://www.baidu.com");
        browser.open("http://www.sohu.com");
        browser.open("http://www.sina.com");
        browser.open("http://www.google.com");
        browser.showCurrentPage();
        browser.forward(); //cannot go forward , no pages ahead
        //测试后退
        browser.back();
        browser.back();
        browser.back();
        browser.back();
        browser.back();
        //测试前进
        browser.forward();
        browser.forward();
        browser.forward();
        browser.forward();
        browser.forward();

        //测试后退后，跳转到新页面
        browser.back();
        browser.open("http://www.yoku.com");
        browser.forward();
    }

    //当前页，用于刷新
    private String currentPage;
    //栈--用于记录浏览记录
    private SequenceStackDynamicAllocationDeep<String> stack;
    //栈--用于记录后退弹出的那些页面，以便再次前进访问
    private SequenceStackDynamicAllocationDeep<String> bakStack;

    public Browser() {
        stack = new SequenceStackDynamicAllocationDeep<>(10);
        bakStack = new SequenceStackDynamicAllocationDeep<>(10);
    }

    /**
     * 打开新页面
     * @param page
     */
    public void open(String page) {
        this.currentPage = page;
        stack.push(page);
        bakStack.clear();
        System.out.println(" open the page : "+ this.currentPage);
    }

    /**
     * 刷新页面
     * @return
     */
    public String flush() {
        System.out.println(" the current page is flushed : "+ this.currentPage);
        return this.currentPage;
    }

    /**
     * 刷新页面
     * @return
     */
    public String showCurrentPage() {
        System.out.println(" the current page is : "+ this.currentPage);
        return this.currentPage;
    }

    /**
     * 前进
     * @return
     */
    public String forward() {
        if (canforward()) {
            currentPage = bakStack.pop();
            System.out.println(" go forward the page : "+currentPage);
            stack.push(currentPage);
            return currentPage;
        } else {
            System.out.println(" cannot go forward , no pages ahead ");
            return null;
        }
    }

    /**
     * 后退
     * @return
     */
    public String back() {
        if (canBack()) {
            currentPage = stack.pop();
            bakStack.push(currentPage);
            System.out.println(" go back the page : "+currentPage);
            return currentPage;
        } else {
            System.out.println(" cannot go back , no pages behind ");
            return null;
        }
    }

    /**
     * 校验--是否可以前进
     * @return true 可以 false不可以
     */
    private boolean canforward() {
        return bakStack.getSize() > 0;
    }
    /**
     * 校验--是否可以后退
     * @return true 可以 false不可以
     */
    private boolean canBack() {
        return stack.getSize() > 0;
    }
}
