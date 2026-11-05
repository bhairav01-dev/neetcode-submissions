class Solution {
    private boolean isOperator(String op){
        return op.equals("+") || op.equals("-")
        || op.equals("*") || op.equals("/");
    }

    private boolean isDig(char c){
        return c>='0' && c <= '9';
    }

    private int operate(String op, int a, int b){
        if(op.equals("*")) return a*b;
        if(op.equals("/") && b != 0) return a/b;
        if(op.equals("+")) return a+b;
        if(op.equals("-")) return a-b;
        return 0;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String s: tokens){
            if(isOperator(s)){
                if(stk.empty()) return -1;
                int b = stk.pop();
                int a = stk.pop();
                int result = operate(s,a,b);
                // System.out.println("pushing result "+result);
                stk.push(result);
            }
            else{
                stk.push(Integer.parseInt(s));
                // System.out.println("stack peek: "+stk.peek());
            }
        }
        if(stk.empty()) return -1;
        else return stk.pop();
    }
}
