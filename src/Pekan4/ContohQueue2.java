package Pekan4;

import java.util.Queue;
import java.util.LinkedList;

public class ContohQueue2 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		//tambah elemen 0,1,2,3,4,5 ke antrian
		
		for (int i = 0; i < 6; i++) {
            q.add(i);
        }

        // Menampilkan isi antrian
        System.out.println("Elemen Antrian = " + q);

        // Menghapus kepala antrian
        int hapus = q.remove();
        System.out.println("Hapus elemen = " + hapus);
        System.out.println(q);

        // Untuk melihat antrian terdepan
        int depan = q.peek();
        System.out.println("Kepala Antrian = " + depan);

        // Ukuran antrian
        int banyak = q.size();
        System.out.println("Size Antrian = " + banyak);
    }

		}
		