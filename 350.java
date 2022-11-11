// 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。

// 算法思想：基于HashMap，首先将短的数组遍历加入HashMap中，然后遍历长数组，遇到相同的就加入result中并在HashMap中-1
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    	if (nums1.length > nums2.length) {
    		return intersect(nums2, nums1); // 前面短数组，后面长数组
    	}
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int num : nums1) {
    		int count = map.getOrDefault(num, 0) + 1;
    		map.put(num, count);
    	}
    	int[] intersection = new int[nums1.length];
    	int index = 0;
    	for (int num : nums2) {
    		int count = map.getOrDefault(num, 0);
    		if (count > 0) {
    			intersection[index++] = num; // 若还有多的相同的数，则加入数组中
    			count--;
    			if (count > 0) {
    				map.put(num, count); // 若还有剩余则更新map表
    			}else {
    				map.remove(num); // 若没有了则在map表中移除
    			}
    		}
    	}
    	// 返回从0到index位的数组
    	return Arrays.copyOfRange(intersection, 0, index);
    }
}


// 算法思想：暴力求解
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] temp1 = new int[1001];
        int[] temp2 = new int[1001];
        for(int i : nums1){
            temp1[i]++;
        }
        for(int i : nums2){
            temp2[i]++;
        }
        ArrayList arr = new ArrayList<>();
        int num = 0;
        for(int i = 0; i < 1001; i++){
            if(temp1[i] != 0 && temp2[i] != 0){
                if(temp1[i] <= temp2[i]){ // 数组1中出现次数较少
                    for(int j = 0; j < temp1[i]; j++){
                        arr.add(i);
                        num++;
                    }
                }else{
                    for(int j = 0; j < temp2[i]; j++){
                        arr.add(i);
                        num++;
                    }
                }
            }
        }
        int[] res = new int[num];
        for(int i = 0; i < num; i++){
            res[i] = (int)arr.get(i);
        }
        return res;
    }
}