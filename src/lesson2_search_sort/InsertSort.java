package lesson2_search_sort;

/**
 * @author Nam Zeng
 * @coding UTF-8
 * @Date 2019/4/7
 * @Description 插入排序
 */
public class InsertSort {
    /**
     * 算法步骤：
     * 1.将第一个元素看做一个有序序列，把从第二个元素到最后一个元素当成是未排序序列。
     * 2.从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
     *   如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。
     */
    public static void insertSort(int[] arr) {

        //从下标为1的元素开始插入到前面的有序序列中
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];

            int j = i;
            // 在有序序列中比较，找到插入位置
            while(j > 0 && arr[j-1] > temp){
                // 将大的元素向后移位
                arr[j] = arr[j-1];
                j--;
            }
            // 插入新元素
            if(j != i) {
                arr[j] = temp;
            }
        }

    }

    //  优化：在查找时使用折半查找
    public static void binaryInsertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {

            int left = 0;
            int right = i-1;
            int mid = 0;
            // 在有序序列中使用二分查找，获取插入位置
            while(left <= right){
                mid = (left + right) / 2;
                if (arr[i] < arr[mid]) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            }

            int temp = arr[i];
            // 移动有序列表， 插入新元素
            for (int j = i-1 ; j >= mid; j--) {
                arr[j+1] = arr[j];
            }
            arr[mid] = temp;
        }
    }

}
