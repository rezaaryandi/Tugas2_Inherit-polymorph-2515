package soal4;

/**
 * Produk digital berlangganan. Harga dihitung per bulan dikali durasi,
 * dengan diskon langganan untuk durasi panjang (tanpa diskon digital).
 */
public class Langganan extends ProdukDigital {

    private static final double DISKON_LANGGANAN = 0.20;
    private static final int BATAS_DURASI_DISKON_BULAN = 12;

    private final int durasiBulan;

    /**
     * Membuat produk langganan.
     *
     * @param kode        kode produk
     * @param nama        nama produk
     * @param hargaDasar  harga dasar per bulan
     * @param ukuranMb    ukuran berkas dalam MB
     * @param durasiBulan durasi langganan dalam bulan, harus positif
     * @throws IllegalArgumentException jika data tidak valid
     */
    public Langganan(String kode, String nama, double hargaDasar, double ukuranMb, int durasiBulan) {
        super(kode, nama, hargaDasar, ukuranMb);
        if (durasiBulan <= 0) {
            throw new IllegalArgumentException("Durasi harus lebih dari 0 bulan");
        }
        this.durasiBulan = durasiBulan;
    }

    /**
     * Menghitung harga akhir: harga dasar dikali durasi, dikurangi diskon
     * langganan jika durasi mencapai batas minimal.
     *
     * @return harga akhir dalam rupiah
     */
    @Override
    public double hitungHargaAkhir() {
        double totalSebelumDiskon = getHargaDasar() * durasiBulan;
        if (durasiBulan >= BATAS_DURASI_DISKON_BULAN) {
            return totalSebelumDiskon * (1 - DISKON_LANGGANAN);
        }
        return totalSebelumDiskon;
    }

    /**
     * Memberi keterangan jenis dan durasi langganan.
     *
     * @return teks seperti "langganan 12 bulan"
     */
    @Override
    public String deskripsi() {
        return "langganan " + durasiBulan + " bulan";
    }
}
