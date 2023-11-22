public class RemoveDuplicates {
    public int removeDuplicates(String[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = "_";
        }
        return k;
    }

    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();
        String[] nums1 = {"1", "1", "2"};
        int k1 = solution.removeDuplicates(nums1);
        System.out.print("Output: " + k1 + ", nums = [");
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + (i == nums1.length - 1 ? "" : ","));
        }
        System.out.println("]");

        String[] nums2 = {"0", "0", "1", "1", "1", "2", "2", "3", "3", "4"};
        int k2 = solution.removeDuplicates(nums2);
        System.out.print("Output: " + k2 + ", nums = [");
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + (i == nums2.length - 1 ? "" : ","));
        }
        System.out.println("]");
    }
}