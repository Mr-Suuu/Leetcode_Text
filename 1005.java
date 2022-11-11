// 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：

// 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
// 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。

// 以这种方式修改数组后，返回数组 可能的最大和 。

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums.length == 1){
            return k % 2 == 0 ? nums[0] : -nums[0];
        }
        Arrays.sort(nums); // 对数组进行排序
        int sum = 0;
        int idx = 0; // 当前下标
        for (int i = 0; i < k; i++) {
            if (i < nums.length - 1 && nums[idx] < 0){
                // 若当前位置为负数则将其变为正数
                nums[idx] = -nums[idx];
                if (nums[idx] >= Math.abs(nums[idx + 1])){
                    // 可使得当数组全为正的时候一直只在最小的数那里正负调换
                    idx++;
                }
                continue;
            }
            nums[idx] = -nums[idx];
        }
        // 求和
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 将数组按绝对值从大到小排序
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0){
                // 若当前位置为负数且还有剩余的次数
                nums[i] = -nums[i];
                k--;
            }
        }
        // 若还有次数则将绝对值最小的正数反转
        if (k % 2 != 0){
            nums[nums.length - 1] = -nums[nums.length - 1];
        }
        return Arrays.stream(nums).sum();
    }
}