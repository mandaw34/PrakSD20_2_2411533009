package Pekan4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pelanggan {
    String id;
    int jumlahPesanan;

    Pelanggan(String id, int jumlahPesanan) {
        this.id = id;
        this.jumlahPesanan = jumlahPesanan;
    }
}

public class FastFoodQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Pelanggan> antrean = new LinkedList<>();

      
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            String id = scanner.next();
            int jumlah = scanner.nextInt();
            antrean.add(new Pelanggan(id, jumlah));
        }

        int waktuTotal = 0;
        while (!antrean.isEmpty()) {
            Pelanggan sekarang = antrean.poll(); 
            waktuTotal += sekarang.jumlahPesanan; 
            System.out.println(sekarang.id + " selesai dalam " + waktuTotal + " menit");
        }

        scanner.close();
    }
}
