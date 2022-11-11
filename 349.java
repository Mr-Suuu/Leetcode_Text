// 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。

// 算法思想：基于HashSet，不需要对数据进行排序，而且还不要让数据重复时就用HashSet
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    	if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length) {
    		return new int[0];
    	}

    	Set<Integer> set1 = new HashSet<>(); // 父类变量引用子类对象
    	Set<Integer> resSet = new HashSet<>();
    	// 遍历数组1
    	for (int i : nums1) {
    		set1.add(i);
    	}
    	// 遍历数组2看有没有对应元素
    	for (int i : nums2) {
    		if (set1.contains(i)) {
    			resSet.add(i); // 若有则加入结果中
    		}
    	}

    	int[] resArr = new int[resSet.size()];
    	int index = 0;
    	// 将结果转为数组并返回
    	for (int i : resSet) {
    		resArr[index++] = i;
    	}
    	return resArr;
    }
}