package com.anthonynsimon.algorithms.sorts;

import java.util.Scanner;

class Counting {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = getArrayInteiros(scan);
		int k = Integer.parseInt(scan.nextLine());
		countingSort(array, k);
		scan.close();
	}

	private static void countingSort(int[] A, int k) {

		int[] C = new int[k + 1];
		int[] B = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			C[A[i]]++;
			imprimeArray(C);
		}

		for (int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}
		imprimeCumulativa(C);

		int a;
		int posicao;
		for (int i = A.length - 1; i >= 0; i--) {
			a = A[i];
			posicao = --C[a];
			B[posicao] = a;
		}

		for (int i = 0; i < B.length; i++) {
			A[i] = B[i];
		}

		imprimeArray(C);
		imprimeArray(A);

	}

	private static int[] getArrayInteiros(Scanner scan) {
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}

	private static String stringArray(int[] array) {
		String result = "";
		for (int i = 0; i < array.length - 1; i++) {
			result += array[i] + " ";
		}
		result += array[array.length - 1] + "";
		return result;
	}

	private static void imprimeArray(int[] array) {
		System.out.println(stringArray(array));
	}

	private static void imprimeCumulativa(int[] array) {
		String result = "Cumulativa do vetor de contagem - " + stringArray(array);
		System.out.println(result);
	}

}