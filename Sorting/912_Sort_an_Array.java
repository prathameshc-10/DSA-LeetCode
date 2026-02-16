package Sorting;

/*
Problem Name:
Sort an Array (Merge Sort Implementation)

Difficulty:
Medium

Approach:
- We use the Divide and Conquer technique.
- Step 1: Recursively divide the array into two halves until each subarray contains only one element.
- Step 2: Merge the two sorted halves by comparing elements from both temporary arrays.
- During merge:
    - Create left and right temporary arrays.
    - Compare elements and place the smaller one back into the original array.
    - Copy remaining elements if any.
- Using "<=" ensures the algorithm remains stable (maintains order of equal elements).

Time Complexity:
O(n log n)
- The array is divided log(n) times.
- Each level of recursion processes all n elements during merging.

Space Complexity:
O(n)
- Extra space is used for temporary left and right arrays.
- Recursion stack space is O(log n).
*/

class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end){
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for(int i = 0; i < n1; i++){
            leftArr[i] = nums[start+i];
        }

        for(int i = 0; i < n2; i++){
            rightArr[i] = nums[mid+1+i];
        }

        int i = 0, j = 0, k = start;
        while(i < n1 && j < n2){
            if(leftArr[i] <= rightArr[j]){
                nums[k++] = leftArr[i++];
            } else{
                nums[k++] = rightArr[j++];
            }
        }

        while(i < n1){
            nums[k++] = leftArr[i++];
        }

        while(j < n2){
            nums[k++] = rightArr[j++];
        }
    }
}
