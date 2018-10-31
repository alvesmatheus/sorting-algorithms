package simpleSorts;

import abstractions.AbstractSorting;
import utility.Utility;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the end of the array by swapping adjacent elements. This may
 * happen until the array is completely sorted.
 * 
 * - COMPLEXITY: O(n2)
 * - IN-PLACE: Yes
 * - STABLE: Yes
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * This method sorts an interval of the array, starting at leftIndex and ending
	 * at rightIndex, both inclusive. The array must not contain null elements. If
	 * leftIndex and/or rightIndex are outside the array limits, this method will do
	 * absolutely nothing. It implements the bubble sort strategy.
	 * 
	 * @param array      The target array of the sorting algorithm.
	 * @param leftIndex  The index where the sorting should begin.
	 * @param rightIndex The index where the sorting should end.
	 * 
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (Utility.inputValidation(array, leftIndex, rightIndex)) {
			for (int i = leftIndex; i <= rightIndex; i++) {
				for (int j = leftIndex; j < rightIndex; j++) {
					if (array[j].compareTo(array[j + 1]) > 0) {
						Utility.swap(array, j, j + 1);
					}
				}
			}
		}
	}

}
