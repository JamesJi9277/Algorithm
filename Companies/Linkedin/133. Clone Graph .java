public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        List<UndirectedGraphNode> list = new ArrayList<>();
        int index = 0;
        list.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while (index < list.size()) {
            UndirectedGraphNode temp = list.get(index++);
            for (UndirectedGraphNode neighbor : temp.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    list.add(neighbor);
                }
            }
        }
        for (UndirectedGraphNode node1 : list) {
            for (UndirectedGraphNode neighbor : node1.neighbors) {
                map.get(node1).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}