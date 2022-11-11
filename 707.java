// 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val和next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。

// 在链表类中实现这些功能：

// get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
// addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
// addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
// addAtIndex(index,val)：在链表中的第index个节点之前添加值为val的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
// deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。

class ListNode{
    int val;
    ListNode next;
    
    // 无参构造方法
    ListNode(){

    }

    // 有参构造方法
    ListNode(int val){
        this.val = val;
    }

}

class MyLinkedList {
    //size存储链表元素的个数
    int size;

    //虚拟头结点
    ListNode head;

    // 初始化链表
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0); // 初始化第一个节点
    }
    
    //获取第index个节点的数值
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        // 创建临时节点
        ListNode currentNode = head;
        // 找index+1的节点，因为有一个头节点，因此要+1
        for (int i = 0; i <= index; i++) { // 循环找到所需的值
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }
    
    // 在链表最前面插入一个节点
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    // 在链表最后面插入一个节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    // 在链表的某一个位置插入元素
    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index > size) { // 若超过表长度直接跳出
            return;
        }
        if (index < 0) { // 若输入小于0，则直接放在头位置
            index = 0;
        }
        size++; // 添加元素因此size+1
        ListNode pred = head; // 用于找到要插入节点的前驱位置
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val); // 创建要插入的节点
        // 插入节点
        toAdd.next = pred.next;
        pred.next = toAdd;

    }
    
    // 删除某一结点
    public void deleteAtIndex(int index) {
        // 若不在范围内则直接返回
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pred = head; //用于找到待删除节点的前一个节点
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next; // 删除节点
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */