package com.leetcode.dynamic;

public class Rob {

    public static void main(String[] args) {
        int[] nums = {2 , 3, 2};
//        System.out.println(rob2(nums, 0, nums.length - 1));
//        System.out.println(rob2(nums, 1, nums.length));
//        int max = Math.max(rob2(nums, 0, nums.length - 2), rob2(nums, 1, nums.length - 1));
//        System.out.println(max);
//        System.out.println(rob(new int[]{1,2,3,1}));
    }

    /**
     * 在原来的基础上加了一个环的校验 首尾也算相邻
     * 解决就是将原来的思路环分为两个部分
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return Math.max(dp(nums, 0, nums.length - 1), dp(nums, 1, nums.length));
    }

    public static int dp(int[] nums, int left, int right) {

        if(right<left)
            return -1;
        if(right-left == 0 && left<nums.length)
            return nums[left];

        int[] dp = new int[right-left+1];
        dp[1] = nums[left];

        for(int i=2;i<dp.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[left + i-1]);
        }
        return dp[right-left];
    }

    public static int rob(int[] nums) {

        if(nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];

        for(int i=2;i<=nums.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }

    public static int rob1(int[] nums) {

        if(nums==null || nums.length==0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int length = nums.length;

        int[] dp1 = new int[length];//dp[i]表示从0-i可得到的最大的金额
        int[] dp2 = new int[length];//dp[i]表示从0-i可得到的最大的金额
        dp1[0] = nums[0];dp1[1] = nums[0];
        dp2[1] = nums[1];
        boolean isPreDp1 = false;
        for(int i=2;i<length-1;i++){
            if(isPreDp1){//这种情况下理论上该dp2加
                if(dp1[i-1] > dp2[i-1] && ((dp1[i-1]-nums[i-1] +nums[i]) > dp1[i-1] && (dp2[i-1]+nums[i]) < (dp1[i-1]-nums[i-1] +nums[i]))){
                    //这种情况下需要讨论是否dp1减去前一个 而加上当前的更合适
                    dp1[i] = dp1[i-1]-nums[i-1] +nums[i];
                    dp2[i] = dp2[i-1];
                    isPreDp1 = true;
                }else {
                    dp2[i] = dp2[i-1] + nums[i];
                    dp1[i] = dp1[i-1];
                    isPreDp1 = false;
                }
            }else {
                if(dp1[i-1] < dp2[i-1] && (dp2[i-1]-nums[i-1] +nums[i]) > dp2[i-1] && (dp1[i-1]+nums[i]) < (dp2[i-1]-nums[i-1] +nums[i])){
                    //这种情况下需要讨论是否dp1减去前一个 而加上当前的更合适
                    dp2[i] = dp1[i-1]-nums[i-1] +nums[i];
                    dp1[i] = dp1[i-1];
                    isPreDp1 = false;
                }else {
                    dp1[i] = dp1[i-1] + nums[i];
                    dp2[i] = dp2[i-1];
                    isPreDp1 = true;
                }
            }
        }
        //单独处理最后一位
        if(isPreDp1){
            dp2[length-1] = dp2[length-2] + nums[length-1];
            dp1[length-1] = dp1[length-2];
            if ((dp1[length-2] + nums[length-1] - nums[0]-nums[length-2]) > dp2[length-1] && (dp1[length-2] + nums[length-1] - nums[0]-nums[length-2])>dp1[length-1]) {
                return (dp1[length-2] + nums[length-1] - nums[0]);
            }
        }else{
            //最后一位和第一位需要去掉一个
            if(nums[0] > nums[length-1]){
                dp1[length-1] = dp1[length-2];
            }else {
                dp1[length-1] = dp1[length-2] + nums[length-1] - nums[0];
            }
            dp2[length-1] = dp2[length-2];
            if(dp2[length-1] <(dp2[length-1] - nums[length-2] + nums[length-1])){
                dp2[length-1] = dp2[length-1] - nums[length-2] + nums[length-1];
            }
        }

        return dp1[length-1]>dp2[length-1]?dp1[length-1]:dp2[length-1];
    }

}
