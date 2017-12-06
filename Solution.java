import java.util.*;
public class Solution {
public static boolean isPalindrome(String s) {
        int n=s.length();
        if(n<2) return true;
        Stack<Character> st=new Stack<Character>();
        int size=0;
        StringBuilder str=new StringBuilder("");
        s=s.toLowerCase();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                str.append(c);
                size=size+1;
            }
        }
        int x=0;
        while(x<size/2){
            st.push(str.charAt(x));
            x=x+1;
        }
        if(size%2==1)
            x=x+1;
        while(x<size){
            char temp = st.pop();
            if (str.charAt(x) != temp)
                return false;
            else
                x++;
        }
        return true;
    }
//O(n) time and O(1) space.
public static boolean isAPalindrome(String s) {
        if(s.length()<2)return true;
        s = s.toLowerCase();
        int start=0,end=s.length()-1;
        while(start<end){
            char first = s.charAt(start);
            //We could use !Character.isLetterOrDigit(first)
            while(start<end && isNotLetterDigit(first)){
                first = s.charAt(++start);
            }
            char last = s.charAt(end);
            //Here too !Character.isLetterOrDigit(last)
            while(start<end && isNotLetterDigit(last)){
                last = s.charAt(--end);
            }
            if(first!=last)break;
            ++start;
            --end;
        }
        return start>=end;
    }
public static boolean isNotLetterDigit(char c){
        return !((c>='0' && c<='9') || (c>='a' && c<='z'));
}
public static boolean isValidPalindrome(String str) {
     if (str.equals(new StringBuilder(str).reverse().toString())) {
          return true;
     }
     else{
          return false;
     }
    //return str.equals(new StringBuilder(str).reverse().toString());
}
/* returns true if given search tree is binary
search tree (efficient version) */
public static boolean isValidBST(TreeNode root) {
    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
}
public static boolean isValid(TreeNode root, long min, long max) {
    if (root == null) return true;
    if (root.val <= min || root.val >= max) return false;
    return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
}
//Missing Number O(n) and O(1)
public static int missingNumber(int[] nums) {
     int missing = nums.length;
     for (int i = 0; i < nums.length; i++) {
          missing ^= i ^ nums[i];
     }
     return missing;
}
/* The functions prints all the keys  in the given range [k1..k2].
The function assumes that k1 < k2 */
public static int printKeysOfBSTInRange(TreeNode node, int k1, int k2) {
     /* base case */
     if (node == null) {
          return 0 ;
     }
     /* Since the desired o/p is sorted, recurse for left subtree first
     If root->data is greater than k1, then only we can get o/p keys
     in left subtree */
     if (k1 < node.val) {
          printKeysOfBSTInRange(node.left, k1, k2);
     }
     /* if root's data lies in range, then prints root's data */
     if (k1 <= node.val && k2 >= node.val) {
          if (node.isLeaf(node)) return node.val;
          else return node.val + printKeysOfBSTInRange(node.left, k1, k2) + printKeysOfBSTInRange(node.right, k1, k2);

          //System.out.print(node.val + " ");
     }
     /* If root->data is smaller than k2, then only we can get o/p keys
     in right subtree */
     if (k2 > node.val) {
          printKeysOfBSTInRange(node.right, k1, k2);
     }
     return 0;
 }
//Given a full binary tree, find the longest path between any  two nodes.
//(Essentially, find the diameter of a full binary tree.)
public static int Diameter(TreeNode root) {
       if (root != null) {
            // get the left and right subtree height
            int leftH = getHeight(root.left);
            int rightH = getHeight(root.right);
            // get the left diameter and right diameter recursively.
            int leftDiameter = Diameter(root.left);
            int rightDiameter = Diameter(root.right);
            // get the max leftsubtree, rightsubtree, longest path goes through
            // root.
            return getMax(leftH + rightH + 1, leftDiameter, rightDiameter);
       }
       return 0;
 }
public static int getHeight(TreeNode root) {
      if (root != null) {
           return 1 + Math.max(getHeight(root.left), getHeight(root.right));
      }
      return 0;
}
public static int getMax(int a, int b, int c) {
      return Math.max(a, Math.max(b, c));
}
//Best Time to Buy and Sell Stock
public static int maxProfit(int prices[]) {
     int minprice = Integer.MAX_VALUE;
     int maxprofit = 0;
     for (int i = 0; i < prices.length; i++) {
          if (prices[i] < minprice)
               minprice = prices[i];
          else if (prices[i] - minprice > maxprofit)
               maxprofit = prices[i] - minprice;
     }
     return maxprofit;
}
// Adds two binary numbers and outputs it as an int
public static int sumOfBinary(String one, String two){
     // Use as radix 2 because it's binary
     int sum = 0;
     if (one == "" || two == "") {
          return -1;
     }
     try{
          int number0 = Integer.parseInt(one, 2);
          int number1 = Integer.parseInt(two, 2);
          sum = number0 + number1;
     }catch(NumberFormatException e){
          return -1;
     }
     return sum;
     }
