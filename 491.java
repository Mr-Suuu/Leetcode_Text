// 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。

// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。

// 算法思想：基于回溯法
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        findSubsequencesHelper(nums, 0);
        return result;
    }

    private void findSubsequencesHelper(int[] nums, int startIndex) {
        if (path.size() > 1){
            // 若路径大于1则加入结果列表中
            result.add(new ArrayList<>(path));
        }
        int used[] = new int[201]; // 记录元素是否使用过，元素范围为-100到100
        for (int i = startIndex; i < nums.length; i++) {
            // 当当前元素比路径中最后一个元素小 或 当前元素已被使用则跳过本次循环
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || used[nums[i] + 100] == 1){
                continue;
            }
            used[nums[i] + 100] = 1; // 标记当前元素已被使用
            path.add(nums[i]);
            findSubsequencesHelper(nums, i + 1);
            path.removeLast(); // 回溯
        }
    }
}