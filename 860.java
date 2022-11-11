// 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。

// 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

// 注意，一开始你手头没有任何零钱。

// 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int len = bills.length;
        int[] rest = new int[3]; // 零钱 分别对应5元 10元 15元
        for (int i = 0; i < len; i++) {
            int sub = bills[i] - 5;
            if (sub == 5){
                if (rest[0] > 0){
                    // 有五块钱剩
                    rest[0]--;
                }else {
                    return false;
                }
            }
            if (sub == 15){
                if (rest[1] > 0 && rest[0] > 0){
                    // 给一张十块一张五块
                    rest[1]--;
                    rest[0]--;
                }else if (rest[0] >= 3){
                    // 给三张五块
                    rest[0] = rest[0] - 3;
                }else {
                    return false;
                }
            }
            if (bills[i] == 5){
                rest[0]++;
            }else if (bills[i] == 10){
                rest[1]++;
            }else {
                rest[2]++;
            }
        }
        return true;
    }
}

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5){
                five++;
            }else if (bills[i] == 10){
                five--;
                ten++;
            }else if (bills[i] == 20){
                if (ten > 0){
                    ten--;
                    five--;
                }else {
                    five -= 3;
                }
            }
            if (five < 0 || ten < 0){
                // 不够钱
                return false;
            }
        }
        return true;
    }
}