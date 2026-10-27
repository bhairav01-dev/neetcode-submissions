class Solution {
    private boolean isValidChar(char c){
        if((c>='a' && c <= 'z') || (c >= 'A' && c <= 'Z' || (c >= '0' && c <= '9'))){
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        s = s.toUpperCase();
        while(i<j){
            if(!isValidChar(s.charAt(i))){
                i++;
                continue;
            }
            if(!isValidChar(s.charAt(j))){
                j--;
                continue;
            }
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
