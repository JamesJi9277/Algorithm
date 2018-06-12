class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int [] sol = new int[n];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> carry = new Stack<>();
        
        for(String s : logs){
            String [] arr = s.split(":");
            int id = Integer.parseInt(arr[0]);
            int time = Integer.parseInt(arr[2]);
            
            if(arr[1].equals("start")){
                stack.push(time);
                carry.push(0);
            } else {
                int carryOver = carry.pop();
                int currentTime = time - stack.pop() + 1;
                
                sol[id] += (currentTime - carryOver);
                if(!carry.isEmpty()) carry.push(carry.pop() + currentTime);
            }
        }
        
        return sol;
    }
}