/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
     /**
      * @param node: A undirected graph node
      * @return: A undirected graph node
      */
     public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {         
         if (node == null) {
             return null;
         }
         List<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
         HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
         nodes.add(node);
         map.put(node, new UndirectedGraphNode(node.label));
         int start = 0;
         while (start < nodes.size()) {
             UndirectedGraphNode temp = nodes.get(start++);
             for (int i = 0; i < temp.neighbors.size(); i++) {
                 UndirectedGraphNode neighbor = temp.neighbors.get(i);
                 if (!map.containsKey(neighbor)) {
                     map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                     nodes.add(neighbor);
                 }
             }
         }
         
         for (int i = 0; i < nodes.size(); i++) {
             UndirectedGraphNode temp = map.get(nodes.get(i));
             for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                 UndirectedGraphNode newNeighbor = map.get(nodes.get(i).neighbors.get(j));
                 temp.neighbors.add(newNeighbor);
             }
         }
         return map.get(node);
     }
 }
