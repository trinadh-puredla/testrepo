package com.trinu.core.infy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeArray {
	
	public static void main(String[] args) {
		
		// As of now hardcoding the array elements
		int[] sourceArray = { 1, 2, 3, 4, 5, 7, 5, 8, 9, 5 };
		int[] targetArray = { 1, 5, 6 };
		int[] resultArray = {};

		if (sourceArray.length == 0 && targetArray.length == 0) {
			throw new MergeArrayException("NO Elements Found to merge");
		}

		boolean isNumberAvailable = IntStream.of(sourceArray).anyMatch(myValue -> myValue == 5);
		if (isNumberAvailable) {
			resultArray = getTheTransformedArray(sourceArray, targetArray);
			System.out.println("ResultArray is--->" + Arrays.toString(resultArray));
		} else {
			throw new MergeArrayException("Required Element Not found to Append at last in the resultArray");
		}

	}

	public static int[] getTheTransformedArray(int[] source, int[] target) {
		
		int[] merged = IntStream.concat(IntStream.of(source), IntStream.of(target)).toArray();
		int[] arrayTobeAppended = Arrays.stream(merged).filter(val -> val == 5).toArray();
		int[] arrayWithoutReqdElement = Arrays.stream(merged).filter(val -> val != 5).toArray();

		return IntStream.concat(IntStream.of(arrayWithoutReqdElement), IntStream.of(arrayTobeAppended)).toArray();

	}

}
