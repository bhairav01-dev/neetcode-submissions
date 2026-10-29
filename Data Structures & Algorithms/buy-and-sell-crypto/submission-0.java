class Solution {
    public int maxProfit(int[] prices) {
        int minLeft = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price: prices){
            minLeft = Math.min(price, minLeft);
            maxProfit=Math.max(maxProfit, price-minLeft);
        }
        return maxProfit;
    }
}
