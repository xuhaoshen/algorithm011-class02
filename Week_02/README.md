学习笔记  
在第二周中，学习了哈希表、无序集合、树、堆。  
  
哈希表：  
是根据键值码而直接进行访问的数据结构。哈希表通过把键值码映射到表中一个位置来访问记录，以加快查找的速度。
JAVA中处理哈希冲突办法：
1）数组+链表
2）数组+红黑树
平均时间复杂度：O(1)

无序集合：
Set继承于Collection接口，是一个不允许出现重复元素，并且无序的集合。底层实现基于哈希表。

树：
二叉树：每个节点最多有两个子节点的树。
二叉搜索时：
1）是一棵空树，或者是具有下列性质的二叉树：
2）左子树不空，则左子树上所有结点的值均小于它的根结点的值；
3）右子树不空，则右子树上所有结点的值均大于它的根结点的值；
4）左、右子树也分别为二叉搜索树。
平均时间复杂度：O(nlogn)

堆：
堆通常是一个可以被看做一棵完全二叉树的数组对象。
堆分为两种：最大堆和最小堆。
详见第一周的学习笔记关于优先队列的说明。








 
 
