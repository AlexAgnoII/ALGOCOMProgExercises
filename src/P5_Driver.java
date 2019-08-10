
public class P5_Driver {
	
	public P5_Driver() {
		this.Tests();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new P5_Driver();
	}
	
	public void Tests() {
		String[] s = {"A 4 10", "B 10 3", "C 3 12", "D 12 20", "E 20 7"};
		DynamicProgramming.assignTable(s);
	}

}
