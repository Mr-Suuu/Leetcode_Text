// 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	int m = matrix.length; // 行数
    	int n = matrix[0].length; //列数
    	List<Integer> l = new ArrayList<Integer>();
    	// 根据右下左上的顺序进行遍历，并循环一圈就缩圈
    	int left = 0, right = n - 1, top = 0, bottom = m - 1;
    	while(left < right && top < bottom){
    		// →
    		for (int i = 0; i < right - left; i++) {
    			l.add(matrix[top][left+i]);
    		}

    		// ↓
    		for (int i = 0; i < bottom - top; i++) {
    			l.add(matrix[top+i][right]);
    		}

    		// ←
    		for (int i = 0; i < right - left; i++) {
    			l.add(matrix[bottom][right-i]);
    		}

    		// ↑
    		for (int i = 0; i < bottom - top; i++) {
    			l.add(matrix[bottom-i][left]);
    		}
            if(bottom == top && right == left){
                l.add(matrix[top][left]);
            }
    		top++;
    		left++;
    		right--;
    		bottom--;
    	}
        if(top == bottom){
            for(int i = 0; i <= right - left; i++){
                l.add(matrix[top][left+i]);
            }
        }else if(left == right){
            for(int i = 0; i <= bottom - top; i++){
                l.add(matrix[top+i][left]);
            }
        }
    	return l;
    }
}

// 算法思想：转圈遍历，但该方法每次是接收一整行或一整列的数据，包括最后一个
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0){
            return result;
        }
        int m = matrix.length; // 行
        int n = matrix[0].length; // 列
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        int nums = m * n;
        // 转圈遍历
        while (nums >= 1){
            for (int i = 0; i <= right - left && nums >= 1; i++) {
                result.add(matrix[top][left+i]);
                nums--;
            }
            top++; // 这里是一次遍历一整行，包括最后一个元素，因此直接将行数下移
            for (int i = 0; i <= bottom - top && nums >= 1; i++) {
                result.add(matrix[top+i][right]);
                nums--;
            }
            right--;
            for (int i = 0; i <= right - left && nums >= 1; i++) {
                result.add(matrix[bottom][right-i]);
                nums--;
            }
            bottom--;
            for (int i = 0; i <= bottom - top && nums >= 1; i++) {
                result.add(matrix[bottom-i][left]);
                nums--;
            }
            left++;
        }
        return result;
    }
}