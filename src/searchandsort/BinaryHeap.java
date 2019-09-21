package searchandsort;

/**
 * 二叉小根堆的实现
 *
 * @author Nanrong Zeng
 * @version 1.0
 */
public class BinaryHeap {

    /**
     * 当前堆的大小
     */
    private int currentSize;
    /**
     * 存储堆的数组
     * 对于二叉堆，从脚标1开始存根节点。
     * 位于数组i位置上的元素，其左儿子的位置在2*i上，右儿子在2*i+1上,父亲节点的位置为i/2
     */
    private int[] array;

    /**
     * 堆的初始化
     *
     * @param items 需要转化为二叉堆的数组
     */
    public BinaryHeap(int[] items) {
        // 二叉堆从脚标1开始存根节点
        currentSize = items.length;
        // 扩容10%，减少增加元素时的频繁扩容操作
        array = new int[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (int item : items) {
            array[i++] = item;
        }

        buildHeap();
    }

    /**
     * 判断当前堆是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        if (currentSize == 0) {
            return true;
        }
        return false;
    }

    /**
     * 添加元素到堆中
     *
     * @param x
     */
    public void insert(int x) {
        if (currentSize == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
        }

        // 新元素的位置
        int hole = ++currentSize;
        // 最终hole可能上滤到根节点1的位置，将插入项引入到位置0可使得循环终止
        for (array[0] = x; x < array[hole / 2]; hole /= 2) {
            //大的父亲下移
            array[hole] = array[hole / 2];
        }

        array[hole] = x;
    }

    /**
     * 获得最小元素，即堆顶元素
     */
    public int findMin() {
        return array[1];
    }

    /**
     * 删除最小元素
     *
     * @return 最小元素，即堆顶元素
     */
    public int deleteMin() throws Exception {
        if (isEmpty()) {
            throw new Exception("heap is empty!");
        }

        int minItem = findMin();

        array[1] = array[currentSize--];
        // 重新建堆
        percolateDown(1);

        return minItem;
    }

    /**
     * 建堆
     */
    private void buildHeap() {
        // 从位于末尾的父亲节点开始建堆，直至根节点1
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    /**
     * 下滤，将大元素下降到合适的位置
     *
     * @param hole 需要下降的元素所在的位置
     */
    private void percolateDown(int hole) {
        int temp = array[hole];

        for (int child = hole * 2; child <= currentSize; child = hole * 2) {
            // 选出左右孩子中较小的
            if (child != currentSize && array[child] > array[child + 1]) {
                child++;
            }
            // 将较小的孩子与父亲比较
            if (array[child] < temp) {
                // 小的孩子上移成为父亲
                array[hole] = array[child];
                // 父亲下滤成为孩子
                hole = child;
            } else {
                break;
            }
        }

        array[hole] = temp;
    }

    /**
     * 将堆扩容
     *
     * @param newSize
     */
    private void enlargeArray(int newSize) {
        int[] newArray = new int[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, -1, 5, 3, 4};

        BinaryHeap binaryHeap = new BinaryHeap(arr);
        binaryHeap.insert(-2);
        int len = binaryHeap.currentSize;
        try {
            for (int i = 0; i < len; i++) {
                System.out.println(binaryHeap.deleteMin());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
