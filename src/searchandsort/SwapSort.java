package searchandsort;

/**
 * @author Nam Zeng
 * @coding UTF-8
 * @Date 2019/4/7
 * @Description 交换排序
 */
public class SwapSort {

    /**
     * If the length of an array to be sorted is less than this
     * constant, insertion sort is used in preference to Quicksort.
     */
    private static final int INSERTION_SORT_THRESHOLD = 47;

    /**
     * 冒泡排序
     * 算法步骤：
     * 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 3.针对所有的元素重复以上的步骤，除了最后一个。
     * 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */
    public static void bubbleSort(int[] arr) {

        // 设置完成标志，当一次比较后若没有进行交换，则说明数组以有序，直接退出循环
        boolean done = false;

        // 进行n-1次循环比较
        for (int i = 1; i < arr.length && !done; i++) {
            done = true;
            for (int j = 0; j < arr.length - i; j++) {
                // 从小到大排序
                if (arr[j] > arr[j + 1]) {
                    // 交换
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];

                    done = false;
                }
            }
        }
    }

    /**
     * 快速排序
     * 算法步骤：
     * 1.使用三数中值分割法从数列中挑出一个“枢纽元”（pivot）元素
     * 2.创建游标i,j 分别从左和右端扫描数组，将小于pivot移动其左边，大于的移到其右边
     * 3.对pivot的左右两部分分别调用递归，重复1，2操作
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        // 当需要排列的元素较小时,直接使用插入排序
        if (right - left < INSERTION_SORT_THRESHOLD) {
            InsertSort.insertSort(arr, left, right);
        } else {
            int pivot = getPivot(arr, left, right);
            int i = left;
            int j = right - 1;
            while (true) {
                // 经过getPivot()后，left已经是小于pivot的，right-1=pivot
                // 若i--,j++时，在arr[i]=arr[j]=pivot时会出现死循环
                // 在等于时也停止，已尽量获取俩个较为平衡的分割
                // （可假设数组元素全相等时, < 与 <= 区别）
                while (arr[++i] < pivot) { }
                while (arr[--j] > pivot) { }
                if (i < j) {
                    swap(arr, i, j);
                } else {
                    // 此时i所在位置的元素一定是>=pivot的
                    break;
                }
            }
            // 此时i所在的元素大于等于pivot,置换right-1位置的pivot
            swap(arr, i, right - 1);

            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);

//                   //对于找出数组第k小元素的quickSelect(int[]arr, int left, int right, int k)
//                   //当完成排序后，数组的第k-1个元素即为第k小元素
//                    if(k <= i){
//                        quickSelect(arr, left, i-1, k);
//                    } else if (k > i + 1){
//                        // 当k = i+1, 则i所在元素即为第k小元，直接结束函数即可
//                        quickSelect(arr, i+1, right, k);
//                    }
        }
    }

    /**
     * 获取每次排序的枢纽元pivot
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static final int getPivot(int[] arr, int left, int right) {
        int center = left + (right - left) / 2;

        // 冒泡排列序，比较arr[left] arr[center] arr[right] 的大小，
        // arr[left]存放最小，arr[right]存最大，arr[center]做为pivot
        // 在quickSort主程序中，游标i, j就可以分别从left+1, right-2开始
        if (arr[right] < arr[center]) {
            swap(arr, center, right);
        }
        if (arr[center] < arr[left]) {
            swap(arr, left, center);
        }
        if (arr[right] < arr[center]) {
            swap(arr, center, right);
        }
        // pivot与right-1交换，这样待处理的元素都集中在[reft-1,right-2]之间
        swap(arr, center, right - 1);

        return arr[right - 1];
    }

    /**
     * 交换arr[i], arr[j]
     *
     * @param arr
     * @param i
     * @param j
     */
    public static final void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
