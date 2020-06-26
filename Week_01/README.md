学习笔记
在第一周中，学习了数组、链表、跳表、栈和队列。

数组：
初始化时，需要先申请内存大小，它在内存中的地址是相邻的。
优点：查询速度快，时间复杂度可以达到O(1)
缺点：1、从头部插入、删除时，效率低，时间复杂度为O(n)
2、内存利用率低，空间要求高
3、不能动态扩展

链表：
它在内存中是不连续的，是由一系列节点组成。每个节点又是由存储数据元素的数据域以及下一个节点地址的指针域组成。
优点：1、插入和删除时间复杂度高，为O(1)
2、空间利用率高
3、不用申请空间大小，可以动态扩展
缺点：随机访问效率低，时间复杂度O(n)

不同操作下数据与链表的比较

————————————————————————————————
操作       | 数组     | 链表     |
————————————————————————————————
随机访问    | O(1)    | O(n)    |
————————————————————————————————
头部插入元素 | O(n)    | O(1)    |
————————————————————————————————
头部删除元素 | O(n)    | O(1)    |
————————————————————————————————
尾部插入元素 | O(1)    | O(1)    |
————————————————————————————————
尾部删除元素 | O(1)    | O(1)    |
————————————————————————————————

跳表：
基于链表的优化，通过空间换时间的方式优化了查询效率。

Lv2.索引：   1           →           7     →
            ↓                       ↓
Lv1.索引：   1   →   3   →   5   →   7     →    
            ↓       ↓       ↓       ↓
原始链表：    1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 

时间复杂度分析：
第k级的节点个数为：n/2^k
因此，顶部高度为h=log2(n)-1
时间复杂度为O(logn)

栈：
一种后出先进(LIFO,Last input, First output)的数据结构。删除和新增时，时间复杂度为O(1)。
通过数组实现栈：
    ————————————————————————————
     A | B | C |  |  |  |  |  |
    ————————————————————————————    
               top
     0   1   2   3  4  5  6  7

初始化：top = 0
push： arr[top++] = val
pop:  val = arr[--top]
 
队列：
一种先进先出(FIFO,Fast input, First output)的数据结构。删除和新增时，时间复杂度为O(1)。
通过数组实现队列：
通过数组实现栈：
    ————————————————————————————
     A | B | C |  |  |  |  |  |
    ————————————————————————————
   head         tail                   
     0   1   2   3  4  5  6  7
初始化： head = tail = 0
push: arr[tail++] = val
poll:  val = arr[head++]

deque改造：
```JAVA
        Deque<String> deque = new ArrayDeque<>();
        deque.push("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        System.out.println(deque.peek());
        while (!deque.isEmpty()) {
            System.out.println(deque.removeFirst());
        }
``` 
      
分析 Queue 和 Priority Queue 的源码：

Queue本身是接口，继承自Collection接口，共提供5个方法：
```JAVA
    // 尾部插入，如果队列越界则抛出异常
    boolean add(E e);
    // 尾部插入，如果队列越界则返回false
    boolean offer(E e);
    // 移除第一个元素，如果队列为空则抛出异常
    E remove();
    // 移除第一个元素，如果队列为空则返回null
    E poll();
    // 返回第一个元素，如果队列为空则抛出异常
    E element();
    // 返回第一个元素，如果队列为空则返回null
    E peek();
```

PriorityQueue
插入：
```JAVA
    //
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)
            grow(i + 1); // 扩容
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
    }
    //
    private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
            siftUpComparable(k, x);
    }
```

siftUpUsingComparator()使用自定义比较器，siftUpComparable使用x实现的比较器（因此泛型对象必须实现比较器）
实现方式：最小堆
最小堆定义：
1、完全二叉树
2、任意节点的值小于等于左右孩子的值
3、任意非叶子节点的左右子树也是堆
```JAVA
    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            // 移动元素
            queue[k] = e;
            k = parent;
        }
        // 最后赋值
        // 这样做比交换减小开销
        queue[k] = x;
    }
```

举例图解：
```JAVA
PriorityQueue queue = new PriorityQueue();
queue.offer(14);
queue.offer(7);
queue.offer(12);
queue.offer(6);
queue.offer(9);
queue.offer(4);
queue.offer(17);
queue.offer(23);
queue.offer(15);
System.out.println(queue);
```
打印结果为[4, 7, 6, 10, 9, 12, 17, 23, 14, 15]，现在需要插入元素[3]，
初始状态：
             4
            (0)
          /    \
         7       6
        (1)     (2)
      /   \    /  \
    10     9  12   17
    (3)   (4) (5) (6)
   /  \   /  \
 23  14  15  
(7) (8) (9) 

k=11, parent=(10 - 1) >>> 1 = 4, queue[4] = 9 > 3
             4
            (0)
          /    \
         7       6
        (1)     (2)
      /   \    /  \
    10     9  12   17
    (3)   (4) (5) (6)
   /  \   /  \
 23  14  15  9
(7) (8) (9) (10)

k=4, parent=(4 - 1) >>> 1 = 1, queue[1] = 7 > 3
             4
            (0)
          /    \
         7       6
        (1)     (2)
      /   \    /  \
    10     7  12   17
    (3)   (4) (5) (6)
   /  \   /  \
 23  14  15  9
(7) (8) (9) (10)

k=1, parent=(1 - 1) >>> 1 = 0, queue[0] = 4 > 3
             4
            (0)
          /    \
         4       6
        (1)     (2)
      /   \    /  \
    10     7  12   17
    (3)   (4) (5) (6)
   /  \   /  \
 23  14  15  9
(7) (8) (9) (10)

k=0, queue[0] = 3

则打印结果为[3, 4, 6, 10, 7, 12, 17, 23, 14, 15, 9]

方法poll()同理，不再分析








 
 
