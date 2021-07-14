class Solution {
  public int findPeakElement(int[] nums) {
    // the range between left and right is [0,nums.length - 1]
    int left = 0;
    int right = nums.length - 1;
    
    // when left = right, the while loop will stop.
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[mid + 1]) {
        // search range becomes to [left,mid]
        right = mid;
      } else if (nums[mid] < nums[mid + 1]) {
        // search range becomes to [mid+1,right]
        left = mid + 1;
      }
    }
    return left;
  }
}
