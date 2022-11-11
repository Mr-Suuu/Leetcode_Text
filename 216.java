// 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：

// 只使用数字1到9
// 每个数字 最多使用一次 
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。

// 算法思想：基于回溯的思想
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }

    private void backTracking(int targetSum, int k, int startIndex, int sum) {
        // 剪枝操作
        if (sum > targetSum){
            return;
        }

        if (path.size() == k){
            if (sum == targetSum){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i < 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(targetSum, k, i + 1, sum);
            path.removeLast();
            sum -= i; // 回溯
        }
    }
}