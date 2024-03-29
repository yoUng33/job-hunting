# LeetCode Monotone Stack Summary 单调栈小结
<https://www.cnblogs.com/grandyang/p/8887985.html>

话说博主在写 Max Chunks To Make Sorted II 这篇帖子的解法四时，写到使用单调栈Monotone Stack的解法时，突然脑中触电一般，想起了之前曾经在此贴 LeetCode All in One 题目讲解汇总(持续更新中...) 的留言区中说要写单调栈的总结帖，当时答应了要写，就去 LeetCode 上看标记为 Stack 的题，可是发现有好多题，而且很多用的不是单调栈，于是博主一个一个的看了起来，但是无奈太多了，一直没有时间全部看完，就一直没有动笔写。虽说时间就像那啥，挤挤总会有的，但是这不一个恍惚，半年就过去了，如果博主再不开始写，等回过神来，绝对又是半年。于是，博主决定改变策略，不去看所有题的，而是好坏不多想，直接动笔先写个大概，留到以后慢慢补充完整吧。

好，废话不多说，来说单调栈吧。所谓的单调栈 Monotone Stack，就是栈内元素都是单调递增或者单调递减的，有时候需要严格的单调递增或递减，根据题目的具体情况来看吧。关于单调栈，这个帖子讲的不错，而且举了个排队的例子来类比。那么，博主也举个生动的例子来说明吧：比如有一天，某家店在发 free food，很多人在排队，于是你也赶过去凑热闹。但是由于来晚了，队伍已经很长了，想着不然就插个队啥的。但发现排在队伍最前面的都是一些有纹身的大佬，惹不起，只能赞美道，小猪佩奇身上纹，来世还做社会人。于是往队伍后面走，发现是一群小屁孩，直接全部撵走，然后排在了社会大佬们的后面。那么这就是一个单调递减的栈，按实力递减。由于栈元素是后进先出的，所以上面的例子正确的检查顺序应该是从队尾往前遍历，小屁孩都撵走，直到遇到大佬停止，然后排在大佬后面（假设这个队列已经事先按实力递减排好了）。

明白了单调栈的加入元素的过程后，我们来看看它的性质，以及为啥要用单调栈。单调栈的一大优势就是线性的时间复杂度，所有的元素只会进栈一次，而且一旦出栈后就不会再进来了。

单调递增栈可以找到左起第一个比当前数字小的元素。比如数组 [2 1 4 6 5]，刚开始2入栈，数字1入栈的时候，发现栈顶元素2比较大，将2移出栈，此时1入栈。那么2和1都没左起比自身小的数字。然后数字4入栈的时候，栈顶元素1小于4，于是1就是4左起第一个小的数字。此时栈里有1和4，然后数字6入栈的时候，栈顶元素4小于6，于是4就是6左起第一个小的数字。此时栈里有1，4，6，然后数字5入栈的时候，栈顶元素6大于5，将6移除，此时新的栈顶元素4小于5，那么4就是5左起的第一个小的数字，最终栈内数字为 1，4，5。

单调递减栈可以找到左起第一个比当前数字大的元素。这里就不举例说明了，同样的道理，大家可以自行验证一下。

性质搞懂了后，下面来看一下应用，什么样的场景下适合使用单调栈呢？可以看下 Max Chunks To Make Sorted II 这篇帖子的解法四，但这道题并不是单调栈的最典型应用，只能说能想到用单调栈确实牛b，但一般情况下是不容易想到的。我们来看一些特别适合用单调栈来做的题目吧。

首推 Trapping Rain Water 这道题，虽然博主开始也没有注意到可以使用单调栈来做。但实际上是一道相当合适的题，来复习一下题目：

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

![alt text](../resources/histogram.png)

给了边界的高度（黑色部分），让求能装的水量（蓝色部分）。 为啥能用单调栈来做呢？我们先来考虑一下，什么情况下可以装下水呢，是不是必须两边高，中间低呢？我们对低洼的地方感兴趣，就可以使用一个单调递减栈，将递减的边界存进去，一旦发现当前的数字大于栈顶元素了，那么就有可能会有能装水的地方产生。此时我们当前的数字是右边界，我们从栈中至少需要有两个数字，才能形成一个坑槽，先取出的那个最小的数字，就是坑槽的最低点，再次取出的数字就是左边界，我们比较左右边界，取其中较小的值为装水的边界，然后此高度减去水槽最低点的高度，乘以左右边界间的距离就是装水量了。由于需要知道左右边界的位置，所以我们虽然维护的是递减栈，但是栈中数字并不是存递减的高度，而是递减的高度的坐标。这应该属于单调栈的高级应用了，可能并不是那么直接就能想出正确的解法。

