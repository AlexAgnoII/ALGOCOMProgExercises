package P1;

public class Search {
	
	public boolean linear(int[] sortedArr, int key) {
		int arrLength = sortedArr.length; 
		
		                                     //PSEUDOCODE
		for(int i = 0; i < arrLength; i++) { //for i = 0 to arrLength
			if(sortedArr[i] == key) {        //   if sortedArr[i] == num
				return true;                 //       return true
			}
		}
		
		return false;
	}
	
	
	//TODO Implement binary search
	public boolean binary(int[] sortedArr, int key, int low, int high) {
		int mid = low + ((high - low) / 2); //https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
		
		if(low > high) {
			return false;
		}
		
		else if (sortedArr[mid] == key) {
			return true;
		}
		
		else if (key < sortedArr[mid]){
			return binary(sortedArr, key, low, mid - 1);
		}
		
		else {
			return binary(sortedArr, key, mid + 1, high);
		}
		
	}
	
	//TODO Create timestamp to check execution time of search algorithms.

}
