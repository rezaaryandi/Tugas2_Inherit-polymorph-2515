package soal1;

/**
 * Perangkat berjenis laptop dengan data RAM dan ukuran layar.
 */
public class Laptop extends Perangkat {

    private static final double PERSEN_PENUH = 100.0;

    private final int ramGb;
    private final double ukuranLayarInci;

    /**
     * Membuat laptop baru.
     *
     * @param merek           merek laptop
     * @param harga           harga laptop
     * @param garansiBulan    lama garansi dalam bulan
     * @param ramGb           kapasitas RAM dalam GB
     * @param ukuranLayarInci ukuran layar dalam inci
     * @throws IllegalArgumentException jika data dasar perangkat tidak valid
     */
    public Laptop(String merek, double harga, int garansiBulan, int ramGb, double ukuranLayarInci) {
        super(merek, harga, garansiBulan);
        this.ramGb = ramGb;
        this.ukuranLayarInci = ukuranLayarInci;
    }

    /**
     * Menghitung harga setelah diskon. Atribut harga diakses langsung
     * karena berstatus protected di superclass.
     *
     * @param diskonPersen besar diskon dalam persen (0 sampai 100)
     * @return harga setelah diskon
     * @throws IllegalArgumentException jika diskon di luar rentang 0 sampai 100
     */
    public double hitungHargaPromo(double diskonPersen) {
        if (diskonPersen < 0 || diskonPersen > PERSEN_PENUH) {
            throw new IllegalArgumentException("Diskon harus antara 0 dan 100 persen");
        }
        return harga - (harga * diskonPersen / PERSEN_PENUH);
    }

    /**
     * Menyusun ringkasan laptop: data perangkat ditambah RAM dan layar.
     *
     * @return teks ringkasan satu baris
     */
    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | RAM " + ramGb + " GB | layar " + ukuranLayarInci + " inci";
    }
}
