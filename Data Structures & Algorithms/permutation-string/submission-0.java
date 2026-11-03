class Solution {

    private boolean isSequal(String s1, String s2, int i, int j){
        //check length
        if(j-i+1 != s1.length()) return false;
        //check freq
        int[] freq = new int[26];
        for(int p=i; p<=j; p++){
            freq[s2.charAt(p)-'a']++;
        }
        //decrement for s1
        for(int p=0; p<s1.length(); p++){
            freq[s1.charAt(p)-'a']--;
        }
        for(int x: freq){
            if(x!=0) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        for(int i=0; i<=s2.length()-k; i++){
            if(isSequal(s1,s2,i,i+k-1))
                return true;
        }
        return false;
    }
}
