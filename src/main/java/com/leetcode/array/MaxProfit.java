package com.leetcode.array;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] nums =new int[]{6,1,3,2,4,7};
        System.out.println(maxProfit2(nums));
    }

    /**
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     */
    public static int maxProfit1(int[] prices) {
        int min = prices[0];
        int price = 0;
        for(int i=1; i<prices.length; i++) {
            min = Math.min(min, prices[i]);
            price = Math.max(price, prices[i]-min);
        }
        return price;
    }

    /**
     * 股票交易2  可以多次成交 但是每天最多持有一只股票
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
     *      总利润为 4 + 3 = 7 。
     */
    public static int maxProfit2(int[] prices) {
        int sum = 0;
        int min = prices[0];
        for(int i=1; i<prices.length; i++) {
            if(prices[i]<prices[i-1]) {
                sum += prices[i-1]-min;
                min = prices[i];
            }
        }
        return sum + prices[prices.length-1]-min;
    }

    /**
     * 假设只能成交一笔交易
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        //最大值
        int res = 0;
        if (prices.length == 0) {
            return 0;
        }

        //判断应该在哪一日买入,即最小值
        int price = prices[0];
        //遍历所有交易日价格
        for (int i = 1; i < prices.length; i++) {
            //判断本日是否能够卖出
            if (prices[i] > price) {
                //判断如果本日卖出收益是否最大
                if (res < (prices[i] - price)) {
                    res = prices[i] - price;
                }
            } else {
                //判断本日是否为最低价格
                price = prices[i];
            }
        }
        return res;
    }
}
