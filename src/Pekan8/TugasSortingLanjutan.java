package Pekan8;

public class TugasSortingLanjutan {
    public static void main(String[] args) {
        //Devina Amanda Putri
        //2411533009

        int[] data = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47
        }; 

       
        System.out.println("Deret awal: " + arrayToString(data));
        System.out.println("Algoritma: Selection Sort\n");

        selectionSortLangkah(data);

        System.out.println("\nHasil: " + arrayToString(data));
    }

    public static void selectionSortLangkah(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            System.out.println("Langkah " + (i + 1) + ": " + arrayToString(arr));
        }
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
