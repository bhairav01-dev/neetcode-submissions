class Solution {

    private boolean isOpen(Character c){
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isClosed(Character c){
        return c == ')' || c == ']' || c == '}';
    }

    private boolean matches(Character c1, Character c2){
        if(!isOpen(c1) || !isClosed(c2)) return false;
        switch(c1){
            case '[':
                return c2 == ']';
            case '(':
                return c2 == ')';
            case '{':
                return c2 == '}';
            default:
                return false;
        }
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(isOpen(s.charAt(i))){
                st.push(s.charAt(i));
            }
            else{
                if(st.empty() 
                ||!matches(st.pop(),s.charAt(i))
                )
                    return false;
            }
        }
        if(!st.empty()) return false;
        return true;
    }
}
