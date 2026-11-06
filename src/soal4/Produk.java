package soal4;

/**
 * Superclass semua produk di toko digital. Menyimpan identitas dan harga dasar
 * serta mendefinisikan kontrak {@link #hitungHargaAkhir()} dan {@link #deskripsi()}
 * yang di-override oleh setiap jenis produk.
 */
public class Produk {

    private static final String DESKRIPSI_UMUM = "produk umum";

    private final String kode;
    private final String nama;
    private final double hargaDasar;

    /**
     * Membuat produk baru.
     *
     * @param kode       kode unik produk, tidak boleh kosong
     * @param nama       nama produk, tidak boleh kosong
     * @param hargaDasar harga dasar, tidak boleh negatif
     * @throws IllegalArgumentException jika kode/nama kosong atau harga dasar negatif
     */
    public Produk(String kode, String nama, double hargaDasar) {
        if (kode == null || kode.trim().isEmpty()) {
            throw new IllegalArgumentException("Kode produk tidak boleh kosong");
        }
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong");
        }
        if (hargaDasar < 0) {
            throw new IllegalArgumentException("Harga dasar tidak boleh negatif");
        }
        this.kode = kode;
        this.nama = nama;
        this.hargaDasar = hargaDasar;
    }

    /**
     * Mengambil kode produk.
     *
     * @return kode produk
     */
    public String getKode() {
        return kode;
    }

    /**
     * Mengambil nama produk.
     *
     * @return nama produk
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengambil harga dasar produk.
     *
     * @return harga dasar dalam rupiah
     */
    public double getHargaDasar() {
        return hargaDasar;
    }

    /**
     * Menghitung harga akhir produk. Pada produk umum sama dengan harga dasar.
     *
     * @return harga akhir dalam rupiah
     */
    public double hitungHargaAkhir() {
        return hargaDasar;
    }

    /**
     * Memberi keterangan jenis produk.
     *
     * @return keterangan singkat produk
     */
    public String deskripsi() {
        return DESKRIPSI_UMUM;
    }
}
