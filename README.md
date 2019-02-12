# 数据结构与算法 学习笔记
## [数组](https://github.com/hzm-January/0402-dsa/tree/master/dsa-array)
## [链表](https://github.com/hzm-January/0402-dsa/tree/master/dsa-linkedlist)
## 什么是数据结构和算法
数据结构：存储数据的结构  
算法：操作数据的方法  
两者之间的关系：数据结构为算法服务，算法作用在特定的数据结构之上
## 为什么需要数据结构和算法
让代码运行更快更省空间
## 学习要点
来历  
特点  
适合解决的问题  
实际应用场景
## 复杂度分析
### 为什么需要复杂度分析
>事后统计法：运行目标代码，通过统计和监控得到执行时间和占用内存大小  
>>事后统计法的缺点:
>>1. 测试结果非常依赖测试环境，相同代码在不同的测试环境运行结果不一致
>>2. 测试结果受数据规模的影响很大，测试数据规模太小可能无法真实的反应算法的性能  

所以，需要一个不用具体的测试数据来测试，就可以粗略的估计算法的执行效率的方法

### 大O复杂度表示法
代码的执行时间T(n)与每行代码的执行次数n成正比
> **T(n)=O(f(n))**  
n: 数据规模  
f(n): 每行代码的执行次数总和  
T(n)：执行时间  

**注：大O表示法表示代码执行时间随数据规模增长的变化趋势，并不具体表示代码真正的执行时间，通常会忽略公式中的常量、低阶、系数**
### 时间复杂度（也称渐进时间复杂度，简称时间复杂度）
#### 如何分析时间复杂度
1. 只关注循环执行次数最多的一段代码（例：n+100+10000 循环次数最多的是n，所以时间复杂度为O(n)）
2. 加法法则：总时间复杂度等于量级最大的那段代码的时间复杂度（例：n^2+n+10000 量级最大的是n^2，所以时间复杂度为O(n^2)）
> 如果T1(n)=O(f(n))，T2(n)=O(g(n))；那么T(n)=T1(n)+T2(n)=max(O(f(n)),O(g(n)))=O(max(f(n),g(n)))

3. 乘法法则：嵌套代码的复杂度等于嵌套内外代码复杂度的乘机
> 如果T1(n)=O(f(n))，T2(n)=O(g(n))；那么T(n)=T1(n)*T2(n)=O(f(n))*O(g(n))=O(f(n)*g(n))

#### 常见的时间复杂度量级
多项式量级：
+ 常量阶：O(1)
+ 对数阶：O(logn) 
+ 线性阶：O(n)
+ 线性对数阶：O(nlogn)
+ 平方阶：O(n^2)
+ 立方阶：O(n^3)
+ k次方阶：O(n^k)  
#### 最好情况时间复杂度
在最理想情况下，执行代码的时间复杂度
#### 最坏情况时间复杂度
在最糟糕的情况下，执行代码的时间复杂度
#### 加权平均时间复杂度（也称期望时间复杂度，简称平均时间复杂度）
考虑各种情况发生的概率，计算概率论中的加权平均值（也叫期望值）
#### 均摊时间复杂度（特殊的平均时间复杂度）
>摊还分析法：例如数组扩容代码，每一次O(n)的插入操作，都会跟着n-1次O(1)的插入操作，
所以把耗时最多的那次操作均摊到接下来的n-1次操作上，这一组连续的操作的均摊时间复杂度就是O(1)

使用摊还分析法得到的时间复杂度称为均摊时间复杂度  
特点：
+ 大部分情况下，时间复杂度比较低（例如O(1)或其他），个别情况下，时间复杂度比较高（例如O(n)或者其他）
+ 低时间复杂度操作和高时间复杂度操作出现频率非常有规律，有一定的先后顺序，一般都是一个O(n)紧接着n-1个O(1)，循环往复


非多项式量级：
+ 指数阶：O(2^n)
+ 阶乘阶：O(n!)

### 空间复杂度（也称渐进空间复杂度）
表示算法的存储空间与数据规模之间的增长关系   
坐标图（出处：https://www.cnblogs.com/yuduxyz/p/9734367.html）侵删  
![坐标图](https://github.com/hzm-January/0402-dsa/blob/master/graph.jpg)

