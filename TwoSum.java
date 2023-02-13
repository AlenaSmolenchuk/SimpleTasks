//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[0];
        for (int i = 0; i < nums.length - 1; i++) {
          for (int j = i+1; j< nums.length;j++) {
            if (nums[i] + nums[j] == target) {
                result = new int[]{i, j};
            }
          }
        }
        return result;
    }
}
