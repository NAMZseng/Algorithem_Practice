package lesson2_search_sort;

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

    /**
     * 堆排序算法步骤：
     *
     * 1.创建一个堆 H[0……n-1];
     * 2.把堆首（最大值）和堆尾互换;
     * 3.把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置;
     * 4.重复步骤 2，直到堆的尺寸为 1
     */
    public static void heapSort(int[] arr){


    }
}
