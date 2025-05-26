package Pekan5;
import java.util.Scanner;

public class AntrianPasien {
class Node{
	int nomorAntrian;
	String NamaPasien;
	String Keluhan;
	Node next;
	
	Node(int nomorAntrian, String NamaPasien, String Keluhan){
		this.nomorAntrian = nomorAntrian;
		this.NamaPasien = NamaPasien;
		this.Keluhan = Keluhan;
		this.next = null;
		
	}
}

Node head = null;
    void tambahPasien(int nomorAntrian, String nama, String keluhan) {
        Node pasienBaru = new Node(nomorAntrian, nama, keluhan);
        if (head == null) {
            head = pasienBaru;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = pasienBaru;
        }
        System.out.println("Data pasien berhasil ditambahkan!");
    }

  
    void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("--- Daftar Antrian Pasien ---");
            int nomor = 1;
            Node current = head;
            while (current != null) {
                System.out.println(nomor + ". [" + current.nomorAntrian + "] " + current.NamaPasien + " - " + current.Keluhan);
                current = current.next;
                nomor++;
            }
        }
    }


    void hapusPasienPertama() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada pasien yang bisa dilayani.");
        } else {
            System.out.println("Pasien dengan nama " + head.NamaPasien + " telah dilayani (dihapus dari antrian).");
            head = head.next;
        }
    }
    
    void cariPasien(String nama) {
        Node current = head;
        boolean ditemukan = false;
        while (current != null) {
            if (current.NamaPasien.equalsIgnoreCase(nama)) {
                System.out.println("Pasien ditemukan: [" + current.nomorAntrian + "] " + current.NamaPasien + " - " + current.Keluhan);
                ditemukan = true;
                break;
            }
            current = current.next;
        }
        if (!ditemukan) {
            System.out.println("Pasien dengan nama " + nama + " tidak ditemukan.");
        }
    }

   
    boolean isEmpty() {
        return head == null;
    }

    int hitungPasien() {
        int jumlah = 0;
        Node current = head;
        while (current != null) {
            jumlah++;
            current = current.next;
        }
        return jumlah;
    }

  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AntrianPasien antrian = new AntrianPasien();
        int pilihan;

        do {
            System.out.println("\n=== SISTEM ANTRIAN PASIEN KLINIK ===");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Layani Pasien (Hapus Antrian Pertama)");
            System.out.println("4. Cari Pasien");
            System.out.println("5. Jumlah Pasien");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nomor Antrian: ");
                    int no = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Nama Pasien: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Keluhan: ");
                    String keluhan = scanner.nextLine();
                    antrian.tambahPasien(no, nama, keluhan);
                    break;

                case 2:
                    antrian.tampilkanAntrian();
                    break;

                case 3:
                    antrian.hapusPasienPertama();
                    break;

                case 4:
                    System.out.print("Masukkan Nama Pasien yang dicari: ");
                    String cariNama = scanner.nextLine();
                    antrian.cariPasien(cariNama);
                    break;

                case 5:
                    System.out.println("Jumlah pasien saat ini: " + antrian.hitungPasien());
                    break;

                case 6:
                    System.out.println("Terima kasih. Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);

        scanner.close();
    }
}
