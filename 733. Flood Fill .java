class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    private void helper(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        image[sr][sc] = newColor;
        helper(image, sr + 1, sc, color, newColor);
        helper(image, sr - 1, sc, color, newColor);
        helper(image, sr, sc + 1, color, newColor);
        helper(image, sr, sc - 1, color, newColor);
    }
}