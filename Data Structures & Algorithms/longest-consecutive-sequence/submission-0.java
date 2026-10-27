class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int res = 0;
        for(int x: nums){
            st.add(x);
        }
        for(int x: nums){
            if(!st.contains(x-1)){
                //could be starting of sequence
                int cnt = 0;
                int itr = x;
                while(st.contains(itr)){
                    itr++;
                    cnt++;
                }
                res = Integer.max(res, cnt);
            }
        }
        return res;
    }
}
