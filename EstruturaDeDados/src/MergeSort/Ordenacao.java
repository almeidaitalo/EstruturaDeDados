package MergeSort;

public class Ordenacao {

	public static void main(String[] args) {
		int[] a = { 10, 5, 1, 6, 7, 8, 4, 2 };
		mergeSort(a, a.length);
		System.out.println("time A:");
		for (int i = 0; i < a.length / 2; i++)
			System.out.println(a[i]);
		System.out.println("time B:");
		for (int i = a.length / 2; i < a.length; i++)
			System.out.println(a[i]);
	}

	public static void mergeSort(int[] a, int n) {
		if (n < 2)
			return;
		int meio = n / 2;
		int[] l = new int[meio];
		int[] r = new int[n - meio];

		for (int i = 0; i < meio; i++) {
			l[i] = a[i];
		}
		for (int i = meio; i < n; i++) {
			r[i - meio] = a[i];
		}
		mergeSort(l, meio);
		mergeSort(r, n - meio);

		merge(a, l, r, meio, n - meio);
	}

	public static void merge(int[] a, int[] l, int[] r, int esquerda, int direita) {

		int i = 0, j = 0, k = 0;

		while (i < esquerda && j < direita) {

			if (l[i] <= r[j])
				a[k++] = l[i++];
			else
				a[k++] = r[j++];

		}

		while (i < esquerda)
			a[k++] = l[i++];

		while (j < direita)
			a[k++] = r[j++];
	}
}

