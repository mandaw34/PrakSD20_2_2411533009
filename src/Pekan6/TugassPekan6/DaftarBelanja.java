package TugassPekan6;

import java.util.Scanner;

public class DaftarBelanja {
    Node head;
    Node tail;

    public DaftarBelanja() {
        head = null;
        tail = null;
    }

    public void tambahItem(String nama, int kuantitas, String kategori) {
        ItemBelanja item = new ItemBelanja(nama, kuantitas, kategori);
        Node baru = new Node(item);

        if (head == null) {
            head = tail = baru;
        } else {
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
        }
        System.out.println("Item berhasil ditambahkan");
    }

    public void hapusItem(String nama) {
        if (head == null) {
            System.out.println("Daftar belanja kosong");
            return;
        }

        Node curr = head;
        while (curr != null) {
            if (curr.data.nama.equalsIgnoreCase(nama)) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                } else if (curr == head) {
                    head = head.next;
                    head.prev = null;
                } else if (curr == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                System.out.println("Item berhasil dihapus.");
                return;
            }
            curr = curr.next;
        }

        System.out.println("Item tidak ditemukan.");
    }

    public void tampilkanSemuaItem() {
        if (head == null) {
            System.out.println("Daftar belanja kosong.");
            return;
        }

        System.out.println("-- DAFTAR BELANJA --");
        Node curr = head;
        while (curr != null) {
            ItemBelanja item = curr.data;
            System.out.println("- " + item.nama + " (" + item.kuantitas + ") [" + item.kategori + "]");
            curr = curr.next;
        }
    }

    public void tampilkanPerkategori(String kategori) {
        boolean ditemukan = false;
        Node curr = head;
        System.out.println("-- Item dalam Kategori \"" + kategori + "\" --");
        while (curr != null) {
            if (curr.data.kategori.equalsIgnoreCase(kategori)) {
                System.out.println("- " + curr.data.nama + " (" + curr.data.kuantitas + ")");
                ditemukan = true;
            }
            curr = curr.next;
        }
        if (!ditemukan) {
            System.out.println("Tidak ada item dalam kategori tersebut.");
        }
    }

    public void cariItem(String nama) {
        Node current = head;
        while (current != null) {
            if (current.data.nama.equalsIgnoreCase(nama)) {
                System.out.println("Item ditemukan: " + current.data.nama + " (" + current.data.kuantitas + ") [" + current.data.kategori + "]");
                return;
            }
            current = current.next;
        }
        System.out.println("Item tidak ditemukan.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DaftarBelanja daftar = new DaftarBelanja();

        int pilihan;
        do {
            System.out.println("\n=== MENU DAFTAR BELANJA ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Hapus Item");
            System.out.println("3. Tampilkan Semua Item");
            System.out.println("4. Tampilkan Item per Kategori");
            System.out.println("5. Cari Item");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama item: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan jumlah: ");
                    int jumlah = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan kategori: ");
                    String kategori = scanner.nextLine();
                    daftar.tambahItem(nama, jumlah, kategori);
                    break;
                case 2:
                    System.out.print("Masukkan nama item yang akan dihapus: ");
                    String hapus = scanner.nextLine();
                    daftar.hapusItem(hapus);
                    break;
                case 3:
                    daftar.tampilkanSemuaItem();
                    break;
                case 4:
                    System.out.print("Masukkan nama kategori: ");
                    String kat = scanner.nextLine();
                    daftar.tampilkanPerkategori(kat);
                    break;
                case 5:
                    System.out.print("Masukkan nama item yang dicari: ");
                    String cari = scanner.nextLine();
                    daftar.cariItem(cari);
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
