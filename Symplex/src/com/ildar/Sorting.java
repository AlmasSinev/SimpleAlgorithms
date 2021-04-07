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
	
	public void showArr(int[] arr) {
		System.out.println("");
		System.out.print("{ ");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print(" }");
	}
	
	
}
