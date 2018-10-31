package variations.bubbleSort;

import abstractions.AbstractSorting;
import utility.Utility;

/**
 * This algorithm applies two bubblesorts simultaneously. In a same iteration, a
 * bubblesort pushes the greatest elements to the end of the array and another
 * bubblesort pushes the smallest elements to the beginning of the array. At the
 * end of the first iteration, the smallest element is in the first position
 * (index 0) and the greatest element is the last position (index N-1). The next
 * iteration does the same from index 1 to index N-2. This process continues
 * until the array is completely sorted.
 * 
 * - COMPLEXITY: O(n2)
 * - IN-PLACE: Yes
 * - STABLE: Yes
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class CocktailSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * This method sorts an interval of the array, starting at leftIndex and ending
	 * at rightIndex, both inclusive. The array must not contain null elements. If
	 * leftIndex and/or rightIndex are outside the array limits, this method will do
	 * absolutely nothing. It implements the cocktail sort strategy.
	 * 
	 * @param array      The target array of the sorting algorithm.
	 * @param leftIndex  The index where the sorting should begin.
	 * @param rightIndex The index where the sorting should end.
	 * 
	 */
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (Utility.inputValidation(array, leftIndex, rightIndex)) {
			int startAt = leftIndex;
			int endAt = rightIndex;
			int middleIndex = 1 + ((leftIndex + rightIndex) / 2);

			for (int i = leftIndex; i <= middleIndex; i++) {
				for (int j = startAt; j < endAt; j++) {
					if (array[j].compareTo(array[j + 1]) > 0) {
						Utility.swap(array, j, j + 1);
					}
				}
				endAt--;

				for (int j = endAt; j > startAt; j--) {
					if (array[j].compareTo(array[j - 1]) < 0) {
						Utility.swap(array, j, j - 1);
					}
				}
				startAt++;
			}
		}
	}

}
