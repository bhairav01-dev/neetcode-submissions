class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String x: strs){
            String[] parts = x.split("");
            Arrays.sort(parts);
            String rejoined = String.join("",parts);
            if(!mp.containsKey(rejoined)){
                mp.put(rejoined, new ArrayList<>());
            }
            mp.get(rejoined).add(x);
        }
        List<List<String>> answer = new ArrayList<>();
        for(String key: mp.keySet()){
            answer.add(mp.get(key));
        }
        return answer;
    }
}
