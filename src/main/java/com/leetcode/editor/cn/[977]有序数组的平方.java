package com.leetcode.editor.cn;//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// Related Topics 数组 双指针 排序 👍 569 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class SortedSquares {
    public int[] sortedSquares(int[] nums) {

        int left = 0, right = 0;
        //找到第一个不为负数的下标
        int index = 0;
        for(index=0; index<nums.length; index++) {
            if (nums[index] >= 0) break;
        }
        left = (right = index)-1;
        //从中间向两边扩散
        int[] rnt = new int[nums.length];
        int idx = 0;
        while (left>=0 && right<nums.length) {
            if (Math.abs(nums[left]) <= nums[right]) {
                rnt[idx++] = nums[left] * nums[left];
                left--;
            }else {
                rnt[idx++] = nums[right] * nums[right];
                right++;
            }
        }
        //处理还没有被排到的数据
        if (left >= 0){
            while (left >= 0) {
                rnt[idx++] = nums[left] * nums[left];
                left--;
            }
        }

        if (right < nums.length) {
            while (right < nums.length) {
                rnt[idx++] = nums[right] * nums[right];
                right++;
            }
        }
        return rnt;
    }

    public int[] sortedSquares1(int[] nums) {
        //上面的思路是从中间向两边扩散

        // 但是实际上对于从负数到正数的平方
        // 那么一定最大到最小一定是从两边向中间靠拢
        // 所以从两边开始处理 然后反方向的插入新的数组应该会更快
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
