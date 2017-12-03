import java.util.*;
public class test{
      public static void main(String args[]){
     //      System.out.println(Integer.toBinaryString(23423414));
     // }
     int[] nums = new int[] {7, 6, 4, 3, 1};
		int[] data = twoSum(nums, 11);
     System.out.println(Arrays.toString(data));
}

public static int[] twoSum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = k - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}

}
