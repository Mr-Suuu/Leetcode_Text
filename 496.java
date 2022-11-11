// nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。

// 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。

// 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。

// 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。

// 算法思想：暴力搜索
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]){
                    for (int k = j+1; k < nums2.length; k++) {
                        if (nums2[k] > nums1[i]){
                            res[i] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return res;
    }
}

// 算法思想：基于单调栈实现
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> temp = new Stack<>(); // 用于记录下标
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1); // 全部填充为-1
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            // 保存num1中每个元素及其对应下标
            hashMap.put(nums1[i], i);
        }
        temp.add(0);
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] <= nums2[temp.peek()]){
                // 若当前元素小于等于栈顶元素则入栈
                temp.add(i);
            }else {
                while (!temp.isEmpty() && nums2[temp.peek()] < nums2[i]){
                    // 循环找到右边第一个大于的元素是当前元素的元素
                    if (hashMap.containsKey(nums2[temp.peek()])){
                        Integer index = hashMap.get(nums2[temp.peek()]);
                        res[index] = nums2[i];
                    }
                    temp.pop();
                }
                temp.add(i);
            }
        }
        return res;
    }
}