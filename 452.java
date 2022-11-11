有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。

一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。

给你一个数组 points ，返回引爆所有气球所必须射出的 最小弓箭数。

// 算法思想：当气球出现重叠就射箭，即当前气球的左边界大于上一个气球的右边界的时候就要射箭+1
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0){
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0])); // 根据左边界排序
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]){
                // 当前左边界大于上一个的右边界就射箭
                count++;
            }else {
                // 更新最小右边界
                points[i][1] = Math.min(points[i][1], points[i-1][1]);
            }
        }
        return count;
    }
}