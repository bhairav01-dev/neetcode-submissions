class Solution {
    public int lengthOfLongestSubstring(String s) {
        //logic
            //1. take a sliding window 
                //=> and move window, and check if window contains repeated elements
        Set<Character> st = new HashSet<>();
        int i=0;
        int j=0;
        int maxLength = 0;
        while(true){
            while(j<s.length()){
                if(!st.contains(s.charAt(j))){
                    st.add(s.charAt(j));
                }
                else{
                    break;
                }
                j++;
                maxLength = Math.max(j-i,maxLength);
            }
            //j is on repeating element
            //move i to repeating element
            if(j!= s.length()){
                while(st.contains(s.charAt(j))){
                    //while set contains jth element
                    st.remove(s.charAt(i));
                    i++;
                }
            }
            else{
                break;
            }
        }
        return maxLength;
    }
}
