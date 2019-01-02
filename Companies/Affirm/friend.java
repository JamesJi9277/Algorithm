import java.io.*;
import java.util.*;

// you can add other public classes to this editor in any order
public class Solution {
  public static void main(String[] args) {
    Solution s = new Solution();
    List<String> list = Arrays.asList(new String[]{"$%^&", "%^&*", "&*("});
    s.findNeighbor(list);
  }
  public void findNeighbor(List<String> list) {
    Map<Character, PriorityQueue<Node>> map1 = new HashMap<>();
    for (String s : list) {
      for (char c : s.toCharArray()) {
        map1.putIfAbsent(c, new PriorityQueue<>((a, b) -> {
          if (a.c != b.c) {
            return b.count - a.count;
          } else {
            return a.c - b.c;
          }
        }));
      }
    }
    Map<Character, Map<Character, Integer>> map = new HashMap<>();
    for (String s : list) {
      for (int i = 0; i < s.length(); i++) {
        map.putIfAbsent(s.charAt(i), new HashMap<>());
        for (int j = 0; j < s.length(); j++) {
          char c1 = s.charAt(i);
          char c2 = s.charAt(j);
          if (i == j || c1 == c2) {
            continue;
          }
          Map<Character, Integer> map2 = map.get(c1);
          map2.put(c2, map2.getOrDefault(c2, 0) + 1);
        }
      }
    }
    for (Map.Entry<Character, Map<Character, Integer>> entry : map.entrySet()) {
      for (Map.Entry<Character, Integer> entry1 : entry.getValue().entrySet()) {
        Node n = new Node(entry1.getKey(), entry1.getValue());
        map1.get(entry.getKey()).offer(n);
      }
    }
    for (Map.Entry<Character, PriorityQueue<Node>> entry : map1.entrySet()) {
      StringBuffer sb = new StringBuffer();
      sb.append(entry.getKey());
      sb.append(" ");
      int max = 0;
      if (!entry.getValue().isEmpty()) {
        sb.append(entry.getValue().peek().c);
        max = entry.getValue().poll().count;
      }
      while (!entry.getValue().isEmpty() && entry.getValue().peek().count == max) {
        sb.append(entry.getValue().poll().c);
      }
      System.out.println("The first result is: " + sb.toString());
    }
  }
}

class Node {
  char c;
  int count;
  public Node(char c, int count) {
    this.c = c;
    this.count = count;
  }
}