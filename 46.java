// 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

// 算法思想：基于回溯法，使用数组记录数字是否被访问过
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int[] used = new int[21];
    public List<List<Integer>> permute(int[] nums) {
        permuteHelper(nums, 0);
        return result;
    }

    private void permuteHelper(int[] nums, int pathNums) {
        if (pathNums == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[nums[i] + 10] == 1){
                // 若当前数字已经用过则跳过
                continue;
            }
            path.add(nums[i]);
            used[nums[i] + 10] = 1;
            pathNums++;
            permuteHelper(nums, pathNums);
            // 回溯
            path.removeLast();
            pathNums--;
            used[nums[i] + 10] = 0;
        }
    }
}