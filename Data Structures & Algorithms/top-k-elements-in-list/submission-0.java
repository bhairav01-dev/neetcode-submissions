class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int x: nums){
            if(mp.containsKey(x)){
                mp.put(x, mp.get(x)+1);
            }
            else{
                mp.put(x, 1);
            }
        }
        //have a priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(b[1],a[1]));
        for(Map.Entry<Integer, Integer> entry: mp.entrySet()){
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] = pq.poll()[0];
        }
        return result;
    }
}
