package Pekan7;
public class TugasSorting {
    public static void main(String[] args) {
        char[]huruf = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 
                         'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 
                         'f', 'e', 'd', 'c', 'b', 'a'};
        int m = 9;
        
                bubbleSort(huruf, m);
        printArray(huruf);
    }
    public static void bubbleSort(char[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                  
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
   
    public static void printArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(" - ");
            }
        }
        System.out.println();
    }
}
