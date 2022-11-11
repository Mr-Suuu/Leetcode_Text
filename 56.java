// 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

// 算法思想：首先根据左边界排序，然后逐个比较是否重叠，若重叠则取最大右边界合并，若不重叠则将当前开始至结束位置存入结果中
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> res = new LinkedList<>();
        int start = intervals[0][0]; // 初始化左边界
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i-1][1]){
                // 若下一个的左边界小于等于上一个的右边界则重叠，将其合并，更新当前最大右边界
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            }else {
                // 不重叠则将其存入结果中
                res.add(new int[]{start, intervals[i-1][1]});
                start = intervals[i][0]; // 更新起始位置
            }
        }
        // 将最后一组加入结果中
        res.add(new int[]{start, intervals[intervals.length-1][1]});
        return res.toArray(new int[res.size()][]);
    }
}