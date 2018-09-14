/**
 * Implement a messaging composing feature that should involve selecting and de-selecting of contacts. Every selection and de-selection will change the order of the overall selection and as such once done, the ordering should be returned. The constraint is that the selection and de-selection of contacts and the ordering must be maintained in constant time. The order can be returned in linear time.
 * 
 * e.g Select Contact A
 * B
 * Y
 * 
 * A, B, Y
 * 
 * If B is de-selected, the new order becomes A, Y
 * I select B again, the new order now becomes A, Y, B
 * y.pre = a;
 * y.next = b;
 * a.next = b;
 * b.pre = a;
 * 
 * 
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    class Element {
        String key;
        Element prev;
        Element next;
        // default
        public Element() {
            
        }
        public Element(String key) {
            this.key = key;
            this.prev = null;
            this.next = null;
        }
    }
    static Map<Element, Integer> map;
    static List<Element> list;
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        map = new HashMap<Element, Integer>();
        list = new ArrayList<>();
        Solution solution = new Solution();
        solution.select("A");
        solution.select("B");
        solution.select("C");
        solution.deselect("C");
        solution.deselect("A");
        print(list.get(1));
        
    }
    private void select(String s) {
        // sanity check
        if (s == null || s.length() == 0) {
            return;
        }
        Element e = new Element(s);
        if (list.isEmpty()) {
            map.put(e, 0);
            list.add(e);
        } else {
            list.get(list.size() - 1).next = e;
            e.prev = list.get(list.size() - 1);
            map.put(e, list.size());
            list.add(e);
        }
        // print(list.get(0));
    }
    private void deselect(String s) {
        // sanity check
        if (s == null || s.length() == 0) {
            return;
        }
        int index = 0;
        for (Map.Entry<Element, Integer> entry : map.entrySet()) {
            if (entry.getKey().key.equals(s)) {
                index = entry.getValue();
            }
        }
        // remove head
        if (index == 0) {
            if (list.size() == 1) {
                list = new ArrayList<Element>();
                return;
            } else {
                list.get(0).next = null;
                list.get(1).prev = null;
                map.remove(list.get(0).key);
                // print(list.get(1));
                return;
            }
        } else {
            Element pre = list.get(index - 1);
            Element next = index + 1 < list.size() ? list.get(index + 1) : null;
            pre.next = next;
            if (next != null) {
                next.prev = pre;
            }
            // print(list.get(0));
            return;
        }
    }
    public static void print(Element e) {
        Element runner = e;
        while (e != null) {
            System.out.println(e.key);
            e = e.next;
        }
    }
}