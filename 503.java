// 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。

// 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。

// 算法思想：基于单调栈的思想，模拟遍历两次数组从而达到循环数组的目的
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 1){
            return new int[]{-1};
        }
        Stack<Integer> temp = new Stack<>(); // 用于存放下标
        int size = nums.length;
        int[] res = new int[size];
        Arrays.fill(res, -1);
        temp.add(0);
        // 循环的时候对数组循环两次以达到循环的效果
        for (int i = 0; i < 2 * size; i++) {
            while (!temp.isEmpty() && nums[i % size] > nums[temp.peek()]){
                res[temp.peek()] = nums[i % size];
                temp.pop();
            }
            temp.add(i % size);
        }
        return res;
    }
}