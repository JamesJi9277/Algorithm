The key task here is to connect those emails, and this is a perfect use case for union find.
to group these emails, each group need to have a representative, or parent.
At the beginning, set each email as its own representative.
Emails in each account naturally belong to a same group, and should be joined by assigning to the same parent (let's use the parent of first email in that list);

a b c // now b, c have parent a
d e f // now e, f have parent d
g a d // now abc, def all merged to group g

parents populated after parsing 1st account: a b c
a->a
b->a
c->a

parents populated after parsing 2nd account: d e f
d->d
e->d
f->d

parents populated after parsing 3rd account: g a d
g->g
a->g
d->g
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return res;
        }
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                parents.put(account.get(i), account.get(i));
                owner.put(account.get(i), account.get(0));
            }
        }
        for (List<String> account : accounts) {
            String p = find(account.get(1), parents);
            for (int i = 2; i < account.size(); i++) {
                parents.put(find(account.get(i), parents), p);
            }
        }
        for (List<String> account : accounts) {
            String p = find(account.get(1), parents);
            if (!unions.containsKey(p)) {
                unions.put(p, new TreeSet<String>());
            }
            for (int i = 1; i < account.size(); i++) {
                unions.get(p).add(account.get(i));
            }
        }
        for (String p : unions.keySet()) {
            List<String> email = new ArrayList<>(unions.get(p));
            email.add(0, owner.get(p));
            res.add(email);
        }
        return res;
    }
    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}

https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC++-Union-Find