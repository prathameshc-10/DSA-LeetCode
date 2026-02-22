package Queue;

/*
Problem Name:
Top K Frequent Elements

Difficulty:
Medium

Approach:
- Step 1: Count the frequency of each element using a HashMap.
- Step 2: Use a Min Heap (PriorityQueue) to keep track of the top k frequent elements.
- The heap stores Map.Entry (number → frequency).
- Comparator sorts entries based on frequency in ascending order.
- If heap size exceeds k, remove the smallest frequency element.
- This ensures the heap always contains the k most frequent elements.
- Step 3: Extract elements from the heap and store their keys in the result array.
- Order of result does not matter.

Time Complexity:
O(n log k)
- Building frequency map takes O(n).
- For each unique element (at most n), we insert into heap → O(log k).
- Extracting k elements takes O(k log k).
- Overall dominated by O(n log k).

Space Complexity:
O(n)
- HashMap stores frequencies of up to n unique elements.
- Min Heap stores at most k elements.
*/

import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();     
            }
        }

        int[] result = new int[k];
        int i = 0;
        while(!minHeap.isEmpty()){
            result[i] = minHeap.poll().getKey();
            i++;
        }
        return result;
    }
}
