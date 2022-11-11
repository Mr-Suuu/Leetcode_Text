给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。

// 算法思想：基于回溯法，
class Solution {
    List<List<Integer>> result = new ArrayList<>(); // 结果列表
    LinkedList<Integer> path = new LinkedList<>(); // 中间路径列表
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return result;
    }

    private void combineHelper(int n, int k, int startIndex) {
        if (path.size() == k){
            // 若路径长度等于k则将当前路径加入结果列表中并直接跳出本层递归
            result.add(new ArrayList<>(path));
            return;
        }
        // n - (k - path.size()) + 1 表示剩余元素上限，是剪枝操作，将个数不合要求的直接跳过
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i); // 将当前节点加入路径中
            combineHelper(n, k, i + 1); //递归下一次
            path.removeLast(); // 回溯，删除本次节点加入路径的影响
        }
    }
}

// 回溯法，
