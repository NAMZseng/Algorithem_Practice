package strings;

/**
 * @author Nam Zeng
 * @coding UTF-8
 * @Date 2019/3/31
 * @Description 循环左移字符串,时间复杂度O(n)
 */
public class LeftRotation {

    /**
     * 将str左移K位
     *
     * @param str
     * @param k
     */
    public void leftRotateString(char[] str, int k) {
        k %= str.length;

        // (X'Y')' = YX
        // X = ab, x' = ba
        // Y = xyz, Y'= zyx
        // XY = abxyz
        // (X'Y')' = YX =xyzab
        reverseString(str, 0, k - 1);
        reverseString(str, k, str.length - 1);
        reverseString(str, 0, str.length - 1);
    }

    /**
     * 将str中下标从[from, to]的子串反转
     *
     * @param str
     * @param from
     * @param to
     */
    public void reverseString(char[] str, int from, int to) {
        while (from < to) {
            char temp = str[from];
            str[from++] = str[to];
            str[to--] = temp;
        }
    }
}
