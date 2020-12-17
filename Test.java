import java.util.Arrays;

//used to test the boundaries

public class Test {
	
	public static void main(String[] args) {
		
		Solution TestSolution = new Solution();
		int [] testarray = new int[] {0, 0, 1, 3, 4, 4, 4, 4, 5, 6, 7, 7};
		
		int [] output = TestSolution.searchRange(testarray, 0);
		
		System.out.println(Arrays.toString(output));
	}
}
