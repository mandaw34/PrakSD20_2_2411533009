package Pekan3;
import java.util.Stack;
import java.util.Scanner;

class Buku {
	String judul;
	
	Buku(String judul){
		this.judul = judul;
	}
}

public class PerpustakaanMini {
Stack <Buku> TumpukanBuku = new Stack <>();	

void tambahBuku (Buku buku) {
	TumpukanBuku.push(buku);
	System.out.println("Buku \"" + buku.judul + "\" Sudah ditambahkan ke tumpukan ");
}

void ambilBuku() {
	if (!TumpukanBuku.isEmpty()) {
		Buku buku = TumpukanBuku.pop();
		System.out.println("Buku yang di ambil "+ buku.judul);
	} else {
		System.out.println("Tumpukan kosong");
	}
}

void lihatTumpukan() {
	if (TumpukanBuku.isEmpty()) {
	System.out.println("Tidak ada buku di tumpukan");
	
} else {
	System.out.println("Tumpukan buku saat ini: ");
	
	for (int i = TumpukanBuku.size() - 1; i >= 0; i--) {
		System.out.println("- " + TumpukanBuku.get(i).judul);
	}
}
}

void cariBuku(String judul) {
    boolean ditemukan = false;
    for (Buku buku : TumpukanBuku) {
        if (buku.judul.equalsIgnoreCase(judul)) {
            ditemukan = true;
            break;
        }
    }
    if (ditemukan) {
        System.out.println("Buku \"" + judul + "\" ada dalam tumpukan.");
    } else {
        System.out.println("Buku \"" + judul + "\" tidak ditemukan dalam tumpukan.");
    }
}
	

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PerpustakaanMini perpustakaan = new PerpustakaanMini();
    
    String[] bukuAwal = {
           "Algoritma Dasar", "Struktur Data", "Basis Data",
            "Pemrograman Java", "Jaringan Komputer",
            "Sistem Operasi" };
    
    for (String judul : bukuAwal) {
        perpustakaan.tambahBuku(new Buku(judul));
    }
    
    int pilihan;
    do {
        System.out.println("\n=== MENU PERPUSTAKAAN MINI ===");
        System.out.println("1. Tambah Buku ke Tumpukan");
        System.out.println("2. Ambil Buku Teratas");
        System.out.println("3. Lihat Tumpukan Buku");
        System.out.println("4. Keluar");
        System.out.print("Pilihan: ");
        pilihan = scanner.nextInt();
        scanner.nextLine(); 

        switch (pilihan) {
        case 1:
            System.out.print("Masukkan judul buku: ");
            String judulBaru = scanner.nextLine(); 
            perpustakaan.tambahBuku(new Buku(judulBaru));
            break;

            case 2:
                perpustakaan.ambilBuku();
                break;
            case 3:
                perpustakaan.lihatTumpukan();
                break;
            case 4:
                System.out.println("Terima kasih!");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    } while (pilihan != 4);

    scanner.close();
}
}
        
	
