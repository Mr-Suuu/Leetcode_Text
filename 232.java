// 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

// 实现 MyQueue 类：

// void push(int x) 将元素 x 推到队列的末尾
// int pop() 从队列的开头移除并返回元素
// int peek() 返回队列开头的元素
// boolean empty() 如果队列为空，返回 true ；否则，返回 false
// 说明：

// 你 只能 使用标准的栈操作 —— 也就是只有 push to top,peek/pop from top,size, 和is empty 操作是合法的。
// 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。


class MyQueue {
    // 使用栈来完成队列操作
    Stack<Integer> stackIn; // 入栈
    Stack<Integer> stackOut; // 出栈

    // 初始化队列
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    // 入队
    public void push(int x) {
        stackIn.push(x);
    }
    
    // 出队
    public int pop() {
        dumpstackIn(); // 检查stackOut是否为空
        return stackOut.pop();
    }
    
    // 输出队头元素
    public int peek() {
        dumpstackIn(); // 检查stackOut是否为空
        return.stackOut.peek(); //stackOut栈顶元素，即为队头元素
    }
    
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // 若stackOut为空，则要将stackIn中的所有元素放到stackOut中
    private void dumpstackIn(){
        // 若stackOut不为空则跳出
        if(!stackOut.isEmpty()){
            return;
        }
        // 将stackIn中所有元素出栈再入栈到stackIn中
        while(!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */