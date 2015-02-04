package array;

/*
 * Question : http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * 
 * Algorithm:
 * 1. For every character swap the current character with the next character.
 * 2. Fix the current character and recursively do for the sub array. 
 */

public class Permutations {

	public int[] swap(int[] array, int index1, int index2) {
		// Swap the elements
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;

		return array;
	}

	public void printPermutations(int[] array, int min, int max) {

		// Base condition when the given array does not contain any elements
		if (array.length == 0 || array == null)
			return;

		// If the array contains only one element
		if (min == max) {
			for (int i = 0; i < array.length; i++)
				System.out.print(array[i]);
			System.out.println();
		}

		else {
			// For every character swap the character with the next character
			for (int i = min; i <= max; i++) {
				array = swap(array, min, i);
				printPermutations(array, min + 1, max);
				array = swap(array, min, i);
			}
		}
	}

	public static void main(String args[]) {
		int[] array = new int[] { 1, 2, 3, 4 };
		Permutations permutations = new Permutations();
		permutations.printPermutations(array, 0, array.length - 1);
	}
}
