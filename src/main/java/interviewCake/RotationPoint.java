package interviewCake;

public class RotationPoint {

	/**
	 * I want to learn some big words so people think I'm smart.
	 *
	 * I opened up a dictionary to a page in the middle and started flipping through, looking for words I didn't know.
	 * I put each word I didn't know at increasing indices in a huge array I created in memory.
	 * When I reached the end of the dictionary, I started from the beginning and did the same thing
	 * until I reached the page I started at.
	 *
	 * Now I have an array of words that are mostly alphabetical, except they start somewhere in the middle of the
	 * alphabet, reach the end, and then start from the beginning of the alphabet.
	 * In other words, this is an alphabetically ordered array that has been "rotated." For example:
	 *
	 *   String[] words = new String[]{
	 *     "ptolemaic",
	 *     "retrograde",
	 *     "supplant",
	 *     "undulate",
	 *     "xenoepist",
	 *     "asymptote",  // <-- rotates here!
	 *     "babka",
	 *     "banoffee",
	 *     "engender",
	 *     "karpatka",
	 *     "othellolagkage",
	 * };
	 *
	 * Write a method for finding the index of the "rotation point," which is where I started working from
	 * the beginning of the dictionary.
	 * This array is huge (there are lots of words I don't know) so we want to be efficient here.
	 *
	 * @param words
	 * @return
	 */

	public static int findRotationPoint(String[] words) {
		int start = 0;
		int end = words.length-1;

		while(start<end){
			int mid = (start+end)/2;
			//No rotation
			if (lesserThan(words[mid],words[0]))
				start=mid;
			else
				end=mid;
			if (start+1 == end){
				break;
			}
		}
		return end;
	}
	public static boolean lesserThan(String s1, String s2){
		return (s1.compareToIgnoreCase(s2)>=0);
	}
}
