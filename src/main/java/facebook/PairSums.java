package facebook;

import java.util.*;


class PairSums {

	/**
	 *
	 * Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.
	 * If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs are considered different if one pair includes at least one array index which the other doesn't, even if they include the same values.
	 * Signature : int numberOfWays(int[] arr, int k)
	 * Input
	 * 	- n is in the range [1, 100,000].
	 * 	- Each value arr[i] is in the range [1, 1,000,000,000].
	 * 	- k is in the range [1, 1,000,000,000].
	 * Output
	 * 	- Return the number of different pairs of elements which sum to k.
	 *
	 * 	Example:
	 * 		n = 5
	 * 		k = 6
	 * 		arr = [1, 5, 3, 3, 3]
	 * 		output = 4
	 *
	 * 		There's one valid pair 1+5, and three different valid pairs 3+3 (the 3rd and 4th elements, 3rd and 5th elements,
	 * 		and 4th and 5th elements).
	 */

	int numberOfWays(int[] arr, int k) {

		/**

		 1. Create a map to store frequency of each number in the array. (Single traversal is required)
		 2. In the next traversal, for every element check if it can be combined with any other element (other than itself!) to give   the desired sum. Increment the counter accordingly.
		 3. After completion of second traversal, we’d have twice the required value stored in counter because every pair is counted two times. Hence divide count by 2 and return.
		 **/

		Map<Integer, Integer> hashMap = new HashMap<>();

		for (int in: arr){
			int val = hashMap.getOrDefault(in, 0);
			hashMap.put(in, val+1);
		}
		int twiceCount = 0;

		for(int in: arr){
			// iterate through each element and increment the
			// count (Notice that every pair is counted twice)
			twiceCount += hashMap.getOrDefault((k-in), 0);

			// if (k-in)==in, we are count same element twice, the (arr[i], arr[i]) pair is not considered
			if ((k-in)==in)	twiceCount--;
		}

		// return the half of twice_count
		return twiceCount/2;
	}

	int test_case_number = 1;

	void check(int expected, int output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		}
		else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printInteger(expected);
			System.out.print(" Your output: ");
			printInteger(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printInteger(int n) {
		System.out.print("[" + n + "]");
	}

	public void run() {
		int k_1 = 6;
		int[] arr_1 = {1, 2, 3, 4, 3};
		int expected_1 = 2;
		int output_1 = numberOfWays(arr_1, k_1);
		check(expected_1, output_1);

		int k_2 = 6;
		int[] arr_2 = {1, 5, 3, 3, 3};
		int expected_2 = 4;
		int output_2 = numberOfWays(arr_2, k_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}
	public static void main(String[] args) {
		new PairSums().run();
	}
}