class MinStack {
    private Stack<Integer> stk;
    private Stack<Integer> minStk;
    public MinStack() {
        this.stk = new Stack<>();
        this.minStk= new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(!minStk.empty()) minStk.push(Math.min(val,minStk.peek()));
        else minStk.push(val);
    }
    
    public void pop() {
        if(!stk.empty()) stk.pop();
        if(!minStk.empty()) minStk.pop();
    }
    
    public int top() {
        if(!stk.empty()) return stk.peek();
        return -1;
    }
    
    public int getMin() {
        if(!minStk.empty()) return minStk.peek();
        return -1;
    }
}
