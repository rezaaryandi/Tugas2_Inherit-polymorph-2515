package soal4;

import java.util.ArrayList;
import java.util.List;

/**
 * Keranjang belanja yang menyimpan daftar {@link Produk} (composition).
 * Perhitungan harga dan struk bergantung pada polimorfisme.
 */
public class Keranjang {

    private static final String FORMAT_BARIS_STRUK = "%s | %s | %s | Rp%.0f%n";
    private static final String FORMAT_TOTAL_STRUK = "TOTAL: Rp%.0f%n";

    private final List<Produk> daftarProduk = new ArrayList<>();

    /**
     * Menambahkan produk ke keranjang.
     *
     * @param produk produk yang ditambahkan
     * @throws IllegalStateException jika kode produk sudah ada di keranjang
     */
    public void tambah(Produk produk) {
        if (sudahAda(produk.getKode())) {
            throw new IllegalStateException("Produk dengan kode " + produk.getKode()
                    + " sudah ada di keranjang");
        }
        daftarProduk.add(produk);
    }

    /**
     * Menghitung total harga akhir semua produk. Tidak memakai instanceof;
     * setiap produk menghitung harganya sendiri (polimorfisme).
     *
     * @return total harga dalam rupiah
     */
    public double hitungTotal() {
        double total = 0;
        for (Produk produk : daftarProduk) {
            total += produk.hitungHargaAkhir();
        }
        return total;
    }

    public void cetakStruk() {
        for (Produk produk : daftarProduk) {
            System.out.printf(FORMAT_BARIS_STRUK, produk.getKode(), produk.getNama(),
                    produk.deskripsi(), produk.hitungHargaAkhir());
        }
        System.out.printf(FORMAT_TOTAL_STRUK, hitungTotal());
    }

    
    public void hitungPerJenis() {
        RekapJenis rekap = kelompokkanPerJenis();
        System.out.println("Fisik: " + rekap.daftarFisik.size()
                + ", Digital: " + rekap.daftarDigital.size()
                + ", Langganan: " + rekap.daftarLangganan.size());
    }

    private boolean sudahAda(String kode) {
        for (Produk produk : daftarProduk) {
            if (produk.getKode().equals(kode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Mengelompokkan produk ke daftar bertipe spesifik. Setiap produk diperiksa
     * dengan instanceof sebelum di-downcast, sehingga cast selalu aman.
     * Urutan pengecekan penting: Langganan harus diperiksa sebelum
     * ProdukDigital karena Langganan juga merupakan ProdukDigital.
     */
    private RekapJenis kelompokkanPerJenis() {
        RekapJenis rekap = new RekapJenis();
        for (Produk produk : daftarProduk) {
            if (produk instanceof Langganan) {
                rekap.daftarLangganan.add((Langganan) produk);
            } else if (produk instanceof ProdukDigital) {
                rekap.daftarDigital.add((ProdukDigital) produk);
            } else if (produk instanceof ProdukFisik) {
                rekap.daftarFisik.add((ProdukFisik) produk);
            }
        }
        return rekap;
    }

    /** Penampung produk yang sudah dikelompokkan menurut jenisnya. */
    private static class RekapJenis {
        private final List<ProdukFisik> daftarFisik = new ArrayList<>();
        private final List<ProdukDigital> daftarDigital = new ArrayList<>();
        private final List<Langganan> daftarLangganan = new ArrayList<>();
    }
}
