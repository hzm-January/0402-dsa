# 递归
## 什么是递归
在运行中调用自己
## 递归要素
+ 一个问题可以分解为几个子问题的解
+ 这个问题与分解后的子问题，除了数据规模不同，求解思路完全一样
+ 存在递归终止条件
## 如何编写递归代码
+ 写出递归公式
+ 找到终止条件
+ 将递归公式和终止条件翻译为代码
## 递归代码注意事项
+ 警惕堆栈溢出    
    + 解决方案：设置最大深度限制
+ 警惕重复计算
    + 解决方案：使用容器记录计算结果，比如散列表
## 如何将递归代码修改为非递归代码
> 将递归改为"手动"递归
+ 理论来讲，所有的递归代码都可以写为迭代循环的代码  
+ 非递归代码并没有解决递归代码带来的问题，只是增加了实现复杂度
 