// Adds two binary numbers and outputs it a binary string.
public static String addTheBinaryNumbers(String num1, String num2) {
    int p1 = num1.length() - 1;
    int p2 = num2.length() - 1;
    StringBuilder buf = new StringBuilder();
    int carry = 0;
    while (p1 >= 0 || p2 >= 0) {
       int sum = carry;
       if (p1 >= 0)
            sum += num1.charAt(p1--) - '0';
       if (p2 >= 0)
            sum += num2.charAt(p2--) - '0';
       carry = sum >> 1;
       sum = sum & 1;
       buf.append(sum == 0 ? '0' : '1');
    }
    if (carry > 0) {
       buf.append('1');
    }
    buf.reverse();
    return buf.toString();
}
//Checks if a given string is number. For loop and char array.
public static boolean isNumeric(String str){
    for (char c : str.toCharArray())
    {
        if (!Character.isDigit(c)) return false;
    }
    return true;
}
//Checks if a given string is a number no loops.
public static boolean isItNumeric(String str) {
  try
  {
    double d = Double.parseDouble(str);
  }
  catch(NumberFormatException nfe)
  {
    return false;
  }
  return true;
}
//Given an array of positive ints and an integer K, determine if a subsequence
//in the array sums to K. Solve in linear time.
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
//Given a fibonacci series, write code to return the element at nth index.
public static int fib(int n){
     int a = 0, b = 1, c;
     if (n == 0)
          return a;
     for (int i = 2; i <= n; i++){
          c = a + b;
          a = b;
          b = c;
     }
     return b;
}
//Word Search using a DFS.
public static boolean exist(char[][] board, String word) {
        boolean flag = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                flag = flag || dfs(board, word, i, j, 0);
            }
        }
    return flag;
}
public static boolean dfs(char[][]board, String word, int i, int j, int idx){
    if(i<0 || i>board.length-1 || j<0 || j>board[i].length-1)
        return false;
    char ch = board[i][j];
    board[i][j] = '#';
    if(ch != word.charAt(idx)){
        board[i][j] = ch;
        return false;
    }
    if(ch == word.charAt(idx) && idx == word.length()-1){
        board[i][j] = ch;
        return true;
    }

    boolean flag =      dfs(board, word, i-1,j,idx+1) ||
                        dfs(board, word, i+1,j,idx+1) ||
                        dfs(board, word, i,j-1,idx+1) ||
                        dfs(board, word, i, j+1, idx+1);

    board[i][j] = ch;
    return flag;
    }
//Finds the longest contiguous subsequence O(n) time
public static int findLongestConseqSubseq(int arr[],int n){
    HashSet<Integer> S = new HashSet<Integer>();
    int ans = 0;
    // Hash all the array elements
    for (int i=0; i<n; ++i)
        S.add(arr[i]);
    // check each possible sequence from the start
    // then update optimal length
    for (int i=0; i<n; ++i){
        // if current element is the starting
        // element of a sequence
        if (!S.contains(arr[i]-1))
        {
            // Then check for next elements in the
            // sequence
            int j = arr[i];
            while (S.contains(j))
                j++;
            // update  optimal length if this length
            // is more
            if (ans<j-arr[i])
                ans = j-arr[i];
        }
    }
    return ans;
}
//Finds all paths of the BST
public static List<String> binaryTreePaths(TreeNode root) {
        List<String> values = new ArrayList<String>();
        if(root == null) return values;
        util(values, root, "");
        return values;
    }
public static void util(List<String> values, TreeNode root, String current) {
        if(root.right!=null)
            util(values, root.right, current+ root.val + "->");
        if(root.left!=null)
            util(values, root.left,current + root.val + "->");
        if(root.right == null && root.left == null) values.add(current + root.val);
    }
//Given a char array representing tasks CPU need to do.
public static int leastInterval(char[] tasks, int n) {
     int[] map = new int[26];
     for (char c: tasks)
          map[c - 'A']++;
     Arrays.sort(map);
     int max_val = map[25] - 1, idle_slots = max_val * n;
     for (int i = 24; i >= 0 && map[i] > 0; i--) {
          idle_slots -= Math.min(map[i], max_val);
     }
     return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
     }
//preforms an xor to determine where the bit is different.
public static int hammingDistance(int x, int y) {
     return Integer.bitCount(x^y);
}
//Given an array of integers, every element appears three times except for one,
//which appears exactly once. Find that single one.
public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        int common_bit_mask;

        for(int i=0; i<nums.length; i++ )
        {
            /*"one & arr[i]" gives the bits that are there in
            both 'ones' and new element from arr[]. We
            add these bits to 'twos' using bitwise OR*/
            twos = twos | (ones & nums[i]);

            /*"one & arr[i]" gives the bits that are
            there in both 'ones' and new element from arr[].
            We add these bits to 'twos' using bitwise OR*/
            ones = ones ^ nums[i];

            /* The common bits are those bits which appear third time
            So these bits should not be there in both 'ones' and 'twos'.
            common_bit_mask contains all these bits as 0, so that the bits can
            be removed from 'ones' and 'twos'*/
            common_bit_mask = ~(ones & twos);

            /*Remove common bits (the bits that appear third time) from 'ones'*/
            ones &= common_bit_mask;

            /*Remove common bits (the bits that appear third time) from 'twos'*/
            twos &= common_bit_mask;
        }
        return ones;
    }
//Valid Parentheses
public boolean isValid(String s) {
     Deque<Character> stack = new ArrayDeque<Character>();
     for (char c : s.toCharArray()){
          if (c == '(') stack.push(')');
          else if (c == '{') stack.push('}');
          else if (c == '[') stack.push(']');
          else if (stack.peek() == null || stack.pop() != c) return false;
     }
     return stack.isEmpty();
}

}
