
public class Main {

	public static void main(String[] args) {
		int[] array = new int[9];
		
		for (int e : array) {
			System.out.println(e);
		}
		}
		
	
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i-1;
			while (j >= 0 && temp < array[j]) {
				array[j+1] = array[j];
				array[j] = temp;
				j--;
			}
		}
	}

}
