// 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。


// 算法思想：基于回溯法
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length]; // 判断元素是否使用
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTrack(nums, used);
        return result;
    }

    private void backTrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 这里used[i-1] == false也可以，若取false，则在同一层时不能取到相同的元素
            if (i > 0 && nums[i] == nums[i-1] && used[i - 1] == true){
                continue;
            }
            // 若未被使用
            if (used[i] == false){
                used[i] = true;
                path.add(nums[i]);
                backTrack(nums, used);
                // 回溯
                path.removeLast();
                used[i] = false;
            }
        }
    }
}