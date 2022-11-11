// 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。

// 请你找到这个数组里第 k 个缺失的正整数。

// 算法思想：循环迭代判断两数之间差了多少个数
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] nums = new int[arr[arr.length-1]];
        int index = 0;
        if(arr.length == 0){ // 数组为空的情况
            return k;
        }
        for(int i = 1; i < arr[0]; i++){ // 将第一个数特殊处理放入缺失数组中
            nums[index++] = i;
        }
        for(int i = 1; i < arr.length; i++){
            int x = arr[i] - arr[i-1]; // 计算与前一个数的差
            for(int j = 1; j < x; j++){
                nums[index++] = arr[i-1] + j; // 放入缺失的数
            }
        }
        if(k > index){
            return arr[arr.length-1] + (k-index);
        }else{
            return nums[k-1];
        }
    }
}

// 二分法没看懂