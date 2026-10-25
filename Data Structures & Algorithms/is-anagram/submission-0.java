class Solution {
    public boolean isAnagram(String s, String t) {
        String[] chars1 = s.split("");
        Arrays.sort(chars1);
        String[] chars2 = t.split("");
        Arrays.sort(chars2);

        if(chars1.length != chars2.length) return false;
        for(int i=0; i<chars1.length; i++){
            // System.out.print("c1,c2: "+chars1[i]+":"+chars2[i]);
            if(!chars1[i].equals(chars2[i])){
                return false;
            }
        }
        return true;
    }
}
