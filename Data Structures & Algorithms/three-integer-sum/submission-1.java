class Solution {
    private int increment(int i, int[] nums){
        while(i<nums.length-1){
            if(nums[i+1] == nums[i]) i++;
            else break;
        }
        i++;
        return i;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue; //already processed this
            int j=i+1;
            int k=nums.length-1;
            int target = -1*nums[i];
            while(j<k){
                int sum = nums[j]+nums[k];
                if(sum == target){
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j = increment(j, nums);
                    k--;
                }
                else if(sum < target){
                    j = increment(j, nums);
                }
                else{
                    k--;
                }
            }
        }
        return result;
    }
}
