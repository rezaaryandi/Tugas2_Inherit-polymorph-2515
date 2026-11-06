package soal4;

/**
 * Produk berwujud barang yang dikenai ongkos kirim berdasarkan berat.
 */
public class ProdukFisik extends Produk {

    private static final double ONGKOS_KIRIM_PER_KG = 10000;

    private final double beratKg;

    /**
     * Membuat produk fisik.
     *
     * @param kode       kode produk
     * @param nama       nama produk
     * @param hargaDasar harga dasar produk
     * @param beratKg    berat dalam kilogram, tidak boleh negatif
     * @throws IllegalArgumentException jika data tidak valid
     */
    public ProdukFisik(String kode, String nama, double hargaDasar, double beratKg) {
        super(kode, nama, hargaDasar);
        if (beratKg < 0) {
            throw new IllegalArgumentException("Berat tidak boleh negatif");
        }
        this.beratKg = beratKg;
    }

    /**
     * Menghitung harga akhir: harga dasar ditambah ongkos kirim.
     *
     * @return harga akhir dalam rupiah
     */
    @Override
    public double hitungHargaAkhir() {
        return getHargaDasar() + beratKg * ONGKOS_KIRIM_PER_KG;
    }

    /**
     * Memberi keterangan jenis dan berat produk.
     *
     * @return teks seperti "fisik 1.5 kg"
     */
    @Override
    public String deskripsi() {
        return "fisik " + beratKg + " kg";
    }
}
