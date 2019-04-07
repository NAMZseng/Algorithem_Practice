package lesson2_search_sort;

/**
 * @author Nam Zeng
 * @coding UTF-8
 * @Date 2019/4/7
 * @Description 交换排序
 */
public class SwapSort {

    /**
     * 冒泡排序
     * 算法步骤：
     * 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 3.针对所有的元素重复以上的步骤，除了最后一个。
     * 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */
    public void bubbleSort(int[] arr) {

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
     * 1.从数列中挑出一个元素，称为 “基准”（pivot）。
     * 2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面(相同的数可以到任一边)
     *   在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * 3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     */
    public void quickSort(int[] arr){

    }

}
