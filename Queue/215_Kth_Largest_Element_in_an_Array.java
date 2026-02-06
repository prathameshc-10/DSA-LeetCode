package Queue;
import java.util.PriorityQueue;

// Problem Name: Kth Largest Element in an Array
// Difficulty Level: Medium
// Approach:
// Use a Min Heap (PriorityQueue) of size k.
// Iterate through the array and insert each element into the heap.
// If heap size exceeds k, remove the smallest element.
// At the end, the heap contains the k largest elements,
// and the top of the heap is the kth largest element.
// Time Complexity: O(n log k)
// Space Complexity: O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
