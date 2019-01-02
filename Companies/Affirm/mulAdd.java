public class Solution {
	class Pair {
		String s;
		int n;
		public Pair(String s, int n) {
			this.s = s;
			this.n = n;
		}
	}
	public int parse(String exp) {
		Stack<Pair> op = new Stack<>();
		Stack<Pair> num = new Stack<>();
		String[] arr = exp.split(" ");
		int res = 0;
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("(")) {
				if (i != 0) {
					num.push(new Pair("" + res, temp));
				}
				temp++;
			} else if (arr[i].equals("add") || arr[i].equals("mul")) {
				op.push(new Pair(arr[i], temp));
				if (arr[i].equals("add")) {
					res = 0;
				} else {
					res = 1;
				}
			} else if (isNumber(arr[i])) {
				if (op.peek().s.equals("add")) {
					res += Integer.parseInt(arr[i]);
				} else {
					res *= Integer.parseInt(arr[i]);
				}
			} else if (arr[i].equals(")")) {
				while (!num.isEmpty() && num.peek().n == temp) {
					if (op.peek.n == temp) {
						if (op.peek().s.equals("add")) {
							res += Integer.parseInt(num.pop().s);
						} else {
							res *= Integer.parseInt(num.pop().s);
						}
					}
				}
				op.pop();
				temp--;
			}
		}
		return res;
	}
	private boolean isNumber(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}
}



class Pair {
    String s;
    int count;
    public Pair(String s, int count) {
        this.s = s;
        this.count = count;
    }
}
public class Solution {
    public static void main(String args[]) {
        Solution s = new Solution();
        String eval = "add ( 1 mul ( 1 2 -3 ) 3 )";
        System.out.println("Result is " + s.evaluate(eval));
    }
    private int evaluate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] array = s.split(" ");
        Stack<Pair> ops = new Stack<>();
        Stack<Pair> nums = new Stack<>();
        int res = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("(")) {
                if (i != 0) {
                    nums.push(new Pair("" + res, count));
                }
                count++;
            } else if (array[i].equals(")")) {
                while (!nums.isEmpty() && nums.peek().count == count) {
                    if (!ops.isEmpty() && ops.peek().s.equals("add")) {
                        res += Integer.parseInt(nums.pop().s);
                    } else {
                        res += Integer.parseInt(nums.pop().s);
                    }
                }
                ops.pop();
                count--;
            } else if (array[i].equals("add") || array[i].equals("mul")) {
                ops.push(new Pair(array[i], count));
                if (array[i].equals("add")) {
                    res = 0;
                } else {
                    res = 1;
                }
            } else {
                if (ops.peek().s.equals("add")) {
                    res += Integer.parseInt(array[i]);
                } else {
                    res *= Integer.parseInt(array[i]);
                }
            }
        }
        return res;
    } 
}