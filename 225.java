// 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。

// 实现 MyStack 类：

// void push(int x) 将元素 x 压入栈顶。
// int pop() 移除并返回栈顶元素。
// int top() 返回栈顶元素。
// boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。

// 注意：

// 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
// 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。

// 方法一：基于两个Queue
class MyStack {

	Queue<Integer> queue1; // 和栈中保持一样元素的队列
    Queue<Integer> queue2; // 辅助队列

    // 初始化栈
    public MyStack() {
    	queue1 = new Queue<>();
    	queue2 = new Queue<>();
    }
    
    // 入栈
    public void push(int x) {
    	// 先将x放入辅助队列中
    	queue2.offer(x); // 添加一个元素并返回true
    	while(!queue1.isEmpty()){
    		queue2.offer(queue1.poll()); // 返回queue1中第一个元素
    	}
    	Queue<Integer> queueTemp;
    	// 交换queue1和queue2
    	queueTemp = queue1;
    	queue1 = queue2;
    	queue2 = queueTemp;
    	// 交换后queue1即为栈顺序
    }
    
    // 弹出栈顶元素
    public int pop() {
    	// queue1中的元素与栈中元素顺序一致，因此可以直接弹出首个元素即为栈顶元素
    	return queue1.poll(); // 返回队列首个元素
    }
    
    // 返回栈顶元素
    public int top() {
    	// queue1中的元素与栈中元素顺序一致
    	return queue1.peek();
    }
    
    // 判断队列是否为空
    public boolean empty() {
    	return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */