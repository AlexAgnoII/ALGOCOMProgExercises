package P2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//Created by: Alexander H. Agno II
//ALGOCOM S18

public class Algorithm_Design_Writing {
	
	private static final int N_MAX = 1000000;
	private static final int M_MAX = 5000;
	private static final String NOT_ENOUGH_FOOD = "NOT ENOUGH FOOD!";
	private static final String JUST_ENOUGH_FOR_EVERYONE = "JUST ENOUGH FOR EVERYONE";
	private static final String PARTY = "PARTY!";
	
	private static final char CHAR_MIN = 65;
	private static final char CHAR_MAX = 90;
	
	
	private static final int N_COMBINATION_MAX = 20;
	
	
	public static void analyze (String input) {
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
		   
		long optimalCount = 0;
		
		for(int x = 1; x < length; x++) {
			
			for(int y = 0; y < length - x; y++) {
				
				//perform swap
				if(carriageNumbers[y] > carriageNumbers[y+1]) {
					int temp = carriageNumbers[y];
					carriageNumbers[y] = carriageNumbers[y+1];
					carriageNumbers[y+1] = temp;
					optimalCount++;
				}
			}
		}
		
		System.out.println("The most optimal train swaps: " + optimalCount);
	}
	
	public static void checkHarvest (int numVillages, //N - number of villages to feed
			                         int costToFeed, //M - cost to feed each villager.
			                         int[] harvests) {
		
		long foodGoal = numVillages * costToFeed;
		long totalHarvest = 0;
		
		if((numVillages >= 1 && numVillages <= N_MAX) &&
		   (costToFeed >= 1 && costToFeed <= M_MAX)) {
			
			for(int i = 0; i < numVillages; i++) {
				totalHarvest += harvests[i];
			}
			
			if(totalHarvest < foodGoal) {
				System.out.println(NOT_ENOUGH_FOOD);
			}
			
			else if (totalHarvest > foodGoal) {
				System.out.println(PARTY);
			}
			
			else if (totalHarvest == foodGoal) {
				System.out.println(JUST_ENOUGH_FOR_EVERYONE);
			}
		}
	}
	
	public static void printCombination (int N, int K) { // nCk
		
		if((N >= 1 && N <= N_COMBINATION_MAX) &&
			K >=1 && K <= N) {
			int[] nElements = new int[N];
			int[] temp = new int[N];
			
			for(int i = 0; i < N; i++) {
				nElements[i] = i+1;
			}
			
			doCombination(nElements, temp, 0, N, 0, K);
		}
		else {
			System.out.println("Invalid N or K value.");
		}
	}
	
	private static void doCombination(int[] nElements, int[] temp, int start, int end, int index, int K) {
		
		//when the index is equal to the number of set K, print
		if(index == K) {
			for(int i = 0; i < K; i++) {
				System.out.print(temp[i] + " ");
			}
			System.out.println();
		}
		
		else {
			//iterate over the tree of all possible combinations.
			for(int i = start; i < end; i++) {
				temp[index] = nElements[i];
				doCombination(nElements, temp, i+1, end, index+1, K);
			}
		}
	}
}
