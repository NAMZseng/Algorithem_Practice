package lesson2_search_sort;

/**
 * @author Nam Zeng
 * @coding UTF-8
 * @Date 2019/4/7
 * @Description 测试排序方法
 * link:https://github.com/hustcc/JS-Sorting-Algorithm
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 9, 7, 6, 4, 3, 2, 1};

        InsertSort.binaryInsertSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