再来看一道 Largest Rectangle in Histogram，这道求直方图中的最大矩阵的题，也是非常适合用单调栈来做的，来复习一下题目：

For example,
Given height = [2,1,5,6,2,3],
return 10.

![alt text](../resources/histogram.png)

我们可以看到，直方图矩形面积要最大的话，需要尽可能的使得连续的矩形多，并且最低一块的高度要高。有点像木桶原理一样，总是最低的那块板子决定桶的装水量。那么既然需要用单调栈来做，首先要考虑到底用递增栈，还是用递减栈来做。我们想啊，递增栈是维护递增的顺序，当遇到小于栈顶元素的数就开始处理，而递减栈正好相反，维护递减的顺序，当遇到大于栈顶元素的数开始处理。那么根据这道题的特点，我们需要按从高板子到低板子的顺序处理，先处理最高的板子，宽度为1，然后再处理旁边矮一些的板子，此时长度为2，因为之前的高板子可组成矮板子的矩形 ，因此我们需要一个递增栈，当遇到大的数字直接进栈，而当遇到小于栈顶元素的数字时，就要取出栈顶元素进行处理了，那取出的顺序就是从高板子到矮板子了，于是乎遇到的较小的数字只是一个触发，表示现在需要开始计算矩形面积了，为了使得最后一块板子也被处理，这里用了个小trick，在高度数组最后面加上一个0，这样原先的最后一个板子也可以被处理了。由于栈顶元素是矩形的高度，那么关键就是求出来宽度，那么跟之前那道 Trapping Rain Water 一样，单调栈中不能放高度，而是需要放坐标。由于我们先取出栈中最高的板子，那么就可以先算出长度为1的矩形面积了，然后再取下一个板子，此时根据矮板子的高度算长度为2的矩形面积，以此类推，直到数字大于栈顶元素为止，再次进栈，巧妙的一比！

初步来总结一下单调栈吧，单调栈其实是一个看似原理简单，但是可以变得很难的解法。线性的时间复杂度是其最大的优势，每个数字只进栈并处理一次，而解决问题的核心就在处理这块，当前数字如果破坏了单调性，就会触发处理栈顶元素的操作，而触发数字有时候是解决问题的一部分，比如在 Trapping Rain Water 中作为右边界。有时候仅仅触发作用，比如在 Largest Rectangle in Histogram 中是为了开始处理栈顶元素，如果仅作为触发，可能还需要在数组末尾增加了一个专门用于触发的数字。另外需要注意的是，虽然是递增或递减栈，但里面实际存的数字并不一定是递增或递减的，因为我们可以存坐标，而这些坐标带入数组中才会得到递增或递减的数。所以对于玩数组的题，如果相互之间关联很大，那么就可以考虑考虑单调栈能否解题。

 

应用实例：

[Max Chunks To Make Sorted II](http://www.cnblogs.com/grandyang/p/8850299.html)

[Trapping Rain Water](http://www.cnblogs.com/grandyang/p/4402392.html)

[Largest Rectangle in Histogram](http://www.cnblogs.com/grandyang/p/4322653.html)

[Remove K Digits](http://www.cnblogs.com/grandyang/p/5883736.html)

 

相关帖子：

[CareerCup All in One 题目汇总](http://www.cnblogs.com/grandyang/p/5162994.html)

[Manacher's Algorithm 马拉车算法](http://www.cnblogs.com/grandyang/p/4475985.html)

[KMP Algorithm 字符串匹配算法KMP小结](http://www.cnblogs.com/grandyang/p/6992403.html)

[LeetCode Binary Search Summary 二分搜索法小结](http://www.cnblogs.com/grandyang/p/6854825.html)

 

参考资料：

https://zhuanlan.zhihu.com/p/26465701

https://chuckliu.me/#!/posts/585a2cb4f33c18149026f0be

https://blog.csdn.net/liujian20150808/article/details/50752861