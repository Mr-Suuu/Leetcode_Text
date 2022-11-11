// 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

// 算法思想：首先统计词频，然后基于小根堆求出现频率前K高的元素
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值正序排，相当于小根堆
        // (o1, o2) -> o1.getValue() - o2.getValue()是定义判断大小的条件，这里是指PriorityQueue是小根堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries){
            queue.offer(entry); // 将元素加入小根堆中
            if (queue.size() > k){ // 若当前有效元素个数大于K则将最小元素出堆，小根堆每次将最小元素移到最后面并将其余元素恢复成小根堆
                queue.poll();
            }
        }
        // 最终留下的小根堆中最前面的K个元素即为所求
        for (int i = k - 1; i >= 0; i--){
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}