// 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

// 回文串 是正着读和反着读都一样的字符串。

class Solution {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12){ // 若长度超出则直接返回空列表
            return result;
        }
        backTrack(s, 0, 0);
        return result;
    }

    // pointNum表示小数点个数，3个即切分完成
    private void backTrack(String s, int startIndex, int pointNum) {
        if (pointNum == 3){
            if (isValid(s, startIndex, s.length() - 1)){
                result.add(s); // 若符合要求则加入结果列表中
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)){
                s = s.substring(0, i + 1) + '.' + s.substring(i+1, s.length()); // 在该位置后面加一个点分割
                pointNum++;
                backTrack(s, i + 2, pointNum); // 要后移两位，因为加了一个点
                pointNum--; // 回溯
                s = s.substring(0, i + 1) + s.substring(i + 2, s.length()); // 删去本次添加的点
            }else {
                // 若不符合要求直接结束，剪枝操作
                break;
            }
        }

    }

    private Boolean isValid(String s, int start, int end) {
        if (start > end){
            return false;
        }
        // 0开头不合法
        if (s.charAt(start) == '0' && start != end){
            return false;
        }
        // 大于255不合法
        int num = 0;
        for (int i = start; i <= end; i++) {
            // 非法字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0'){
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255){
                return false;
            }
        }
        // 若符合条件则返回true
        return true;
    }
}