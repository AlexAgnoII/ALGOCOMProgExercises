import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming {
	
	public static void assignTable(String[] input) {
        List<Integer> matrixDimList = new ArrayList<Integer>();
        String[] matrixName = new String[input.length];
        int[][] tableForPrinting;
        
        //Parse
        for(int i = 0; i < input.length; i++) {
        	String[] inputSplitted = input[i].split(" ");
        	matrixName[i] = inputSplitted[0];
        	
        	if(i == 0) 
        		matrixDimList.add(Integer.parseInt(inputSplitted[1]));
        		
        	matrixDimList.add(Integer.parseInt(inputSplitted[2]));
        }
        
        //Compute
        tableForPrinting = matrixChainMultiplication(matrixDimList, matrixDimList.size());

        //Print
        printMatrixChainMultOrder(1, matrixDimList.size() - 1, matrixDimList.size(), tableForPrinting, matrixName);
	}
	
	private static void printMatrixChainMultOrder(int x, int y, int size, int[][] tableForPrinting, String[] matrixName) {
		
		if(x == y) {
			System.out.print(matrixName[x-1]);
		}
		
		else {
			System.out.print("("); 
			
			printMatrixChainMultOrder(x, tableForPrinting[x][y], size, tableForPrinting, matrixName);
			printMatrixChainMultOrder(tableForPrinting[x][y] + 1, y, size, tableForPrinting, matrixName);
			
			System.out.print(")");
		}
	}

	private static int[][] matrixChainMultiplication(List<Integer> matrixDimList, int n) {
		
		int[][] tableM = new int[n][n]; //Table that will keep track of the minimum.
		int[][] tableS = new int[n][n]; //Table that will tell us what is the order.
		
		
		for(int i = 1; i < n; i++) {
			tableM[i][i] = 0;
		}
		
		for(int subLen = 2; subLen < n; subLen++) { 
			
			for(int x = 1; x < n - subLen + 1; x++) {
				int y = x + subLen - 1;
				
				if(y != n) {
					
					//Take the min of all possible combination of number of operation..
					tableM[x][y] = Integer.MAX_VALUE;
					for( int k = x ; k < y; k++) {
						
						//The number of operation done when multiplying two matrixes.
						int numOfOperation = tableM[x][k] + tableM[k + 1][y] + 
								             matrixDimList.get(x - 1) * 
								             matrixDimList.get(k) * 
								             matrixDimList.get(y);
						
						if(numOfOperation < tableM[x][y]) {
							tableM[x][y] = numOfOperation;
							tableS[x][y] = k; //The partition on where the matrices where multiplied
						}
					}
				}
			}
		}
		
		return tableS;
	}



}
