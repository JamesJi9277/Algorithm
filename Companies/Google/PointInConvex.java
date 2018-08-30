// heron's formula
i = (a + b + c) / 2;
s = Math.sqrt(i* (a - i) * (b - i) * (c - i));
if s1 + s2 + s3 == s, then the point is in the convex

// 从这个点开始做射线rays
	如果只与多边形有奇数个交点，则说明在内部，否则就是在外部
// vector
if (p.x < minX || p.x > maxX || p.y < minY || p.y > maxY) {
	return false;
}
// 每次取三个点，相当于是做一个三角形来验证
double multiply(Point p1, Point p2, Point target) {
	// 表示从target到p1的向量点乘上target到p2的向量
	return (p1.x - target.x) * (p2.y - target.y) - (p2.x - target.x) * (p1.y - target.y);
}

boolean verify(List<Point> points, Point target) {
	// 从1应该是逆时针旋转才能够到达向量p0  
	// 同理，从i - 1开始也只能够顺时针来到大p0
	if (multiply(points[1], points[0], target) > 0 || multiply(points[points.length - 1], points[0], target) < 0) {
		return false;
	}
	int start = 1;
	int end = points.length - 1;
	int line = -1;
	while (start <= end) {
		int mid = start + (end - start) / 2;
		if (multiply(target, points[mid], points[0]) > 0) {
			line = mid;
			end = mid - 1;
		}// target 在M的顺时针方向 , line保存的是m逆时针方向后的第一个点 
		else {
			start = mid + 1;
		}
	}
	return multiply(points[line], target, points[line - 1] > 0);
}



public class Solution {
    /**
     * @param point: a list of two-tuples
     * @return: a boolean, denote whether the polygon is convex
     */
    public boolean isConvex(int[][] point) {
        // write your code here
        if (point == null || point.length == 0 || point[0].length == 0) {
            return false;
        }
        boolean isNeg = false;
        boolean isPos = false;
        for (int i = 2; i < point.length + 2; i++) {
            int[] p1 = point[(i - 2) % point.length];
            int[] p2 = point[(i - 1) % point.length];
            int[] p3 = point[i % point.length];
            if (crossProduct(p1, p2, p3) > 0) {
                isPos = true;
            } else if (crossProduct(p1, p2, p3) < 0) {
                isNeg = true;
            }
        }
        return isPos ^ isNeg;
    }
    private int crossProduct(int[] p1, int[] p2, int[] p3) {
        int ax = p2[0] - p1[0];
        int ay = p2[1] - p1[1];
        int bx = p3[0] - p2[0];
        int by = p3[1] - p2[1];
        int cp = ax * by - ay * bx;
        if (cp > 0) {
            return 1;
        } else if (cp < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}

https://blog.csdn.net/lttree/article/details/24291719

a. 这题是一题几何题，给定一系列的点判断是否是凸多边形，根据凸多边形的定义，我们很容易就可以想到判断所有的点是不是在任意一条边的同旁即可，这么做的时间复杂度是O(n^2)，对于这题的数据范围来说很低效。
b. 由于这题给出的多边形是一个简单多边形，因此我们不需要考虑边互相交叉的情况，所以我们可以直接判断这个多边形的每一个内角大小，若均小于（本题中可以等于）180度，则为凸多边形。
c. 判断两条边的夹角我们可以用向量的叉积来计算，二维向量A与向量B的叉积可以表示为|A×B|=AxBy-AyBx，若这个值大于0，则说明B指向A逆时针旋转0到180的方向，若这个值小于0，则说明B指向A顺时针旋转0到180的方向，若等于0，则两向量共线。
根据向量的叉积我们就可以判断这个多边形的内角是否均小于180度，相邻两条边的向量均保持顺时针或逆时针旋转才符合条件。
