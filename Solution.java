
public class Solution {

	public int [] searchRange(int [] nums, int target) {

		int occurrence = binarySearch(nums, target); //first uses binary search to find occurrence 
		
		if(occurrence < 0) {
			return new int[] {-1, -1}; //if no occurrences of the number are found returns empty length
		}
		
		return bounds(nums, target, occurrence);
	}

	// binary search has a runtime of O(log n)
	private int binarySearch(int [] nums, int target) {
		
		int lower = 0;
		int upper = nums.length - 1;
		
		while(lower <= upper) {
			int middle = (lower+upper) / 2;
			
			if(nums[middle] == target) {
				
				return middle;
			} else if(nums[middle] < target) {
				
				lower = middle +1; // shifts the lower boundary past the middle point
			} else {
				
				upper = middle -1; // shifts the upper boundary past the middle point
			}
		}
		
		return -1;
	}
	
	//searches in linear fashion until it finds the last occurrence.
	private int [] bounds (int [] nums, int target, int occurrence) {
		int upperbound = occurrence;
		int lowerbound = occurrence;
		
		int lowerinc = 1;
		int upperdec = 1;
		
		//loops until it reaches a number which is not the target
		while(nums[upperbound] == target) {
			
			if(upperbound == nums.length-1) {
				upperdec = 0; //if end of the array is reached, do not decrement
				break;
			}
			upperbound++;
		}
		
		while(nums[lowerbound] == target ) {
			
			if(lowerbound == 0) {
				lowerinc = 0; //if start of the array is reached, do not increment
				break;
			}
			lowerbound--;
		}
		
		return new int[] {lowerbound + lowerinc, upperbound - upperdec};
	}
}
