class Solution {

    private boolean isValid(String s, int i, int j, Map<Character,Integer> mp, int k){

        //check if non-max frequent elements count is replaceable
        Integer freq = 0;
        for(Map.Entry<Character,Integer> entry: mp.entrySet()){
            if(entry.getValue() > freq){
                freq = entry.getValue();
            }
        }
        //System.out.println("checking validity: "+i+","+j+": "+freq);
        return (j-i+1)-freq <= k;
    }

    public int characterReplacement(String s, int k) {
        int i=0;
        int j=0;
        int n=s.length();
        int maxLength = 0;
        Map<Character,Integer> mp = new HashMap<>();
        mp.put(s.charAt(i),1);
        while(true){
            //window is valid
            maxLength = Math.max(maxLength, j-i+1);
            if(j == n-1) break;
            
            //increment j until window become invalid
            while(j<n-1){
                j++;
                if(mp.containsKey(s.charAt(j)))
                    mp.put(s.charAt(j), mp.get(s.charAt(j))+1);
                else mp.put(s.charAt(j),1);
                //update frequencies
                if(!isValid(s, i, j, mp,k)) break;
                maxLength = Math.max(maxLength, j-i+1);
            }
            //increment i until window become valid again
            while(i<j){
                if(mp.get(s.charAt(i)) == 1) mp.remove(s.charAt(i));
                else
                mp.put(s.charAt(i), mp.get(s.charAt(i))-1);
                i++;
                //update frequencies
                if(isValid(s,i,j,mp,k)) break;
            }
        }
        return maxLength;
    }
}
