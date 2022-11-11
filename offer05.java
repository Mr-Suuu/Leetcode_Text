// 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

class Solution {
    public String replaceSpace(String s) {
        ArrayList<Character> res = new ArrayList<>();
        for (char c : s.toCharArray()){
            if (c != ' '){
                res.add(c);
            }else {
                res.add('%');
                res.add('2');
                res.add('0');
            }
        }
        String listString = res.stream().map(Object::toString)
                .collect(Collectors.joining(""));
        return listString;
    }
}

class Solution {
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }
}

