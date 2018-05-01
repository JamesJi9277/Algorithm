class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (A-C)*(B-D)+(E-G)*(F-H);
        if(C<=E||B>=H|| F>=D ||G<=A){
        return sum;
        }
        int a = Math.max(A,E);
        int b = Math.max(B,F);
        int c = Math.min(C,G);
        int d = Math.min(D,H);
        return sum-(c-a)*(d-b);
    }
}