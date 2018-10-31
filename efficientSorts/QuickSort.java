package efficientSorts;

import abstractions.AbstractSorting;
import utility.Utility;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts.
 * 
 * - COMPLEXITY: O(n2)
 * - IN-PLACE: Yes 
 * - STABLE: No
 * 
 * @author Matheus Alves dos Santos
 * 
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * This method sorts an interval of the array, starting at leftIndex and ending
	 * at rightIndex, both inclusive. The array must not contain null elements. If
	 * leftIndex and/or rightIndex are outside the array limits, this method will do
	 * absolutely nothing. It implements the quick sort strategy.
	 * 
	 * @param array      The target array of the sorting algorithm.
	 * @param leftIndex  The index where the sorting should begin.
	 * @param rightIndex The index where the sorting should end.
	 * 
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (Utility.inputValidation(array, leftIndex, rightIndex)) {
			int pivotIndex = partition(array, leftIndex, rightIndex);

			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex + 1, rightIndex);
		}
	}

	/**
	 * After choosing a pivot element, the one at the leftIndex, this method will
	 * reorder the array so that all elements with values less or equal than the
	 * pivot come before it, while all elements with values greater than the pivot
	 * come after it. After this partitioning, the pivot is in its final position.
	 * 
	 * @param array      The target array of the sorting algorithm.
	 * @param leftIndex  The index where the sorting should begin.
	 * @param rightIndex The index where the sorting should end.
	 * 
	 * @return the pivot's final position.
	 * 
	 */
	private int partition(T[] array, int leftIndex, int rightIndex) {
		T pivot = array[leftIndex];
		int i = leftIndex;
		
		for (int j = i + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				Utility.swap(array, i, j);
			}
		}

		Utility.swap(array, leftIndex, i);
		return i;
	}
}
