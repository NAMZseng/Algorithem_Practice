package searchandsort;

/**
 * @author Nam Zeng
 * @coding UTF-8
 * @Date 2019/4/7
 * @Description 选择排序
 */
public class SelectSort {

    /**
     * 直接选择排序算法步骤：
     * 1.首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 2.再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 3.重复第二步，直到所有元素均排序完毕。
     */
    public static void selectSort(int[] arr) {
        // 进行n-1次循环比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                arr[min] ^= arr[i];
                arr[i] ^= arr[min];
                arr[min] ^= arr[i];
            }
        }
    }
}
