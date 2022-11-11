// 编写一个程序，通过填充空格来解决数独问题。

// 数独的解法需 遵循如下规则：

// 数字1-9在每一行只能出现一次。
// 数字1-9在每一列只能出现一次。
// 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
// 数独部分空格内已填入了数字，空白格用'.'表示。

// 算法思想：基于回溯的思想
class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board){
        for (int i = 0; i < 9; i++) { // 遍历行
            for (int j = 0; j < 9; j++) { // 遍历列
                // 若本来有数字则跳过
                if (board[i][j] != '.'){
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) {
                    if (isValidSudoku(i, j, k, board)){
                        // 若该数填入无问题
                        board[i][j] = k;
                        if (solveSudokuHelper(board)){
                            // 若能找到解则直接返回
                            return true;
                        }
                        board[i][j] = '.'; // 回溯
                    }
                }
                return false; // 若九个数试完都不符合则返回false
            }
        }
        return true; // 若全部填满则返回true
    }
    
    private boolean isValidSudoku(int row, int col, char val, char[][] board){
        // 判断同一行是否有相同的数
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val){
                return false;
            }
        }
        // 判断同一列是否有相同的数
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val){
                return false;
            }
        }
        // 判断九宫格内是否有相同的数
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
}