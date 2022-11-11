// 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。

// 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。

// 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
// 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。

// 算法思想：基于深度优先遍历和回溯法，首先统计各起飞点能到的终点信息，然后从起点开始，逐个深度遍历看能否全部地点到达，不能则回溯重新进行新的深度优先遍历
class Solution {
    private Deque<String> res;
    private Map<String, Map<String, Integer>> map; // 用来存储各地能起飞的次数

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, Map<String, Integer>>();
        res = new LinkedList<>();
        // 遍历tickets的起飞点并计数
        for (List<String> t: tickets) {
            Map<String, Integer> temp; // temp用来存放目的地信息
            // 判断map中是否有记录当前机票起飞点信息
            if (map.containsKey(t.get(0))){
                // 已有该起飞点信息则取出起飞点对应的终点信息并对终点计数
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            }else {
                temp = new TreeMap<>(); // 升序Map，使得终点按照字母升序顺序排列
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp); // 更新起飞点信息
        }
        res.add("JFK"); // 将最初的起点加入结果列表中
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }

    private boolean backTracking(int ticketNum) {
        if (res.size() == ticketNum + 1) {
            return true;
        }
        String last = res.getLast(); // 获取当前到达的最终目的地
        // 若有从该最终目的地起飞的飞机
        if (map.containsKey(last)){
            // entrySet使得键值对能够被遍历
            for (Map.Entry<String, Integer> target : map.get(last).entrySet()) {
                int count = target.getValue(); // 逐一获取当前目的地起飞的飞机的可达终点信息
                if (count > 0){
                    // 若有机票能到达此目的地
                    res.add(target.getKey()); // 加入路径
                    target.setValue(count - 1); // 消费机票
                    if (backTracking(ticketNum)){
                        // 若有路径则返回true
                        return true;
                    }
                    // 回溯
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false; // 若找不到路径则返回false
    }
}