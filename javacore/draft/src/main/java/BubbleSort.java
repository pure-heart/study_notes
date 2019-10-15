import java.util.Arrays;

/**冒泡排序
 * @Auther:JHLY
 * @Date:2019/10/10
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 8, 6, 55, 432, 346, 234, 7, 9, 17, 13, 0};
        System.out.println(Arrays.toString(bubble(nums)));
    }

    private static int[] bubble(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i -1; j++) {
                if(nums[j] >nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
}
