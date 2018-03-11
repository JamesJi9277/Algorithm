class Solution {
    public int addDigits(int num) {
        if(num < 0) {
            return 0;
        }
        return 1 + (num - 1) % 9;//数根
    }
}

class Solution {
    public int addDigits(int num) {
        if(num < 0) {
            return 0;
        }
        int sum = 0;
        String s = Integer.toString(num, 10);
        if (s.length() == 1) {
            return Integer.parseInt(s);
        }
        for (int i = 0; i < s.length(); i++) {
            sum += (s.charAt(i) - '0');
        }
        return addDigits(sum);
    }
}

public class Solution {
  public int addDigits(int num) {
    if(num < 10) {
      return num;
    }
    int result = num;
    while(result >= 10) {
      result = digitSum(result);
    }
    return result;
  }
  private int digitSum(int num) {
    int sum = 0;
    while(num != 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }
}