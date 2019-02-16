# 排序
## 如何分析排序算法
+ 最好、最坏、平均时间复杂度
+ 内存消耗（空间时间复杂度）
+ 稳定性
+ 时间复杂度的系数、低阶、常数
    + 同阶复杂度的排序算法的性能对比，需要考虑系数、低阶、常数
+ 比较次数和交换（或移动）次数
    + 基于比较的排序算法涉及两种操作：比较和交换
## 相关概念
稳定性
+ 稳定：如果a原本在b前面，而a=b，排序之后a仍然在b的前面
+ 不稳定：如果a原本在b的前面，而a=b，排序之后 a 可能会出现在 b 的后面

有序度和逆序度
+ 有序元素对：a[i] <= a[j]，如果i < j
+ 逆序元素对：a[i] > a[j]，如果i < j
+ 有序度：数组中具有有序关系的元素对个数；
+ 逆序度：数组中具有逆序关系的元素对个数；
+ 满有序度：完全有序数组的有序度
+ 逆序度 = 满有序度-有序度
## 排序种类
|排序算法|时间复杂度（平均）|时间复杂度（最好）|时间复杂度（最坏）|空间复杂度|基于比较|稳定性|
|:-:|:-:|:-:|:-:|:-:|
|冒泡排序|O(n^2)|O(n)|O(n^2)|O(1)|是|是|
|插入排序|O(n^2)|O(n)|O(n^2)|O(1)|是|是|
|选择排序|O(n^2)|O(n^2)|O(n^2)|O(1)|是|否|
## 冒泡排序（Bubble Sort）

![冒泡排序](https://github.com/hzm-January/0402-dsa/blob/master/dsa-algorithm-sort/src/main/resources/sortimages/bubble.gif)
## 选择排序
![选择排序](https://github.com/hzm-January/0402-dsa/blob/master/dsa-algorithm-sort/src/main/resources/sortimages/selection.gif)
## 插入排序
![插入排序](https://github.com/hzm-January/0402-dsa/blob/master/dsa-algorithm-sort/src/main/resources/sortimages/insert.gif)
## 参考
[https://www.cnblogs.com/onepixel/p/7674659.html](https://www.cnblogs.com/onepixel/p/7674659.html)  


