class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j=heights.length-1;
        int maxi = 0;
        while(i<j){
            maxi = Math.max(maxi, 
                   Math.min(heights[i],heights[j])*(j-i)
            );
            if(heights[i]<heights[j])
                i++;
            else j--;
        }
        return maxi;
    }
}
