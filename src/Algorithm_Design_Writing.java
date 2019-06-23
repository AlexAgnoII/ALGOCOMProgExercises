import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Algorithm_Design_Writing {
	
	private static final int N_MAX = 1000000;
	private static final int M_MAX = 5000;
	
	private static final char CHAR_MIN = 65;
	private static final char CHAR_MAX = 90;
	
	
	public static void analyze(String input) {
		int inputSize = input.length();
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		
		input = input.toUpperCase();
		
		//Counting.
		for(int i = 0; i < inputSize; i++) {
			char charTemp = input.charAt(i);
			
			if(charTemp >= CHAR_MIN && charTemp <= CHAR_MAX) {
			
				//first time.
				if(!charCountMap.containsKey(charTemp)) {
					charCountMap.put(charTemp, 1);
				}
				
				//already existing
				else {
					int charCount = charCountMap.get(charTemp);
					charCount++;
					charCountMap.put(charTemp, charCount);
				}
			}
		}
		
		//Arrangement.
		HashMap<Integer, List<Character>> charArrangedMap = new HashMap<Integer, List<Character>>();		
		
		for(char charKey : charCountMap.keySet()) {
			int countKey = charCountMap.get(charKey);
			
			//does not have this key yet
			if(!charArrangedMap.containsKey(countKey)) {
				List<Character> charTempList = new ArrayList<Character>();
				charTempList.add(charKey);
				charArrangedMap.put(countKey, charTempList);
			}
			
			else {
				List<Character> charTempList = charArrangedMap.get(countKey);
				charTempList.add(charKey);
				charArrangedMap.put(countKey, charTempList);
			}
			
		}

		//Output.
		List<Integer> outputList = new ArrayList<Integer>();
		for(int key : charArrangedMap.keySet()) {
			outputList.add(key);
		}

		Collections.sort(outputList, Collections.reverseOrder());
		
		for(int count : outputList) {
			
			List<Character> charTempList = charArrangedMap.get(count);
			Collections.sort(charTempList);
			for(char finalChar : charTempList) {
				System.out.println(finalChar + " " + count);
			}
		}		
	}
	
	public static void countSwaps (int length, int[] carriageNumbers) {
		   
		int optimalCount = 0;
		
		for(int x = 1; x < length; x++) {
			
			for(int y = 0; y < length - x; y++) {
				
				//perform swap
				if(carriageNumbers[y] > carriageNumbers[y+1]) {
					carriageNumbers[y] = carriageNumbers[y] + carriageNumbers[y+1]; 
					carriageNumbers[y+1] = carriageNumbers[y] - carriageNumbers[y+1];
					carriageNumbers[y] = carriageNumbers[y] - carriageNumbers[y+1];
					optimalCount++;
				}
			}
		}
		
		System.out.println("The most optimal train swaps: " + optimalCount);
	}
	
	public static void checkHarvest (int numVillages, int costToFeed, int[] harvests) {
		   //put your code here and the print statements for the output.
	}

	public static void printCombination (int N, int K) {
		   //put your code here and the print statements for the output.
	}
	

	

}
