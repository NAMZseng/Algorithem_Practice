package strings;

/**
 * @author Nam Zeng
 * @coding UTF-8
 * @Date 2019/3/31
 * @Description 全排列
 */
public class AllSequencePermutation {

    /**
     * 使用递归对str从第pos位开始进行全排列
     *
     * @param str
     * @param pos 表示确定全排列的第pos位
     */
    public void allSequencePermutate(char[] str, int pos) {
        if (pos == str.length) {
            // 全排列完成，可在此if语句体中调用完成全排列时进行的动作
            // check();
            return;
        }

        for (int i = pos; i < str.length; i++) {

            // 剪枝，判断是否有重复项
            // 如str = abbcd,则只需对第一个b进行
            // 当i=2时，即到达第二个b,由于[pos=0, 2)中有b,所以此b位不用进行全排列

            // 剪枝法一：时间换空间，时间复杂度O((n+1)!)
            if(hasSame(str, pos, i)){
                continue;
            }

//            // 剪枝法二：空间换时间，时间复杂度O(n!), 空间复杂度O(n)
//            // 对于128个ascii码，当某个字符已经出现过，直接跳过
//            boolean[] mark = new boolean[128];
//            if (mark[(int)str[i]] == true){
//                continue;
//            }
//            mark[(int)str[i]] = true;

            // 将第i位和第pos位交换，即让字符串中的各个元素分别充当首元素（pos位）
            char temp = str[i];
            str[i] = str[pos];
            str[pos] = temp;

            // 递归，从第pos+1位开始，确定pos位后面的排列
            allSequencePermutate(str, pos + 1);

            // 回溯，交换回初始的首元素，防止影响下一次的交换
            temp = str[i];
            str[i] = str[pos];
            str[pos] = temp;
        }
    }

    /**
     * 判断str[from,to)中是有和str[to]重复的项
     *
     * @param str
     * @param from
     * @param to
     * @return
     */
    public boolean hasSame(char[] str, int from ,int to){
        for (int i = from; i < to; i++) {
            if(str[i] == str[to]){
                return true;
            }
        }
        return false;
    }

}
