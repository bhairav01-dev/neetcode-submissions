class Solution {
    public int[] productExceptSelf(int[] nums) {
        //two condition need separate handling
        //single zero
        int n =nums.length;
        int[] result = new int[n];
        int zeroCnt = 0;
        long prod = 1;
        for(int i=0; i<n; i++){ 
            if(nums[i] == 0) zeroCnt++;
            if(i!=0){
                prod = prod*nums[i];
            }
        }
        System.out.println("zeroCnt: "+zeroCnt);
        if(zeroCnt >= 2){
            //return all zeros
            for(int i=0; i<n; i++){
                result[i] = 0;
            }
        }
        else if(zeroCnt == 1){
            //return array with zeros except one place
            prod = 1;
            int idx = 0;
            for(int i=0; i<n; i++){
                if(nums[i] == 0){
                    idx = i;
                }
                else prod = prod*nums[i];
            }
            for(int i=0; i<n; i++){
                if(i==idx) result[i] = (int)prod;
                else result[i] = 0;
            }
        }
        else{
            result[0] = (int)prod;
            for(int i=1; i<n; i++){
                result[i] = (int)prod*nums[i-1]/nums[i];
                prod = result[i];
            }
        }
        return result;
    }
}  
