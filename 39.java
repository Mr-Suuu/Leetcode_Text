// 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int index) {
        if (sum > target){ // 剪枝操作
            return;
        }
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(res, path, candidates, target, sum, i); // 这里由于数字可以重复使用，所以i不用+1
            sum -= candidates[i];
            path.remove(path.size() - 1); // 回溯删除元素
        }
    }
}
