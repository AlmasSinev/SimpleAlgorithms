package com.ildar;

public class Sorting {
	
	
	public void bubbleSorting(int[] arr) {
		// Сортировка пузырьком. Время O(n^2), лучшее O(n). Память O(1)
		int bmp  = 0;
		for (int i=0; i+1 < arr.length; i++) {
			for (int j=0; j+1 < arr.length-i; j++) {
				if (arr[j] > arr[j+1]) {
					bmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = bmp;
				}
			}
		}
	}
	
	public void combSorting(int[] arr) {
		// Сортировка расческой. С каждой итерацией расстояние между двумя сравниваемыми точками уменьшается.
		// Лучшее время O(n log n). Память O(1).
		double fac = 1.247; // Константа
		double step = arr.length - 1;
		int bmp = 0;
		
		while (step >= 1.0) {
			for (int i = 0; i+step < arr.length; i++) {
				if (arr[i] > arr[(int)(i + step)]) {
					bmp = arr[(int)(i + step)];
					arr[(int)(i + step)] = arr[i];
					arr[i] = bmp;
				}
			}
			step /= fac;
			for (int i=0; i+1 < arr.length; i++) {
				for (int j=0; j+1 < arr.length-i; j++) {
					if (arr[j] > arr[j+1]) {
						bmp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = bmp;
					}
				}
			}
		}
	}
	
	public void insertionSort(int[] arr) {
		// Сортировка вставками. Лучшее время O(n) для сравнений, O(1) для перестановок. 
		// Затраты памяти: O(n) основной, O(1) дополнительной.
		for (int i = 1; i < arr.length; i++) {
			int x = arr[i];
			int j = i;
			while (j > 0 && arr[j-1] > x) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = x;
		}
	}
	
	public void showArr(int[] arr) {
		System.out.println("");
		System.out.print("{ ");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print(" }");
	}
	
	public void mergeSortImpl(int[] arr, int[] buffer, int l, int r) {
		if(l < r) {
			int m = (l + r) / 2;
			mergeSortImpl(arr, buffer, l, m);
			mergeSortImpl(arr, buffer, m+1, r);
			
			int k = l;
			for(int i = l, j = m+1; i <= m || j <= r; ) {
				if (j > r || (i <= m && arr[i] < arr[j])) {
					buffer[k] = arr[i];
					i++;
				} else {
					buffer[k] = arr[j];
					j++;
				}
				k++;
			}
			for(int i = l; i <= r; i++) {
				arr[i] = buffer[i];
			}
		}
	}
	
	public void mergeSort(int[] arr) {
		// Сортировка слиянием. Время O(nlogn). Память O(n) вспомогательной.
		if (!(arr.length == 0)) {
			int[] buffer = new int[arr.length];
			mergeSortImpl(arr, buffer, 0, arr.length - 1);
		}
	}
	
	
}
