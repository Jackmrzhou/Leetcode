package leetcodeJava;

class MinStack {
    LinkedList<Integer> stack = new LinkedList<Integer>();
    LinkedList<Integer> minStack = new LinkedList<Integer>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.add(new Integer(val));
            minStack.add(new Integer(val));
        } else {
            if (val <= minStack.getLast()) {
                minStack.add(new Integer(val));
            }
            stack.add(new Integer(val));
        }
    }
    
    public void pop() {
        if (stack.getLast().equals(minStack.getLast())) {
            stack.removeLast();
            minStack.removeLast();
        } else {
            stack.removeLast();
        }
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minStack.getLast();
    }
}
