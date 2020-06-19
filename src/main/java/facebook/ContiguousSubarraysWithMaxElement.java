package facebook;

public class ContiguousSubarraysWithMaxElement {

	public int[] countSubarrays(int[] arr) {
		int[] output = new int[arr.length];
		int maxValue = -1, maxCount = 0;

		for(int i=0; i<arr.length;i++){
			int left=i-1, right=i+1;
			output[i]++;	// current element as default subarray count

			//[7,3,4,5] gives wrong left count for [4]
			// Left Count
			if (left>=0 && arr[i]>maxValue) output[i]+=maxCount;

			// Right Count update
			while(right<arr.length && arr[i]>arr[right]){
				output[i]++; right++;
			}

			// Memoization for the left count
			if (arr[i]>maxValue && output[i]>maxCount) {
				maxValue = arr[i];
				maxCount = output[i];
			}
		}
		return output;
	}

	// These are the tests we use to determine if the solution is correct.
	int test_case_number = 1;
	void check(int[] expected, int[] output) {
		int expected_size = expected.length;
		int output_size = output.length;
		boolean result = true;
		if (expected_size != output_size) {
			result = false;
		}
		for (int i = 0; i < Math.min(expected_size, output_size); i++) {
			result &= (output[i] == expected[i]);
		}
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		}
		else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printIntegerArray(expected);
			System.out.print(" Your output: ");
			printIntegerArray(output);
			System.out.println();
		}
		test_case_number++;
	}
	void printIntegerArray(int[] arr) {
		int len = arr.length;
		System.out.print("[");
		for(int i = 0; i < len; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}
	public void run() {
		int[] test_1 = {3, 4, 1, 6, 2};
		int[] expected_1 = {1, 3, 1, 5, 1};
		int[] output_1 = countSubarrays(test_1);
		check(expected_1, output_1);

		int[] test_2 = {2, 4, 7, 1, 5, 3};
		int[] expected_2 = {1, 2, 6, 1, 2, 1};
		int[] output_2 = countSubarrays(test_2);
		check(expected_2, output_2);

	}
	public static void main(String[] args) {
		new ContiguousSubarraysWithMaxElement().run();
	}
}