public class Main {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        System.out.println("Максимальная прибыль: " + maxProfit);
    }

    public static int maxProfit(int[] prices) {
        return calculateMaxProfit(prices, 0);
    }

    public static int calculateMaxProfit(int[] prices, int start) {
        if (start >= prices.length) {
            return 0;
        }

        int maxProfit = 0;

        for (int i = start; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int profit = prices[j] - prices[i] + calculateMaxProfit(prices, j + 1);
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
        }

        return maxProfit;
    }
}


