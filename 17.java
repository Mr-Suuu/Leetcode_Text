// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

// 算法思想：
class Solution {
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return result;
        }
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);
        //迭代处理
        return result;
    }

    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    StringBuilder temp = new StringBuilder();

    private void backTracking(String digits, String[] numString, int num) {
        // digits是键盘输入的数字串，num表示当前是第几个数字
        if (num == digits.length()){
            result.add(temp.toString());
            return;
        }

        // 获取当前数字所对应的字母串
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i)); // 加入组合中
            backTracking(digits, numString, num + 1);
            temp.deleteCharAt(temp.length() - 1); // 回溯，删除本次添加的元素
        }
    }
}