public class Solution {
	public String compress(String s) {
		int count = 1;
		char last = s.charAt(0);
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == last) {
				count++;
			} else {
				if (count > 1) {
					sb.append("" + count + last);
				} else {
					sb.append(last);
				}
				count = 1;
				last = s.charAt(i);
			}
		}
		if (count > 1) {
			sb.append("" + count + last);
		} else {
			sb.append(last);
		}
		return sb.toString();
	}
}