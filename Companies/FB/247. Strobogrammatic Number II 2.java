class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        helper(0, n - 1, res, new char[n]);
        return res;
    }
    private void helper(int left, int right, List<String> res, char[] array) {
        if (left == right) {
            array[left] = '0';
            res.add(new String(array));
            
            array[left] = '1';
            res.add(new String(array));
            
            array[left] = '8';
            res.add(new String(array));
            return;
        } else if (left > right) {
            res.add(new String(array));
            return;
        }
        if (left != 0) {
            array[left] = '0';
            array[right] = '0';
            helper(left + 1, right - 1, res, array);
        }
        array[left] = '1';
        array[right] = '1';
        helper(left + 1, right - 1, res, array);
        
        array[left] = '8';
        array[right] = '8';
        helper(left + 1, right - 1, res, array);
        
        array[left] = '6';
        array[right] = '9';
        helper(left + 1, right - 1, res, array);
        
        array[left] = '9';
        array[right] = '6';
        helper(left + 1, right - 1, res, array);
    }
}