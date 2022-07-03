//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1700 👎 0
package com.leetcode.editor.cn;

import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest largest = new FindKthLargest();
        largest.findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }

    public int findKthLargest(int[] nums, int k) {
        //构建一个小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() >= k) {
                //比较堆顶元素和当前元素的大小
                if (queue.peek() < num) {
                    // 如果当前堆顶元素小于当前元素 那么就需要将其移除，保证堆内元素是遍历到目前为止最大的k个数
                    queue.poll();
                    queue.add(num);
                }
            } else {
                queue.add(num);
            }
        }

        return queue.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
