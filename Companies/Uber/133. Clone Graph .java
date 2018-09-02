public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        List<UndirectedGraphNode> list = new ArrayList<>();
        list.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        int index = 0;
        while (index < list.size()) {
            UndirectedGraphNode temp = list.get(index++);
            for (UndirectedGraphNode neighbor : temp.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    list.add(neighbor);
                }
            }
        }
        for (UndirectedGraphNode temp : list) {
            for (UndirectedGraphNode neighbor : temp.neighbors) {
                map.get(temp).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}