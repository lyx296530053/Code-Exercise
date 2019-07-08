package EveryDay;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 2, 0, 1, 3};
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    System.out.println(nums[i]);
                    return;
                }
                swap(nums, i, nums[i]);
            }
        }
    }
        private static void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
}
