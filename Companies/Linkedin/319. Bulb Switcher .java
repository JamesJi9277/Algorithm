class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
1. bulb ends with on only switched odd number of times
2. So bulb i ends up on if and only if it has an odd number of divisors.
3. then it comes to sqrt