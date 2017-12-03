import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution test = new Solution();
		boolean check = test.isValidPalindrome("redivider");
		assertEquals(check, true);
		int[] nums = new int[] {1,2,3,4,5,6,7,8,10};
		int data = test.missingNumber(nums);
		assertEquals(10, 10);
	}

}
