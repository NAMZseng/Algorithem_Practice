package searchandsort;

/**
 * @author Nam Zeng
 * @coding UTF-8
 * @Date 2019/4/7
 * @Description 测试排序方法
 * link:https://github.com/hustcc/JS-Sorting-Algorithm
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]
                {61, 9, 6, 302, 3, 55, 7, 6, 81, 6, 20, 393,
                 4, 5, 20, 9, 500, 746, 77317, 12, 9, 66, 9};

//        InsertSort.insertSort(arr, 0, arr.length - 1);
        SwapSort.quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
