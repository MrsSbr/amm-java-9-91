
public class Main {
    public static void main(String[] args) {
        int[] prices = {7, 2, 5, 1, 6, 2, 7, 9};
        int maxProfit = maxProfit(prices);
        System.out.println("Максимальная прибыль: " + maxProfit);
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            int maxProfit = 0;
            for (int j = i + 1; j < n; j++) {
                if (prices[j] > prices[i]) {
                    int profit = prices[j] - prices[i] + (j + 1 < n ? dp[j + 1] : 0);
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
            dp[i] = Math.max(maxProfit, dp[i + 1]);
        }

        return dp[0]; //
    }
}
