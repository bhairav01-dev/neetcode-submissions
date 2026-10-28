class Solution {
    private int monotonicStack(int height[]){
        Stack<Integer> stk = new Stack<>();
        int n = height.length;
        for(int i=n-1; i>=0; i--){
            //always push higher to stack, if not just push same top again
            if(stk.empty()) stk.push(height[i]);
            stk.push(Math.max(stk.peek(), height[i]));
        }
        //maintain max while traversing and calculate potential water can be stored over current bar
        //Logic is simple => water will spread over until leftMax and rightMax is reached, and height it can attain is min(left, right)
        int leftMaxHeight = 0;
        int totalWater = 0;
        for(int i=0; i<height.length; i++){
            leftMaxHeight = Math.max(leftMaxHeight,height[i]);
            int waterLevel = Math.min(leftMaxHeight, stk.pop());
            int waterStored= waterLevel - height[i];
            if(waterStored > 0)
                totalWater += waterStored;
        }
        return totalWater;
    }

    public int trap(int[] height) {
        //for each column,
        //water will spread until spill over
            //spill over will happen when it reaches max possible on both side
            //so for each point we need find prefixMax, and postfixMax
            //calculate the volume for each bar, and sum final
        return monotonicStack(height);
    }
}
