/**
 * 二分查找
 *
 * @Auther:JHLY
 * @Date:2019/10/10
 * @Description:PACKAGE_NAME
 * @Version:1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 8, 6, 55, 432, 346, 234, 7, 9, 17, 13, 0};
        int i = 17;
        System.out.println(binaryFind(nums, i));
    }

    private static String binaryFind(int[] nums, int i) {
        int low = 0;
        int high = nums.length - 1;
        int count = 1 ;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (mid > i) {
                high = mid - 1;
            } else if (mid < i) {
                low = mid + 1;
            }else {
                return "第"+count+"次找到";
            }
            count++;
        }
        return "无匹配";
    }
}
