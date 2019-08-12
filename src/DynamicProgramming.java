import java.util.ArrayList;
import java.util.List;

//Alexander H. Agno II
//ALGOCOM S18
public class DynamicProgramming {
	
	public static void assignTable(String[] input) {
        List<Integer> matrixDimList = new ArrayList<Integer>();
        int numMatrix = Integer.parseInt(input[0]);
        String[] matrixName = new String[numMatrix];
        int[][] tableForPrinting;
        
        //Parse into list of dimensions (correct order, duplicates are combined)
        for(int i = 0; i < numMatrix; i++) {
        	String[] inputSplitted = input[i+1].split(" ");
        	matrixName[i] = inputSplitted[0];
        	
        	if(i == 0) 
        		matrixDimList.add(Integer.parseInt(inputSplitted[1]));
        		
        	matrixDimList.add(Integer.parseInt(inputSplitted[2]));
        }
        
        //Compute
        tableForPrinting = matrixChainMultiplication(matrixDimList, matrixDimList.size());

        //Print
        printMatrixChainMultOrder(1, matrixDimList.size() - 1, tableForPrinting, matrixName);
	}
	
	private static void printMatrixChainMultOrder(int x, int y, int[][] tableForPrinting, String[] matrixName) {
		
		if(x == y) {
			System.out.print(matrixName[x-1]);
		}
		
		else {
			System.out.print("("); 
			
			printMatrixChainMultOrder(x, tableForPrinting[x][y], tableForPrinting, matrixName);
			printMatrixChainMultOrder(tableForPrinting[x][y] + 1, y, tableForPrinting, matrixName);
			
			System.out.print(")");
		}
	}


	private static int[][] matrixChainMultiplication(List<Integer> matrixDimList, int n) {
		
		int[][] tableM = new int[n][n]; //Table that will keep track of the minimum for DP.
		int[][] tableS = new int[n][n]; //Table that will tell us what is the order.
		
		//If one matrix, it means there are no multiplication cost.
		for(int i = 1; i < n; i++) {
			tableM[i][i] = 0;
		}
		
		for(int subLen = 2; subLen < n; subLen++) { 
			
			for(int x = 1; x < n - subLen + 1; x++) {
				int y = x + subLen - 1;
				
				if(y != n) {
					
					//Take the min of all possible combination of number of cost
					tableM[x][y] = Integer.MAX_VALUE;
					for( int k = x ; k < y; k++) {
						
						//The cost when multiplying two matrixes.
						int cost = tableM[x][k] + 
								   tableM[k + 1][y] + 
								   matrixDimList.get(x - 1) * 
								   matrixDimList.get(k) * 
								   matrixDimList.get(y);
						
						if(cost < tableM[x][y]) {
							tableM[x][y] = cost;
							tableS[x][y] = k; //The partition on where the matrices where multiplied
						}
					}
				}
			}
		}
		
		return tableS;
	}

	//Budget <= 500
	//Party <= 100
	public static void partyBudget(String[] inputs) {
		List<Party> partyList = new ArrayList<Party>();
		int[][] partyFun; //table to store party fun maximum for DP.
		int budget;
		int numParties;
		
		//parse
		String[] temp = inputs[0].split(" ");
		budget = Integer.parseInt(temp[0]);
		numParties = Integer.parseInt(temp[1]);
		
		for(int i = 0; i < numParties; i++) {
			temp = inputs[i+1].split(" ");
			partyList.add(new Party(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
		}
		
		int row = numParties+1,
		    col = budget + 1;
		partyFun = new int[row][col];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				partyFun[i][j] = 0;
			}
		}
		
		//start at 1 since when there is 0 weight and 0 items, there's 0 values.
		for(int i = 1; i < row; i++) {
			for(int w = 1; w < col; w++) {
				
				int otherWeight = w - partyList.get(i-1).getEntranceFee();
				if(otherWeight < 0) {
					partyFun[i][w] = partyFun[i-1][w];
				}
				else {
					partyFun[i][w] = Math.max(partyFun[i-1][w], partyFun[i-1][otherWeight] + partyList.get(i-1).getFun());
				}
			}
		}

		int maxFun = partyFun[row-1][col-1];
		int budgetSpent = backTrackPartyFun(row-1, col-1, maxFun, partyFun, partyList);
		System.out.println(budgetSpent + " " + maxFun);
		
	}
	
	private static int backTrackPartyFun(int row, int col, int maxFun, int[][] partyFun, List<Party> partyList) {
		int budgetSpent = 0;
		int w  = col;	
		
		for(int i = row; i > 0; i--) {
			
			if(maxFun > 0) {
				if (partyFun[i-1][w] != maxFun) {
					budgetSpent += partyList.get(i - 1).getEntranceFee();
					maxFun = maxFun - partyList.get(i - 1).getFun(); 
					w = w - partyList.get(i - 1).getEntranceFee();
				}
			}
			else break; //stop when the maxFun has been exhausted
		}
		
		return budgetSpent;
	}
	
	private static class Party {
		private int entranceFee; //5 - 25
		private int fun; //0 - 10
		
		public Party(int entranceFee, int fun) {
		    this.entranceFee = entranceFee;
		    this.fun = fun;
		}
		
		public int getEntranceFee() {
			return entranceFee;
		}
		
		public int getFun() {
			return fun;
		}
	}
	
	public static void cut (int l, int cuts, int[] places) {
		int modifiedCuts = cuts + 2;
		int[] modifiedPlaces = new int[modifiedCuts]; 
		int[][] costTable; //table used to store the maximum costs for DP.

		//create modified places (added 0 at first elem, and l in the last elem)
		for(int i = 0; i < modifiedPlaces.length; i++) {
			if (i == 0)
				modifiedPlaces[i] = 0;
			
			else if(i == modifiedPlaces.length - 1) 
				modifiedPlaces[i] = l;
			else 
				modifiedPlaces[i] = places[i-1];
		}
		
		//Initialize costTable.
		costTable = new int[modifiedCuts][modifiedCuts];
		for(int x = 0 ; x < modifiedCuts; x++) {
			for(int y = 0; y < modifiedCuts; y++) {
				costTable[x][y] = 0;
			}
		}
		
		//Traverse cost table diagonally representing the cuts.
		//Skip length with 0 cost.
		for (int rightPos = 2; rightPos < modifiedCuts; rightPos++) {
			for (int leftPos = rightPos - 2; leftPos >= 0; leftPos--) {
				
				costTable[leftPos][rightPos] = Integer.MAX_VALUE;
				
				for(int cutIndex = leftPos +1; cutIndex < rightPos; cutIndex++) {
					int sum = costTable[leftPos][cutIndex] + costTable[cutIndex][rightPos];
					
					if (sum < costTable[leftPos][rightPos])
						costTable[leftPos][rightPos] = sum;

				}
				
				costTable[leftPos][rightPos] = costTable[leftPos][rightPos] +  modifiedPlaces[rightPos] - modifiedPlaces[leftPos];
			}
		}

		System.out.println("The minimum cutting is " + costTable[0][modifiedCuts-1]);
	}



	


}
