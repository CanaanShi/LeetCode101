class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // way 1
        int i = 0;
        while (arr[i] < arr[i+1]){
            i++;
        }
        return i;
        
        
        /*
         * way 2
          if(arr.length == 1){
              return 0;
          }else if(arr[0]>arr[1]){
              return 0;
          }else if(arr[arr.length - 1] >= arr[arr.length - 2]){
              return arr.length-1;
          }
          for(int i = 1; i < arr.length - 1; i++){

          // Check if the neighbors are smaller
              if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]){
                  return i;
              }      
          }
          return 0;
        */
    }
}
