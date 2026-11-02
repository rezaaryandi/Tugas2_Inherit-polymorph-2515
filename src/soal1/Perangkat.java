package soal1;

/**
 * Merepresentasikan satu perangkat elektronik yang dijual di toko.
 * Kelas ini menyimpan data dasar perangkat dan memastikan setiap
 * nilai yang disimpan lolos validasi.
 */
public class Perangkat {

    /** Tarif pajak sebesar 10 persen dari harga. */
    private static final double TARIF_PAJAK = 0.10;

    /** Harga perangkat; protected agar subclass dapat mengaksesnya langsung. */
    protected double harga;

    private final String merek;
    private final int garansiBulan;

    /**
     * Membuat perangkat baru.
     *
     * @param merek        merek perangkat, tidak boleh kosong
     * @param harga        harga perangkat, tidak boleh negatif
     * @param garansiBulan lama garansi dalam bulan, tidak boleh negatif
     * @throws IllegalArgumentException jika merek kosong, harga negatif, atau garansi negatif
     */
    public Perangkat(String merek, double harga, int garansiBulan) {
        validasiMerek(merek);
        validasiHarga(harga);
        if (garansiBulan < 0) {
            throw new IllegalArgumentException("Garansi tidak boleh negatif");
        }
        this.merek = merek;
        this.harga = harga;
        this.garansiBulan = garansiBulan;
    }

    /**
     * Mengambil merek perangkat.
     *
     * @return merek perangkat
     */
    public String getMerek() {
        return merek;
    }

    /**
     * Mengambil lama garansi perangkat.
     *
     * @return garansi dalam bulan
     */
    public int getGaransiBulan() {
        return garansiBulan;
    }

    /**
     * Mengubah harga perangkat setelah melalui validasi.
     *
     * @param harga harga baru, tidak boleh negatif
     * @throws IllegalArgumentException jika harga negatif
     */
    public void setHarga(double harga) {
        validasiHarga(harga);
        this.harga = harga;
    }

    /**
     * Menghitung pajak perangkat sebesar tarif pajak dikali harga.
     *
     * @return nilai pajak dalam rupiah
     */
    public double hitungPajak() {
        return harga * TARIF_PAJAK;
    }

    /**
     * Menyusun ringkasan satu baris tentang perangkat.
     *
     * @return teks berisi merek dan garansi
     */
    public String infoSingkat() {
        return merek + " | garansi " + garansiBulan + " bulan";
    }

    private static void validasiMerek(String merek) {
        if (merek == null || merek.trim().isEmpty()) {
            throw new IllegalArgumentException("Merek tidak boleh kosong");
        }
    }

    private static void validasiHarga(double harga) {
        if (harga < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif");
        }
    }
}
