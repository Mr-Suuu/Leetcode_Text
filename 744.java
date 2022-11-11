// 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。

// 在比较时，字母是依序循环出现的。举个例子：

// 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'

// 算法思想：基于二分法，
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
    	int left = 0, right = letters.length - 1;
    	int ans = 0;
    	while(left < right){
    		int mid = left + ((right - left) >> 1);
    		if (letters[mid] <= target) {
    			ans = mid;
    			left = mid + 1;
    		}else {
    			right = mid - 1;
    		}
    	}
    	if (letters[ans] > target) {
    		return letters[ans];
    	}else {
    		if (ans == letters.length - 1) {
    			return letters[0];
    		}else {
    			return letters[ans+1];
    		}
    	}
    }
}


int m = matrix.length; // 行数
    	int n = matrix[0].length; //列数
    	int[] res = new int[m*n];
        int pos = 0;
    	// 根据右下左上的顺序进行遍历，并循环一圈就缩圈
    	int left = 0, right = n - 1, top = 0, bottom = m - 1;
    	while(left < right && top < bottom){
    		// →
    		for (int i = 0; i < right - left; i++) {
    			res[pos] = matrix[top][left+i];
    		}

    		// ↓
    		for (int i = 0; i < bottom - top; i++) {
    			res[pos] = matrix[top+i][right];
    		}

    		// ←
    		for (int i = 0; i < right - left; i++) {
    			res[pos] = matrix[bottom][right-i];
    		}

    		// ↑
    		for (int i = 0; i < bottom - top; i++) {
    			res[pos] = matrix[bottom-i][left];
    		}
            if(bottom == top && right == left){
                res[pos] = matrix[top][left];
            }
    		top++;
    		left++;
    		right--;
    		bottom--;
    	}
        if(top == bottom){
            for(int i = 0; i <= right - left; i++){
                res[pos] = matrix[top][left+i];
            }
        }else if(left == right){
            for(int i = 0; i <= bottom - top; i++){
                res[pos] = matrix[top+i][left];
            }
        }
    	return res;