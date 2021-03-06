# 数组
## 什么是数组
用一组**连续的内存空间**，存储一组具有**相同类型的数据**的一种**线性表结构**  
## 为什么数组可以被随机访问
数组定义中有两个限制，保证了数组可以被随机访问 
+ 连续的内存空间
+ 相同类型的数据  

数组任意位置的内存地址值为：
>a[i]_address = base_address+i*data_type_size

data_type_size 数组中每个元素的大小
base_address 数组内存块首地址
i 数组下标（从0开始）
> 为什么数组的下标从0开始  
>>说法一：  
如果下标（偏移offset）从1开始，那么数组任意位置的内存地址值为：  
a[i]_address = base_address + (i-1)*data_type_size  
每次随机访问数组都多了一次减法运算，对于CPU来说，多了一次减法指令，
对于数组这种基础数据结构来说，使用下标随机访问操作比较频繁，
效率的优化要尽量做到极致，所以下标从0开始。  
>>说法二：  
历史原因，C语言的设计者用0开始计数数组下标，之后的语言都效仿了C语言，
减少学习成本。  

## 数组优缺点
优点：  
+ 可以随机访问（时间复杂度O(1)）  
+ 因为连续内存空间，所以对CPU缓存友好，可以预读（CPU加载数据是加载一个连续的数据块）

缺点：  
+ 为了保证数组的连续性，必须进行频繁的数据搬迁，所以插入和删除操作非常低效
## 数组适用场景
1. 存储基本类型。  
虽然list集合也可以存储基本类型的包装类型，但是Autoboxing,Unboxing有一定的性能消耗
2. 如果数据大小事先已知，并且对数据的操作非常简单，用不到list的大部分功能

## 数组低效的插入和删除操作优化方案
+ 插入  
  + 低效原因：为了保证数组的连续性，在插入元素时，需要将插入位置后的元素向后移动一位
  + 优化方案：如果对存储数据的顺序没有要求，只作为存储数据的集合，
那么在插入元素时，将插入位置的元素放在最后，然后再讲目标元素插入
+ 删除
  + 低效原因：为了保证数组的连续性，在删除元素后，需要将删除位置后的元素向前移动一位
  + 优化方案：如果对连续性要求不高，那么可以先将要删除元素进行标记，
  当数组没有更多存储空间时，将多个已标记元素集中执行删除操作（JVM标记删除原理）

## 数组越界
很多病毒都利用数组越界可以访问非法地址的漏洞攻击系统
