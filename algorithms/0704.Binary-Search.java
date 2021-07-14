class Solution{
    /**
     * @param array is the object of array
     * @param key is the element to be searched
     */
    int binarySearch(int[] nums,int target){
        // the range between left and right is [left,right]
        int left = 0;
        int right = nums.length - 1;
       
        /*
         * if while(left < right){
         * 		loop body;
         * }
         * return nums[left] == target?left:-1;
         */
        
        // when left == tight + 1,foramat is [right+1,right],
    	// the while(left <= right) stop, and return -1.
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // search range becomes to [mid+1,right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // search range becomes to [left,mid-1]
                right = mid -1;
            }
         }
         return -1;
    }
}
