package P1;

public class ArrayGenerator {
	
	public static final int SIZE_100 = 100;
	public static final int SIZE_500 = 500;
	public static final int SIZE_1000 = 1000;
	public static final int SIZE_5000 = 5000;
	public static final int SIZE_10000 = 10000;
	public static final int SIZE_25000 = 25000; 
	public static final int SIZE_50000 = 50000;
	public static final int SIZE_75000 = 75000; 
	public static final int SIZE_100000 = 100000;
	public static final int SIZE_300000 = 300000;
	public static final int SIZE_500000 = 500000;
    public static final int SIZE_750000 = 750000;
    public static final int SIZE_1000000 = 1000000; 
	
	public static int[] generate(int size) {
		int[] generatedArray = new int[size];
		int number = 1;
		
		for(int i = 0; i < size; i++) {
			generatedArray[i] = number;
			number++;
		}
		
		return generatedArray;
	}

}
