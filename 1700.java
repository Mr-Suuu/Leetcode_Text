// 学校的自助午餐提供圆形和方形的三明治，分别用数字0和1表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
// 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个栈里，每一轮：

// 如果队列最前面的学生喜欢栈顶的三明治，那么会拿走它并离开队列。
// 否则，这名学生会放弃这个三明治并回到队列的尾部。
// 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。

// 给你两个整数数组students 和sandwiches，其中sandwiches[i]是栈里面第i个三明治的类型（i = 0是栈的顶部），
// students[j]是初始队列里第j名学生对三明治的喜好（j = 0是队列的最开始位置）。请你返回无法吃午餐的学生数量。

// 算法思想：学生顺序没有影响，只要判断三明治栈顶元素在学生队列中是否存在即可
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] st = new int[students.length]; // 保存该学生是否已用餐，1表示没有，0表示有
        Arrays.fill(st, 1);
        int flag;
        for (int i = 0; i < sandwiches.length; i++) {
            flag = 0;
            for (int j = 0; j < students.length; j++) {
                if (students[j] == sandwiches[i] && st[j] == 1){
                    st[j] = 0;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                break;
            }
        }
        return Arrays.stream(st).sum();
    }
}

// 算法思想：学生顺序没有影响，只要判断三明治栈顶元素在学生队列中是否存在即可，先统计每种类型的学生数量，然后根据栈顶三明治进行比较
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnts = new int[2]; // 记录喜欢两种类型的学生数量
        for (int student : students) {
            cnts[student]++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (--cnts[sandwiches[i]] == -1){
                // 表示若当前该类型学生数量已为0，则返回没饭吃的学生人数
                return sandwiches.length - i;
            }
        }
        return 0;
    }
}