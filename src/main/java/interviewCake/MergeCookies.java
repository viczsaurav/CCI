package interviewCake;

public class MergeCookies {
	/**
	 * In order to win the prize for most cookies sold, my friend Alice and I are going to merge our Girl Scout Cookies orders and enter as one unit.
	 * <p>
	 * Each order is represented by an "order id" (an integer).
	 * <p>
	 * We have our lists of orders sorted numerically already, in arrays. Write a method to merge our arrays of orders into one sorted array.
	 * <p>
	 * For example:
	 * <p>
	 * int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
	 * int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};
	 * <p>
	 * System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
	 * // prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
	 */

	public static int[] mergeArrays(int[] myArray, int[] alicesArray) {

		int[] mergedArray = new int[myArray.length + alicesArray.length];

		int myArrayIdx = 0;
		int alicesArrayIdx = 0;
		int mergedArrayIdx = 0;

		while (mergedArrayIdx < mergedArray.length) {
			if (myArrayIdx >= myArray.length) {
				mergedArray[mergedArrayIdx] = alicesArray[alicesArrayIdx];
				alicesArrayIdx++;
			} else if (alicesArrayIdx >= alicesArray.length) {
				mergedArray[mergedArrayIdx] = myArray[myArrayIdx];
				myArrayIdx++;
			} else if (myArray[myArrayIdx] <= alicesArray[alicesArrayIdx]) {
				mergedArray[mergedArrayIdx] = myArray[myArrayIdx];
				myArrayIdx++;
			} else {
				mergedArray[mergedArrayIdx] = alicesArray[alicesArrayIdx];
				alicesArrayIdx++;
			}
			mergedArrayIdx++;
		}
		return mergedArray;
	}


}
