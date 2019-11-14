# 155. Min Stack
<https://leetcode.com/problems/min-stack/>
Easy

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

* push(x) -- Push element x onto stack.
* pop() -- Removes the element on top of the stack.
* top() -- Get the top element.
* getMin() -- Retrieve the minimum element in the stack.
 

Example:

    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> Returns -3.
    minStack.pop();
    minStack.top();      --> Returns 0.
    minStack.getMin();   --> Returns -2.

Related Topics: Stack; Design
Similar Questions: 
    medium [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
    easy [Max Stack](https://leetcode.com/problems/max-stack/)




## Two Stacks Solution:
用两个stack，stack保存所有数字，miniStack保存所有出现过的最小值。
```java
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> miniStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        miniStack = new Stack();
    }
    
    public void push(int x) {
        stack.push(x);
        if(miniStack.isEmpty() || x<=miniStack.peek()){
            miniStack.push(x);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if(!miniStack.isEmpty() && val == miniStack.peek()){
            miniStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return miniStack.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

## One Stack Solution:  
整合之前的两个stack的解法。一个stack里同时记录所有数和出现过的所有最小数。出现过的最小数会出现两次，一次作为节点来标识区间。用min记录当前最小数。
当push()时，如果当前数字小于min，把min入栈并把当前数赋值给mini。然后把当前数入栈。
当pop()时，如果栈顶等于min，需要pop两次并更新mini。
```java
class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
```